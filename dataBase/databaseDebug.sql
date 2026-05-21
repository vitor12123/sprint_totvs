use totvs;

show tables;

CREATE TABLE conv (
	id_conv INT PRIMARY KEY auto_increment,
    id_clie varchar(15) not null,
    id_meet int not null,
    dt_conv datetime,
	tr_conv longtext,
    st_conv varchar(50),
    
    foreign key (id_clie) REFERENCES clie(id_clie)
);

alter table clie modify column id_clie varchar(15) not null;

show columns from clie;
select * from clie;

select * from conv;

show columns from conv;

