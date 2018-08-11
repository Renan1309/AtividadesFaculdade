import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;



public class leitura2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc;
		MontagemAES aes = new MontagemAES();
		String Encrypted;
		try {
			sc = new Scanner(new File("c:/arquivo1.txt"));
			while (sc.hasNextLine()) {
				String ww = sc.nextLine();
				String message = new String();
			     
				message = ww;
				
				Encrypted=aes.encrypt(message);
				
				
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}
}