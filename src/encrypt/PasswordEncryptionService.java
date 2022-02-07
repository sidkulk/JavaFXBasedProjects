package encrypt;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class PasswordEncryptionService implements PasswordEncryptServer {

	private static final String ALGO = "AES";
	private byte[] keyValue;
	private static String secretKey = "thracbL&qaml12Xc";
	
	public PasswordEncryptionService() {
		keyValue = secretKey.getBytes();
	}

	@Override
	public String encrypt(String data) {
		try {
			Key key = generateKey();
			Cipher cipher = Cipher.getInstance(ALGO);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = cipher.doFinal(data.getBytes());
			return new String(Base64.encodeBase64(encVal));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String decrypt(String encryptedData) {
		try {
			Key key = generateKey();
			Cipher cipher = Cipher.getInstance(ALGO);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodedValue = Base64.decodeBase64(encryptedData);
			byte[] decValue = cipher.doFinal(decodedValue);
			return new String(decValue);
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Key generateKey() {
		Key key = new SecretKeySpec(keyValue, ALGO);
		return key;
	}
}
