package co.simplon.laposte.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.laposte.bean.Blogement;

public class Dlogement extends Connexion {
	private int idAdresse;
	private int idType;
	private int idLogement;
	private boolean adresseAdded;
	private boolean ajoutType;
	private boolean ajoutLogement;

	public void ajouterlogement(Blogement logement) throws SQLException {

		String sql;
		PreparedStatement pStatement;
		ResultSet rSet;
		int rowsAffected;
		
/********************************************************************************/
		sql = "insert into Adresse set rue=?, code=?, ville=?";
		pStatement = cn.prepareStatement(sql);
		pStatement.setString(1, logement.getRue());
		pStatement.setString(2, logement.getCode());
		pStatement.setString(3, logement.getVille());

		rowsAffected = pStatement.executeUpdate();
		rSet = pStatement.getGeneratedKeys();
		idAdresse = pStatement.getGeneratedKeys().getInt(1);
		adresseAdded = (rowsAffected == 1);

		System.out.println(rowsAffected);

		rSet.close();
		pStatement.close();

/********************************************************************************/
		sql = "insert into Type set description=?";
		pStatement = cn.prepareStatement(sql);
		pStatement.setString(1, logement.getType());

		rowsAffected = pStatement.executeUpdate();
		rSet = pStatement.getGeneratedKeys();
		idType = pStatement.getGeneratedKeys().getInt(1);
		ajoutType = (rowsAffected == 1);

		System.out.println(rowsAffected);

		rSet.close();
		pStatement.close();

/********************************************************************************/
		sql = "insert into Logement set description=?, adresse_id=?, proprietaire_id=?, type_id=?";
		pStatement = cn.prepareStatement(sql);
		pStatement.setString(1, logement.getDescription());
		pStatement.setInt(2, idAdresse);
		pStatement.setInt(3, logement.getId());
		pStatement.setInt(4, idType);

		rowsAffected = pStatement.executeUpdate();
		rSet = pStatement.getGeneratedKeys();
		idLogement = pStatement.getGeneratedKeys().getInt(1);
		ajoutLogement = (rowsAffected == 1);

		System.out.println(rowsAffected);

		rSet.close();
		pStatement.close();
/********************************************************************************/
	}

	public int getIdAdresse() {
		return idAdresse;
	}

	public int getIdType() {
		return idType;
	}

	public int getIdLogement() {
		return idLogement;
	}

	public boolean isadresseAdded() {
		return adresseAdded;
	}

	public boolean isAjoutType() {
		return ajoutType;
	}

	public boolean isAjoutLogement() {
		return ajoutLogement;
	}
	
}
