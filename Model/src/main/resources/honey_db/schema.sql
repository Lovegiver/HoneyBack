
DROP TABLE IF EXISTS public.USER_ORDER;
DROP TABLE IF EXISTS public.USER_CART;
DROP TABLE IF EXISTS public.CART;
DROP TABLE IF EXISTS public.ORDER;
DROP TABLE IF EXISTS public.ORDERITEM;
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
    usr_gender bool DEFAULT NULL ,
    usr_description varchar(255) NOT NULL ,
    usr_last_co timestamp NOT NULL
);

CREATE TABLE IF NOT EXISTS public.BUYER (
    usr_id serial PRIMARY KEY
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

CREATE TABLE IF NOT EXISTS public.ORDERITEM (
    lin_id serial PRIMARY KEY ,
    lin_status varchar(10) NOT NULL ,
    lin_create_date timestamp NOT NULL ,
    lin_qty bigint DEFAULT NULL ,
    lin_unit_price_no_Vat real DEFAULT NULL ,
    lin_no_Vat_amount real DEFAULT NULL ,
    lin_unit_price_with_Vat real DEFAULT NULL ,
    lin_with_Vat_amount real DEFAULT NULL ,
    lin_vat_value real DEFAULT NULL ,
    lin_discount real DEFAULT NULL ,
    lin_is_active bool DEFAULT TRUE ,
    lin_pdt_id bigint NOT NULL ,
    lin_ord_id bigint NOT NULL ,
    lin_crt_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.ORDER (
    oic_id serial PRIMARY KEY ,
    oic_no_vat_amount real DEFAULT NULL ,
    oic_with_vat_amount real DEFAULT NULL ,
    ord_is_shared bool DEFAULT FALSE ,
    ord_usr_id_seller bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.CART (
    oic_id serial PRIMARY KEY ,
    oic_no_vat_amount real DEFAULT NULL ,
    oic_with_vat_amount real DEFAULT NULL ,
    crt_is_shared bool DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS public.USER_CART (
    crt_id bigint NOT NULL ,
    usr_id bigint NOT NULL
);

CREATE TABLE IF NOT EXISTS public.USER_ORDER (
    ord_id bigint NOT NULL ,
    usr_id bigint NOT NULL
);