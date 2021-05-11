package business.abstracts;


import java.util.List;

import entities.concretes.User;

public interface UserService {

	void Add(User user);
	void Delete(User user);
	void Update(User user);
	User GetUser(User user);
	List<User>GetAllUser();
	
	void Signup(User user);
	void Login(User user);
}
