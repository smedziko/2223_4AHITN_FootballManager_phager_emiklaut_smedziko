
create database football

create table players
(
    id           int auto_increment
        primary key,
    name         varchar(255) charset utf8mb3 not null,
    country_code varchar(255)                 not null,
    position     varchar(255)                 null,
    speed        int                          null,
    shooting     int                          not null,
    dribbling    int                          not null,
    passing      int                          not null,
    defense      int                          not null,
    physis       int                          not null,
    image        blob                         null
);





INSERT INTO football.players (id, name, country_code, speed, shooting, dribbling, passing, defense, physis, image) VALUES (1, 'test', 'AUT', 60, 40, 20, 30, 90, 30, null);
