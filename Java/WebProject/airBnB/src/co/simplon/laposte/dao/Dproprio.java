package co.simplon.laposte.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.simplon.laposte.bean.Bproprio;

public class Dproprio extends Connexion {
	private boolean proprioAdded;
	private ResultSet rSet;
	private int id;
	
	public void ajouterProprio(Bproprio proprio) throws SQLException {
		String sql = "insert into Proprietaire set nom=?, prenom=?, telephone=?, email=?";
		PreparedStatement pStatement = cn.prepareStatement(sql);
		pStatement.setString(1, proprio.getNom());
		pStatement.setString(2, proprio.getPrenom());
		pStatement.setString(3, proprio.getTelephone());
		pStatement.setString(4, proprio.getEmail());
		int rowsAffected = pStatement.executeUpdate();
		rSet = pStatement.getGeneratedKeys();
		id = rSet.getInt(1);
		proprioAdded = (rowsAffected == 1);
		rSet.close();
		pStatement.close();
	}
	
	public int identifierProprio(Bproprio proprio) throws SQLException {
		String sql = "select nom, prenom from Proprietaire";
		PreparedStatement pStatement = cn.prepareStatement(sql);
		int rowsAffected = pStatement.executeUpdate();
		rSet = pStatement.getGeneratedKeys();
		id = rSet.getInt(1);
		boolean proprioExist = (rowsAffected == 1);
		if (!proprioExist) {
			id=-1;
		}
		rSet.close();
		pStatement.close();
		this.seDeconnecter();
		return id;
	}

	public boolean isproprioAdded() {
		return proprioAdded;
	}

	public int getId() {
		return id;
	}

}
