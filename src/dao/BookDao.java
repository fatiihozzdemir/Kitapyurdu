package dao;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;

import model.Book;

public interface BookDao {
	
	
	void saveBook (Book book);

	void update(Book book);

	void delete(Integer bookId);
	
	Book getBook(Integer bookId);
		
	List<Book> getBookList() throws ServletException;
	
	Date getInsertDate(Integer bookId);

}