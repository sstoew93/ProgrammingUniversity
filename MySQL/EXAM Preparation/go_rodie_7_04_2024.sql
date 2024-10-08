# SECTION #1
CREATE DATABASE `go_rodie`;
USE `go_rodie`;

CREATE TABLE `cities` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `cars` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `brand` VARCHAR(20) NOT NULL,
    `model` VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE `instructors` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(40) NOT NULL,
    `last_name` VARCHAR(40) NOT NULL UNIQUE,
    `has_a_license_from` DATE NOT NULL
);

CREATE TABLE `driving_schools` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(40) NOT NULL UNIQUE,
    `night_time_driving` BOOL NOT NULL,
	`average_lesson_price` DECIMAL(10, 2),
    `car_id` INT NOT NULL,
    `city_id` INT NOT NULL,
    
    CONSTRAINT fk_driving_schools_cars
    FOREIGN KEY (`car_id`) REFERENCES `cars`(`id`),
	CONSTRAINT fk_driving_schools_cities
	FOREIGN KEY (`city_id`) REFERENCES `cities`(`id`)
);

CREATE TABLE `students` (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(40) NOT NULL,
    `last_name` VARCHAR(40) NOT NULL UNIQUE,
    `age` INT,
    `phone_number` VARCHAR(20) UNIQUE
);

CREATE TABLE `instructors_driving_schools` (
	`instructor_id` INT,
    `driving_school_id` INT NOT NULL,
    
    CONSTRAINT fk_instructors_driving_schools_instructors
    FOREIGN KEY (`instructor_id`) REFERENCES `instructors`(`id`),
	CONSTRAINT fk_instructors_driving_schools_driving_schools
    FOREIGN KEY (`driving_school_id`) REFERENCES `driving_schools`(`id`)
);

CREATE TABLE `instructors_students` (
	`instructor_id` INT NOT NULL,
    `student_id` INT NOT NULL,
    
    CONSTRAINT fk_instructors_students_instructors
    FOREIGN KEY (`instructor_id`) REFERENCES `instructors`(`id`),
	CONSTRAINT fk_instructors_students_students
    FOREIGN KEY (`student_id`) REFERENCES `students`(`id`)
);

# SECTION #2
#INSERT
INSERT INTO `students` (`first_name`, `last_name`, `age`, `phone_number`)
SELECT 
	REVERSE(LOWER(`first_name`)) AS `first_name`,
	REVERSE(LOWER(`last_name`)) AS `last_name`,
    `age` + CAST(LEFT(`phone_number`, 1) AS UNSIGNED) AS `age`,
    CONCAT('1+', `phone_number`) AS `phone_number`
FROM `students`
WHERE `age` < 20;

#UPDATE
UPDATE `driving_schools` ds
JOIN `cities` c ON ds.`city_id` = c.`id`
SET `average_lesson_price` = `average_lesson_price` + 30
WHERE c.`name` = 'London' AND `night_time_driving` = 1;

#DELETE
DELETE FROM `driving_schools`
WHERE `night_time_driving` IS FALSE;

# Section 3
# Youngest students
SELECT CONCAT(`first_name`, ' ', `last_name`) AS `full_name`, `age` FROM `students`
WHERE `first_name` LIKE '%a%' AND `age` = 19
ORDER BY `id` ASC;

# Driving schools without instructors
SELECT ds.`id`, ds.`name`, c.`brand` FROM `driving_schools` ds
JOIN `cars` c ON ds.`car_id` = c.`id`
LEFT JOIN `instructors_driving_schools` ids ON ds.`id` = ids.`driving_school_id`
WHERE ids.`driving_school_id` IS NULL
ORDER BY c.`brand` ASC, ds.`id`
LIMIT 5;

# Instructors with more than one student
SELECT i.`first_name`, i.`last_name`, COUNT(*) AS `students_count`, c.`name` FROM `instructors` i
JOIN `instructors_students` ins ON i.`id` = ins.`instructor_id`
JOIN `instructors_driving_schools` ids ON i.`id` = ids.`instructor_id`
JOIN `driving_schools` ds ON ids.`driving_school_id` = ds.`id`
JOIN `cities` c ON ds.`city_id` = c.`id`
GROUP BY ins.`instructor_id`, c.`name`
HAVING `students_count` > 1
ORDER BY `students_count` DESC, i.`first_name`;

# Instructor's count by city
SELECT c.`name`, COUNT(*) AS `instructors_count` FROM `cities` c
JOIN `driving_schools` ds ON c.`id` = ds.`city_id`
JOIN `instructors_driving_schools` ids ON ds.`id` = ids.`driving_school_id`
JOIN `instructors` i ON ids.`instructor_id` = i.`id`
GROUP BY c.`name`
HAVING `instructors_count` > 0
ORDER BY `instructors_count` DESC;

# Instructor's experience level
SELECT CONCAT(`first_name`, ' ', `last_name`) AS `full_name`, (
	CASE
		WHEN YEAR(`has_a_license_from`) >= 1980 AND YEAR(`has_a_license_from`) < 1990 THEN 'Specialist'
		WHEN YEAR(`has_a_license_from`) >= 1990 AND YEAR(`has_a_license_from`) < 2000 THEN 'Advanced'
		WHEN YEAR(`has_a_license_from`) >= 2000 AND YEAR(`has_a_license_from`) < 2008 THEN 'Experienced'
		WHEN YEAR(`has_a_license_from`) >= 2008 AND YEAR(`has_a_license_from`) < 2015 THEN 'Qualified'
		WHEN YEAR(`has_a_license_from`) >= 2015 AND YEAR(`has_a_license_from`) < 2020 THEN 'Provisional'
        ELSE 'Trainee'
	END
) AS `level` FROM `instructors`
ORDER BY YEAR(`has_a_license_from`) ASC, `first_name`;

# Section 4
# Extract the average lesson price by city
DELIMITER $$
CREATE FUNCTION udf_average_lesson_price_by_city (name VARCHAR(40))
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
	DECLARE average DECIMAL(19, 2);
    SET average = (
	SELECT AVG(ds.`average_lesson_price`) FROM `driving_schools` AS ds
             JOIN `cities` AS c ON c.`id` = ds.`city_id`
    WHERE c.`name` = name);
    RETURN average;
END$$
DELIMITER ;

SELECT name, udf_average_lesson_price_by_city ('London') as average_lesson_price
FROM cities c
WHERE c.name = 'London'

# Find a driving school by the desired car brand
DELIMITER $$
CREATE PROCEDURE udp_find_school_by_car(brand VARCHAR(20))
BEGIN
	SELECT ds.`name`, ds.`average_lesson_price` FROM `driving_schools` ds
    JOIN `cars` c ON ds.`car_id` = c.`id`
	WHERE c.`brand` = brand
    ORDER BY ds.`average_lesson_price` DESC;
END$$
DELIMITER ;

CALL udp_find_school_by_car ('Mercedes-Benz');
