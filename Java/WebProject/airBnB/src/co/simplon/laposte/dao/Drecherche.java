package co.simplon.laposte.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.simplon.laposte.bean.Brecherche;

public class Drecherche extends Connexion {

	private ResultSet enreg;
	private ArrayList<String> liste = new ArrayList<>();
	private int nbLogement;

	public void dispon(Brecherche cherche) throws SQLException {

		nbLogement = 0;
		String sql = "SELECT Logement.id FROM Logement "
//				+ "INNER JOIN Type      ON   Type.id      =  Logement.Type_id "
				+ "INNER JOIN Adresse   ON   Adresse.id   =  Logement.adresse_id "
				+ "INNER JOIN Planning  ON   Logement.id  =  Planning.logement_id "
				+ "WHERE (Planning.fin>? AND Planning.debut<?) AND Adresse.ville=?";

		PreparedStatement pStatement = cn.prepareStatement(sql);

		pStatement.setString(1, cherche.getDebut());
		pStatement.setString(2, cherche.getFin());
		pStatement.setString(3, cherche.getVille());

		nbLogement = pStatement.executeUpdate();
		enreg = pStatement.getResultSet();
//		enreg = pStatement.getGeneratedKeys();
		enreg.beforeFirst();
		while (enreg.next()) {
			liste.add(""+enreg.getRow());
		}
		enreg.close();
		pStatement.close();
		this.seDeconnecter();
	}
	
	public ResultSet getEnreg() {
		return enreg;
	}

	public ArrayList<String> getListe() {
		return liste;
	}

	public int getNbLogement() {
		return nbLogement;
	}

	public void setEnreg(ResultSet enreg) {
		this.enreg = enreg;
	}

	public void setListe(ArrayList<String> liste) {
		this.liste = liste;
	}

	public void setNbLogement(int nbLogement) {
		this.nbLogement = nbLogement;
	}

}
