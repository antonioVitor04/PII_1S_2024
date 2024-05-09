create database memoria_encantada;
use database memoria_encantada;

-- create table tipo_usuario(
--     idtipo_usuario int not null auto_increment,
--     nome_do_cargo varchar(80) not null,
--     primary key (idtipo_usuario))engine=innodb;

--     insert into tipo_usuario value (null, 'ALUNO');
--     insert into tipo_usuario value (null, 'PROFESSOR');

create table tb_turma(
    id_turma int not null auto_increment,
    turma varchar (20),
    primary key (id_turma))engine=innodb;

    insert into tb_turma value (null,'1');
    insert into tb_turma value (null,'2');
    insert into tb_turma value (null,'3');
    insert into tb_turma value (null,'4');
    insert into tb_turma value (null,'5');
    insert into tb_turma value (null,'6');
    insert into tb_turma value (null,'7');
    insert into tb_turma value (null,'8');
    insert into tb_turma value (null,'9');
    insert into tb_turma value (null,'10');

-- create table tb_fase(
--     id_fase int not null auto_increment,
--     fase int not null,
--     primary key (id_fase))engine=innodb;

--     insert into tb_fase value (null,1);
--     insert into tb_fase value (null,2);
--     insert into tb_fase value (null,3);
--     insert into tb_fase value (null,4);
--     insert into tb_fase value (null,5);
--     insert into tb_fase value (null,6);
--     insert into tb_fase value (null,7);
--     insert into tb_fase value (null,8);
--     insert into tb_fase value (null,9);
--     insert into tb_fase value (null,10);

create table tb_fase(
    id_fase int not null auto_increment,
    fase int not null,
    nome_fase varchar(80),
    primary key (id_fase))engine=innodb;

    insert into tb_fase value (null,1,'CASA');
    insert into tb_fase value (null,2,'ESCOLA');
    insert into tb_fase value (null,3,'HOSPITAL');
    insert into tb_fase value (null,4,'RESTAURANTE');
    insert into tb_fase value (null,5,'PARQUE');

create table aluno(
    id_aluno int not null auto_increment,
    nome_aluno varchar(80) not null UNIQUE,
    data_de_cadastro date,
    turma int NOT NULL,
    FOREIGN KEY (turma) references tb_turma (idturma),
    primary key (id_aluno))engine=innodb;

    insert into aluno value (null,'aluno',2024-04-23, 1);

create table professor(
    id_professor int not null auto_increment,
    nome_professor varchar(80) not null UNIQUE,
    senha VARCHAR(64),
    data_de_cadastro date,
    primary key (id_professor))engine=innodb;

    insert into professor value (null,'admin','admim',2024-04-23);





create table ranked(
    id_ranked int not null auto_increment,
    id_aluno int not null,
    tempo_de_fase time,
    numero_da_fase int not null,
    turma int,
    FOREIGN KEY (turma) references tb_turma (id_turma),
    FOREIGN KEY (id_aluno) references aluno (id_aluno),
    FOREIGN KEY (numero_da_fase) references tb_fase (id_fase),
    primary key (id_ranked)) engine=innodb;
