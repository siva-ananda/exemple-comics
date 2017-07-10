package be.steformations.pc.java_data.comics.dao.managers.spring_jdbc;

import java.util.Date;
import java.util.List;

import be.steformations.java_data.comics.interfaces.dao.beans.Aventure;
import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;
import be.steformations.pc.java_data.comics.dao.beans.AventureImpl;
import be.steformations.pc.java_data.comics.dao.beans.PersonnageImpl;

public class SpringJdbcDaoPersonnage implements PersonnageManager {

	private org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
	
	public SpringJdbcDaoPersonnage(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Personnage getPersonnage(String prenom, String nom) {
		PersonnageImpl personnage = null;
		
		if (prenom != null && nom != null) {
			String sql = "select p.pk, p.prenom, p.nom, p.aka, p.ddn, g.num, g.nom "
					   + "from personnages as p left join genres as g on g.num = p.fk_genre "
					   + "where lower(p.prenom) = lower(?) and lower(p.nom) = lower(?)";
			try {
				SpringJdbcPersonnageRowMapper mapper = new SpringJdbcPersonnageRowMapper();
				personnage = this.jdbcTemplate.queryForObject(sql, mapper, prenom, nom);
				/*
				 	public Object queryForObject(String sql, RowMapper mapper, Object... parametres) {
				 		Object o = null;
				 		try (
							java.sql.Connection c = this.dataSource.getConnection();
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
						if(rs.next()) {
							o = mapper.mapRow(rs, 1);
						} else {
							throw new org.springframework.dao.EmptyResultDataAccessException();
						}
						return o;
				 	}
				 */
			} catch(org.springframework.dao.EmptyResultDataAccessException e) {}
		}
		
		return personnage;
	}

	@Override
	public Personnage getPersonnage(int id) {
		PersonnageImpl personnage = null;
		
		if (id > 0) {
			String sql = "select p.pk, p.prenom, p.nom, p.aka, p.ddn, g.num, g.nom "
					   + "from personnages as p left join genres as g on g.num = p.fk_genre "
					   + "where p.pk = ?";
			try {
//				SpringJdbcPersonnageRowMapper mapper = new SpringJdbcPersonnageRowMapper();
//				personnage = this.jdbcTemplate.queryForObject(sql, mapper, id);
				
				SpringJdbcPersonnageResultSetExtractor extractor = new SpringJdbcPersonnageResultSetExtractor();
				personnage = this.jdbcTemplate.query(sql, extractor, id);
			} catch(org.springframework.dao.EmptyResultDataAccessException e) {}
		}
		
		return personnage;
	}

	@Override
	public List<? extends Aventure> getAventures(int id) {
		java.util.List<AventureImpl> liste = null;
		
		String sql = "select id, titre "
				+    "from aventures join liens_personnages_aventures on fk_aventure = id "
				+    "               join personnages as p on fk_personnage = p.pk "
				+    "where p.pk = ?";
		
		liste = this.jdbcTemplate.query(sql, new SpringJdbcAventureRowMapper(), id);
		
		return liste;
	}

	@Override
	public Personnage creerPersonnage(String prenom, String nom, String aka, Date ddn, Genre genre) {
		Personnage personnage = null;
		
		if (prenom != null && nom != null) {
			String sql = "insert into personnages(prenom, nom, aka, ddn, fk_genre) "
					   + "values(?, ?, ?, ?, ?)";
			Integer fkGenre = genre == null ? null : genre.getId();
			this.jdbcTemplate.update(sql, prenom, nom, aka, ddn, fkGenre);
			personnage = this.getPersonnage(prenom, nom);
		}
		
		return personnage;
	}

	@Override
	public void modifierPersonnage(int id, String aka) {
		String sql = "update personnages set aka = ? where pk = ?";
		this.jdbcTemplate.update(sql, aka, id);
	}

	@Override
	public void supprimerPersonnage(int id) {
		String sql = "delete from personnages where pk = ?";
		this.jdbcTemplate.update(sql, id);
	}

}
