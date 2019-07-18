package dao;

import model.User;

public interface UserDao {
	
	boolean save (User user);
	
	void update (User user);
	
	void delete(Integer userId);
	
	Boolean isUser(User user);
	
	
	
}