-- Comentario en una sola linea
# Comentario en una sola linea
/*
Hacer comentarios
en
varias
lineas
*/

-- DDL--> Estructuras en tablas y BD.
/*
CREATE
ALTER
DROP
*/

/* SINTAXIS:
create database <nom_BD>;
*/
create database dbcalificaciones;
/* Seleccionar una BD:
SINTAXIS: Use <nom_BD>;
*/
use dbcalificaciones;
/*Crear tablas:
SINTAXIS:
CREATE TABLE <nom_tabla>(
campo1 tipoDato1 primary key,
campo2 tipoDato2,
campo3 tipoDato3, ...
campoN tipoDatoN);
*/
CREATE TABLE materias(
     idmat INT primary key ,
     nommat varchar(45)
);

CREATE TABLE estudiantes(
    idest INT primary key,
    nomest varchar(45) ,
    apest varchar(50),
    direst varchar(60) ,
    celest char(9),
    deporPract varchar(20)
);

CREATE TABLE notas(
  idest INT,
  idmat INT,
  nota INT,
-- constraINT--> Contantes o reglas
-- creando PKC
  constraINT pk_notas primary key(idest,idmat),
-- creando FK
  constraINT fk_mat_notas foreign key(idmat) references materias(idmat),
  constraINT fk_est_notas foreign key(idest) references estudiantes(idest)
);

/*Instrucción: ALTER--> Modificar estructuras BD, Tablas y campos
*/
-- Adicionar un nuevo campo a la tabla
ALTER TABLE notas ADD COLUMN nota2 INT;
-- Adicionar un nuevo campo en una posicion específica
ALTER TABLE notas ADD COLUMN nota1 INT AFTER idmat;
-- Modificar el nombre del campo de una tabla
ALTER TABLE notas change nota nota3 INT;
-- Modificar la posición de un campo
ALTER TABLE notas modify nota3 INT AFTER nota2;
-- Modificar el tipo de dato o longitud de un campo
ALTER TABLE notas ADD COLUMN prom INT;
ALTER TABLE notas modify prom decimal(4,2);
-- Modificar el nombre de una tabla
ALTER TABLE notas rename calificacion;
ALTER TABLE materias rename cursos;
/*
DROP--> Eliminar BD, Tablas y campos
*/
-- Eliminar un campo de una tabla
ALTER TABLE calificacion drop column prom;
-- Eliminar Tablas
drop table calificacion;
-- Eliminar BD
drop database dbcalificaciones;

# Optimizacion DDL - creacion de BD, TB
/*
- Establecer obligatoriedad de campos (NOT NULL)
NULL--> opcional y acepta campos vacíos
NOT NULL--> No acepta campos vacíos
- Establecer un campo autoincrementable(AUTO_INCREMENT)--> Sólo para tipos de datos enteros
- Establecer valor por defecto en un campo(DEFAULT)
- Establecer un campo con valores unicos(UNIQUE)
*/
create database dbcalificaciones;
use dbcalificaciones;
CREATE TABLE materias(
    idmat INT auto_increment primary key,
    nommat varchar(45) NOT NULL
);

CREATE TABLE estudiantes(
    idest INT auto_increment primary key,
    nomest varchar(45) NOT NULL,
    apest varchar(50) NOT NULL,
    direst varchar(60) NOT NULL,
    celest char(9) unique NOT NULL,
    deporPract varchar(20)
);

CREATE TABLE notas(
    idest INT,
    idmat INT,
    nota1 INT NOT NULL,
    nota2 INT NOT NULL,
    nota3 INT NOT NULL,
    fechreg datetime default now(),
    constraINT pk_notas primary key(idest,idmat),
    constraINT fk_mat_notas foreign key(idmat) references materias(idmat),
    constraINT fk_est_notas foreign key(idest) references estudiantes(idest)
);

/*Instrucciones DML--> Manipular datos de las tablas
Insert
Update
Delete
SELECT
*/

-- Instrucción: INSERT--> Adicionar un nuevo registro a una tabla
/*
Forma 01:
SINTaxis:
INSERT INTO <NOM_TABLA> VALUES(VALOR1,VALOR2,....);

Forma 02:
SINTaxis:
INSERT INTO <NOM_TABLA>(CAMPO1, CAMPO2,...) VALUES(VALOR1,VALOR2,....);
*/
INSERT INTO materias(nommat) VALUES ('Matemática Básica');
INSERT INTO materias(nommat) VALUES ('Física I');
INSERT INTO materias(nommat) VALUES ('Estadística I');

SELECT * FROM materias;

insert INTo estudiantes(nomest,apest,direst,celest,deporPract) VALUES
('Juan Carlos','Santillan Rivera','Jr. Camelias 715','923658963','Fútbol'),
('Karla Maria','Ordaz Vela','Jr. Perú 115','923658999', NULL),
('Julio Esteban','Callan Espiritu','Jr. Ambo 915','923658999', NULL);

SELECT * FROM estudiantes;

insert INTo notas(idest,idmat,nota1,nota2,nota3)
values(2,1,12,16,9);
insert INTo notas(idest,idmat,nota1,nota2,nota3)
values(2,3,19,15,13);
SELECT * FROM notas;
