package criptografiades;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MontagemAES {

	private IvParameterSpec ivParameterSpec;
	private SecretKeySpec secretKeySpec;
	private Cipher cipher;
	private SecretKey key ;
	public String thekey ;
	public String iv ;
	
	public MontagemAES(){
		//Este foi o primeiro que eu fiz
	}
	
	public void geraition() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
	    ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
	    secretKeySpec = new SecretKeySpec(thekey.getBytes("UTF-8"), "AES");
	    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	}
	
	
	
	public String encrypt(String message) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		 return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
	/**
		byte[] encrypted = cipher.doFinal(message.getBytes("UTF8"));
	    byte[] raw = cipher.doFinal(encrypted);
	    BASE64Encoder encoder = new BASE64Encoder();
		String base64= encoder.encode(raw);
		
		return base64;
		 **/
		
	}
	
	public String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		 return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
		
		/**
		BASE64Decoder decoder = new BASE64Decoder();
		byte[]raw = decoder.decodeBuffer(encrypted);
		byte[] decryptedBytes = cipher.doFinal(raw);
		String clear = new String(decryptedBytes,"UTF8");
		return clear;
		**/
	}


	public static void main(String[] args) {
		String Message=" ";
		String Decrypted;
		String Encrypted;
		MontagemAES aes = new MontagemAES();
		aes.thekey="1234a67890123abc";
		aes.iv ="afdgtrfesdergfbv";
		
		
		try 
		
		{ aes.geraition();
			//des.generateKey();
			System.out.println("clear message: " + Message);
			Encrypted=aes.encrypt(Message);
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(Encrypted.getBytes());
			  StringBuilder hexString = new StringBuilder();
               for (byte b : hash) {
                 hexString.append(String.format("%02X", 0xFF & b));
               }
               String senhahex = hexString.toString();
               
               //System.out.println(senhahex);
              // 55575BA81F4F1D02203A6C33D8A27D2C4325723BDA8B013B99DCAC5AED137F15
			Decrypted=aes.decrypt(Encrypted);
			
	
			System.out.println("encrypted message:"+ Encrypted);
			System.out.println("decrypted message:"+ Decrypted);
			System.out.println("hash message:"+ senhahex);
		

	}catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	
}
	}
}
