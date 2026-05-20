CREATE TABLE conv (
	id_conv INT PRIMARY KEY,
    id_meet int not null,
    dt_conv datetime,
	tr_conv longtext,
    st_conv varchar(50),
    
    foreign key clie(id_clie)
    REFERENCES clie(id_clie)
);

create table clie (
	id_clie int primary key,
    nm_clie varchar(100),
	nt_nps DECIMAL(3,1),
    dt_ultima_pesquisa DATE,
    nm_segm varchar(40)
);

