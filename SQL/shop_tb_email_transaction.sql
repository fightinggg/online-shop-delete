create table tb_email_transaction
(
    id bigint not null,
    constraint tb_email_transaction_id_uindex
        unique (id)
);

alter table tb_email_transaction
    add primary key (id);

