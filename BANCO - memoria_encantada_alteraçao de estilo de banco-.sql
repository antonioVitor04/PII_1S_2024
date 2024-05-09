create database memoria_encantada;
use database memoria_encantada;

create table tb_turma(
    idturma int not null auto_increment,
    turma varchar (20),
    primary key (idturma))engine=innodb;

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

create table tb_fase(
    idfase int not null auto_increment,
    fase int not null,
    nome_fase varchar(80),
    primary key (idfase))engine=innodb;

        insert into tb_fase value (null,1,"PARQUE");
        insert into tb_fase value (null,2,"RESTAURANTE");
        insert into tb_fase value (null,3,"ESCOLA: MATERIAL ESCOLAR");
        insert into tb_fase value (null,4,"ESCOLA: ATIVIDADES");
        insert into tb_fase value (null,5,"HOSPITAL");
        insert into tb_fase value (null,6,"CASA: COZINHA");
        insert into tb_fase value (null,7,"CASA: SALA");
        insert into tb_fase value (null,8,"CASA: QUARTO");
        insert into tb_fase value (null,9,"CASA: BANHEIRO");
        insert into tb_fase value (null,10,null);

create table prof(
    id_prof int not null auto_increment,
    nome_usuario varchar(80) not null,
    login_usuario varchar(80) not null unique,
    senha varchar(200) not null,
    tipo_cargo int not null,
    data_de_cadastro date,
    turma int,
    turma2 int,
    turma3 int,
    turma4 int,
    turma5 int,
    turma6 int,
    turma7 int,
    turma8 int,
    turma9 int,
    turma10 int,
    FOREIGN KEY (turma10) references tb_turma (idturma),
    FOREIGN KEY (turma9) references tb_turma (idturma),
    FOREIGN KEY (turma8) references tb_turma (idturma),
    FOREIGN KEY (turma7) references tb_turma (idturma),
    FOREIGN KEY (turma6) references tb_turma (idturma),
    FOREIGN KEY (turma5) references tb_turma (idturma),
    FOREIGN KEY (turma4) references tb_turma (idturma),
    FOREIGN KEY (turma3) references tb_turma (idturma),
    FOREIGN KEY (turma2) references tb_turma (idturma),
    FOREIGN KEY (turma) references tb_turma (idturma),
    primary key (id_prof))engine=innodb;

create table alunos(
    id_alunos int not null auto_increment,
    nome_aluno varchar(80) not null,
    login_aluno varchar(80) not null unique,
    data_de_cadastro_aluno date,
    turma int,
    FOREIGN KEY (turma) references tb_turma (idturma),
    primary key (id_alunos))engine=innodb;

create table ranked(
    id_ranked int not null auto_increment,
    id_prof int not null,
    id_alunos int,
    tempo_de_fase time,
    numero_da_fase int not null,
    nome_da_fase int,
    turma int,
    FOREIGN KEY (nome_da_fase) references tb_fase (idfase),
    FOREIGN KEY (turma) references tb_turma (idturma),
    FOREIGN KEY (id_alunos) references alunos (id_alunos),
    FOREIGN KEY (numero_da_fase) references tb_fase (idfase),
    primary key (id_ranked))engine=innodb;




