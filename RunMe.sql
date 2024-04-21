CREATE TABLE IF NOT EXISTS "public".users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    username text COLLATE pg_catalog."default",
    fio text COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "public".users
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS "public".logins
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    access_date timestamp without time zone,
    user_id integer,
    applcation text COLLATE pg_catalog."default",
    CONSTRAINT logins_pkey PRIMARY KEY (id),
    CONSTRAINT users_fkey FOREIGN KEY (user_id)
        REFERENCES "Task04".users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS "public".logins
    OWNER to postgres;
