drop table if exists user_profile;
drop table if exists hibernate_sequence;

create table user_profile (
                      id bigint not null,
                      name varchar(255),
                      city varchar(255),
                      primary key (id)
) engine=InnoDB;

create table hibernate_sequence (
    next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values ( 1 );