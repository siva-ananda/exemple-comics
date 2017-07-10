package be.steformations.java_data.comics.interfaces.dao.managers;

import be.steformations.java_data.comics.interfaces.dao.beans.Aventure;
import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;

public interface PersonnageManager {

	Personnage getPersonnage( String prenom, String nom );
	Personnage getPersonnage( int id );
	java.util.List<? extends Aventure> getAventures( int id );
	Personnage creerPersonnage( String prenom, String nom, String aka, java.util.Date ddn, Genre genre );
	void modifierPersonnage( int id, String aka );
	void supprimerPersonnage( int id );
}
