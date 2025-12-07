create DATABASE user_service;
create DATABASE product_service;
create DATABASE sales_service;

GRANT ALL PRIVILEGES ON `user_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON user_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON `product_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON product_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON `sales_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON sales_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
GRANT FILE ON *.* TO 'admin'@'%';
FLUSH PRIVILEGES;
