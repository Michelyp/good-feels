create database ProductosdbMP;
use ProductosdbMP;
create table productos(
codigo INT AUTO_INCREMENT,
descripcion VARCHAR(45) NOT NULL,
precio_unitario DEC(7,2), 
PRIMARY KEY (Codigo)
); 
insert into productos values('1', 'Camiseta', '10');
insert into productos values('2', 'Abrigo', '120');
insert into productos values('3', 'Casadora', '80');
