DROP TABLE IF EXISTS products;

CREATE TABLE products (
    product_key INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    subcategory VARCHAR(100),
    brand VARCHAR(100),
    price DECIMAL(10, 2) NOT NULL
);