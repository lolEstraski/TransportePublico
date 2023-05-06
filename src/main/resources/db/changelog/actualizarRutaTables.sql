CREATE TABLE RUTAS
(
    id         int         NOT NULL AUTO_INCREMENT,
    nombre     varchar(50) NOT NULL,
    frecuencia varchar(50) NOT NULL,
    sentido    varchar(20) NOT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE Administrador
(
    id       int         NOT NULL AUTO_INCREMENT,
    cedula   varchar(50) NOT NULL,
    nombre   varchar(50) NOT NULL,
    telefono varchar(20) NOT NULL,
    email    varchar(20) NOT NULL,
    pass     varchar(20) not null
        PRIMARY KEY (id)
);

CREATE TABLE Horario
(
    id   int         NOT NULL AUTO_INCREMENT,
    hora varchar(50) NOT NULL,
    dia  varchar(50) NOT NULL,

);

CREATE TABLE Persona
(
    id       int         NOT NULL AUTO_INCREMENT,
    cedula   varchar(50) NOT NULL,
    nombre   varchar(50) NOT NULL,
    telefono varchar(50) NOT NULL,
    email    varchar(50) NOT NULL,
    pass     varchar(50) NOT NULL,

);

CREATE TABLE Peticion
(
    id          int         NOT NULL AUTO_INCREMENT,
    nombre      varchar(50) NOT NULL,
    descripcion varchar(50) NOT NULL,
    tipo        varchar(50) NOT NULL,
    fecha       varchar(50) NOT NULL,


);







