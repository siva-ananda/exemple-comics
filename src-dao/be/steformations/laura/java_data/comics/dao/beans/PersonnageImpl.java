package be.steformations.laura.java_data.comics.dao.beans;

import java.sql.Date;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;


@javax.persistence.Entity(name="Comic") //annotation obligatoire (nom facultatif qui pourra être utilisé danns les requêtes) 
											// qui dit que cette classe de java est une table dans la db
@javax.persistence.Table(name="personnages")// précise à quelle table correspond cette classe java
										// ici toute l'annotation est obligatoire sauf si le nom de la table correspond au nom de la classe
public class PersonnageImpl implements Personnage {

	@javax.persistence.Id // toutes les entités doivent avoir au moins un identifiant
	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.IDENTITY)// le seul qui marche avec tout c'est table (créer une table ds la db pour dire où on en est ds les id
	// pas nécessaire si on ne fait pas d'insertions dans la db mais si c'est le cas, il faut dire comment générer le nouvel id
	@javax.persistence.Column(name="pk") // obligatoire car pas le même nom classe/colonne
	private Integer id;
	
	@javax.persistence.Basic // pas clé étrangère, facultatif car c'est l avaleur par défaut
	@javax.persistence.Column(name="prenom")// ici pas nécessaire car porte le même nom que la colonne
	private String prenom;
	private String nom;
	private String aka;
	private java.sql.Date ddn;
	
	// clé étrangère dt on n'a pas défini comment personnage est lié à genre => pour dire à jpa de ne pas s'en occuper :
	//@javax.persistence.Transient
	
	@javax.persistence.ManyToOne//attribut pour préciser la relation de many to one de la clé étrangère
	// lazy par défaut => pas obligé de le préciser
	@javax.persistence.JoinColumn(name="fk_genre")// + préciser sur quoi on joint les tables
	private GenreImpl genre;
	
	
	@javax.persistence.ManyToMany
	@javax.persistence.JoinTable(
		name="liens_personnages_aventures", // ici on a une table de jointure (cf le cours sur la conception de db)
		joinColumns=@javax.persistence.JoinColumn(name="fk_personnage"),// + préciser les clés étrangères qui servent de jointure
		inverseJoinColumns=@javax.persistence.JoinColumn(name="fk_aventure")
		) // en fait on ne fait que définir, décrire la table de jointure
	private java.util.List<AventureImpl> histoires;// on a une liste car un perso est lié à plusieurs aventures (ManyToMany)
	
	
	@javax.persistence.Transient
	private String fullname;
	
	public PersonnageImpl() {
		super();
	}
	
	
	public String getFullname() {
		if (this.fullname == null){
			this.fullname = this.prenom + " " + this.nom;
		}
		return fullname;
	}

	public java.util.List<AventureImpl> getHistoires(){
		if(this.histoires == null){
			this.histoires = new java.util.ArrayList<>();
		}
		return this.histoires;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAka() {
		return aka;
	}

	public void setAka(String aka) {
		this.aka = aka;
	}

	public java.sql.Date getDdn() {
		return ddn;
	}

	public void setDdn(java.sql.Date ddn) {
		this.ddn = ddn;
	}

	public GenreImpl getGenre() {
		return genre;
	}

	public void setGenre(GenreImpl genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aka == null) ? 0 : aka.hashCode());
		result = prime * result + ((ddn == null) ? 0 : ddn.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonnageImpl other = (PersonnageImpl) obj;
		if (aka == null) {
			if (other.aka != null)
				return false;
		} else if (!aka.equals(other.aka))
			return false;
		if (ddn == null) {
			if (other.ddn != null)
				return false;
		} else if (!ddn.equals(other.ddn))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonnageImpl [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", aka=" + aka + ", ddn=" + ddn
				+ ", genre=" + genre + "]";
	}
}
