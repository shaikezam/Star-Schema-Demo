create DATABASE users_service;
create DATABASE products_service;
create DATABASE sales_service;

GRANT ALL PRIVILEGES ON `users_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON users_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON `products_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON products_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON `sales_service`.* TO 'admin'@'%';
GRANT ALL PRIVILEGES ON sales_service.* TO 'admin'@'%' IDENTIFIED BY 'admin';
FLUSH PRIVILEGES;
