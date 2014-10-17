/*2.3.1*//*
SELECT MAX(year_result) AS "Plus haut score", MIN(year_result) AS "Plus bas score"
FROM student

--réponse: parce que ce sont des moyennes et qu'elles seraient faussées si le nombre d'entrée venait à changer
*/

/*2.3.2*//*
SELECT COUNT(*) AS "Total étudiants inscrits"
FROM student

--réponse: function interne comptant le nbr de ligne retournée par la requête courante
*/

/*2.3.3*//*
SELECT AVG(year_result)
FROM student

--réponse: VRAI
*/

/*2.3.4*//*
SELECT COUNT(*) AS "Nombre d' éleves", SUM(year_result)  AS "Total addition des points des éleves de la section 1010"
FROM student
WHERE section_id = 1010

--réponse: VRAI
*/

/*2.3.5*//*
SELECT COUNT(*) AS "Nombre d'étudiant"
FROM student

--réponse: VRAI
*/

/*2.3.6*//*
1 non (function = parenthèse)
2 non (COUNT = agrégation !)
3 oui
*/

/*2.3.7*//*
SELECT AVG(year_result)
FROM student
*/

/*2.3.8*//*
SELECT MAX(year_result) AS "Plus haut score"
FROM student
*/

/*2.3.9*//*
SELECT SUM(year_result) AS "Somme des résultats annuels"
FROM student
*/

/*2.3.10*//*
SELECT MIN(year_result) AS "Plus bas score"
FROM student
*/

/*2.3.11*//*
SELECT COUNT(*) AS "Nombre de ligne de la table student"
FROM student
*/

/*2.3.12*//*
SELECT login, YEAR(birth_date) AS "Année de naissance"
FROM student
WHERE YEAR(birth_date) >= YEAR('1970-01-01');
*/

/*2.3.13*//*
SELECT login, last_name
FROM student
WHERE LEN(last_name) >= 8
*/

/*2.3.14*//*
SELECT UPPER(last_name) AS "Nom de famille", first_name, year_result
FROM student
WHERE year_result >= 16
ORDER BY year_result DESC
*/

/*2.3.15*//*
SELECT first_name, last_name, login, LOWER(REPLACE(SUBSTRING(first_name, 1, 2) + SUBSTRING(last_name, 1, 4), ' ', '')) AS "Nouveau login"
FROM student
WHERE year_result BETWEEN 6 AND 10
*/

/*2.3.16*//*
SELECT first_name, last_name, login, SUBSTRING(first_name, LEN(first_name) -2, LEN(first_name)) + SUBSTRING(CONVERT(varchar, YEAR(birth_date)), 3, 4) AS "Nouveau login"
FROM student
WHERE year_result IN (10, 12, 14)
*/

/*2.3.17*//*
SELECT last_name, login, year_result
FROM student
WHERE SUBSTRING(last_name, 1, 1) IN ('D', 'M', 'S')
ORDER BY birth_date ASC
*/

/*2.3.18*//*
SELECT last_name, login, year_result
FROM student
WHERE year_result % 2 != 0 AND year_result > 10
ORDER BY year_result DESC
*/

/*2.3.19*//*
SELECT COUNT(*) AS "Nombre d'étudiants qui ont 7 lettres dans leur nom"
FROM student
WHERE LEN(last_name) <= 7
*/

/*2.3.20*//*
SELECT last_name, year_result,
CASE 
	WHEN year_result >= 12 THEN 'OK'
	WHEN year_result < 12 THEN 'KO'
END AS "Statut"
FROM student
WHERE YEAR(birth_date) < 1955
*/

/*2.3.21*//*
SELECT last_name, year_result,
CASE 
	WHEN year_result < 10 THEN 'inférieure'
	WHEN year_result = 10 THEN 'neutre'
	WHEN year_result > 10 THEN 'supérieure'
END AS "Catégorie"
FROM student
WHERE YEAR(birth_date) >= 1955 AND YEAR(birth_date) <= 1965
*/

