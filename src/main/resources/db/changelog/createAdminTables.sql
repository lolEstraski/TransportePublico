CREATE TABLE ADMINISTRADORES (
    id int NOT NULL AUTO_INCREMENT,
    cedula varchar(20) NOT NULL,
    nombre varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    telefono varchar(20) NOT NULL,
    pass varchar(20) NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE hibernate_sequence START WITH (Select (count(id) +1) from ADMINISTRADORES);