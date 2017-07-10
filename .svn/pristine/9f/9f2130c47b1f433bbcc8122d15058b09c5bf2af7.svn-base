package be.steformations.java_data.comics.interfaces.jdbc;

public interface ComicsJDBC {

	boolean ping();
	String selectAka(String prenom, String nom);
	String selectGenre( String prenom, String nom );
	java.util.List<String> selectPrenoms( String genre );
	int insertPersonnage(String prenom, String nom, String aka, java.sql.Date ddn);
	void updateAka(String prenom, String nom, String aka);
}
