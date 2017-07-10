package be.steformations.laura.java_data.comics.dao.managers.jdbc;

import java.util.Date;
import java.util.List;

import be.steformations.java_data.comics.interfaces.dao.beans.Aventure;
import be.steformations.java_data.comics.interfaces.dao.beans.Genre;
import be.steformations.java_data.comics.interfaces.dao.beans.Personnage;
import be.steformations.java_data.comics.interfaces.dao.managers.PersonnageManager;
import be.steformations.laura.java_data.comics.dao.beans.PersonnageImpl;

public class JdbcDaoPersonnage implements PersonnageManager {

	private JdbcPersonnageDaoHelper helper;
	
	public JdbcDaoPersonnage(JdbcPersonnageDaoHelper helper) {
		super();
		this.helper = helper;
	}
	
	@Override
	public Personnage getPersonnage(String prenom, String nom) {
		
		PersonnageImpl personnage = null;
		
		if (prenom != null && nom != null){
			String sql = "select p.pk, p.prenom, p.nom, p.aka, p.ddn, g.num, g.nom from personnages as p left join genres as g on g.num = p.fk_genre "
				+ "where lower(p.prenom) = lower(?) and lower(p.nom) = lower(?)"; // left join : jointure externe car on peut avoir un personnage sans genre
			
			personnage = this.helper.queryForObject(sql,  prenom, nom);
			
		}
		return personnage;
	}

	@Override
	public Personnage getPersonnage(int id) {
		
		PersonnageImpl personnage = null;
		
		if (id > 0){
			String sql = "select p.pk, p.prenom, p.nom, p.aka, p.ddn, g.num, g.nom from personnages as p left join genres as g on g.num = p.fk_genre "
				+ "where p.pk = ?"; 
			
			personnage = this.helper.queryForObject(sql,  id);
			
		}
		return personnage;
	}

	@Override
	public List<? extends Aventure> getAventures(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personnage creerPersonnage(String prenom, String nom, String aka, Date ddn, Genre genre) {
		Personnage personnage = null;
		String sql = null;
		Object[] parametres = null;
		
		if(genre != null){
			sql = "insert into personnages(prenom, nom, aka, ddn, fk_genre) values(?, ?, ?, ?, ?)";
			parametres = new Object[] {
				prenom, nom, aka, new Date(ddn.getTime()), genre.getId()
			};
		} else {
			sql = "insert into personnages(prenom, nom, aka, ddn) values(?, ?, ?, ?, )";
			parametres = new Object[] {
				prenom, nom, aka, new Date(ddn.getTime())
			};
		}
		
		this.helper.queryForUpdate(sql, parametres);
		personnage = this.getPersonnage(prenom, nom);
		
		return personnage;
	}

	@Override
	public void modifierPersonnage(int id, String aka) {
		String sql = "update personnages set aka = ? where pk = ?";
		this.helper.queryForUpdate(sql, aka, id);

	}

	@Override
	public void supprimerPersonnage(int id) {
		String sql = "delete from personnages where pk = ?";
		this.helper.queryForUpdate(sql, id);

	}

}
