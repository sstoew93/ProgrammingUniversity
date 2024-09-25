USE `book_library`;

SELECT `title` FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;

SELECT CONCAT('***', SUBSTRING(`title`, 4)) FROM `books`
WHERE `title` LIKE 'The%'
ORDER BY `id`;

SELECT ROUND(SUM(`cost`), 2) FROM `books`;

SELECT 
    CONCAT(`first_name`, ' ', `last_name`) AS `Full Name`,
    CASE 
        WHEN `died` IS NOT NULL 
            THEN DATEDIFF(`died`, `born`) 
        ELSE NULL
    END AS `Days Lived`
FROM authors;

SELECT `title` FROM `books`
WHERE `title` LIKE 'Harry Potter%'
ORDER BY `id`;
