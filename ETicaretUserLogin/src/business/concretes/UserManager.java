package business.concretes;

import java.util.List;

import business.abstracts.AuthService;
import business.abstracts.UserService;
import core.abstracts.SignUpService;
import data.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private AuthService authService;
	private SignUpService signUpService;
	public UserManager(UserDao userDao,AuthService authService,SignUpService signUpService) {
	
		this.userDao=userDao;
		this.authService=authService;
		this.signUpService=signUpService;
	}
	@Override
	public void Add(User user) {
	
		userDao.Add(user);
		
	}

	@Override
	public void Delete(User user) {
		userDao.Delete(user);
		
	}

	@Override
	public void Update(User user) {
	userDao.Update(user);
		
	}

	@Override
	public User GetUser(User user) {
	
		return userDao.GetUser(user.getId());
	}

	@Override
	public List<User> GetAllUser() {
	
		return userDao.GetAll();
	}

	@Override
	public void Signup(User user) {
	
		if (user.getPassword().length()<6 && user.getName().length()<2 && user.getLastName().length()<2) {
			
			System.out.println("Password cannot be less than 6 characters. and Name and surname cannot be less than 2 characters.");
			return;
		}
		if (authService.isMailBeforeValid(user.getMail())) {
			
			System.out.println("Email Address:"+user.getMail()+ " is already in use. Please enter another Email address.");
			return;
		}
		if (authService.isMailValid(user.getMail())) {
			System.out.println("mail gecerli degil");
			return;
			
		}
		userDao.Add(user);
		signUpService.SigupToSystem(user);
		System.out.println("user signed up successfully. Email send to"+user.getMail());
	}

	@Override
	public void Login(User user) {
		
	if (authService.isMailValid(user.getMail())) {
		System.out.println("user succesfully login!");
	}
	else {
		System.out.println("hatali giris");
	}
	
		
	}

}
