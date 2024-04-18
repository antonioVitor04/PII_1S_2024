create database memoria_encantada;
use database memoria_encantada,

create table tipo_usuario(
    idtipo_usuario int not null auto_increment,
    nome_do_cargo varchar not null,
    primary key (idtipo_usuario))engine=innodb;

    insert into tipo_usuario value (null, 'ALUNO');
    insert into tipo_usuario value (null, 'ADMINISTRADOR');
    insert into tipo_usuario value (null, 'PROFESSOR');

create table tb_fase(
    idfase int not null auto_increment,
    fase int not null,
    primary key (idfase))engine=innodb;

    insert into tb_fase value (null,1);
    insert into tb_fase value (null,2);
    insert into tb_fase value (null,3);
    insert into tb_fase value (null,4);
    insert into tb_fase value (null,5);
    insert into tb_fase value (null,6);
    insert into tb_fase value (null,7);
    insert into tb_fase value (null,8);
    insert into tb_fase value (null,9);
    insert into tb_fase value (null,10);
    insert into tb_fase value (null,11);
    insert into tb_fase value (null,12);
    insert into tb_fase value (null,13);
    insert into tb_fase value (null,14);
    insert into tb_fase value (null,15);
    insert into tb_fase value (null,16);
    insert into tb_fase value (null,17);
    insert into tb_fase value (null,18);
    insert into tb_fase value (null,19);
    insert into tb_fase value (null,21);
    insert into tb_fase value (null,22);
    insert into tb_fase value (null,23);
    insert into tb_fase value (null,24);
    insert into tb_fase value (null,25);

create table tb_mapa(
    idmapa int not null auto_increment,
    mapa int not null,
    nome_mapa varchar,
    primary key (idmapa))engine=innodb;

    insert into tb_mapa value (null,1,'CASA');
    insert into tb_mapa value (null,2,'ESCOLA');
    insert into tb_mapa value (null,3,'HOSPITAL');
    insert into tb_mapa value (null,4,'RESTAURANTE');
    insert into tb_mapa value (null,4,'PARQUE');

create table usuario(
    idusuario int not null auto_increment,
    nome_usuario varchar(80) not null,
    login_usuario varchar(80) not null unique,
    senha varchar(64) not null,
    tipo_cargo int not not null,
    data_de_cadastro date,
    FOREIGN KEY (tipo_cargo) references tipo_usuario (idtipo_usuario),
    primary key (idusuario))engine=innodb;

create table ranked(
    id_ranked int not null auto_increment,
    idusuario int not null,
    tempo_de_fase time,
    numero_da_fase int not null,
    mapa_tipo int not null,
    FOREIGN KEY (idusuario) references usuario (idusuario),
    FOREIGN KEY (numero_da_fase) references tb_fase (idfase),
    FOREIGN KEY (mapa_tipo) references tb_mapa (idmapa),
    primary key (id_ranked))engine=innodb;
















