package Cripografia;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

public class Aesjava {
	public static void main(String[] args) throws Exception {
		Aesjava aes = new Aesjava() ;
		  //String chaveencriptacao = "acdef88888888888";
	    String teste = "hoje vai ter festa";
	     byte[] result =Aesjava.encrypt(teste, chaveencriptacao);
	     
	     String pdf = new String(result);
	     JOptionPane.showMessageDialog(null, pdf);
	     String codigo = new BASE64Encoder().encode(cipher);
		
	}
		
	static String IV= "abcdefghijk";
	private static String chaveencriptacao = "acdef88888888888";
	
	public static String getKeyencript() {
		
		return chaveencriptacao;
	}
	public static byte[] encrypt(String textopuro, String chaveencriptacao) throws Exception {
        Cipher encripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
        SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
        encripta.init(Cipher.ENCRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
        return encripta.doFinal(textopuro.getBytes("UTF-8"));
	}
        
        public static String decrypt(byte[] textoencriptado, String chaveencriptacao) throws Exception{
            Cipher decripta = Cipher.getInstance("AES/CBC/PKCS5Padding", "SunJCE");
            SecretKeySpec key = new SecretKeySpec(chaveencriptacao.getBytes("UTF-8"), "AES");
            decripta.init(Cipher.DECRYPT_MODE, key,new IvParameterSpec(IV.getBytes("UTF-8")));
            return new String(decripta.doFinal(textoencriptado),"UTF-8");
      }
	}
