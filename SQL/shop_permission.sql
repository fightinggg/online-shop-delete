create table permission
(
    id        int auto_increment
        primary key,
    global_id bigint      not null,
    name      varchar(30) not null
);

