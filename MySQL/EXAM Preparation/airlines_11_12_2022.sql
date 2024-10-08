CREATE DATABASE airlines_db;
USE airlines_db;

# SECTION 1
CREATE TABLE countries (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL UNIQUE,
    description TEXT,
    currency VARCHAR(5) NOT NULL
);

CREATE TABLE airplanes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(50) NOT NULL UNIQUE,
    passengers_capacity INT NOT NULL,
    tank_capacity DECIMAL(19,2) NOT NULL,
    cost DECIMAL(19,2) NOT NULL
);

CREATE TABLE passengers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    country_id INT NOT NULL,
    FOREIGN KEY (country_id) REFERENCES countries(id)
);

CREATE TABLE flights (
    id INT AUTO_INCREMENT PRIMARY KEY,
    flight_code VARCHAR(30) NOT NULL UNIQUE,
    departure_country INT NOT NULL,
    destination_country INT NOT NULL,
    airplane_id INT NOT NULL,
    has_delay BOOLEAN,
    departure DATETIME,
    FOREIGN KEY (departure_country) REFERENCES countries(id),
    FOREIGN KEY (destination_country) REFERENCES countries(id),
    FOREIGN KEY (airplane_id) REFERENCES airplanes(id)
);

CREATE TABLE flights_passengers (
    flight_id INT NOT NULL,
    passenger_id INT NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flights(id),
    FOREIGN KEY (passenger_id) REFERENCES passengers(id)
);

# SECTION 2
# INSERT
INSERT INTO airplanes (model, passengers_capacity, tank_capacity, cost)
SELECT 
    CONCAT(REVERSE(first_name), '797') AS model, 
    LENGTH(last_name) * 17 AS passengers_capacity,
    id * 790 AS tank_capacity,
    LENGTH(first_name) * 50.6 AS cost
FROM passengers
WHERE id <= 5;

# UPDATE
UPDATE flights
SET airplane_id = airplane_id + 1
WHERE departure_country = (
    SELECT id
    FROM countries
    WHERE name = 'Armenia'
);

# DELETE
DELETE FROM flights
WHERE id NOT IN (
    SELECT DISTINCT flight_id
    FROM flights_passengers
);

# airplanes
SELECT 
    id,
    model,
    passengers_capacity,
    tank_capacity,
    cost
FROM airplanes
ORDER BY cost DESC, id DESC;

# Flights from 2022
SELECT 
    flight_code,
    departure_country,
    airplane_id,
    departure
FROM flights
WHERE YEAR(departure) = 2022
ORDER BY airplane_id ASC, flight_code ASC
LIMIT 20;

# Private flights
SELECT 
    CONCAT(UPPER(LEFT(p.last_name, 2)), p.country_id) AS flight_code,
    CONCAT(p.first_name, ' ', p.last_name) AS full_name,
    p.country_id
FROM passengers p
LEFT JOIN flights_passengers fp ON p.id = fp.passenger_id
WHERE fp.passenger_id IS NULL
ORDER BY p.country_id ASC;

# LEading destination
SELECT 
    c.name AS name,
    c.currency AS currency,
    COUNT(fp.passenger_id) AS booked_tickets
FROM flights_passengers fp
JOIN flights f ON fp.flight_id = f.id
JOIN countries c ON f.destination_country = c.id
GROUP BY c.name, c.currency
HAVING COUNT(fp.passenger_id) >= 20
ORDER BY booked_tickets DESC;

# Parts of the day
SELECT 
    flight_code,
    departure,
    CASE
        WHEN HOUR(departure) >= 5 AND HOUR(departure) < 12 THEN 'Morning'
        WHEN HOUR(departure) >= 12 AND HOUR(departure) < 17 THEN 'Afternoon'
        WHEN HOUR(departure) >= 17 AND HOUR(departure) < 21 THEN 'Evening'
        ELSE 'Night'
    END AS day_part
FROM flights
ORDER BY flight_code DESC;

# Number of flights
DELIMITER $$
CREATE FUNCTION udf_count_flights_from_country(country VARCHAR(50))
RETURNS INT
BEGIN
    DECLARE flight_count INT;

    SELECT COUNT(*) INTO flight_count
    FROM flights f
    JOIN countries c ON f.departure_country = c.id
    WHERE c.name = country;

    RETURN flight_count;
END$$
DELIMITER ;

# Delay flight
DELIMITER $$
CREATE PROCEDURE udp_delay_flight(IN code VARCHAR(50))
BEGIN
    -- Update the flight status and departure time
    UPDATE flights
    SET 
        has_delay = TRUE, 
        departure = DATE_ADD(departure, INTERVAL 30 MINUTE)
    WHERE flight_code = code;
END$$
DELIMITER ;

