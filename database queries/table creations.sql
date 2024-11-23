drop table users;

create table public."users" 
(
username varchar(100) primary key, 
fullname varchar(100) not null,
email_or_phone varchar(100) unique, 
password varchar(100) not null
);


select * from users;