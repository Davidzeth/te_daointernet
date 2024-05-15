DROP DATABASE IF EXISTS bd_internet;
CREATE DATABASE bd_internet CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use bd_internet;
create table registro (
id int(11) unsigned auto_increment primary key,
nombre varchar(50) not null,
apellido varchar(50) not null,
seminario varchar(50) not null,
confirmado boolean not null,
fecha varchar(20) not null DEFAULT('-')
);

insert into registro (nombre, apellido, seminario, confirmado, fecha) values ('Bruno','Diaz Yujra','Hacking web', true, '12/12/2024');
insert into registro (nombre, apellido, seminario, confirmado, fecha) values ('Zoila', 'Mamani Perez','Criptografia', false, '11/01/2024');

select * from registro;