package be.steformations.laura.java_data.comics.dao.managers.jdbc;

import java.sql.*;
import java.util.List;

import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.GenreManager;
import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;

public class JdbcDaoGenre implements GenreManager {

	private String url;
	private String user;
	private String pwd;
	
	public JdbcDaoGenre(String url, String user, String pwd) {
		super();
		this.url = url;
		this.user = user;
		this.pwd = pwd;
	}

	@Override
	public Genre getGenre(String nom) {
		GenreImpl genre = null;
		
		String sql = "select num, nom from genres where lower(nom) = lower(?)";
		
		try (Connection connexion = DriverManager.getConnection(this.url, this.user, this.pwd);
				PreparedStatement requete = connexion.prepareStatement(sql)) {
			
			requete.setString(1, nom);
			ResultSet resultat = requete.executeQuery();
			if (resultat.next()){
				int numero = resultat.getInt("num");
				String name = resultat.getString("nom");
				genre = new GenreImpl();
				genre.setId(numero);
				genre.setNom(name);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		return genre;
	}

	@Override
	public List<? extends Personnage> getPersonnages(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
