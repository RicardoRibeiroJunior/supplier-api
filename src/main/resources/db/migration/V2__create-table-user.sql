create table user(

    id bigint not null auto_increment,
    name varchar(255) not null,
    email varchar(100) not null,
    password varchar(255) not null,

    primary key(id)

);