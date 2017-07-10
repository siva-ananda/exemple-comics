package be.steformations.laura.java_data.comics.dao.beans;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;

public class GenreImpl implements Genre {

	//configuré dans le fichier orm.xml
	
	private Integer id;
	private String nom;
	
	// pour définir le pendant du many to one de personnage
	// ici on aurait une liste de personnages par genre : one to many
	// -> la propriété sera définie dans le orm.xml (mais on peut aussi le faire par annotation
	
	java.util.List<PersonnageImpl> comics;
	
	public GenreImpl(){
		super();
	}
	
	public java.util.List<PersonnageImpl> getComics() {
		if(this.comics == null){
			this.comics = new java.util.ArrayList<>();
		}
		return comics;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public String getNom() {
		return this.nom;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	// on surcharge ces méthodes car les objets créés votn se retrouver dans des structures de données type liste, etc.
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		GenreImpl other = (GenreImpl) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "GenreImpl [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	
}
