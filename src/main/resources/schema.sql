create table menu (id bigint generated by default as identity, name varchar(255) not null, parent_id bigint, uri varchar(255), primary key (id))
alter table menu add constraint FKgeupubdqncc1lpgf2cn4fqwbc foreign key (parent_id) references menu