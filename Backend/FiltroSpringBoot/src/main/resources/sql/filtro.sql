CREATE TABLE CelularPersonal(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    personal_id INT NOT NULL,
    celular VARCHAR(255) NOT NULL
);
ALTER TABLE
    CelularPersonal ADD UNIQUE celularpersonal_celular_unique(celular);
CREATE TABLE Personal(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    identificacion VARCHAR(255) NOT NULL,
    nombre1 VARCHAR(255) NOT NULL,
    nombre2 VARCHAR(255) NULL,
    apellido1 VARCHAR(255) NOT NULL,
    apellido2 VARCHAR(255) NULL,
    nacimiento DATE NOT NULL,
    sexo VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);
ALTER TABLE
    Personal ADD UNIQUE personal_identificacion_unique(identificacion);
CREATE TABLE Inventario(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    producto_id INT NOT NULL,
    cantidad INT NOT NULL
);
CREATE TABLE Producto(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    imagen VARCHAR(255) NOT NULL,
    precio DOUBLE NOT NULL
);
CREATE TABLE Carrito(
    producto_id INT NOT NULL,
    factura_id INT  NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY(producto_id,factura_id)
);
CREATE TABLE Cuenta(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('debito','credito') NOT NULL,
    tarjeta VARCHAR(255) NOT NULL,
    cvv VARCHAR(255) NOT NULL,
    caducidad DATE NOT NULL
);
CREATE TABLE Cliente(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    identificacion VARCHAR(255) NOT NULL,
    nombre1 VARCHAR(255) NOT NULL,
    nombre2 VARCHAR(255) NULL,
    apellido1 VARCHAR(255) NOT NULL,
    apellido2 VARCHAR(255) NULL,
    nacimiento DATE NOT NULL,
    sexo VARCHAR(255) NOT NULL,
    celular VARCHAR(255) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    correo VARCHAR(255) NOT NULL
);
ALTER TABLE
    Cliente ADD UNIQUE cliente_identificacion_unique(identificacion);
ALTER TABLE
    Cliente ADD UNIQUE cliente_celular_unique(celular);
ALTER TABLE
    Cliente ADD UNIQUE cliente_correo_unique(correo);
CREATE TABLE Factura(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    personal_ID INT NOT NULL,
    cliente_ID INT NOT NULL,
    fecha DATE NOT NULL,
    estado ENUM('proceso', 'pagado') NOT NULL,
    cuenta_id INT NOT NULL
);
CREATE TABLE CorreosPersonal(
    id INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    personal_id INT NOT NULL,
    correoElectronico VARCHAR(255) NOT NULL
);
ALTER TABLE
    CorreosPersonal ADD UNIQUE correospersonal_correoelectronico_unique(correoElectronico);


ALTER TABLE
    Carrito ADD CONSTRAINT carrito_id_foreign_producto FOREIGN KEY(producto_id) REFERENCES Producto(id);
ALTER TABLE
    Carrito ADD CONSTRAINT carrito_id_foreign_factura FOREIGN KEY(factura_id) REFERENCES Factura(id);
ALTER TABLE
    Factura ADD CONSTRAINT factura_cliente_id_foreign FOREIGN KEY(cliente_ID) REFERENCES Cliente(id);
ALTER TABLE
    Factura ADD CONSTRAINT factura_cuenta_id_foreign FOREIGN KEY(cuenta_id) REFERENCES Cuenta(id);
ALTER TABLE
    Factura ADD CONSTRAINT factura_personal_id_foreign FOREIGN KEY(personal_ID) REFERENCES Personal(id);
ALTER TABLE
    Inventario ADD CONSTRAINT inventario_producto_id_foreign FOREIGN KEY(producto_id) REFERENCES Producto(id);
ALTER TABLE
    CorreosPersonal ADD CONSTRAINT correospersonal_personal_id_foreign FOREIGN KEY(personal_id) REFERENCES Personal(id);
ALTER TABLE
    CelularPersonal ADD CONSTRAINT celularpersonal_personal_id_foreign FOREIGN KEY(personal_id) REFERENCES Personal(id);