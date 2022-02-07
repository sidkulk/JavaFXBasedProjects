package service.hashing;

public interface HashingServer {
	public String generateStringPasswordHash(String password);

	public boolean verifyPassword(String passworedEntered, String hashedPassword);

}
