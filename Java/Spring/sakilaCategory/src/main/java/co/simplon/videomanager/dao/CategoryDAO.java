package co.simplon.videomanager.dao;

import java.util.List;

import co.simplon.videomanager.domain.Category;

public interface CategoryDAO {

	public List<Category> listCategorys(String search) throws Exception;

	public Category getCategory(Long id) throws Exception;

	public void insertCategory(Category category) throws Exception;

	public void updateCategory(Category category) throws Exception;
	
	public void deleteCategory(Long id) throws Exception;

}
