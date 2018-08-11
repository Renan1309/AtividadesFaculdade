package criptografiades;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UsandoHash {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, FileNotFoundException {
		
		
	                     
	                    try {
	                     InputStream is = new FileInputStream("c://teste.txt");
	                     InputStreamReader isr = new InputStreamReader(is);
	                     BufferedReader reader = new BufferedReader(isr);
	                     String linha = reader.readLine();
	         			while (linha != null) {
	         				System.out.println(linha);
	         				linha = reader.readLine();
	         				  MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
	 	                     byte messageDigest[] = algorithm.digest(linha.getBytes("UTF-8"));
	 	                     
	 	                     System.out.println(messageDigest);
	 	                     StringBuilder hexString = new StringBuilder();
	 	                     for (byte b : messageDigest) {
	 	                       hexString.append(String.format("%02X", 0xFF & b));
	 	                     }
	 	                     String senhahex = hexString.toString();
	 	                     
	 	                     System.out.println(senhahex);
	 	           }
	         		
	         				reader.close();
	         				} catch (IOException e) {
	         				System.out.println("Erro ao tentar ler o arquivo " + e);
	         				}
	                     
	                   
	           }
}

	


