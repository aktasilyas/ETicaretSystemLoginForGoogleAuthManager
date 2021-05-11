package business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.AuthService;
import data.abstracts.UserDao;

public class AuthManager implements AuthService {
	
	private UserDao userDao;
	public AuthManager(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public boolean isMailValid(String mail) {
		
		String regex="^(.+)@(.+)$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(mail);
		return matcher.find();
	}

	@Override
	public boolean isPasswordValid(String password) {
	
		for(String pass:userDao.GetAllPassword()) {
			if (pass==password) {
				return true;
				
			}
		}
		return false;
	}

	@Override
	public boolean isMailBeforeValid(String mailBefore) {
		
		for(String mail:userDao.GetAllEmails()) {
			if (mail==mailBefore) {
				return true;
				
			}
		}
		return false;
	}

}
