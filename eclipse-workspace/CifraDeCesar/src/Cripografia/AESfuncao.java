package Cripografia;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class AESfuncao {
	private IvParameterSpec ivParameterSpec;
	private SecretKeySpec secretKeySpec;
	private Cipher cipher;
	private SecretKey key ;
	public String thekey ;
	public String iv = "afdgtrfesdergfbv" ;
	
	public AESfuncao(){
		//Este foi o primeiro que eu fiz
	}
	
	public void geraition(String thekey) throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
	    ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
	    secretKeySpec = new SecretKeySpec(thekey.getBytes("UTF-8"), "AES");
	    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	}
	
	
	
	public String encrypt(String message) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		 return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));

		
	}
	
	public String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, NoSuchPaddingException {
		
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		 return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
		
		
	}


}

