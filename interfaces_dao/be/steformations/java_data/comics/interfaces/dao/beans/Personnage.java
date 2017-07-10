package be.steformations.java_data.comics.interfaces.dao.beans;

import java.io.Serializable;
import java.sql.Date;

public interface Personnage extends Serializable {
	Integer getId();
	String getNom();
	String getPrenom();
	Date getDdn();
	String getAka();
	Genre getGenre();
}
