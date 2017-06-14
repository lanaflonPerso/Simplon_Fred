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

import co.simplon.videomanager.domain.Category;

@Component
public class JdbcCategoryDao implements CategoryDAO {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private DataSource ds;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcCategoryDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.ds = this.jdbcTemplate.getDataSource();
	}

	@Override
	public List<Category> listCategorys(String search) throws Exception {
		Category category;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String sql;
		ArrayList<Category> aLlistOfCategory = new ArrayList<Category>();

		try {
			sql = "SELECT * FROM category ";
			if (search == null || search.trim().equals("")) {
				pstmt = ds.getConnection().prepareStatement(sql);
			}
			else {
				sql += "WHERE name like ?";
				pstmt = ds.getConnection().prepareStatement(sql);
				pstmt.setString(1, "%" + search + "%");
			}
			logSQL(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				category = getCategoryFromResultSet(rs);
				aLlistOfCategory.add(category);
			}
		} catch (Exception e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
		return aLlistOfCategory;

	}

	@Override
	public Category getCategory(Long id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs;
		Category category = null;
		String sql = "SELECT * FROM category WHERE category_id = ?";

		try {
			pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setLong(1, id);
			logSQL(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next())
				category = getCategoryFromResultSet(rs);
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}
		return category;
	}

	@Override
	public void insertCategory(Category category) throws Exception {
		category.setId(new Long(0)); // force auto incremente, sinon erreur sql si
									// id existant
		PreparedStatement pstmt = null;
		ResultSet rs;
		int i = 0;
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());

		String sql = "INSERT INTO category (category_id, name, last_update) VALUES (?,?,?)";
		try {
			pstmt = ds.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setLong(++i, category.getId());
			pstmt.setString(++i, category.getName());
			pstmt.setTimestamp(++i, updateTime);
			logSQL(pstmt);
			pstmt.executeUpdate();

			// recupération de l'id
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				category.setId(rs.getLong(1));
				category.setLastUpdate(updateTime);
			}
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}

	}

	@Override
	public void updateCategory(Category category) throws Exception {
		PreparedStatement pstmt = null;
		int i = 0;
		String sql = "UPDATE category SET name = ?, last_update = ? WHERE category_id = ?";
		Timestamp updateTime = new Timestamp(System.currentTimeMillis());
		try {
			pstmt = ds.getConnection().prepareStatement(sql);
			pstmt.setString(++i, category.getName());
			pstmt.setTimestamp(++i, updateTime);
			pstmt.setLong(++i, category.getId());
			logSQL(pstmt);
			pstmt.executeUpdate();

			// maj date modif
			category.setLastUpdate(updateTime);
		} catch (SQLException e) {
			log.error("SQL Error !:"+pstmt.toString(),e);
			throw new Exception("SQL Error");
		} finally {
			pstmt.close();
		}

	}

	@Override
	public void deleteCategory(Long id) throws Exception {
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM category WHERE category_id = ?";
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

	private Category getCategoryFromResultSet(ResultSet rs) throws SQLException {
		Category category = new Category();
		category.setId(rs.getLong("category_id"));
		category.setName(rs.getString("name"));
		category.setLastUpdate(rs.getTimestamp("last_update"));
		return category;
	}

	private void logSQL(PreparedStatement pstmt) {
		String sql;
		if (pstmt == null) return;
		sql = pstmt.toString().substring(pstmt.toString().indexOf(":")+2);
		log.debug(sql);
	}
}
