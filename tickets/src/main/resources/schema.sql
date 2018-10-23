create table person(
User_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
First_Name VARCHAR(64),
Last_Name VARCHAR(64),
Email VARCHAR(64)
);

create table reservations(
Reservation_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
User_ID BIGINT NOT NULL,
Movie_ID BIGINT NOT NULL,
Res_Date DATE
);

create table movie(
Movie_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
Movie_Name VARCHAR(64)
);

ALTER TABLE reservations ADD FOREIGN KEY (User_ID) REFERENCES person(User_ID);
ALTER TABLE reservations ADD FOREIGN KEY (Movie_ID) REFERENCES movie(Movie_ID);