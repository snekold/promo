create table prize
(id serial primary key ,
 name_winner varchar(100),
 number varchar(100),
 email varchar(100),
 status boolean not null default false,
 cod varchar(20) not null,
 name_prize varchar(50) not null,
 image_path  varchar(255)
);