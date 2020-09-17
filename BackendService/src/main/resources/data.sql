
INSERT INTO AUTH_USER(first_name ,last_name ,username ,password,auth_user_id)
VALUES('Stipe','Babic','admin','admin',0);

INSERT INTO AUTH_USER(first_name ,last_name ,username ,password,auth_user_id)
VALUES('Petar','Vuk','petar123','vuk123',1);

INSERT INTO AUTH_USER(first_name ,last_name ,username ,password,auth_user_id)
VALUES('Ivan','Modric','ivan123','modric123',2);

INSERT INTO AUTH_USER(first_name ,last_name ,username ,password,auth_user_id)
VALUES('Ante','Vukic','ante123','vukic123',3);

INSERT INTO AUTH_USER(first_name ,last_name ,username ,password,auth_user_id)
VALUES('Duje','Loncar','duje123','loncar123',4);



INSERT INTO AUTH_ROLE
VALUES(0,'ONLY ADMIN','ROLE_ADMIN');

INSERT INTO AUTH_ROLE
VALUES(1,'NORMAL USER','ROLE_USER');


INSERT INTO AUTH_USER_ROLE(auth_role_id,auth_user_id)
VALUES(0,0);

INSERT INTO AUTH_USER_ROLE(auth_role_id,auth_user_id)
VALUES(1,1);

INSERT INTO AUTH_USER_ROLE(auth_role_id,auth_user_id)
VALUES(1,2);

INSERT INTO AUTH_USER_ROLE(auth_role_id,auth_user_id)
VALUES(1,3);
INSERT INTO AUTH_USER_ROLE(auth_role_id,auth_user_id)
VALUES(1,4);



INSERT INTO MOVIE(movie_id,title,year,genre,summary)
VALUES(1,'Titanic',1997,'drama','true story about ship');
INSERT INTO MOVIE(movie_id,title,year,genre,summary)
VALUES(2,'Superman',1987,'action','action hero saves the world');
INSERT INTO MOVIE(movie_id,title,year,genre,summary)
VALUES(3,'Forrest Gump',1998,'drama','guy who likes running');
INSERT INTO MOVIE(movie_id,title,year,genre,summary)
VALUES(4,'lotr',1997,'adventure','gratest fantasy story ever');



INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(1,1,'not bad',5);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(1,2,'adventure',1);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(1,3,'not bad',8);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(1,4,'not bad',5);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(2,0,'not bad',7);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(2,2,'adventure',9);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(2,4,'adventure',3);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(2,3,'adventure',1);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(3,3,'adventure',7);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(3,2,'not bad',9);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(3,1,'not bad',10);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(4,0,'not bad',4);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(4,2,'not bad',6);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(4,1,'adventure',3);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(4,4,'adventure',5);
INSERT INTO REVIEW (movieid,userid,comment,rating)
VALUES(4,3,'adventure',5);


