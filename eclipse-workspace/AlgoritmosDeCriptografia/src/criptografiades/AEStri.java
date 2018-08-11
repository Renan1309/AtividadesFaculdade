package criptografiades;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class AEStri {
	private static final String SECRET_KEY_1 = "ssdkF$HUy2A#D%kd";
	private static final String SECRET_KEY_2 = "weJiSEvR5yAC5ftB";

	private IvParameterSpec ivParameterSpec;
	private SecretKeySpec secretKeySpec;
	private Cipher cipher;
	private static String toBeEncrypt= "olá brasil";

	public AEStri() {
	
	}
	

	private void  AEStri() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
	    ivParameterSpec = new IvParameterSpec(SECRET_KEY_1.getBytes("UTF-8"));
	    secretKeySpec = new SecretKeySpec(SECRET_KEY_2.getBytes("UTF-8"), "AES");
	    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	}


	private String encrypt(String toBeEncrypt) throws NoSuchPaddingException, NoSuchAlgorithmException,
	        InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
	    cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
	    byte[] encrypted = cipher.doFinal(toBeEncrypt.getBytes("UTF8"));
	    
	    //byte[] stringBytes = message.getBytes("UTF8");
		
		byte[] raw = cipher.doFinal(encrypted);
	
		
		
		BASE64Encoder encoder = new BASE64Encoder();
		String base64= encoder.encode(raw);
		
		return base64;
	}
	public String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException {
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] decryptedBytes = cipher.doFinal(Base64.decodeBase64(encrypted));
		return new String(decryptedBytes);

	public static void main(String[] args) {
		String Encrypted;
		System.out.println(toBeEncrypt);
		System.out.println("clear message " + toBeEncrypt);
		
		AEStri aes = new AEStri();
		try {
			Encrypted=aes.encrypt(toBeEncrypt);
			System.out.println("encrypted message:"+ Encrypted);
			
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
		catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
