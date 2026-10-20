show databases;

create database teste1;

use teste1;

create table cliente (
	pk_cli varchar(7) primary key,
    dt_ultpes_cli varchar(7),
    fax_fat_cli varchar(35),
    nm_seg_cli varchar(20)
);

create table reuniao(
	pk_reu int primary key,
    fk_pk_cli varchar(7) unique ,
    constraint fk_pk_cli
    foreign key(fk_pk_cli) references cliente(pk_cli),
    nt_nps_reu int, 
    tr_reu longtext not null,
    dt_reu datetime not null
);

create table relatorio_IA(
	pk_rel int primary key auto_increment,
    fk_pk_reu int unique not null,
    constraint fk_pk_reu
    foreign key(fk_pk_reu) references reuniao(pk_reu),
    dr_cli_rel varchar(120), 
    rs_rel varchar(120),
    pr_cli_rel varchar(200),
    rc_rel varchar(350)
);

create table usuario(
	pk_usu int primary key,
    email_usu varchar(35) unique not null ,
    sn_usu varchar(30) not null, 
    num_tel_usu varchar(15),
    cr_usu varchar(30) not null
);

create table produto(
	pk_pro int primary key auto_increment,
    nm_pro varchar(35) not null ,
    ds_pro varchar(150) not null
);


desc cliente;
desc reuniao;
desc relatorio_IA;
desc usuario;
desc produto;

alter table reuniao modify fk_pk_cli varchar(7) not null;
alter table usuario modify pk_usu int auto_increment;
alter table usuario add nome varchar(15);
alter table usuario CHANGE COLUMN nome nm_usu varchar(15);

show tables;

select * from cliente;

insert into usuario (email_usu, sn_usu, num_tel_usu, cr_usu) values('vitorpallis@gmail.com', '666999Op!@+2','11 99021-1003','dev');
insert into usuario (email_usu, sn_usu, num_tel_usu, cr_usu) values('carlos_o_CEO@gmail.com', '123456','11 12345-7890','ceo');

update usuario set nome = "vitor" where pk_usu = 1;
update usuario set nome = "carlos" where pk_usu = 2;

CREATE USER 'backend_sprint'@'localhost' IDENTIFIED BY 'senha_do_backend';

GRANT SELECT, INSERT
ON teste1.*
TO 'backend_sprint'@'localhost';

FLUSH PRIVILEGES;