DROP DATABASE IF EXISTS second_hand;
CREATE DATABASE second_hand;

USE second_hand;

create table postings (
    posting_id varchar(128),
    posting_date varchar(128) not null,
    name varchar(128) not null,
    email varchar(128),
    phone varchar(128),
    title varchar(256),
    description TEXT,
    image varchar(256)

    primary key(posting_id)
)