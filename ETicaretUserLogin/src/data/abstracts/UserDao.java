package data.abstracts;


import java.util.List;

import entities.concretes.User;

public interface UserDao {

	void Add(User user);
	void Delete(User user);
	void Update(User user);
	User GetUser(int id);
	List<User> GetAll();
	
	List<String> GetAllEmails();
	List<String> GetAllPassword();
}
