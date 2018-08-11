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

public class CriptografiaDES {
	private IvParameterSpec ivParameterSpec;
	private SecretKeySpec secretKeySpec;
	private Cipher cipher;
	private SecretKey key ;
	public String thekey ;
	public String iv ;
	
	public CriptografiaDES() {
		
	}
	
	private void geraition() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
	   // ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
	    secretKeySpec = new SecretKeySpec(thekey.getBytes("UTF-8"), "DES");
	    cipher = Cipher.getInstance("DES/CBC/PKCS5PADDING");
	}
	private String encrypt(String message) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		 return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
	
	}
	public String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException,
    BadPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, NoSuchPaddingException {
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		 return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
		}
	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, IOException {
		String Message="Tem que funcinar esse algoritmo ";
		String Decrypted;
		String Encrypted;
		CriptografiaDES des = new CriptografiaDES();
		des.thekey="agfdrtyhgfdvcgft";
		//des.iv ="afdgtrfesdergfbv";
		
		try {
		
		
		
     
        
			des.geraition();
			//des.generateKey();
			System.out.println("clear message: " + Message);
			Encrypted=des.encrypt(Message);
			Decrypted=des.decrypt(Encrypted);
			
			System.out.println("encrypted message:"+ Encrypted);
			System.out.println("decrypted message:"+ Decrypted);
	
	}catch(Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	
}
	}
}

