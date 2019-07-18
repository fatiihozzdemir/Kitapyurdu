package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import model.Category;


public class CategoryDaoImpl implements CategoryDao {

	@Override
	public boolean save(Category category) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		String categoryName = category.getCategoryName();
		try {
			String query = " INSERT INTO `categories` (`categoryId`, `categoryName`) VALUES (NULL, ?)";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, categoryName);
			preparedStmt.execute();
			System.out.println("Data is Successfully Inserted into category Table");
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
		return false;
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer categoryId) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		System.out.println("ok");
		try {

			String query = " DELETE FROM `categories` WHERE `categoryId`= ? ";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setLong(1, categoryId);

			preparedStmt.execute();

			System.out.println("Data is Successfully Deleted.");

		} catch (SQLException e) {
			System.out.println("Category delete catch");
			e.printStackTrace();
		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
	}

	@Override
	public List<Category> getCategoryList() throws ServletException {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		try {
			String query = " SELECT * FROM `categories` ";
			preparedStmt = connection.prepareStatement(query);

			ResultSet rs = preparedStmt.executeQuery(query);
			List<Category> list = new ArrayList<Category>();

			while (rs.next()) {
				Integer categoryId = rs.getInt("categoryId");
				String categoryName = rs.getString("categoryName");
				Category bCategory = new Category(categoryId, categoryName);
				list.add(bCategory);
			}
			return list;
		} catch (SQLException e) {
			System.out.println("An error occured while retrieving " + "all categories: " + e.toString());
		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
		return null;
	}

	@Override
	public String getCategoryName(Integer categoryId) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		try {
			String query = " SELECT `categoryName` FROM `categories` WHERE `categoryId` = ?";
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, categoryId.toString());

			ResultSet rs = preparedStmt.executeQuery();
			rs.next();

			String categoryName = rs.getString("categoryName");
			return categoryName;
		} catch (SQLException e) {
			System.out.println("An error occured while retrieving " + "all categories: " + e.toString());
		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
		return null;
	}

	@Override
	public Category getCategory(Integer categoryId) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		String wId = categoryId.toString();
		String categoryName;
		Category category = null;
		try {

			String query = "SELECT * FROM `categories` WHERE `categoryId` = ?";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, wId);

			ResultSet rs = null;
			preparedStmt.execute();
			rs = preparedStmt.getResultSet();

//			while (rs.next()) {
			rs.next();
			categoryName = rs.getString("categoryName");

			category = new Category(categoryId, categoryName);
//			}
			System.out.println("Category is Successfully Found.");
			return category;

		} catch (SQLException e) {
			System.out.println("Category select catch");
			e.printStackTrace();
		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
		return null;
	}

}