package co.simplon.laposte.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.laposte.bean.Bresa;

public class Dselect  extends Connexion {
	private boolean ajoutResa;
	private int id;

	public void ajouterResa(Bresa resa) throws SQLException {

		String sql = "insert into Planning set debut=?, fin=?, logement_id=?";
		PreparedStatement pStatement = cn.prepareStatement(sql);
		pStatement.setString(1, resa.getDebut());
		pStatement.setString(2, resa.getFin());
		pStatement.setInt(3, resa.getId());

		int rowsAffected = pStatement.executeUpdate();
		ResultSet rSet = pStatement.getGeneratedKeys();
		id = rSet.getInt(1);
		ajoutResa = (rowsAffected == 1);
		id = rSet.getInt(1);
		
		rSet.close();
		pStatement.close();
	}

	public boolean isAjoutResa() {
		return ajoutResa;
	}

	public int getId() {
		return id;
	}

	public void setAjoutResa(boolean ajoutResa) {
		this.ajoutResa = ajoutResa;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
