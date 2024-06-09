CREATE TABLE supplier(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(250) NOT NULL,
    cnpj varchar(14) NOT NULL,
    branch varchar(100) NOT NULL,
    phone varchar(250) NOT NULL,
    street varchar(250) NOT NULL,
    neighborhood varchar(250) NOT NULL,
    cep varchar(8) NOT NULL,
    uf varchar(2) NOT NULL,
    city varchar(250) NOT NULL,
    number varchar(100) NOT NULL,
    complement varchar(250) NOT NULL,

    PRIMARY KEY(id)
)