-- drop table if exists authorities cascade ;
CREATE TABLE if not exists authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);

-- drop table if exists users cascade ;
CREATE TABLE if not exists users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(200) NOT NULL,
    enabled      boolean default true,
    role_id int          not null references authorities (id)
);

-- drop table if exists topics cascade ;
create table if not exists topics
(
    id        serial primary key,
    name      varchar(200),
    description varchar(200),
    created     timestamp without time zone not null default now(),
    author_id int references users (id)
);

-- drop table if exists messages cascade ;
create table if not exists messages
(
    id          serial primary key,
    text text,
    created     timestamp without time zone not null default now(),
    author_id int references users(id),
    topic_id int references topics(id)
);