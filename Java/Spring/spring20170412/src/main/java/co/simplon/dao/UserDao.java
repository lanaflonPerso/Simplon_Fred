package co.simplon.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.simplon.domain.UserDom;

@Component
public class UserDao implements IUserDao {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private DataSource ds;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = this.jdbcTemplate.getDataSource();
	}

	@Override
	public UserDom getUser(long id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs;
		UserDom user = null;
		String sql = "SELECT * FROM Personnel WHERE id = ?";

		try {
			pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			logSQL(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next())
				user = getUserFromResultSet(rs);
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
		return user;
	}

	@Override
	public void addUser(UserDom user) throws Exception {
		user.setId(new Long(0));
		PreparedStatement pstmt = null;
		ResultSet rs;
		int i = 0;

		String sql = "INSERT INTO Personnel (id, Nom, Prenom, Matricule, Email, MotDePasse, Equipe_id, TypeDroit_id, Valideur_id, RH_id, Compteur_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = ds.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setLong(++i, user.getId());
			pstmt.setString(++i, user.getNom());
			pstmt.setString(++i, user.getPrenom());
			pstmt.setString(++i, user.getMatricule());
			pstmt.setString(++i, user.getEmail());
			pstmt.setString(++i, user.getMotDePasse());
			pstmt.setLong(++i, user.getEquipe_id());
			pstmt.setLong(++i, user.getTypeDroit_id());
			pstmt.setLong(++i, user.getValideur_id());
			pstmt.setLong(++i, user.getRH_id());
			pstmt.setLong(++i, user.getCompteur_id());
	
			logSQL(pstmt);
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				user.setId(rs.getLong(1));
			}
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
		
	}

	@Override
	public void majUser(UserDom user) throws Exception {
		PreparedStatement pstmt = null;
		int i = 0;
		String sql = "UPDATE Personnel SET id, Nom, Prenom = ?, Matricule = ?, Email = ?, MotDePasse = ?, Equipe_id = ?, TypeDroit_id = ?, Valideur_id = ?, RH_id = ?, Compteur_id = ?";
		try {
			pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setLong(++i, user.getId());
			pstmt.setString(++i, user.getNom());
			pstmt.setString(++i, user.getPrenom());
			pstmt.setString(++i, user.getMatricule());
			pstmt.setString(++i, user.getEmail());
			pstmt.setString(++i, user.getMotDePasse());
			pstmt.setLong(++i, user.getEquipe_id());
			pstmt.setLong(++i, user.getTypeDroit_id());
			pstmt.setLong(++i, user.getValideur_id());
			pstmt.setLong(++i, user.getRH_id());
			pstmt.setLong(++i, user.getCompteur_id());
			logSQL(pstmt);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
	}

	@Override
	public void delUser(long id) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM Personnel WHERE id = ?";
		try {
			pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			logSQL(pstmt);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
	}

	private UserDom getUserFromResultSet(ResultSet rs) throws SQLException {
		UserDom user = new UserDom();
		user.setId(rs.getLong("id"));
		user.setNom(rs.getString("Nom"));
		user.setPrenom(rs.getString("Prenom"));
		user.setMatricule(rs.getString("Matricule"));
		user.setEmail(rs.getString("Email"));
		user.setMotDePasse(rs.getString("MotDePasse"));
		user.setEquipe_id(rs.getLong("Equipe_id"));
		user.setTypeDroit_id(rs.getLong("TypeDroit_id"));
		user.setValideur_id(rs.getLong("Valideur_id"));
		user.setRH_id(rs.getLong("RH_id"));
		user.setCompteur_id(rs.getLong("Compteur_id"));
		return user;
	}

	private void logSQL(PreparedStatement pstmt) {
		String sql;
		if (pstmt == null) return;
		sql = pstmt.toString().substring(pstmt.toString().indexOf(":")+2);
		log.debug(sql);
	}

}
