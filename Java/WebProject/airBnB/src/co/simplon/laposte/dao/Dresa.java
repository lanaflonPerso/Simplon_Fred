package co.simplon.laposte.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.laposte.bean.Bresa;

public class Dresa extends Connexion {
	private boolean resaAdded;
	private int id;

	public void ajouterResa(Bresa resa) throws SQLException {
		
		String sql = "insert into Planning set debut=?, fin=?, logement_id=?";
		PreparedStatement pStatement = cn.prepareStatement(sql);
		pStatement.setString(1, resa.getDebut());
		pStatement.setString(2, resa.getFin());
		pStatement.setInt(3, resa.getLogement_id());

		int rowsAffected = pStatement.executeUpdate();
		ResultSet rSet = pStatement.getGeneratedKeys();
		id = rSet.getInt(1);
		resaAdded = (rowsAffected == 1);
		
		id = rSet.getInt(1);
		rSet.close();
		pStatement.close();
	}

	public boolean isresaAdded() {
		return resaAdded;
	}

	public int getId() {
		return id;
	}

}
