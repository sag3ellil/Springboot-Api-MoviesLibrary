INSERT INTO fc_categorie (id,"name")
VALUES
(1,'Action'),
(2,'Cartoon');

INSERT INTO fc_movie (id,"name", actors,"description",id_categorie)
VALUES
(1,'007','Tom cruse, james bond, alpha romio,...','this movie is full of actions and missions , bring your popcorn you will enjoy',1),
(2,'Simba','Samir lousif, sonya il ajmi , mostfa hwas','this movie is cartoon movie , the story of Symba is famous enougth to write a description , better quality waitting for you ',2)
;



INSERT INTO fc_movie_categorie (id_movie, id_categorie)
VALUES
(1,1),
(2,2);


