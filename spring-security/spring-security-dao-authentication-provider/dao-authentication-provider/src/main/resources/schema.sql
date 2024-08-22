DROP TABLE user_info IF EXISTS;

CREATE TABLE user_info (id int NOT NULL, username varchar(255), password varchar(255), roles varchar(255), PRIMARY KEY(id));