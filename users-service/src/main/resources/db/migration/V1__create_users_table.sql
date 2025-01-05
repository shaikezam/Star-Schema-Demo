DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    city TEXT,
    country TEXT,
    phone_1 TEXT,
    phone_2 TEXT,
    email TEXT
);

LOAD DATA INFILE '/app/users_data.csv'
INTO TABLE users
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(first_name, last_name, city, country, phone_1, phone_2, email)
