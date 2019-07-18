package dao;

import java.util.List;

import javax.servlet.ServletException;

import model.Writer;

public interface WriterDao {

	boolean save(Writer writer);

	void update(Writer writer);

	void delete(Integer writerId);

	List<Writer> getWriterList() throws ServletException;
	
	String getWriterName(Integer writerId);

	Writer getWriter(Integer writerId);

}