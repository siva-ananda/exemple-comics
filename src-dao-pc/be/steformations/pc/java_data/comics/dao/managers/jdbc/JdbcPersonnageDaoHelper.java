package be.steformations.pc.java_data.comics.dao.managers.jdbc;

import be.steformations.pc.java_data.comics.dao.beans.GenreImpl;
import be.steformations.pc.java_data.comics.dao.beans.PersonnageImpl;

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

	public java.util.List<PersonnageImpl> queryForList(String sql, Object[] parametres) {
		java.util.List<PersonnageImpl> liste = new java.util.ArrayList<>();
		
		try (
			java.sql.Connection c = java.sql.DriverManager.getConnection(url, login, pwd);
			java.sql.PreparedStatement requete = c.prepareStatement(sql);
		) {
			for(int i=0; i < parametres.length; i++) {
				Object param = parametres[i];
				if (param instanceof Integer) {
					requete.setInt(i+1, (Integer) param);
				} else if (param instanceof java.sql.Date) {
					requete.setDate(i+1, (java.sql.Date) param);
				} else {
					requete.setString(i+1, (String) param);
				}
			}
			java.sql.ResultSet rs = requete.executeQuery();
			while(rs.next()) {
				PersonnageImpl p = this.create(rs);
				liste.add(p);
			}
		} catch(java.sql.SQLException e) {
			e.printStackTrace();
		}
		
		return liste;
	}
	
	public PersonnageImpl queryForObject(String sql, Object... parametres) {
		PersonnageImpl personnage = null;
		
		java.util.List<PersonnageImpl> liste = this.queryForList(sql, parametres);
		if (! liste.isEmpty()) {
			personnage = liste.get(0);
		}
		
		return personnage;
	}
	
	public void queryForUpdate(String sql, Object... parametres) {
		try (
			java.sql.Connection c = java.sql.DriverManager.getConnection(url, login, pwd);
			java.sql.PreparedStatement requete = c.prepareStatement(sql);
		) {
			for(int i=0; i < parametres.length; i++) {
				Object param = parametres[i];
				if (param instanceof Integer) {
					requete.setInt(i+1, (Integer) param);
				} else if (param instanceof java.sql.Date) {
					requete.setDate(i+1, (java.sql.Date) param);
				} else {
					requete.setString(i+1, (String) param);
				}
			}
			requete.executeUpdate();
		} catch(java.sql.SQLException e) {
			e.printStackTrace();
		}
	}
	
	private PersonnageImpl create(java.sql.ResultSet rs) throws java.sql.SQLException {
		PersonnageImpl personnage = null;
		GenreImpl genre = null;
		
		int id = rs.getInt(1);
		String prenom = rs.getString(2);
		String nom = rs.getString(3);
		String aka = rs.getString(4);
		java.sql.Date ddn = rs.getDate(5);
		int numGenre = rs.getInt(6);
		if (! rs.wasNull()) {
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
