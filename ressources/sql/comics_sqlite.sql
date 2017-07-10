BEGIN TRANSACTION;

CREATE TABLE genres (
	nom VARCHAR(50),
	num INTEGER PRIMARY KEY AUTOINCREMENT
);

INSERT INTO genres(nom) VALUES('Disney');
INSERT INTO genres(nom) VALUES('DC Comics');
INSERT INTO genres(nom) VALUES('Marvel');


CREATE TABLE personnages (
	pk INTEGER PRIMARY KEY AUTOINCREMENT,
	nom VARCHAR(50) NOT NULL,
	prenom VARCHAR(50) NOT NULL,
	aka VARCHAR(50),
	ddn DATE,
	fk_genre INTEGER REFERENCES genres(num),
	UNIQUE(nom, prenom)
);

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
	id SERIAL PRIMARY KEY,
	titre VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO aventures(titre) VALUES('The Mightiest Team in the World');
INSERT INTO aventures(titre) VALUES('Justice League Adventures');
INSERT INTO aventures(titre) VALUES('Steamboat Willie');

CREATE TABLE liens_personnages_aventures (
	pk INTEGER PRIMARY KEY AUTOINCREMENT,
	fk_personnage INTEGER REFERENCES personnages(pk),
	fk_aventure INTEGER REFERENCES aventures(id)
);

INSERT INTO liens_personnages_aventures(fk_personnage, fk_aventure)
	SELECT personnages.pk, aventures.id
	FROM personnages CROSS JOIN aventures
	WHERE personnages.aka IN ( 'Superman', 'Batman' )
			AND aventures.titre IN( 'The Mightiest Team in the World', 'Justice League Adventures' );
			
INSERT INTO liens_personnages_aventures(fk_personnage, fk_aventure)
	SELECT personnages.pk, aventures.id
	FROM personnages CROSS JOIN aventures
	WHERE personnages.nom = 'Mouse'
			AND aventures.titre = 'Steamboat Willie';
			

-- Pas de "CREATE FUNCTION" dans SQLite

COMMIT;