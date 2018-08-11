package criptografiades;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DesCriptografia {
	public static void main(String[] argv) throws IOException, NoSuchAlgorithmException {

		File arq = new File("c:/teste.txt");
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		FileInputStream in = new FileInputStream(arq);
		int b;
		while((b = in.read())>-1){
		   out.write(b);
		}
		out.close();
		in.close();
		byte[] array = out.toByteArray();
		System.out.print(array);
		
		 MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
          byte messageDigest[] = algorithm.digest(out.toByteArray());
          
          System.out.println(messageDigest);
          StringBuilder hexString = new StringBuilder();
          for (byte b1 : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b1));
          }
          String senhahex = hexString.toString();
          
          System.out.println(senhahex);
}
}

	

