CREATE DATABASE market;
USE market;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

ALTER TABLE products ADD COLUMN create_at DATETIME DEFAULT now();
ALTER TABLE products ADD COLUMN updated_at DATETIME DEFAULT now();

ALTER TABLE products CHANGE create_at created_at DATETIME NOT NULL DEFAULT now();

INSERT INTO products (name, price, stock) VALUES
('Samsung', 12.56, 45),
('Lenovo', 12.56, 45),
('Apple MacBook Air M2', 5400.00, 5),
('Asus ROG Strix G15', 4800.75, 7),
('Xiaomi Redmi Note 13', 999.99, 20),
('Dell Inspiron 3520', 3100.20, 9),
('Acer Nitro 5', 4100.00, 6),
('Huawei MateBook D14', 2900.00, 12),
('MSI Modern 14', 2700.00, 14),
('Samsung Monitor 27"', 750.00, 25),
('Logitech G Pro Mouse', 250.00, 40),
('Razer BlackWidow Keyboard', 550.00, 18),
('Kingston SSD 1TB', 420.00, 50),
('Corsair RAM 16GB', 310.00, 35),
('Seagate HDD 2TB', 360.00, 22),
('Nvidia RTX 4060', 2100.00, 6),
('AMD Ryzen 7 5800X', 1500.00, 9),
('TP-Link Router AX1800', 320.00, 30),
('Canon Printer G3110', 890.00, 11);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    dni CHAR(8) UNIQUE NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL
);