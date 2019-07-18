package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import model.Writer;


public class WriterDaoImpl implements WriterDao {

	@Override
	public boolean save(Writer writer) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		String writerName = writer.getWriterName();
		String gender = writer.getGender();
		Date birthDate = writer.getBirthDate();
		try {
			String query = "INSERT INTO `writers` (`writerId`, `writerName`, `gender`, `writerBirthDay`) "
					+ "VALUES (NULL, ?, ?, ?);";
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, writerName);
			preparedStmt.setString(2, gender);
			preparedStmt.setDate(3, birthDate);
			preparedStmt.execute();
			System.out.println("Data is Successfully Inserted into writers Table");
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
		return false;
	}

	@Override
	public void update(Writer writer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer writerId) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		System.out.println("ok");
		try {

			String query = " DELETE FROM `writers` WHERE `writerId`= ? ";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setLong(1, writerId);

			preparedStmt.execute();

			System.out.println("Data is Successfully Deleted.");

		} catch (SQLException e) {
			System.out.println("Writer delete catch");
			e.printStackTrace();
		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
	}

	@Override
	public List<Writer> getWriterList() throws ServletException {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		try {
			String query = " SELECT * FROM `writers` ";
			preparedStmt = connection.prepareStatement(query);

			ResultSet rs = preparedStmt.executeQuery(query);
			List<Writer> list = new ArrayList<Writer>();

			while (rs.next()) {
				Integer writerId = rs.getInt("writerId");
				String writerName = rs.getString("writerName");
				String gender = rs.getString("gender");
				Date birthDate = rs.getDate("writerBirthDay");
				Writer bWriter = new Writer(writerId, writerName, gender, birthDate);
				bWriter.setWriterName(bWriter.getWriterName().replace('_', ' '));
				list.add(bWriter);
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
	public String getWriterName(Integer writerId) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		try {
			String query = " SELECT `writerName` FROM `categories` WHERE `writerId` = ?";
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, writerId.toString());

			ResultSet rs = preparedStmt.executeQuery();
			rs.next();

			String writerName = rs.getString("writerName");
			return writerName;
		} catch (SQLException e) {
			System.out.println("An error occured while retrieving " + "all categories: " + e.toString());
		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
		return null;
	}

	@Override
	public Writer getWriter(Integer writerId) {
		Connection connection = DaoConnection.connect();
		PreparedStatement preparedStmt = null;
		String wId = writerId.toString();
		String writerName;
		String gender;
		Date birthDate;
		Writer writer = null;
		try {

			String query = "SELECT * FROM `writers` WHERE `writerId` = ?";

			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, wId);

			ResultSet rs = null;
			preparedStmt.execute();
			rs = preparedStmt.getResultSet();

//			while (rs.next()) {
			rs.next();
			writerName = rs.getString("writerName");
			gender = rs.getString("gender");
			birthDate = rs.getDate("writerBirthDay");

			writer = new Writer(writerId, writerName, gender, birthDate);
//			}
			System.out.println("Writer is Successfully Found.");
			return writer;

		} catch (SQLException e) {
			System.out.println("Writer select catch");
			e.printStackTrace();
		} finally {
			DaoConnection.closeAll(preparedStmt, connection);
		}
		return null;
	}

}