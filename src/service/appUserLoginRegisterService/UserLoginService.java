package service.appUserLoginRegisterService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import service.dbInit.DatabaseSchemaServer;
import service.dbInit.DatabaseService;
import service.hashing.HashingServer;
import service.hashing.HashingServiceClass;

public class UserLoginService implements AppServer {
	private static PreparedStatement pstmt;
	private static ResultSet resultSet;

	private HashingServer hashService = new HashingServiceClass();

	@Override
	public boolean verifyUserLogin(String username, String passwordEntered) {
		String query = "SELECT passwordhash FROM " + DatabaseSchemaServer.USER_TAB_NAME + " WHERE username = ?";

		try {
			boolean isCorrect = false;
			pstmt = DatabaseService.getConnection().prepareStatement(query);
			pstmt.setString(1, username);
			resultSet = pstmt.executeQuery();
			
			String returnedHash = resultSet.getString(1);
			
			if(returnedHash == null) {
				throw new IllegalStateException("User with username: " + username + " does not exists!");
			} else {
				isCorrect = hashService.verifyPassword(passwordEntered, returnedHash);
			}
			
			return isCorrect;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean registerNewUser(User user) {
		String query = "INSERT INTO " + DatabaseSchemaServer.USER_TAB_NAME
				+ "(username, email, passwordhash, nickname, schoolname) VALUES(?, ?, ?, ?, ?)";

		try {
			pstmt = DatabaseService.getConnection().prepareStatement(query);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, hashService.generateStringPasswordHash(user.getPassword())); // passwordHash store
			pstmt.setString(4, user.getNickname());
			pstmt.setString(5, user.getChildhoodSchoolName());
			int rowUpdateCount = pstmt.executeUpdate();
			if (rowUpdateCount > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
