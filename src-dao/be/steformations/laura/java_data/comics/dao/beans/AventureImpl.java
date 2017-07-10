package be.steformations.laura.java_data.comics.dao.beans;

import be.steformations.java_data.comics.interfaces.dao.beans.Aventure;

public class AventureImpl implements Aventure {

	private Integer id;
	private String titre;
	

	public AventureImpl() {
		super();
	}

	@Override
	public String getTitre() {
		return titre;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titre == null) ? 0 : titre.hashCode());
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
		AventureImpl other = (AventureImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AventureImpl [id=" + id + ", titre=" + titre + "]";
	}
	
	

}
