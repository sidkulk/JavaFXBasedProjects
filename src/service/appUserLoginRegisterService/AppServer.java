package service.appUserLoginRegisterService;

import model.User;

public interface AppServer {
	public boolean verifyUserLogin(String username, String passwordEntered);

	public boolean registerNewUser(User user);
}
