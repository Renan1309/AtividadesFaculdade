package criptografiades;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Encoder;

public class DESjuncao {
	private SecretKey key ;
	public String thekey ;
	
	public DESjuncao() {
		
	}
	private void generateKey() throws Exception {
		DESKeySpec deskeySpec = new DESKeySpec(thekey.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		key = keyFactory.generateSecret(deskeySpec);
		
	}
	private String encrypt(String message) throws Exception {
		Cipher desCipher;
		desCipher = Cipher.getInstance("DES");
		//Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		//Cipher.getInstance("DES/ECB/NoPadding");
		desCipher.init(Cipher.ENCRYPT_MODE, key);
		
		
		byte[] stringBytes = message.getBytes();
		byte[] raw = desCipher.doFinal(stringBytes);
	
		BASE64Encoder encoder = new BASE64Encoder();
		String base64= encoder.encode(raw);

		return base64;
		
		
	}
	public static void main(String[] args) {
		

		
		String Message="Código tem que funcionar  ";
		String Decrypted;
		String Encrypted;
		DESjuncao des = new DESjuncao();
		des.thekey="computador";
		
		try 
		{
			des.generateKey();
			System.out.println("clear message " + Message);
			Encrypted=des.encrypt(Message);
		
			
			System.out.println("encrypted message:"+ Encrypted);
			

	
}catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
}
}

}
