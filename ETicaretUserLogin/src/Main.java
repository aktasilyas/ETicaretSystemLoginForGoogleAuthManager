import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.UserManager;
import core.concretes.GoogleAuthServiceAdapter;
import data.concretes.HibernateUserDao;
import entities.concretes.User;



public class Main {

	public static void main(String[] args) {
	
		
		UserService userService=new UserManager(new HibernateUserDao(), new AuthManager(new HibernateUserDao()), new GoogleAuthServiceAdapter());
	
		User user=new User(1, "ilyas", "aktas", "aktasilyas875@gmail.com", "1234567");
		User user2=new User(1, "ahmet", "tas", "afdfdfgmail", "342");
		userService.Add(user);
		userService.Add(user2);
		for (User userservice : userService.GetAllUser()) {
			
			System.out.println(userservice.getName());
		}
		
		userService.Signup(user2);
		userService.Login(user);
	}

}
