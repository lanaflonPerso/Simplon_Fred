package co.simplon.videomanager.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.simplon.videomanager.domain.Actor;

@Component
public class JdbcActorDao implements ActorDAO {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private DataSource ds;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcActorDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = this.jdbcTemplate.getDataSource();
	}

	@Override
	public List<Actor> listActors(String search) throws Exception {
		Actor actor;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Actor> aLlistOfActor = new ArrayList<Actor>();

		try {
			sql = "SELECT * FROM actor ";
			if (search == null || search.trim().equals("")) {
				pstmt = ds.getConnection().prepareStatement(sql);
			}
			else {
				sql += "WHERE first_name like ? OR last_name like ?";
				pstmt = ds.getConnection().prepareStatement(sql);
				pstmt.setString(1, "%" + search + "%");
				pstmt.setString(2, "%" + search + "%");
			}
			logSQL(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				actor = getActorFromResultSet(rs);
				aLlistOfActor.add(actor);
			}
		} catch (Exception e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
		return aLlistOfActor;

	}

	@Override
	public Actor getActor(Long id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs;
		Actor actor = null;
		String sql = "SELECT * FROM actor WHERE actor_id = ?";

		try {
			pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			logSQL(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next())
				actor = getActorFromResultSet(rs);
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
		return actor;
	}

	@Override
	public void insertActor(Actor actor) throws Exception {
		actor.setId(new Long(0)); // force auto incremente, sinon erreur sql si
									// id existant
		PreparedStatement pstmt = null;
		ResultSet rs;
		int i = 0;
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());

		String sql = "INSERT INTO actor (actor_id, first_name, last_name, last_update) VALUES (?,?,?,?)";
		try {
			pstmt = ds.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setLong(++i, actor.getId());
			pstmt.setString(++i, actor.getFirstName());
			pstmt.setString(++i, actor.getLastName());
			pstmt.setTimestamp(++i, updateTime);
			logSQL(pstmt);
			pstmt.executeUpdate();

			// recupération de l'id
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				actor.setId(rs.getLong(1));
				actor.setLastUpdate(updateTime);
			}
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}

	}

	@Override
	public void updateActor(Actor actor) throws Exception {
		PreparedStatement pstmt = null;
		int i = 0;
		String sql = "UPDATE actor SET first_name = ?, last_name = ?, last_update = ? WHERE actor_id = ?";
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());
		try {
			pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setString(++i, actor.getFirstName());
			pstmt.setString(++i, actor.getLastName());
			pstmt.setTimestamp(++i, updateTime);
			pstmt.setLong(++i, actor.getId());
			logSQL(pstmt);
			pstmt.executeUpdate();

			// maj date modif
			actor.setLastUpdate(updateTime);
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}

	}

	@Override
	public void deleteActor(Long id) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM actor WHERE actor_id = ?";
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

	private Actor getActorFromResultSet(ResultSet rs) throws SQLException {
		Actor actor = new Actor();
		actor.setId(rs.getLong("actor_id"));
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));
		actor.setLastUpdate(rs.getTimestamp("last_update"));
		return actor;
	}

	private void logSQL(PreparedStatement pstmt) {
		String sql;
		if (pstmt == null) return;
		sql = pstmt.toString().substring(pstmt.toString().indexOf(":")+2);
		log.debug(sql);
	}
}