/*2.3.22*//*
SELECT last_name, year_result,
CASE
	--WHEN CHARINDEX('Jan', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Jan', 'janvier')
	--WHEN CHARINDEX('Feb', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Feb', 'février')
	WHEN CHARINDEX('Mar', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Mar', 'mars')
	WHEN CHARINDEX('Apr', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Apr', 'avril')
	--WHEN CHARINDEX('May', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'May', 'mai')
	WHEN CHARINDEX('Jun', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Jun', 'juin')
	--WHEN CHARINDEX('Jul', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Jul', 'juillet')
	--WHEN CHARINDEX('Aug', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Aug', 'aôut')
	--WHEN CHARINDEX('Sep', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Sep', 'septembre')
	--WHEN CHARINDEX('Oct', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Oct', 'octobre')
	--WHEN CHARINDEX('Nov', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Nov', 'novembre')
	--WHEN CHARINDEX('Dec', birth_date) > 0 THEN REPLACE(CONVERT(varchar, birth_date, 106), 'Dec', 'décembre')
END AS [Literal_date]
FROM student
WHERE YEAR(birth_date) >= 1975 AND YEAR(birth_date) <= 1985
*//*
SELECT last_name, year_result, CONVERT(varchar, DAY(birth_date)) + ' ' + CONVERT(varchar, DATENAME(MONTH, birth_date)) + ' ' + CONVERT(varchar, YEAR(birth_date)) AS [Litteral_date]
FROM student
WHERE YEAR(birth_date) >= 1975 AND YEAR(birth_date) <= 1985
*/

/*2.3.23*//*
SELECT last_name, MONTH(birth_date) AS "Mois de naissance", year_result,
NULLIF(year_result, 4) AS "Nouveau résultat"
FROM student
WHERE MONTH(birth_date) NOT IN (12, 1, 2, 3) AND year_result < 7
*/

/*2.4.7*//*
SELECT section_id, AVG(year_result) AS "Résultat maximum"
FROM student
GROUP BY section_id
*/

/*2.4.8*//*
SELECT section_id, AVG(CAST(year_result AS FLOAT)) AS "Moyenne"
FROM student
WHERE section_id LIKE '10%'
GROUP BY section_id
*/

/*2.4.9*//*
SELECT MONTH(birth_date) AS "Mois de naissance", AVG(year_result) AS "Moyenne"
FROM student
WHERE YEAR(birth_date) BETWEEN  1970 AND 1985
GROUP BY MONTH(birth_date)
*/

/*2.4.10*//*
SELECT section_id, AVG(CAST(year_result AS FLOAT)) AS "Moyenne"
FROM student
GROUP BY section_id
HAVING COUNT(*) > 3
*/

/*2.4.11*//*
SELECT section_id, AVG(year_result) AS "Moyenne", MAX(year_result) AS "Résultat maximum"
FROM student
GROUP BY section_id
HAVING AVG(year_result) >= 10
*/

/*2.5.6*//*
SELECT section_id, course_id, AVG(CAST(year_result AS FLOAT)) AS "Moyenne"
FROM student
WHERE section_id IN (1010, 1320)
GROUP BY ROLLUP (section_id, course_id)
*/

/*2.5.7*//*
SELECT course_id, section_id, AVG(CAST(year_result AS FLOAT)) AS "Moyenne"
FROM student
WHERE section_id IN (1010, 1320)
GROUP BY CUBE (course_id, section_id)
*/

/*2.6.1*//*
SELECT c.course_name, s.section_name, p.professor_name
FROM course AS c JOIN professor AS p ON c.professor_id = p.professor_id
JOIN section AS s ON s.section_id = p.section_id
--ORDER BY c.course_name DESC
*/

/*2.6.2*//*
SELECT s.section_id, s.section_name, st.last_name
FROM section s JOIN student st ON st.student_id = s.delegate_id
ORDER BY s.section_id DESC
*/

