
CREATE TABLE Salary (
   id int PRIMARY KEY, 
   yearId varchar(200),
   teamId varchar(200),
   lgId varchar(200),
   playerId varchar(200),
   salary varchar(200),
   inclusionDate date
);

CREATE SEQUENCE sfi_seq START WITH 1 INCREMENT BY 1;