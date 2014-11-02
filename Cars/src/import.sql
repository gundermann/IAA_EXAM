-- adding keywords
insert into KEYWORD (KEYWORDID, KEYWORD) values ('1', 'Nordakademie');
insert into KEYWORD (KEYWORDID, KEYWORD) values ('2', 'Java');
insert into KEYWORD (KEYWORDID, KEYWORD) values ('3', 'Linux');

-- adding lender
insert into LENDER (LENDERID, FIRSTNAME, LASTNAME, MATRICULATIONNUMBER) values ('1', 'Hannes', 'Junger', '1234');
insert into LENDER (LENDERID, FIRSTNAME, LASTNAME, MATRICULATIONNUMBER) values ('2', 'Max', 'Mustermann', '1334');
insert into LENDER (LENDERID, FIRSTNAME, LASTNAME, MATRICULATIONNUMBER) values ('3', 'Moritz', 'Jungernich', '2234');

-- adding publisher
insert into PUBLISHER (PUBLISHERID, PUBLISHERNAME) values ('1', 'Nordakademie');
insert into PUBLISHER (PUBLISHERID, PUBLISHERNAME) values ('2', 'Weltverlag');
insert into PUBLISHER (PUBLISHERID, PUBLISHERNAME) values ('3', 'Verlag der grünen Sonne');

-- adding authors
insert into AUTHOR (AUTHORID, NAME) values ('1', 'Jürgen Wolf');
insert into AUTHOR (AUTHORID, NAME) values ('2', 'Hans R. Müller');
insert into AUTHOR (AUTHORID, NAME) values ('3', 'Jens Willinger');

-- adding publication types
insert into PUBLICATIONTYPE (PUBLICATIONTYPEID, NAME) values ('1', 'Buch');
insert into PUBLICATIONTYPE (PUBLICATIONTYPEID, NAME) values ('2', 'Bachelorarbeit');
insert into PUBLICATIONTYPE (PUBLICATIONTYPEID, NAME) values ('3', 'Zeitschrift');

-- adding publications
insert into PUBLICATION (PUBLICATIONID, ISBN, NAKID , QUANTITY, TITLE, DATEOFPUBLICATION , PUBLICATIONTYPE_PUBLICATIONTYPEID, PUBLISHER_PUBLISHERID) values ('1', '1234567890123', '1' , '2', 'Hibernate für Anfänger', '2013-11-09 00:00:00' , '1', '1');
insert into PUBLICATION (PUBLICATIONID, ISBN, NAKID , QUANTITY, TITLE, DATEOFPUBLICATION , PUBLICATIONTYPE_PUBLICATIONTYPEID, PUBLISHER_PUBLISHERID) values ('2', '1231167890123', '2' , '3', 'Struts für Anfänger', '2012-11-09 00:00:00' , '2', '3');
insert into PUBLICATION (PUBLICATIONID, ISBN, NAKID , QUANTITY, TITLE, DATEOFPUBLICATION , PUBLICATIONTYPE_PUBLICATIONTYPEID, PUBLISHER_PUBLISHERID) values ('3', '1234567120123', '3' , '1', 'Spring für Anfänger', '2013-10-12 00:00:00' , '3', '2');




