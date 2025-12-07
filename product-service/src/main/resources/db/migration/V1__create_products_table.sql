DROP TABLE IF EXISTS product;

CREATE TABLE product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name TEXT NOT NULL,
    category TEXT NOT NULL,
    sub_category TEXT NOT NULL,
    brand TEXT,
    price DECIMAL(10, 2) NOT NULL,
    type TEXT NOT NULL,
    rating DECIMAL(3, 2) CHECK (rating BETWEEN 0 AND 5),
    description TEXT NOT NULL
);

LOAD DATA INFILE '/app/product_data.csv'
INTO TABLE product
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS
(product_name, category, sub_category, brand, price, type, @rating, description)
SET rating = NULLIF(@rating, '');
