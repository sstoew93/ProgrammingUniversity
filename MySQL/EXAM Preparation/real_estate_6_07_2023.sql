CREATE DATABASE `real_estate_db`;
USE `real_estate_db`;

CREATE TABLE `cities` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(60) NOT NULL UNIQUE
);

CREATE TABLE `property_types` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `type` VARCHAR(40) NOT NULL UNIQUE,
    `description` TEXT
);

CREATE TABLE `properties` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `address` VARCHAR(80) NOT NULL UNIQUE,
    `price`DECIMAL(19, 2) NOT NULL,
    `area` DECIMAL(19, 2),
    `property_type_id` INT,
    `city_id` INT,
    
    CONSTRAINT fk_properties_property_types
    FOREIGN KEY (`property_type_id`) REFERENCES `property_types`(`id`),
	CONSTRAINT fk_properties_cities
    FOREIGN KEY (`city_id`) REFERENCES `cities`(`id`)
);

CREATE TABLE `agents` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(40) NOT NULL,
    `last_name` VARCHAR(40) NOT NULL,
    `phone` VARCHAR(20) NOT NULL UNIQUE,
    `email` VARCHAR(50) NOT NULL UNIQUE,
    `city_id` INT,
    
    CONSTRAINT fk_agents_cities
    FOREIGN KEY (`city_id`) REFERENCES `cities`(`id`)
);

CREATE TABLE `buyers` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(40) NOT NULL,
    `last_name` VARCHAR(40) NOT NULL,
    `phone` VARCHAR(20) NOT NULL UNIQUE,
    `email` VARCHAR(50) NOT NULL UNIQUE,
	`city_id` INT,
    
    CONSTRAINT fk_buyers_cities
    FOREIGN KEY (`city_id`) REFERENCES `cities`(`id`)
);

CREATE TABLE `property_offers` (
	`property_id` INT NOT NULL,
    `agent_id` INT NOT NULL,
    `price` DECIMAL(19, 2) NOT NULL,
    `offer_datetime` DATETIME,
    
    CONSTRAINT fk_property_offers_properties
    FOREIGN KEY (`property_id`) REFERENCES `properties`(`id`),
    
	CONSTRAINT fk_property_offers_agents
    FOREIGN KEY (`agent_id`) REFERENCES `agents`(`id`)
);

CREATE TABLE `property_transactions` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `property_id` INT NOT NULL,
    `buyer_id` INT NOT NULL,
    `transaction_date` DATE,
    `bank_name` VARCHAR(30),
    `iban` VARCHAR(40) UNIQUE,
    `is_successful` BOOL,
    
	CONSTRAINT fk_property_transactions_properties
    FOREIGN KEY (`property_id`) REFERENCES `properties`(`id`),
    
	CONSTRAINT fk_property_transactions_buyers
    FOREIGN KEY (`buyer_id`) REFERENCES `buyers`(`id`)
);

# SECTION 2
# INSERT
INSERT INTO `property_transactions` (`property_id`, `buyer_id`, `transaction_date`, `bank_name`, `iban`, `is_successful`)
SELECT 
	`agent_id` + DAY(`offer_datetime`) AS `agent_id`,
	`agent_id` + MONTH(`offer_datetime`) AS `buyer_id`,
    DATE(`offer_datetime`) AS `transaction_date`,
    CONCAT('Bank ', `agent_id`) AS `bank_name`,
    CONCAT('BG', `price`, `agent_id`) AS `iban`,
    TRUE
 FROM `property_offers`
WHERE `agent_id` <= 2;

# UPDATE
UPDATE `properties`
SET `price` = `price` - 50000
WHERE `price` >= 800000;

# DELETE
DELETE FROM `property_transactions`
WHERE `is_successful` = 0;

#AGENTS
SELECT * FROM `agents`
ORDER BY `city_id` DESC, `phone` DESC;

# Offers from 2021
SELECT * FROM `property_offers`
WHERE YEAR(`offer_datetime`) = 2021
ORDER BY `price` ASC
LIMIT 10;

#  Properties without offers
SELECT LEFT(p.`address`, 6) AS `agent_name`, CHAR_LENGTH(p.`address`) * 5430 AS `price` FROM `properties` p
LEFT JOIN `property_offers` po ON p.`id` = po.`property_id`
WHERE po.`property_id` IS NULL
ORDER BY `agent_name` DESC, `price` DESC;

# BEST BANKS
SELECT `bank_name`, COUNT(*) AS `count` FROM `property_transactions`
GROUP BY `bank_name`
HAVING `count` >= 9
ORDER BY `count` DESC, `bank_name` ASC;

# SIZE OF THE AREA
SELECT p.`address`, p.`area`, (
	CASE 
		WHEN p.`area` <= 100 THEN 'small'
		WHEN p.`area` <= 200 THEN 'medium'
		WHEN p.`area` <= 500 THEN 'large'
		WHEN p.`area` > 500 THEN 'extra large'
	END
) AS `size` FROM `properties` p
ORDER BY p.`area` ASC, p.`address` DESC;

# OFFERS COUNT
DELIMITER $$
CREATE FUNCTION udf_offers_from_city_name (cityName VARCHAR(50))
	RETURNS INT
	DETERMINISTIC
	BEGIN
		DECLARE count INT;
        SET count = (
			SELECT COUNT(*) AS `offer_count` FROM `cities` c
            JOIN `properties` p ON c.`id` = p.`city_id`
            JOIN `property_offers` po ON p.`id` = po.`property_id`
            WHERE c.`name` = cityName
            GROUP BY c.`name`
        );
        RETURN count;
	END$$
DELIMITER ;

SELECT udf_offers_from_city_name('Amsterdam') AS 'offers_count';

# SPECIAL OFFER
DELIMITER $$
CREATE PROCEDURE udp_special_offer(first_name VARCHAR(50))
BEGIN
	UPDATE `property_offers` po
    JOIN `agents` a ON po.`agent_id` = a.`id`
    SET `price` = ROUND(`price` -  (`price` * 0.10), 2)
    WHERE a.`first_name` = first_name;
END$$
DELIMITER ;

CALL udp_special_offer('Hans');

