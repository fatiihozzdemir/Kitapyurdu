package dao;

import java.util.List;

import javax.servlet.ServletException;

import model.Category;

public interface CategoryDao {

	boolean save(Category category);

	void update(Category category);

	void delete(Integer categoryId);

	List<Category> getCategoryList() throws ServletException;
	
	String getCategoryName(Integer categoryId);
	
	Category getCategory(Integer categoryId);

}