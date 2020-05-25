DROP SCHEMA IF EXISTS web_customer;
DROP DATABASE IF EXISTS web_customer_tracker;

CREATE DATABASE web_customer_tracker;


CREATE SCHEMA web_customer_demo;

DROP TABLE IF EXISTS web_customer_demo.customer;

CREATE TABLE web_customer_demo.customer (
                        id SERIAL PRIMARY KEY NOT NULL UNIQUE ,
                        first_name varchar(45) DEFAULT NULL,
                        last_name varchar(45) DEFAULT NULL,
                        email varchar(45) DEFAULT NULL
                                        );

INSERT INTO web_customer_demo.customer (first_name, last_name, email) VALUES
    ('Aleksandr','Fedorov','alex@mail.ru'),
    ('Ivan','Orlov','ivan@gmail.com'),
    ('Olga','Polixina','polux@yahoo.com'),
    ('Mary','Ivanova','mary@gmail.com'),
    ('Petr','Arsentiev','petya@luv2fuck.com');