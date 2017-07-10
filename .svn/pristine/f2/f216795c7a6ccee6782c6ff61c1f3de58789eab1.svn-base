package be.steformations.pc.java_data.comics.dao.beans;

import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;

public class PersonnageImpl implements Personnage {

	private Integer id;
	private String prenom;
	private String nom;
	private String aka;
	private java.sql.Date ddn;
	private GenreImpl genre;
	
	public PersonnageImpl() {
		super();
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
