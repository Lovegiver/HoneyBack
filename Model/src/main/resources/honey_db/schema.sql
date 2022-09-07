
DROP TABLE IF EXISTS public.PRODUCT;
DROP TABLE IF EXISTS public.ADDRESS;
DROP TABLE IF EXISTS public.PICTURE;
DROP TABLE IF EXISTS public.BUYER;
DROP TABLE IF EXISTS public.SELLER;
DROP TABLE IF EXISTS public.USER;

CREATE TABLE IF NOT EXISTS public.USER (
    usr_id serial PRIMARY KEY ,
    usr_type varchar(10) NOT NULL ,
    usr_email varchar(100) NOT NULL ,
    usr_pwd varchar(50) NOT NULL ,
    usr_pseudo varchar(25) NOT NULL ,
    usr_firstname varchar(50) NOT NULL ,
    usr_lastname varchar(50) NOT NULL ,
    usr_description varchar(255) NOT NULL ,
    usr_last_co timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS public.BUYER (
    usr_id serial PRIMARY KEY ,
    usr_gender varchar(2) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS public.SELLER (
    usr_id serial PRIMARY KEY ,
    usr_company_name varchar(100) NOT NULL ,
    usr_rcs varchar(50) NULL ,
    usr_siren varchar(50) NULL
);

CREATE TABLE IF NOT EXISTS public.ADDRESS (
    add_id serial PRIMARY KEY ,
    add_type varchar(20) NOT NULL ,
    add_street1 varchar(100) NOT NULL ,
    add_street2 varchar(100) ,
    add_zipcode varchar(10) NOT NULL ,
    add_city varchar(50) NOT NULL ,
    add_country varchar(30) NOT NULL ,
    add_state varchar(30) ,
    add_active bool DEFAULT FALSE ,
    add_usr_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.PICTURE (
    pic_id serial PRIMARY KEY ,
    pic_type varchar(10) NOT NULL ,
    pic_usr_id_owner bigint NOT NULL ,
    pic_usr_id bigint DEFAULT NULL ,
    pic_picture text NOT NULL
);

CREATE TABLE IF NOT EXISTS public.PRODUCT (
    pdt_id serial PRIMARY KEY ,
    pdt_name varchar(255) NOT NULL ,
    pdt_reference varchar(50) NOT NULL ,
    pdt_description varchar(255) ,
    pdt_unit varchar(5) NOT NULL ,
    pdt_quantity integer NOT NULL ,
    pdt_usr_id_seller bigint NOT NULL ,
    pdt_pic_id bigint DEFAULT NULL
);
