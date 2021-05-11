package business.abstracts;

public interface AuthService {

	boolean isMailValid(String mail);
	boolean isPasswordValid(String password);
	boolean isMailBeforeValid(String mailBefore);
}
