INSERT INTO person (First_Name, Last_name, Email) VALUES ('Shruti','Kadge','shrutikadge@gmail.com');
INSERT INTO person (First_Name, Last_name, Email) VALUES ('Jack','J','jack@gmail.com');
INSERT INTO person (First_Name, Last_name, Email) VALUES ('Jill','K','jill@gmail.com');


INSERT INTO movie (Movie_Name) VALUES ('A');
INSERT INTO movie (Movie_Name) VALUES ('B');
INSERT INTO movie (Movie_Name) VALUES ('C');
INSERT INTO movie (Movie_Name) VALUES ('D');
INSERT INTO movie (Movie_Name) VALUES ('E');

INSERT INTO reservations (Movie_ID, User_ID, Res_Date) VALUES ((SELECT Movie_ID FROM movie WHERE Movie_Name = 'A'), (SELECT User_ID FROM person WHERE Last_Name = 'Kadge'), '2017-01-01');