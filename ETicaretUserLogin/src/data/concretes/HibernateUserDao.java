package data.concretes;

import java.util.ArrayList;
import java.util.List;

import data.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {

	List<User> users;
	public HibernateUserDao() {
		users=new ArrayList<User>();
	}
	@Override
	public void Add(User user) {
		
		users.add(user);
		System.out.println("user Eklendi");
		
	}

	@Override
	public void Delete(User user) {
		User deleteUser=users.stream().filter(u->u.getId()==user.getId()).findFirst().get();
		users.remove(deleteUser);
		System.out.println("user deleted:"+user.getName());
		
	}

	@Override
	public void Update(User user) {
		
		User updateUser=users.stream().filter(u->u.getId()==user.getId()).findFirst().get();
		updateUser.setId(user.getId());
		updateUser.setName(user.getName());
		updateUser.setLastName(user.getLastName());
		updateUser.setMail(user.getMail());
		updateUser.setPassword(user.getPassword());
		users.remove(user);
		users.add(updateUser);
		
		
	}

	@Override
	public User GetUser(int id) {
	
		User user=users.stream().filter(u->u.getId()==id).findFirst().get();
		return user;
	}

	@Override
	public List<User> GetAll() {
		return users;
	}

	@Override
	public List<String> GetAllEmails() {
		List<String> mailsList=new ArrayList<String>();
		for(User user:users) {
			mailsList.add(user.getMail());
		}
		return mailsList;
	}

	@Override
	public List<String> GetAllPassword() {
		List<String> passList=new ArrayList<String>();
		for(User user:users) {
			passList.add(user.getPassword());
		}
		return passList;
	}

}