/*2.6.3*//*
SELECT s.section_id, s.section_name, p.professor_name
FROM section s LEFT JOIN professor p ON p.section_id = s.section_id
ORDER BY s.section_id DESC
*/

/*2.6.4*//*
SELECT s.section_id, s.section_name, p.professor_name
FROM section s JOIN professor p ON p.section_id = s.section_id
ORDER BY s.section_id DESC
*/

/*2.6.5*//*
SELECT st.last_name, st.year_result, g.grade
FROM student st LEFT JOIN grade g ON st.year_result BETWEEN g.lower_bound AND g.upper_bound
WHERE st.year_result >= 12
ORDER BY g.grade
*/

/*2.6.6*//*
SELECT p.professor_name, s.section_name, c.course_name, c.course_ects
FROM professor p 
LEFT JOIN course c 
ON p.professor_id = c.professor_id
LEFT JOIN section s
ON s.section_id = p.section_id
ORDER BY c.course_ects DESC
*/

/*2.6.7*//*
SELECT p.professor_id, SUM(c.course_ects) AS ECTS_TOT
FROM professor p 
LEFT JOIN course c 
ON p.professor_id = c.professor_id
GROUP BY p.professor_id
ORDER BY ECTS_TOT DESC
*/

/*2.6.8*//*
SELECT first_name, last_name, 'S' AS "Catégorie"
FROM student
WHERE LENGTH(last_name) > 8
UNION
SELECT professor_surname, professor_name, 'P' AS "Catégorie"
FROM professor
WHERE LENGTH(professor_name) > 8
*/

/*2.6.9*//*
SELECT section_id
FROM section
MINUS -- EXCEPT
SELECT section_id
FROM professor
*/

/*2.7.1*//*
SELECT last_name, first_name, section_id
FROM student
WHERE section_id = (SELECT section_id FROM student WHERE last_name = 'Roberts')
AND last_name != 'Roberts'
*/

/*2.7.2*//*
SELECT last_name, first_name, year_result
FROM student
WHERE year_result > (SELECT AVG(year_result) FROM student) * 2
*/

/*2.7.3*//*
SELECT section_id, section_name
FROM section
WHERE section_id NOT IN (SELECT section_id FROM professor)
*/

/*2.7.4*//*
SELECT last_name, first_name, CONVERT(varchar, birth_date, 103) AS "Date de naissance", year_result
FROM student
WHERE MONTH(birth_date) = (SELECT MONTH(professor_hire_date) FROM professor WHERE professor_name = 'Giot')
*/

/*2.7.5*//*
SELECT last_name, first_name, year_result
FROM student s
WHERE 'TB' = (SELECT grade FROM grade WHERE s.year_result BETWEEN lower_bound AND upper_bound)
*/

/*2.7.6*//*
SELECT last_name, first_name, section_id
FROM student
WHERE section_id = (SELECT section_id FROM student WHERE last_name = 'Marceau')
*/

/*2.7.7*//*
SELECT s.section_id, s.section_name
FROM section s
WHERE 4 < (SELECT COUNT(*) FROM student WHERE section_id = s.section_id)
*/

/*2.7.8*//*
SELECT last_name, first_name, section_id
FROM student s
WHERE year_result = (SELECT MAX(year_result) FROM student WHERE section_id = s.section_id GROUP BY section_id)
AND section_id NOT IN (SELECT section_id FROM student GROUP BY section_id HAVING AVG(year_result) < 10)
ORDER BY section_id DESC
*/

/*2.7.9*//*
SELECT section_id, AVG(year_result) AS "AVG"
FROM student
--WHERE year_result = (SELECT MAX(SELECT AVG(year_result) FROM student)
GROUP BY section_id
--HAVING MAX(year_result) >= ANY (SELECT AVG(year_result) FROM student)
HAVING AVG(year_result) = (SELECT MAX(Maximum) FROM (SELECT section_id, AVG(year_result) AS 'Maximum' FROM student GROUP BY section_id) AS 'Nouvelle table'
*/

