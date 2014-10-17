/*1.2*/

CREATE TABLE T_MAINTENANCE_MTN (
	id int NOT NULL PRIMARY KEY identity(1,1),
	num_incident int NOT NULL UNIQUE,
	day_off varchar(3) NOT NULL CHECK (day_off IN ('Lun' , 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam', 'Dim')),
	machine_name varchar(50) NOT NULL,
	speed int NULL,
	temperature int NULL,
	hour_off time NOT NULL,
	what_happens varchar(55) NOT NULL
)

------------------------------------------------------
/*1.3*/

CREATE TABLE T_TAUX_TVA (
	id int NOT NULL PRIMARY KEY identity(1,1)
)

CREATE TABLE T_RAYON_RYN (
	id int NOT NULL PRIMARY KEY identity(1,1)
)

CREATE TABLE T_FABRICANT_FBQ (
	id int NOT NULL PRIMARY KEY identity(1,1)
)

CREATE TABLE T_PRODUCT (
	id int NOT NULL PRIMARY KEY identity(1,1),
	ref_shop varchar(55) NOT NULL,
	ref_vendor varchar(55) NOT NULL,
	ean_13 varchar(13) NOT NULL,
	price int NOT NULL,
	taux_tva_id int NOT NULL,	
	rayon_ryn_id int NOT NULL,
	fabricant_fbq_id int NOT NULL,
	CONSTRAINT FK_taux_tva_id FOREIGN KEY (taux_tva_id) REFERENCES T_TAUX_TVA (id),
	CONSTRAINT FK_rayon_ryn FOREIGN KEY (rayon_ryn_id) REFERENCES T_RAYON_RYN (id),
	CONSTRAINT FK_fabricant_fbq FOREIGN KEY (fabricant_fbq_id) REFERENCES T_FABRICANT_FBQ (id)
)

-------------------------------------------------------

/*1.4*/

/*
17, 14, 7 (last) carburant ne peut pas être null, à en + une valeur par défaut et ne peut contenir que 2 lettres char(2)
19, 20 UNIQUE
31 ne peut pas être une chaine de caractère
31 et 11 ne peut pas être une chaine vide
7 (first) et 7 (last) substr(..., 9, 1) étant une chaine de charactère représentant un nbr, ce nbr est plus grand que '96'
(14, 15) et (16, 17) ne respecte pas la contrainte d'unicité sur 3 colonnes
*/

--------------------------------------------------------

/*1.5*/

CREATE TABLE section (
  section_id int NOT NULL,
  section_name varchar(50),
  delegate_id int,
  CONSTRAINT PK_section PRIMARY KEY (section_id)
)

CREATE TABLE professor (
  professor_id int NOT NULL,
  professor_name varchar(30) NOT NULL,
  professor_surname varchar(30) NOT NULL,
  section_id int NOT NULL,
  professor_office int NOT NULL,
  professor_email varchar(30) NOT NULL,
  professor_hire_date datetime NOT NULL,
  professor_wage int NOT NULL,
  CONSTRAINT PK_professor PRIMARY KEY (professor_id),
  constraint FK_professor_section foreign key (section_id) references section (section_id)
)

CREATE TABLE course (
  course_id varchar(8) NOT NULL ,
  course_name varchar(200) NOT NULL ,
  course_ects decimal(3,1) NOT NULL,
  professor_id int NOT NULL,
  CONSTRAINT PK_course PRIMARY KEY (course_id),
  constraint FK_course_professor foreign key (professor_id) references professor (professor_id)
)

CREATE TABLE student (
  student_id int NOT NULL,
  first_name varchar(50),
  last_name varchar(50),
  birth_date datetime,
  login varchar(50),
  section_id int,
  year_result int,
  course_id varchar(6) NOT NULL,
  CONSTRAINT PK_student PRIMARY KEY (student_id),
  constraint FK_student_section foreign key (section_id) references section (section_id)
)

CREATE TABLE grade (
  grade char(2) NOT NULL ,
  lower_bound int NOT NULL,
  upper_bound int NOT NULL,
  CONSTRAINT PK_grade PRIMARY KEY (grade)
)

delete from course
delete from professor
delete from student
delete from section
delete from grade

INSERT INTO section VALUES (1010, 'BSc Management', 12);
INSERT INTO section VALUES (1020, 'MSc Management', 9);
INSERT INTO section VALUES (1110, 'BSc Economics', 15);
INSERT INTO section VALUES (1120, 'MSc Economics', 6);
INSERT INTO section VALUES (1310, 'BA Sociology', 23);
INSERT INTO section VALUES (1320, 'MA Sociology', 6);

INSERT INTO professor VALUES (1, 'zidda', 'pietro', 1020, 402, 'pzidda', '2004-12-11', 1900);
INSERT INTO professor VALUES (2, 'decrop', 'alain', 1120, 403, 'adecrop', '2003-05-09', 1950);
INSERT INTO professor VALUES (3, 'giot', 'pierre', 1310, 404, 'pgiot', '2002-12-21', 2100);
INSERT INTO professor VALUES (4, 'lecourt', 'christelle', 1310, 406, 'clecourt', '2003-05-07', 1750);
INSERT INTO professor VALUES (5, 'scheppens', 'georges', 1020, 410, 'gscheppens', '1986-10-09', 2450);
INSERT INTO professor VALUES (6, 'louveaux', 'francois', 1110, 407, 'flouveaux', '1990-05-07', 2200);

INSERT INTO course VALUES ('EING2234', 'Derivatives', 3.0, 3);
INSERT INTO course VALUES ('ECGE2184', 'Marketing management', 3.5, 2);
INSERT INTO course VALUES ('EING2283', 'Marketing engineering', 4.0, 1);
INSERT INTO course VALUES ('ECGE2183', 'Financial Management', 4.0, 3);
INSERT INTO course VALUES ('EING2383', 'Supply chain management et e-business', 2.5, 5);

INSERT INTO student VALUES (1, 'Georges', 'Lucas', '1944-05-17 00:00:00', 'glucas', 1320, 10, 'EG2210');
INSERT INTO student VALUES (2, 'Clint', 'Eastwood', '1930-05-31 00:00:00', 'ceastwoo', 1010, 4, 'EG2210');
INSERT INTO student VALUES (3, 'Sean', 'Connery', '1930-08-25 00:00:00', 'sconnery', 1020, 12, 'EG2110');
INSERT INTO student VALUES (4, 'Robert', 'De Niro', '1943-08-17 00:00:00', 'rde niro', 1110, 3, 'EG2210');
INSERT INTO student VALUES (5, 'Kevin', 'Bacon', '1958-07-08 00:00:00', 'kbacon', 1120, 16, '0');
INSERT INTO student VALUES (6, 'Kim', 'Basinger', '1953-12-08 00:00:00', 'kbasinge', 1310, 19, '0');
INSERT INTO student VALUES (7, 'Johnny', 'Depp', '1963-06-09 00:00:00', 'jdepp', 1110, 11, 'EG2210');
INSERT INTO student VALUES (8, 'Julia', 'Roberts', '1967-10-28 00:00:00', 'jroberts', 1120, 17, '0');
INSERT INTO student VALUES (9, 'Natalie', 'Portman', '1981-06-09 00:00:00', 'nportman', 1010, 4, 'EG2210');
INSERT INTO student VALUES (10, 'Georges', 'Clooney', '1961-05-06 00:00:00', 'gclooney', 1020, 4, 'EG2110');
INSERT INTO student VALUES (11, 'Andy', 'Garcia', '1956-04-12 00:00:00', 'agarcia', 1110, 19, '0');
INSERT INTO student VALUES (12, 'Bruce', 'Willis', '1955-03-19 00:00:00', 'bwillis', 1010, 6, 'EG2210');
INSERT INTO student VALUES (13, 'Tom', 'Cruise', '1962-07-03 00:00:00', 'tcruise', 1020, 4, 'EG2110');
INSERT INTO student VALUES (14, 'Reese', 'Witherspoon', '1976-03-22 00:00:00', 'rwithers', 1020, 7, 'EG1020');
INSERT INTO student VALUES (15, 'Sophie', 'Marceau', '1966-11-17 00:00:00', 'smarceau', 1110, 6, '0');
INSERT INTO student VALUES (16, 'Sarah', 'Michelle Gellar', '1977-04-14 00:00:00', 'smichell', 1020, 7, 'EG2110');
INSERT INTO student VALUES (17, 'Alyssa', 'Milano', '1972-12-19 00:00:00', 'amilano', 1110, 7, '0');
INSERT INTO student VALUES (18, 'Jennifer', 'Garner', '1972-04-17 00:00:00', 'jgarner', 1120, 18, '0');
INSERT INTO student VALUES (19, 'Michael J.', 'Fox', '1969-06-20 00:00:00', 'mfox', 1310, 3, '0');
INSERT INTO student VALUES (20, 'Tom', 'Hanks', '1956-07-09 00:00:00', 'thanks', 1020, 8, 'EG2110');
INSERT INTO student VALUES (21, 'David', 'Morse', '1953-10-11 00:00:00', 'dmorse', 1110, 2, '0');
INSERT INTO student VALUES (22, 'Sandra', 'Bullock', '1964-07-26 00:00:00', 'sbullock', 1010, 2, 'EG1020');
INSERT INTO student VALUES (23, 'Keanu', 'Reeves', '1964-09-02 00:00:00', 'kreeves', 1020, 10, 'EG2210');
INSERT INTO student VALUES (24, 'Shannen', 'Doherty', '1971-04-12 00:00:00', 'sdoherty', 1320, 2, 'EG2120');
INSERT INTO student VALUES (25, 'Halle', 'Berry', '1966-08-14 00:00:00', 'hberry', 1320, 18, 'EG2210');

INSERT INTO grade VALUES ('IG', 0, 7);
INSERT INTO grade VALUES ('I', 8, 9);
INSERT INTO grade VALUES ('F', 10, 11);
INSERT INTO grade VALUES ('S', 12, 13);
INSERT INTO grade VALUES ('B', 14, 15);
INSERT INTO grade VALUES ('TB', 16, 17);
INSERT INTO grade VALUES ('E', 18, 20);

-------------------------------------------------------

/*1.6*/

ALTER TABLE section (
	ALTER COLUMN delegate_id NULL,
	CONSTRAINT FK_delegate_id FOREIGN KEY (delegate_id) REFERENCES student (student_id)
)

ALTER TABLE student (
	DELETE COLUMN course_id,
	ALTER COLUMN student_id IDENTITY(1, 1)
)

ALTER TABLE section (
	ALTER COLUMN section_id char(4) CHECK (section_id IS INT)
)

--------------------------------------------------------