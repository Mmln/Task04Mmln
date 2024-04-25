CREATE TABLE IF NOT EXISTS users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    username  varchar not null,
    fio  varchar not null,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS logins
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    access_date timestamp without time zone,
    user_id integer,
    application  varchar not null,
    CONSTRAINT logins_pkey PRIMARY KEY (id),
    CONSTRAINT users_fkey FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);
--INSERT INTO users (id, username, fio) OVERRIDING SYSTEM VALUE VALUES (1, 'Mmln', 'Mamylin Andrey Anatolievich');
--INSERT INTO users (id, username, fio) OVERRIDING SYSTEM VALUE VALUES (2, 'Sql0001', 'Sql 00 01 ');
--INSERT INTO logins (id, access_date, user_id, applcation) OVERRIDING SYSTEM VALUE VALUES (1, '2024-04-18 00:00:00', 1, 'Word');
--INSERT INTO logins (id, access_date, user_id, applcation) OVERRIDING SYSTEM VALUE VALUES (2, '2024-04-18 00:01:00', 2, 'Excel');
