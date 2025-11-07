CREATE DATABASE dealership;
DROP DATABASE dealership;
USE dealership;

-- Level 0
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    charge VARCHAR(50) NOT NULL,
    phone CHAR(9) UNIQUE NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    dni CHAR(9) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE ,
    address VARCHAR(100)
);

CREATE TABLE marks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE type_of_vehicle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(50) NOT NULL
);

-- Level 1
CREATE TABLE models (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mark_id INT,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT fk_marks FOREIGN KEY (mark_id) REFERENCES marks(id)
);

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    employee_id INT,
    sale_date DATETIME NOT NULL DEFAULT now(),
    method_of_payment VARCHAR(50) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,

    CONSTRAINT fk_clients FOREIGN KEY (client_id) REFERENCES clients(id),
    CONSTRAINT fk_employees FOREIGN KEY (employee_id) REFERENCES employees(id)
);

CREATE TABLE financing (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sale_id INT,
    entity VARCHAR(100) NOT NULL ,
    amount DECIMAL(10,2) NOT NULL,
    term_in_months INT NOT NULL,
    interest_rate DECIMAL(5, 2) NOT NULL,
    CONSTRAINT fk_sale FOREIGN KEY (sale_id) REFERENCES sales(id)
);

CREATE TABLE vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    model_id INT,
    type_of_vehicle_id INT,
    year INT NOT NULL,
    color VARCHAR(30) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL,
    CONSTRAINT fk_models FOREIGN KEY (model_id) REFERENCES models(id),
    CONSTRAINT fk_type_of_vehicle FOREIGN KEY (type_of_vehicle_id) REFERENCES type_of_vehicle(id)
);

CREATE TABLE sales_details (
    id INT AUTO_INCREMENT,
    sale_id INT,
    vehicle_id INT,
    quantity INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL,
    CONSTRAINT pk_sales_details PRIMARY KEY (id, sale_id, vehicle_id),
    CONSTRAINT fk_sales FOREIGN KEY (sale_id) REFERENCES sales(id),
    CONSTRAINT fk_vehicles FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

CREATE TABLE maintenance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    vehicle_id INT,
    maintenance_date DATETIME NOT NULL,
    type_of_service VARCHAR(100) NOT NULL,
    cost DECIMAL(10,2) NOT NULL,
    observations TEXT,
    CONSTRAINT fk_vehicles_maintenance FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);

INSERT INTO type_of_vehicle (description) VALUES ('AUTOMOVIL');
INSERT INTO type_of_vehicle (description) VALUES ('SUV');
INSERT INTO type_of_vehicle (description) VALUES ('PICK-UV');

INSERT INTO marks (name) VALUES ('TOYOTA');
INSERT INTO marks (name) VALUES ('HYUNDAI');
INSERT INTO marks (name) VALUES ('KIA');

INSERT INTO models (mark_id, name) VALUES (1, 'COROLLA');
INSERT INTO models (mark_id, name) VALUES (1, 'LAND CRUSIER');
INSERT INTO models (mark_id, name) VALUES (1, 'HILUX');
INSERT INTO models (mark_id, name) VALUES (2, 'ELANTRA');
INSERT INTO models (mark_id, name) VALUES (2, 'CRETA');
INSERT INTO models (mark_id, name) VALUES (2, 'SANTA FE');
INSERT INTO models (mark_id, name) VALUES (3, 'CERATO');
INSERT INTO models (mark_id, name) VALUES (3, 'KARENS');
INSERT INTO models (mark_id, name) VALUES (3, 'SORENTO');

INSERT INTO vehicles (model_id, type_of_vehicle_id, year, color, price, stock) VALUES (3, 3, 2022, 'RED', 32234, 43);
INSERT INTO vehicles (model_id, type_of_vehicle_id, year, color, price, stock) VALUES (7, 2, 2025, 'BLUE', 423234, 22);
INSERT INTO vehicles (model_id, type_of_vehicle_id, year, color, price, stock) VALUES (6, 1, 2024, 'BLACK', 523234, 13);
INSERT INTO vehicles (model_id, type_of_vehicle_id, year, color, price, stock) VALUES (2, 2, 2023, 'YELLOW', 62234, 83);
INSERT INTO vehicles (model_id, type_of_vehicle_id, year, color, price, stock) VALUES (4, 1, 2022, 'GREEN', 23234, 18);

INSERT INTO clients (name, last_name, dni, email, address) VALUES ('Juan', 'Suarez', '845323454','juansxcez@gmail.com', 'Jr Lima');
INSERT INTO clients (name, last_name, dni, email, address) VALUES ('Juan', 'Suarez', '845373454','juauaez@gmail.com', 'Jr Lima');
INSERT INTO clients (name, last_name, dni, email, address) VALUES ('Juan', 'Suarez', '845523454','juanuarez@gmail.com', 'Jr Lima');
INSERT INTO clients (name, last_name, dni, email, address) VALUES ('Juan', 'Suarez', '949503454','jnsuaez@gmail.com', 'Jr Lima');
INSERT INTO clients (name, last_name, dni, email, address) VALUES ('Juan', 'Suarez', '845323464','junsuarez@gmail.com', 'Jr Lima');

INSERT INTO employees (name, last_name, charge, phone, email) VALUES ('Maria', 'Espinoza', 'Supervisor', '983852345', 'mariaespinoza');
INSERT INTO employees (name, last_name, charge, phone, email) VALUES ('Maria', 'Espinoza', 'Supervisor', '983482345', 'mariaespinoza');
INSERT INTO employees (name, last_name, charge, phone, email) VALUES ('Maria', 'Espinoza', 'Supervisor', '983452345', 'mariaespinoza');
INSERT INTO employees (name, last_name, charge, phone, email) VALUES ('Maria', 'Espinoza', 'Supervisor', '986452345', 'mariaespinoza');
INSERT INTO employees (name, last_name, charge, phone, email) VALUES ('Maria', 'Espinoza', 'Supervisor', '983457345', 'mariaespinoza');

SELECT * FROM clients c JOIN sales s on c.id = s.client_id;

SELECT v.id,year, color, price, stock, mk.name AS mark,m.name AS model, tov.description AS type
FROM vehicles v
    JOIN models m on v.model_id = m.id
    JOIN marks mk on m.mark_id = mk.id
    JOIN type_of_vehicle tov on v.type_of_vehicle_id = tov.id
ORDER BY year DESC;

SELECT * FROM clients;
SELECT * FROM type_of_vehicle;

-- Cambiar nombre a la tabla
ALTER TABLE clients ADD COLUMN phone CHAR(9) UNIQUE AFTER name;
ALTER TABLE vehicles ADD COLUMN serie CHAR(12) UNIQUE AFTER type_of_vehicle_id;

