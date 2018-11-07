/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  udgin
 * Created: 28.11.2017
 */

DROP TABLE IF EXISTS public.orders;
CREATE TABLE public.orders
(
    id SERIAL PRIMARY KEY,
    number CHARACTER VARYING(20) NOT NULL,
    client_id INT NOT NULL,
    note CHARACTER VARYING,
    status CHARACTER VARYING(20) NOT NULL,
    create_time TIMESTAMP DEFAULT current_timestamp,
    due_time TIMESTAMP,
    amount INT DEFAULT 0
) WITH (
    OIDS = FALSE
);


DROP TABLE IF EXISTS public.clients;
CREATE TABLE public.clients
(
    id SERIAL PRIMARY KEY,
    code CHARACTER VARYING(20),
    name CHARACTER VARYING(100),
    note CHARACTER VARYING,
    status CHARACTER VARYING(20) NOT NULL,
    create_time TIMESTAMP DEFAULT current_timestamp
) WITH (
    OIDS = FALSE
);

