CREATE DATABASE `minions`;

USE `minions`;

CREATE TABLE `minions` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `age` INT
);

CREATE TABLE `towns` (minions
	`town_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL 
);

ALTER TABLE `towns`
CHANGE `town_id` `id` INT;

ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL;

ALTER TABLE `minions`
ADD CONSTRAINT `fk_minion_town`
FOREIGN KEY (town_id) REFERENCES towns(id);

INSERT INTO `towns` (id, name) VALUES 
(1, "Sofia"),
(2, "Plovdiv"),
(3, "Varna");

INSERT INTO `minions` (id, name, age, town_id) VALUES
(1, "Kevin", 22, 1),
(2, "Bob", 15, 3),
(3, "Steward", NULL, 2);

TRUNCATE TABLE `minions`;

DROP TABLE `minions`, `towns`;
