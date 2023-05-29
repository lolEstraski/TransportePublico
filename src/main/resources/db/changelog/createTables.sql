CREATE TABLE ADMINISTRADORES
(
    id       int         NOT NULL AUTO_INCREMENT,
    cedula   varchar(20) NOT NULL,
    nombre   varchar(50) NOT NULL,
    email    varchar(50) NOT NULL,
    telefono varchar(20) NOT NULL,
    pass     varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE RUTAS
(
    id         int         NOT NULL AUTO_INCREMENT,
    nombre     varchar(50) NOT NULL,
    plataforma     varchar(50) NOT NULL,
    origen     varchar(50) NOT NULL,
    destino     varchar(50) NOT NULL,
    frecuencia varchar(50) NOT NULL,
    sentido    varchar(50) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE HORARIOS
(
    id         int         NOT NULL AUTO_INCREMENT,
    horaInicio TIME        NOT NULL,
    horaFin    TIME        NOT NULL,
    dia        varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PASAJEROS
(
    id       int         NOT NULL AUTO_INCREMENT,
    cedula   varchar(20) NOT NULL,
    nombre   varchar(50) NOT NULL,
    telefono varchar(20) NOT NULL,
    email varchar(50) NOT NULL,
    pass varchar(20) NOT NULL,
    calificacion INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE PQRS
(
    id          int         NOT NULL AUTO_INCREMENT,
    nombre      varchar(20) NOT NULL,
    descripcion varchar(50) NOT NULL,
    tipo        varchar(20) NOT NULL,
    fecha       varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE RUTAS_FAVORITAS
(
    id     int         NOT NULL AUTO_INCREMENT,
    nombre varchar(50) ,
    id_ruta int NOT NULL,
    id_pasajero int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_ruta) REFERENCES RUTAS(id),
    FOREIGN KEY (id_pasajero) REFERENCES PASAJEROS(id)
);

CREATE TABLE PARADAS
(
    id     int         NOT NULL AUTO_INCREMENT,
    id_ruta int NOT NULL,
    nombre varchar(50) NOT NULL,
    direccion   varchar(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_ruta) REFERENCES RUTAS(id)
);

CREATE SEQUENCE hibernate_sequence START WITH (Select (count(id) +1) from ADMINISTRADORES);