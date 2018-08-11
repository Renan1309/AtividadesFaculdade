package criptografiades;

import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;




public class EncriptaDecriptaAES {
	private static String chaveSimetrica;
	private static String mensagem;
	private static SecretKey key;
	private static byte[] mensagemEncriptada;
	private static byte[] mensagemDescriptada;
	private static Scanner sc = new Scanner(System.in);
 
	public static void main(String args[]) {
/**
 * Solicita ao usuário que informe uma chave com caracteres:
 * (256 / 8 = 32) 32 caracteres = 256 bits
 * (192 / 8 = 192) 24 caracteres = 192 bits
 * (128 / 8 = 128) 16 caracteres = 128 bits
 */
System.out.println("32 caracteres = chave com 256 bits"+ "\n24 caracteres = chave com 192 bits"+ "16 caracteres = chave com 128 bits"+ "\n Infomre uma Chave: ");
chaveSimetrica = sc.nextLine();
key = new SecretKeySpec(chaveSimetrica.getBytes(), "AES");
 
try {
	Cipher cipher = Cipher.getInstance("AES");
 
	cipher.init(Cipher.ENCRYPT_MODE, key);	 	 
		 	 
	String mensagem = "ola brasil tudo bom meu povo"; 	 
	byte[] stringBytes = mensagem.getBytes("UTF8");
	
	
	byte[] raw = cipher.doFinal(stringBytes);
	
	BASE64Encoder encoder = new BASE64Encoder();
	String base64= encoder.encode(raw);
		 	 
	 	 
	System.out.println("Mensagem Encriptada: "	 	 
		+ raw.);	 	 
	
} catch (Exception e) {
	e.printStackTrace();
}	 	 
}
 

}
