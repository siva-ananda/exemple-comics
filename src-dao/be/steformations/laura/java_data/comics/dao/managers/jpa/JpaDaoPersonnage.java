package be.steformations.laura.java_data.comics.dao.managers.jpa;

import java.util.Date;
import java.util.List;

import be.steformations.java_data.comics.interfaces.dao.beans.Aventure;
import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;
import be.steformations.laura.java_data.comics.dao.beans.AventureImpl;
import be.steformations.laura.java_data.comics.dao.beans.PersonnageImpl;
import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;

public class JpaDaoPersonnage implements PersonnageManager {

	private javax.persistence.EntityManager entitymanager;
	
	public JpaDaoPersonnage (javax.persistence.EntityManager entitymanager){
		super();
		this.entitymanager = entitymanager;
	}
	
	@Override
	public PersonnageImpl getPersonnage(String prenom, String nom) {
		PersonnageImpl personnage = null;
		
			// on n'utilise pas du sql ms du jpql
		String jpql = "select o from Comic o where lower(o.prenom) = lower(?1) and lower(o.nom) = lower(?2)";
		// je n'interroge plus une table mais une entité et j'utilise des propriétés d'instances pour la recherche
		// o = instance d'objet (et pas un enregistrement dans la table)
		// le nommer permet de travailler avec les instances : o. ...
		// on a aussi des place orders mais indicés
		
		
		//rem : on peut demander les propriétés mais pas des collections (e;g. je ne peux pas demander un o.aventures)
		
		javax.persistence.TypedQuery<PersonnageImpl> query = this.entitymanager.createQuery(jpql, PersonnageImpl.class);
		// la requête est typée
		query.setParameter(1, prenom);
		query.setParameter(2, nom);
		
		try {
			personnage = query.getSingleResult(); //recherche d'une seule instance
		} catch(javax.persistence.NoResultException e){
			// quand on cherche un seul objet, on peut ne pas en trouver
		}
		
		return personnage;
	}

	@Override
	public PersonnageImpl getPersonnage(int id) {
		PersonnageImpl personnage = null;
		
		//solution plus courte pour les requêtes sur les identifiants
		personnage = this.entitymanager.find(PersonnageImpl.class, id);
		// ne renvoie pas d'exception mais renvoie null si n'a pas été trouvé
		
		return personnage;
		// -> on peut écrire seulement dans le return :
		// return entitymanager.find(PersonnageImpl.class, id);
	}

	@Override
	public List<? extends Aventure> getAventures(int id) {
		java.util.List<AventureImpl> aventures = null;
		
		PersonnageImpl personnage = this.getPersonnage(id);
		if (personnage != null){
			aventures = personnage.getHistoires();
		} else {
			aventures = java.util.Collections.emptyList();
		}
		return aventures;
	}

	@Override
	public Personnage creerPersonnage(String prenom, String nom, String aka, Date ddn, Genre genre) {
		PersonnageImpl personnage = null;
		
		if (prenom != null && nom != null){
			personnage = this.getPersonnage(prenom, nom);
			if (personnage == null){
				personnage = new PersonnageImpl();
				personnage.setPrenom(prenom);
				personnage.setNom(nom);
				personnage.setAka(aka);
				if (ddn != null){
					personnage.setDdn(new java.sql.Date(ddn.getTime()));
				}
				if(genre != null){
					personnage.setGenre((GenreImpl) genre);
				}
				this.entitymanager.getTransaction().begin();
				this.entitymanager.persist(personnage); // fonctionne pour les insertions, modifications et suppressions (?) ds la db
				this.entitymanager.getTransaction().commit();
				
			}
		}
		
		// pour ne pas que l'id reste null, il faut préciser dans PersonnageImpl comment l'id est généré par la db
		return personnage;
	}

	@Override
	public void modifierPersonnage(int id, String aka) {
		PersonnageImpl p = this.getPersonnage(id);
		if (p != null){
			p.setAka(aka);
			this.entitymanager.getTransaction().begin();
			this.entitymanager.persist(p);
			this.entitymanager.getTransaction().commit();
		}

	}

	@Override
	public void supprimerPersonnage(int id) {
		PersonnageImpl p = this.getPersonnage(id);
		if (p != null){
			this.entitymanager.getTransaction().begin();
			this.entitymanager.remove(p); // pour les suppressions
			this.entitymanager.getTransaction().commit();
		}
	}

}
