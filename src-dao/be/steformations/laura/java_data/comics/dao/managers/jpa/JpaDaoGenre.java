package be.steformations.laura.java_data.comics.dao.managers.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.laura.java_data.comics.dao.beans.AventureImpl;
import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;
import be.steformations.laura.java_data.comics.dao.beans.PersonnageImpl;

public class JpaDaoGenre implements GenreManager {

	private javax.persistence.EntityManager entitymanager;
	
	public JpaDaoGenre(EntityManager entitymanager) {
		super();
		this.entitymanager = entitymanager;
	}

	@Override
	public Genre getGenre(String nom) {
		GenreImpl genre = null;
		// autre solution que pour personnage : on déclare les requêtes dans le fichier de configuration
		// et on reprend le nom qu'on y a donné à la requête
		
		javax.persistence.TypedQuery<GenreImpl> query = this.entitymanager.createNamedQuery("GetGenreByName", GenreImpl.class);
		query.setParameter(1, nom);
		
		try {
			genre = query.getSingleResult();
		}catch(javax.persistence.NoResultException e){}
		
		return genre;
	}

	@Override
	public List<? extends Personnage> getPersonnages(String nom) {
	//	return this.getPersonnagesJpql(nom);
		return this.getPersonnagesProperty(nom);
	}
	
	
	public List<? extends Personnage> getPersonnagesProperty(String nom) {
		GenreImpl genre = (GenreImpl) this.getGenre(nom);
		if(genre == null){
			return java.util.Collections.emptyList();
		} else {
			return genre.getComics();
		}
	}
		

	
	public List<? extends Personnage> getPersonnagesJpql(String nom) {
		java.util.List<PersonnageImpl> list = null;
		
		String jpql = "select p from Comic p where p.genre.nom = ?1";
		javax.persistence.TypedQuery<PersonnageImpl> query = this.entitymanager.createQuery(jpql, PersonnageImpl.class);
		query.setParameter(1, nom);
		list = query.getResultList(); // pour récupérer plusieurs objets
				// la liste est toujours instanciée -> elle peut être vide
				// pas d'exception vu que renvoie une liste vide si rien n'est trouvé
		
		return list;
	}

}
