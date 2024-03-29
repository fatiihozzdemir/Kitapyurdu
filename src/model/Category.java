package model;

import dao.CategoryDao;
import dao.CategoryDaoImpl;

public class Category {

	private Integer categoryId;
	// this value will be auto generated by the database
	private String categoryName;

	public Category(Integer categoryId) {
		super();
		this.categoryId = categoryId;
		CategoryDao categoryDao = new CategoryDaoImpl();
		this.categoryName = categoryDao.getCategoryName(categoryId);
	}

	public Category(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public Category(Integer categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}