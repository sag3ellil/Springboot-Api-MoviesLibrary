CREATE SEQUENCE fc_movie_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_movie (
  id int8 NOT NULL DEFAULT nextval('fc_movie_id_seq'),
  actors VARCHAR (255) NOT NULL ,
  name VARCHAR (255) NOT NULL,
  description VARCHAR (255),
  id_categorie int8 ,
  PRIMARY KEY (id));


CREATE SEQUENCE fc_categorie_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE fc_categorie (
  id int8 NOT NULL DEFAULT nextval('fc_categorie_id_seq'),
  name VARCHAR(255), 
  PRIMARY KEY(id));


CREATE TABLE fc_movie_categorie (
  id_categorie int8 NOT NULL ,
  id_movie int8 NOT NULL ,
  PRIMARY KEY (id_movie, id_categorie));



ALTER TABLE if EXISTS fc_movie_categorie
ADD CONSTRAINT fc_movie_fk
FOREIGN KEY (id_movie) REFERENCES fc_movie(id);

ALTER TABLE if EXISTS fc_movie_categorie
ADD CONSTRAINT fc_categorie_fk
FOREIGN KEY (id_categorie) REFERENCES fc_categorie(id);

ALTER TABLE if EXISTS fc_movie
ADD CONSTRAINT fc_categorie_fk
FOREIGN KEY (id_categorie) REFERENCES fc_categorie(id);


