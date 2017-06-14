package co.simplon.videomanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.videomanager.dao.CategoryDAO;
import co.simplon.videomanager.domain.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO dao;

	public List<Category> listCategorys(String search) throws Exception {
		return dao.listCategorys(search);
	}

	public Category getCategory(Long id) throws Exception {
		return dao.getCategory(id);
	}

	public Category insertCategory(Category category) throws Exception {
		dao.insertCategory(category);
		return category;
	}

	public void updateCategory(Category category) throws Exception {
		dao.updateCategory(category);
	}

	public void deleteCategory(Long id) throws Exception {
		dao.deleteCategory(id);
	}

}
