# 01. One-To-One Relationship
CREATE TABLE `passports` (
	`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(255) UNIQUE
);

ALTER TABLE `passports` auto_increment = 101;

CREATE TABLE `people` (
	`person_id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(255),
    `salary` DECIMAL(15,2),
    `passport_id` INT UNIQUE,
    
    CONSTRAINT fk_people_passport
    FOREIGN KEY (`passport_id`) 
    REFERENCES `passports`(`passport_id`)
);

INSERT INTO `passports` (`passport_number`) VALUES
('N34FG21B'),
('K65LO4R7'),
('ZE657QP2');

INSERT INTO `people`(`first_name`, `salary`, `passport_id`) VALUES 
('Roberto', 43300.00, 102),
('Tom', 56100.00, 103),
('Yana', 60200.00, 101);

# 02. One-To-Many Relationship
CREATE TABLE `manufacturers` (
	`manufacturer_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL unique,
    `established_on` DATE NOT NULL
);

INSERT INTO `manufacturers` (`name`, `established_on`) VALUES
('BMW', '1916-03-01'),
('Tesla', '2003-01-01'),
('Lada', '1966-05-01');

CREATE TABLE `models` (
	`model_id` INT PRIMARY KEY auto_increment,
    `name` VARCHAR(50) NOT NULL,
    `manufacturer_id` INT NOT NULL,
    
    CONSTRAINT fk_model_manufacturer
    FOREIGN KEY (`manufacturer_id`)
    REFERENCES `manufacturers`(`manufacturer_id`)
);

ALTER TABLE `models` auto_increment = 101;

INSERT INTO `models` (`name`, `manufacturer_id`) VALUES
('X1', 1),
('i6', 1),
('Model S', 2),
('Model X', 2),
('Model 3', 2),
('Nova', 3);

# 03. Many-To-Many Relationship
CREATE TABLE `exams` (
	`exam_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);

ALTER TABLE `exams` auto_increment = 101;

INSERT INTO `exams` (`name`) VALUES 
('Spring MVC'),
('Neo4j'),
('Oracle 11g');

CREATE TABLE `students` (
	`student_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

INSERT INTO `students` (`name`) VALUES 
('Mila'),
('Toni'),
('Ron');

CREATE TABLE `students_exams` (
	`student_id` INT NOT NULL,
    `exam_id` INT NOT NULL,
    
    CONSTRAINT fk_examid_exams
    FOREIGN KEY (`exam_id`) REFERENCES `exams`(`exam_id`),
    
    FOREIGN KEY (`student_id`) REFERENCES `students`(`student_id`),
    
    PRIMARY KEY (`student_id`, `exam_id`)
);

INSERT INTO `students_exams` (`student_id`, `exam_id`) VALUES 
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

# 04. Self-Referencing
CREATE TABLE `teachers` (
	`teacher_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `manager_id` INT
);

ALTER TABLE `teachers` auto_increment = 101;

INSERT INTO `teachers` (`name`, `manager_id`) VALUES 
('John', null),
('Maya', 106),
('Silvia', 106),
('Ted', 105),
('Mark', 101),
('Greta', 101);

ALTER TABLE `teachers` 
    ADD FOREIGN KEY (`manager_id`)
	REFERENCES `teachers` (`teacher_id`);
    

# 05. Online Store Database
CREATE DATABASE `store_db`;
USE `store_db`;

CREATE TABLE `cities` (
	`city_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `customers` (
	`customer_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `birthday` DATE NOT NULL,
    `city_id` INT NOT NULL,
    
    CONSTRAINT fk_customers_cities
    FOREIGN KEY (`city_id`) REFERENCES `cities`(`city_id`)
);

CREATE TABLE `orders` (
	`order_id` INT AUTO_INCREMENT PRIMARY KEY,
    `customer_id` INT NOT NULL,
    
    constraint fk_orders_customers
    FOREIGN KEY (`customer_id`)
    REFERENCES `customers`(`customer_id`)
);

CREATE TABLE `item_types` (
	`item_type_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `items` (
	`item_id` INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `item_type_id` INT NOT NULL,
    
    CONSTRAINT fk_items_orderitems
    FOREIGN KEY (`item_type_id`) REFERENCES `item_types`(`item_type_id`)
);

CREATE TABLE `order_items` (
	`order_id` INT NOT NULL,
    `item_id` INT NOT NULL,
    PRIMARY KEY(`order_id`, item_id),
    
    CONSTRAINT fk_orderitems_orders
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`order_id`),
    
	CONSTRAINT fk_orderitem_items
    FOREIGN KEY (`item_id`) REFERENCES `items`(`item_id`)
);

# 06. University Database
CREATE DATABASE `uni_db`;
USE `uni_db`;

CREATE TABLE `subjects` (
	`subject_id` INT PRIMARY KEY AUTO_INCREMENT,
    `subject_name` VARCHAR(50) NOT NULL
);

CREATE TABLE `majors` (
	`major_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `students` (
	`student_id` INT AUTO_INCREMENT PRIMARY KEY,
    `student_number` VARCHAR(12) NOT NULL,
    `student_name` VARCHAR(50) NOT NULL,
    `major_id` INT NOT NULL,
    
    CONSTRAINT fk_students_majorid
    FOREIGN KEY (`major_id`) REFERENCES `majors`(`major_id`)
);

CREATE TABLE `payments` (
	`payment_id` INT AUTO_INCREMENT PRIMARY KEY,
    `payment_date` DATE NOT NULL,
    `payment_amount` DECIMAL(8,2) NOT NULL,
    `student_id` INT NOT NULL,
    
    CONSTRAINT fk_studentid_students
    FOREIGN KEY (`student_id`) REFERENCES `students`(`student_id`)
);

CREATE TABLE `agenda` (
	`student_id` INT,
    `subject_id` INT,
    
    PRIMARY KEY (`student_id`, `subject_id`),
    CONSTRAINT 
    FOREIGN KEY (`student_id`) REFERENCES `students`(`student_id`),
    
    CONSTRAINT 
    FOREIGN KEY (`subject_id`) REFERENCES `subjects`(`subject_id`)
);

# 09. Peaks in RIlla

SELECT `mountain_range`, `peak_name`, `elevation` AS 'peak_elevation' FROM `mountains`
JOIN `peaks` ON `mountains`.`id` = `peaks`.`mountain_id`
HAVING `mountain_range` = 'Rila'
ORDER BY `elevation` DESC;






