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

CREATE TABLE `categories` (
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `category` VARCHAR(15) NOT NULL,
    `daily_rate` DOUBLE(5,2) NOT NULL,
    `weekly_rate` DOUBLE(5,2) NOT NULL,
    `monthly_rate` DOUBLE(5,2) NOT NULL,
    `weekend_rate` DOUBLE(5,2) NOT NULL
);

INSERT INTO `categories` (category, daily_rate, weekly_rate, monthly_rate, weekend_rate) VALUES
("category1", 55.00, 45.00, 48.00, 52.00),
("category2", 55.00, 45.00, 48.00, 52.00),
("category3", 55.00, 45.00, 48.00, 52.00);

-- ****************************************************************

CREATE DATABASE `car_rental`;

CREATE TABLE `cars` (
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `plate_number` VARCHAR(15) NOT NULL,
    `make` DOUBLE(5,2) NOT NULL,
    `model` VARCHAR(15) NOT NULL,
    `car_year` YEAR NOT NULL,
    `category_id` INT REFERENCES categories(id),
    `doors` INT NOT NULL,
    `picture` BLOB NOT NULL,
    `car_condition` VARCHAR(100) NOT NULL,
    `available` BOOL NOT NULL
);

INSERT INTO `cars` (plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) VALUES
("FG321KD", 33.3, "model", "2020", 1, 4, "test", "good", true),
("FG2321KD", 33.3, "model2", "2020", 2, 2, "test", "good", true),
("FG3214KD", 33.3, "model3", "2020", 3, 2, "test", "good", true);

CREATE TABLE `employees` (
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `first_name` VARCHAR(15) NOT NULL,
    `last_name` VARCHAR(15) NOT NULL,
    `title` VARCHAR(15) NOT NULL,
    `notes` VARCHAR(100)
);

INSERT INTO `employees` (first_name, last_name, title) VALUES
("name1", "lastname", "worker"),
("name2", "lastname", "worker"),
("name3", "lastname", "worker");


CREATE TABLE `customers` (
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `driver_license_number` INT NOT NULL,
    `full_name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(60) NOT NULL,
    `city` VARCHAR(60) NOT NULL,
    `zip_code` INT NOT NULL,
    `notes` VARCHAR(100)
);

INSERT INTO `customers` (driver_license_number, full_name, address, city, zip_code) VALUES
(32131321, "name name", "address", city, 6000),
(32321131, "name name", "address", city, 6000),
(32154631, "name name", "address", city, 6000);

CREATE TABLE `rental_orders` (
	`id` INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    `employee_id` INT REFERENCES employees(id),
    `customer_id` INT REFERENCES customers(id),
    `car_id` INT REFERENCES cars(id),
    `car_condition` VARCHAR(100) NOT NULL,
    `tank_level` INT NOT NULL,
    `kilometrage_start` INT NOT NULL,
    `kilometrage_end` INT NOT NULL,
    `total_kilometrage` INT NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE NOT NULL,
    `total_days` INT NOT NULL,
    `rate_applied` DOUBLE NOT NULL,
    `tax_rate` DOUBLE NOT NULL,
    `order_status` VARCHAR(10) NOT NULL,
    `notes` VARCHAR(100)
);

INSERT INTO `rental_orders` (employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status) VALUES
(1, 2, 2, "good", "50", 321321, 54353, 654654, "2017-06-15", "2017-06-17", 2, 33.33, 22.22, "active"),
(2, 1, 3, "good", "50", 321321, 54353, 654654, "2017-06-15", "2017-06-17", 2, 33.33, 22.22, "active"),
(3, 3, 1, "good", "50", 321321, 54353, 654654, "2017-06-15", "2017-06-17", 2, 33.33, 22.22, "active");

