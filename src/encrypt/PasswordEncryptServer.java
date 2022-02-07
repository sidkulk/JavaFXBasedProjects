package encrypt;

public interface PasswordEncryptServer {
	public String encrypt(String data);
	
	public String decrypt(String encryptedData);
}
