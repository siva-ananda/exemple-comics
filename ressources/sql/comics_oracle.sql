ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD';

CREATE TABLE genres (
	nom VARCHAR(50),
	num INTEGER PRIMARY KEY
);

INSERT INTO genres(num, nom) VALUES(1, 'Disney');
INSERT INTO genres(num, nom) VALUES(2, 'DC Comics');
INSERT INTO genres(num, nom) VALUES(3, 'Marvel');

CREATE TABLE personnages (
	pk INTEGER PRIMARY KEY,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	aka VARCHAR(50),
	ddn DATE,
	fk_genre INTEGER REFERENCES genres(num),
	UNIQUE(nom, prenom)
);

CREATE SEQUENCE seq_personnages START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER tr_personnages
  BEFORE INSERT ON personnages
  FOR EACH ROW
  BEGIN
  	:new.pk := seq_personnages.nextval;
  END;
/

INSERT INTO personnages(prenom, nom, aka, ddn)
				VALUES('Mickey', 'Mouse', NULL, '1928-11-18');
INSERT INTO personnages(prenom, nom, aka, ddn)
				VALUES('Minerva', 'Mouse', 'Minnie', '1928-11-18');

UPDATE personnages SET fk_genre = ( SELECT MIN(num) FROM genres WHERE nom = 'Disney' )
	WHERE nom = 'Mouse';
			
INSERT INTO personnages(prenom, nom, aka, ddn)
				VALUES('Clark', 'Kent', 'Superman', '1938-06-01');
INSERT INTO personnages(prenom, nom, aka, ddn)
				VALUES('Bruce', 'Wayne', 'Batman', '1939-05-01');
				
UPDATE personnages SET fk_genre = ( SELECT MIN(num) FROM genres WHERE nom = 'DC Comics' )
	WHERE aka IN ('Superman', 'Batman' );
				
INSERT INTO personnages(prenom, nom, aka, ddn, fk_genre)
				VALUES('Betty', 'Boop', NULL, '1930-08-09', NULL);
				
CREATE TABLE aventures (
	id INTEGER PRIMARY KEY,
	titre VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO aventures(id, titre) VALUES(1, 'The Mightiest Team in the World');
INSERT INTO aventures(id, titre) VALUES(2, 'Justice League Adventures');
INSERT INTO aventures(id, titre) VALUES(3, 'Steamboat Willie');

CREATE TABLE liens_personnages_aventures (
	pk INTEGER PRIMARY KEY,
	fk_personnage INTEGER REFERENCES personnages(pk),
	fk_aventure INTEGER REFERENCES aventures(id)
);

CREATE SEQUENCE seq_liens_pers_av START WITH 1 INCREMENT BY 1;

INSERT INTO liens_personnages_aventures(pk, fk_personnage, fk_aventure)
	SELECT seq_liens_pers_av.nextval, personnages.pk, aventures.id
	FROM personnages, aventures
	WHERE personnages.aka IN ( 'Superman', 'Batman' )
			AND aventures.titre IN( 'The Mightiest Team in the World', 'Justice League Adventures' );
			
INSERT INTO liens_personnages_aventures(pk, fk_personnage, fk_aventure)
	SELECT seq_liens_pers_av.nextval, personnages.pk, aventures.id
	FROM personnages, aventures
	WHERE personnages.nom = 'Mouse'
			AND aventures.titre = 'Steamboat Willie';
			
CREATE OR REPLACE PROCEDURE updatePersonnage(firstname VARCHAR2, lastname VARCHAR2, surname VARCHAR2) AS 
	BEGIN
		UPDATE personnages SET aka = surname WHERE prenom = firstname AND nom = lastname;
		COMMIT;
	END;
/
SHO ERR;

COMMIT;
