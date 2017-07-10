package be.steformations.laura.java_data.comics.dao.managers.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import be.steformations.laura.java_data.comics.dao.beans.GenreImpl;
import be.steformations.laura.java_data.comics.dao.beans.PersonnageImpl;




public class JdbcPersonnageDaoHelper {


	private String url;
	private String login;
	private String pwd;

		public JdbcPersonnageDaoHelper(String url, String login, String pwd) {
		super();
		this.url = url;
		this.login = login;
		this.pwd = pwd;
	}

	//doit renvoyer une liste de personnages à partir d'une requête sql
	
	public List<PersonnageImpl> queryForList(String sql, Object[] parametres){
		List<PersonnageImpl> liste = new ArrayList<>();
		
		try (Connection c = DriverManager.getConnection(url, login, pwd);
				PreparedStatement requete = c.prepareStatement(sql);){
			
			for(int i=0; i< parametres.length; i++) {
				Object param = parametres[i];
				if (param instanceof Integer){
					requete.setInt(i+1, (Integer) param);
				}else if (param instanceof Date){
					requete.setDate(i+1, (Date) param);
				}else{
					requete.setString(i+1, (String) param);
				}
			}
			ResultSet rs = requete.executeQuery();
			while(rs.next()){
				PersonnageImpl p = this.create(rs);
				liste.add(p);
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return liste;
	}
	
	// pareil avec un seul perso
	
	public PersonnageImpl queryForObject(String sql, Object... parametres){
		PersonnageImpl personnage= null;
		
		List<PersonnageImpl> liste = this.queryForList(sql, parametres);
		if (! liste.isEmpty()){
			personnage = liste.get(0);
		}
		
		return personnage;
	}
	
	public void queryForUpdate(String sql, Object... parametres){

		try (Connection c = DriverManager.getConnection(url, login, pwd);
				PreparedStatement requete = c.prepareStatement(sql);){
			
			for(int i=0; i< parametres.length; i++) {
				Object param = parametres[i];
				if (param instanceof Integer){
					requete.setInt(i+1, (Integer) param);
				}else if (param instanceof Date){
					requete.setDate(i+1, (Date) param);
				}else{
					requete.setString(i+1, (String) param);
				}
			}
			requete.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	private PersonnageImpl create(ResultSet rs) throws SQLException{
		PersonnageImpl personnage = null;
		GenreImpl genre = null;
		
		int id = rs.getInt(1);
		String prenom = rs.getString(2);
		String nom = rs.getString(3);
		String aka = rs.getString(4);
		Date ddn = rs.getDate(5);
		int numGenre = rs.getInt(6);
		if(! rs.wasNull()){// si la dernière entrée lue n'est pas nulle
			String nomGenre = rs.getString(7);
			genre = new GenreImpl();
			genre.setId(numGenre);
			genre.setNom(nomGenre);
		}
		personnage = new PersonnageImpl();
		personnage.setId(id);
		personnage.setPrenom(prenom);
		personnage.setNom(nom);
		personnage.setAka(aka);
		personnage.setDdn(ddn);
		personnage.setGenre(genre);
		
		return personnage;
	}
	
}
