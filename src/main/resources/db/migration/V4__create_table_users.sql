create table mechanic_users(
 id bigint not null auto_increment,
 login varchar(100) not null,
 pwd varchar(255) not null,
 primary key(id)
);