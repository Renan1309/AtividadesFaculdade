import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class MontagemAES {
	private IvParameterSpec ivParameterSpec;
	private SecretKeySpec secretKeySpec;
	private Cipher cipher;
	private SecretKey key ;
	public String thekey ;
	public String iv ;
	private static BufferedReader br;
	
	public MontagemAES(){
		//Este foi o segundo que eu fiz
	}
	
	private void geraition() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
	    ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
	    secretKeySpec = new SecretKeySpec(thekey.getBytes("UTF-8"), "AES");
	    cipher = Cipher.getInstance("AES/EBC/PKCS5PADDING");
	}
	
	private String encrypt(String message) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		 return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
	
	}
	
	public String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, NoSuchPaddingException {
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		 return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
		}


	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, IOException {
		String Message="Tem que funcinar esse algoritmo ";
		String Decrypted;
		String Encrypted;
		MontagemAES aes = new MontagemAES();
		aes.thekey="agfdrtyhgfdvcgft";
		aes.iv ="afdgtrfesdergfbv";
		
		try {
		
		
		
     
        
			aes.geraition();
			//des.generateKey();
			System.out.println("clear message: " + Message);
			Encrypted=aes.encrypt(Message);
			Decrypted=aes.decrypt(Encrypted);
			
			System.out.println("encrypted message:"+ Encrypted);
			System.out.println("decrypted message:"+ Decrypted);
	
	}catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	
}
	}
}


