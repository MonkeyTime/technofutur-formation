
delete from course;
delete from grade;
delete from professor;
delete from student;
delete from section;

INSERT INTO section VALUES (1010, 'BSc Management', 12);
INSERT INTO section VALUES (1020, 'MSc Management', 9);
INSERT INTO section VALUES (1110, 'BSc Economics', 15);
INSERT INTO section VALUES (1120, 'MSc Economics', 6);
INSERT INTO section VALUES (1310, 'BA Sociology', 23);
INSERT INTO section VALUES (1320, 'MA Sociology', 6);

INSERT INTO professor VALUES (1, 'zidda', 'pietro', 1020, 402, 'pzidda', '11/12/2004', 1900);
INSERT INTO professor VALUES (2, 'decrop', 'alain', 1120, 403, 'adecrop', '09/05/2003', 1950);
INSERT INTO professor VALUES (3, 'giot', 'pierre', 1310, 404, 'pgiot', '21/12/2002', 2100);
INSERT INTO professor VALUES (4, 'lecourt', 'christelle', 1310, 406, 'clecourt', '07/05/2003', 1750);
INSERT INTO professor VALUES (5, 'scheppens', 'georges', 1020, 410, 'gscheppens', '09/10/1986', 2450);
INSERT INTO professor VALUES (6, 'louveaux', 'francois', 1110, 407, 'flouveaux', '07/05/1990', 2200);

INSERT INTO course VALUES ('EING2234', 'Derivatives', 3.0, 3);
INSERT INTO course VALUES ('ECGE2184', 'Marketing management', 3.5, 2);
INSERT INTO course VALUES ('EING2283', 'Marketing engineering', 4.0, 1);
INSERT INTO course VALUES ('ECGE2183', 'Financial Management', 4.0, 3);
INSERT INTO course VALUES ('EING2383', 'Supply chain management et e-business', 2.5, 5);

INSERT INTO grade VALUES ('IG', 0, 7);
INSERT INTO grade VALUES ('I', 8, 9);
INSERT INTO grade VALUES ('F', 10, 11);
INSERT INTO grade VALUES ('S', 12, 13);
INSERT INTO grade VALUES ('B', 14, 15);
INSERT INTO grade VALUES ('TB', 16, 17);
INSERT INTO grade VALUES ('E', 18, 20);




INSERT INTO student VALUES (1, 'Georges', 'Lucas', '17/05/1944', 'glucas', 1320, 10, 'EG2210');
INSERT INTO student VALUES (2, 'Clint', 'Eastwood', '31/05/1930', 'ceastwoo', 1010, 4, 'EG2210');
INSERT INTO student VALUES (3, 'Sean', 'Connery', '25/08/1930', 'sconnery', 1020, 12, 'EG2110');
INSERT INTO student VALUES (4, 'Robert', 'De Niro', '17/08/1943', 'rde niro', 1110, 3, 'EG2210');
INSERT INTO student VALUES (5, 'Kevin', 'Bacon', '08/07/1958', 'kbacon', 1120, 16, '0');
INSERT INTO student VALUES (6, 'Kim', 'Basinger', '08/12/1953', 'kbasinge', 1310, 19, '0');
INSERT INTO student VALUES (7, 'Johnny', 'Depp', '09/06/1963', 'jdepp', 1110, 11, 'EG2210');
INSERT INTO student VALUES (8, 'Julia', 'Roberts', '28/10/1967', 'jroberts', 1120, 17, '0');
INSERT INTO student VALUES (9, 'Natalie', 'Portman', '09/06/1981', 'nportman', 1010, 4, 'EG2210');
INSERT INTO student VALUES (10, 'Georges', 'Clooney', '06/05/1961', 'gclooney', 1020, 4, 'EG2110');
INSERT INTO student VALUES (11, 'Andy', 'Garcia', '12/04/1956', 'agarcia', 1110, 19, '0');
INSERT INTO student VALUES (12, 'Bruce', 'Willis', '19/03/1955', 'bwillis', 1010, 6, 'EG2210');
INSERT INTO student VALUES (13, 'Tom', 'Cruise', '03/07/1962', 'tcruise', 1020, 4, 'EG2110');
INSERT INTO student VALUES (14, 'Reese', 'Witherspoon', '22/03/1976', 'rwithers', 1020, 7, 'EG1020');
INSERT INTO student VALUES (15, 'Sophie', 'Marceau', '17/11/1966', 'smarceau', 1110, 6, '0');
INSERT INTO student VALUES (16, 'Sarah', 'Michelle Gellar', '14/04/1977', 'smichell', 1020, 7, 'EG2110');
INSERT INTO student VALUES (17, 'Alyssa', 'Milano', '19/12/1972', 'amilano', 1110, 7, '0');
INSERT INTO student VALUES (18, 'Jennifer', 'Garner', '17/04/1972', 'jgarner', 1120, 18, '0');
INSERT INTO student VALUES (19, 'Michael J.', 'Fox', '20/06/1969', 'mfox', 1310, 3, '0');
INSERT INTO student VALUES (20, 'Tom', 'Hanks', '09/07/1956', 'thanks', 1020, 8, 'EG2110');
INSERT INTO student VALUES (21, 'David', 'Morse', '11/10/1953', 'dmorse', 1110, 2, '0');
INSERT INTO student VALUES (22, 'Sandra', 'Bullock', '26/07/1964', 'sbullock', 1010, 2, 'EG1020');
INSERT INTO student VALUES (23, 'Keanu', 'Reeves', '02/09/1964', 'kreeves', 1020, 10, 'EG2210');
INSERT INTO student VALUES (24, 'Shannen', 'Doherty', '12/04/1971', 'sdoherty', 1320, 2, 'EG2120');
INSERT INTO student VALUES (25, 'Halle', 'Berry', '14/08/1966', 'hberry', 1320, 18, 'EG2210');



select sysdate from dual;