/*3.1*/
--INSERT INTO student VALUES(26, 'Laurent', 'Bertrand', '27/11/1977', 'lbertrand', 1120, 18, 'EG2110')
--SELECT * FROM student

/*3.2*/
--INSERT INTO student VALUES(27, 'Benoît', NULL, '01/01/1980', NULL, 1120, NULL, 'EG2110')
--SELECT * FROM student

/*3.3*/
--CREATE TABLE section_archives AS (SELECT * FROM section)
--SELECT * FROM section_archives

/*3.4*//*
INSERT INTO student VALUES
(
  28, 
  'Ben', 
  'Affleck', 
  '01/01/1965',
  NULL, 
  (SELECT section_id FROM student WHERE last_name = 'Reeves'), 
  12, 
  (SELECT ('EG' || SUBSTR(course_id, - 4)) FROM course c, professor p WHERE p.professor_name = 'zidda' AND p.professor_id = c.professor_id)
)
*/
--SELECT * FROM student

/*3.5*//*
INSERT INTO section VALUES
(
  1530,
  'Administration des SI',
  (SELECT delegate_id FROM section WHERE section_id = 1010)
)
*/

/*3.6*//*
UPDATE student
SET course_id = 'EG2210'
WHERE student_id = 26
*/

/*3.7*//*
UPDATE student 
SET 
last_name = 'Verstrappen',
year_result = 18,
login = (SELECT REPLACE(LOWER(SUBSTR(first_name, 1, 1) || last_name), ' ', '') FROM student WHERE student_id = 27)
WHERE student_id = 27
*/
--SELECT * FROM student

/*3.8*//*
UPDATE student
SET year_result = 15
WHERE section_id = 1010
*/
--SELECT * FROM student ORDER BY section_id

/*3.9*//*
UPDATE section
SET delegate_id = (SELECT student_id FROM student WHERE first_name = 'Keanu')
WHERE section_id = 1530
*/
--select * from section

/*3.10*//*
UPDATE section
SET 
  section_name = (SELECT section_name FROM section WHERE section_id = 1320),
  delegate_id = (SELECT delegate_id FROM section WHERE section_id = 1320)
WHERE section_id = 1530
*/

--select * from section

/*3.11*//*
UPDATE section
SET delegate_id = (SELECT student_id FROM student WHERE last_name = 'Milano')
WHERE section_id = (SELECT section_id FROM student WHERE last_name = 'Milano')
*/

--select * from section

/*3.12*//*
DELETE FROM student 
WHERE first_name = 'Benoît'
*/

--select * from student

/*3.13*//*
DELETE FROM student 
WHERE first_name = 'Laurent' OR first_name = 'Kim'
*/

--select * from student

/*3.14*//*
DELETE FROM student 
WHERE year_result < 8
*/
--select * from student

/*3.15*//*
DELETE FROM course
WHERE professor_id = NULL OR professor_id NOT IN (SELECT professor_id FROM professor)
*/
--SELECT * FROM course

/*3.16*/
--ALTER TABLE professor
--DROP CONSTRAINT FK_PROFESSOR_SECTION
--ALTER TABLE student
--DROP CONSTRAINT FK_STUDENT_SECTION
--DELETE FROM section
--ALTER TABLE course
--DROP CONSTRAINT FK_COURSE_PROFESSOR2
--DELETE FROM professor
--DELETE FROM student
--DELETE FROM course
--DELETE FROM grade

--select * from section, student, professor, course, grade

/*
ALTER TABLE professor
ADD CONSTRAINT FK_PROFESSOR_SECTION
ALTER TABLE student
ADD CONSTRAINT FK_STUDENT_SECTION
ALTER TABLE course
ADD CONSTRAINT FK_COURSE_PROFESSOR2
*/
