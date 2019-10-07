drop database if exists foro;
create database foro;
use foro;

create table Participante(
	id_participante int not null auto_increment primary key,
    usuario char(15) not null,
	twit varchar(250) not null
);