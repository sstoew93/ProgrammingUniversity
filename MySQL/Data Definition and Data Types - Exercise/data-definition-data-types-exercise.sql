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

-- *****************************************************************************************

CREATE TABLE `people` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(200) NOT NULL,
    `picture` TEXT,
    `height` DOUBLE(3,2),
    `weight` DOUBLE(3,2),
    `gender` VARCHAR(1) NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` text
);

INSERT INTO `people` (name, picture, height, weight, gender, birthdate, biography) VALUES
("Gosho", "test", 2.55, 3.33, "m", "2005-07-07", "text"),
("Gosho2", "test", 2.55, 3.33, "m", "2005-07-07", "text"),
("Gosho3", "test", 2.55, 3.33, "m", "2005-07-07", "text"),
("Gosho4", "test", 2.55, 3.33, "m", "2005-07-07", "text"),
("Gosho5", "test", 2.55, 3.33, "m", "2005-07-07", "text"),
("Gosho6", "test", 2.55, 3.33, "m", "2005-07-07", "text");

CREATE TABLE `users` (
	`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` VARCHAR(900),
    `last_login_time` DATETIME,
    `is_deleted` BOOL
);

INSERT INTO `users` (username, password, profile_picture, last_login_time, is_deleted) VALUES
("user1", "1234", "ttest", "2022-07-07 13:31", false),
("user2", "1234", "ttest", "2022-07-07 13:31", false),
("user3", "1234", "ttest", "2022-07-07 13:31", false),
("user4", "1234", "ttest", "2022-07-07 13:31", false),
("user5", "1234", "ttest", "2022-07-07 13:31", false);

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD PRIMARY KEY (id, username);

ALTER TABLE `users`
CHANGE `last_login_time` `last_login_time` DATETIME DEFAULT NOW();

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD CONSTRAINT `pk_users` PRIMARY KEY (id),
ADD CONSTRAINT `unique` UNIQUE(username);

-- *****************************************************************************************

CREATE DATABASE `movies`;

CREATE TABLE `directors` (
	`id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `director_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

INSERT INTO `directors` (director_name, notes) VALUES
("Director1", "test"),
("Director2", "test"),
("Director3", "test"),
("Director4", "test"),
("Director5", "test");

CREATE TABLE `genres` (
	`id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `genre_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

INSERT INTO `genres` (genre_name, notes) VALUES 
("Genre1", "test"),
("Genre2", "test"),
("Genre3", "test"),
("Genre4", "test"),
("Genre5", "test");

CREATE TABLE `categories` (
	`id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `category_name` VARCHAR(50) NOT NULL,
    `notes` TEXT
);

INSERT INTO `categories` (category_name, notes) VALUES 
("category1", "test"),
("category2", "test"),
("category3", "test"),
("category4", "test"),
("category5", "test");

CREATE TABLE `movies` (
	`id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `title` VARCHAR(50) NOT NULL,
    `director_id` INT,
    `copyright_year` YEAR,
    `length` DOUBLE(5,2),
    `genre_id` INT,
    `category_id` INT,
    `rating` DOUBLE(5,2),
    `notes` TEXT,
    FOREIGN KEY (`director_id`) REFERENCES `directors`(`id`),
    FOREIGN KEY (`genre_id`) REFERENCES `genres`(`id`),
    FOREIGN KEY (`category_id`) REFERENCES `categories`(`id`)
);

INSERT INTO `movies` (title, director_id, copyright_year, length, genre_id, category_id, rating, notes) VALUES
("Title1", 2, 1992, 105.34, 3, 4, 9.33, "test"),
("Title2", 2, 1993, 115.20, 2, 1, 8.45, "test"),
("Title3", 3, 1994, 120.50, 1, 2, 9.50, "test"),
("Title4", 1, 1995, 130.12, 4, 3, 8.75, "test"),
("Title5", 4, 1996, 90.00, 5, 5, 7.90, "test");

