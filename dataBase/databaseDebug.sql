use totvs;

show tables;

alter table clie modify column id_clie varchar(15) not null;

show columns from clie;
select * from clie;

select * from conv;

show columns from conv;

alter table clie modify column dt_ultima_pesquisa varchar(10);
alter table clie drop column nt_nps;

TRUNCATE TABLE clie;

alter table conv drop column id_clie;


