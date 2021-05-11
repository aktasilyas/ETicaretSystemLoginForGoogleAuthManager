package core.concretes;

import core.abstracts.SignUpService;
import entities.concretes.User;
import googleAuthService.GoogleAuthManager;

public class GoogleAuthServiceAdapter implements SignUpService {

	@Override
	public void SigupToSystem(User user) {
		GoogleAuthManager manager=new GoogleAuthManager();
		manager.SignUp(user);
	}

}
