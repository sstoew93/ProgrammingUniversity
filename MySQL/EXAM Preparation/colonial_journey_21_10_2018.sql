CREATE DATABASE `colonial_journey_management_system_db`;
USE `colonial_journey_management_system_db`;

CREATE TABLE `planets` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `spaceports` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `planet_id` INT,
    CONSTRAINT fk_spaceports_planets
	FOREIGN KEY (`planet_id`) REFERENCES `planets`(`id`)
);

CREATE TABLE `spaceships` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `manufacturer` VARCHAR(30) NOT NULL,
    `light_speed_rate` INT DEFAULT 0
);

CREATE TABLE `colonists` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(20) NOT NULL,
    `last_name` VARCHAR(20) NOT NULL,
    `ucn` CHAR(10) NOT NULL UNIQUE,
    `birth_date` DATE NOT NULL
);

CREATE TABLE `journeys` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `journey_start` DATETIME NOT NULL,
    `journey_end` DATETIME NOT NULL,
    `purpose` ENUM('Medical', 'Technical', 'Educational', 'Military'),
    `destination_spaceport_id` INT,
    `spaceship_id` INT,
    CONSTRAINT fk_journeys_spaceports
    FOREIGN KEY (`destination_spaceport_id`) REFERENCES `spaceports`(`id`),
    CONSTRAINT fk_journeys_spaceships
    FOREIGN KEY (`spaceship_id`) REFERENCES `spaceships`(`id`)
);

CREATE TABLE `travel_cards` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `card_number` CHAR(10) NOT NULL UNIQUE,
    `job_during_journey` ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
    `colonist_id` INT,
    `journey_id` INT,
    CONSTRAINT fk_travel_cards_colonists
    FOREIGN KEY (`colonist_id`) REFERENCES `colonists`(`id`),
	CONSTRAINT fk_travel_cards_journeys
    FOREIGN KEY (`journey_id`) REFERENCES `journeys`(`id`)
);

# ******************************************************

INSERT INTO `travel_cards` (`card_number`, `job_during_journey`, `colonist_id`, `journey_id`) 
SELECT (
	IF(DATE(`birth_date`) >'1980-01-01', CONCAT(YEAR(`birth_date`), DAY(`birth_date`), LEFT(`ucn`, 4)), CONCAT(YEAR(`birth_date`), MONTH(`birth_date`), RIGHT(`ucn`, 4)))) AS `card_number`,
	CASE
		WHEN `id` % 2 = 0 THEN 'Pilot'
		WHEN `id` % 3 = 0 THEN 'Cook'
		ELSE 'Engineer'
    END AS `job_during_journey`,
    `id`,
    LEFT(`ucn`, 1)
 FROM `colonists`
WHERE `id` BETWEEN 96 AND 100;

UPDATE `journeys`
SET `purpose` = CASE
        WHEN id % 2 = 0 THEN 'Medical'
        WHEN id % 3 = 0 THEN 'Technical'
        WHEN id % 5 = 0 THEN 'Educational'
        WHEN id % 7 = 0 THEN 'Military'
        ELSE purpose
END;

DELETE c FROM `colonists` as c
LEFT JOIN `travel_cards` as t ON c.`id` = t.`colonist_id`
LEFT JOIN `journeys` as j ON  t.`journey_id` = j.`id`
WHERE t.`journey_id` IS NULL;

#extract
SELECT `id`, `journey_start`, `journey_end` FROM `journeys`
WHERE `purpose` = 'Military'
ORDER BY `journey_start`;

SELECT s.`name`, sp.`name` FROM `spaceships` s
JOIN `journeys` AS j ON s.`id` = j.`spaceship_id`
JOIN `spaceports` sp ON j.`destination_spaceport_id` = sp.`id`
ORDER BY s.`light_speed_rate` DESC
LIMIT 1;

SELECT s.`name`, s.`manufacturer` FROM `spaceships` s
JOIN `journeys` j ON s.`id` = j.`spaceship_id`
JOIN `travel_cards` tc ON  j.`id` = tc.`journey_id`
JOIN `colonists` c ON  c.`id` = tc.`colonist_id`
WHERE (DATEDIFF('2019-01-01', c.birth_date) / 365) < 30 AND job_during_journey = 'Pilot'
GROUP BY s.`name`, s.`manufacturer`
ORDER BY s.`name`;

SELECT p.`name` AS 'planet_name', s.`name` AS 'spaceport_name' FROM `planets` p
JOIN `spaceports` as s ON p.`id` = s.`planet_id`
JOIN `journeys` as j ON s.`id` = j.`destination_spaceport_id`
WHERE j.`purpose` = 'Educational'
ORDER BY s.`name` DESC;

SELECT p.`name` AS 'planet_name', COUNT(*) AS `journeys_count` FROM `planets` p
JOIN `spaceports` as s ON p.`id` = s.`planet_id`
JOIN `journeys` as j ON s.`id` = j.`destination_spaceport_id`
GROUP BY p.`name`
ORDER BY `journeys_count` DESC, p.`name`;


SELECT `job_during_journey` AS 'job_name'
FROM `travel_cards`
WHERE `journey_id` = (
    SELECT `id`
    FROM `journeys`
    ORDER BY TIMESTAMPDIFF(SECOND, `journey_start`, `journey_end`) DESC
    LIMIT 1
)
GROUP BY `job_during_journey`
ORDER BY COUNT(*) ASC
LIMIT 1;

DELIMITER $$
CREATE FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR (30))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE count INT;
    SET count = (SELECT COUNT(*) FROM `planets` p
	JOIN `spaceports` as s ON p.`id` = s.`planet_id`
	JOIN `journeys` as j ON s.`id` = j.`destination_spaceport_id`
    JOIN `travel_cards` tc ON  j.`id` = tc.`journey_id`
	WHERE p.`name` = planet_name);
    
    RETURN count;
END$$
DELIMITER ;

SELECT p.name, udf_count_colonists_by_destination_planet('Otroyphus') AS count
FROM planets AS p
WHERE p.name = 'Otroyphus';

DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT)
BEGIN
    DECLARE `spaceship_exists` INT DEFAULT 0;

    START TRANSACTION;

    SELECT COUNT(*) INTO `spaceship_exists`
    FROM `spaceships`
    WHERE name = `spaceship_name`;

    IF spaceship_exists > 0 THEN
        UPDATE `spaceships`
        SET `light_speed_rate` = `light_speed_rate` + `light_speed_rate_increse`
        WHERE name = `spaceship_name`;

        COMMIT;
    ELSE
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exist.';
    END IF;
END$$
DELIMITER ;

    