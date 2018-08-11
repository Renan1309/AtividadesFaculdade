import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import criptografiades.MontagemAES;

public class Testedoispravaler {

	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, IOException {
		
		String Decrypted;
		String Encrypted;
		MontagemAES aes = new MontagemAES();
		aes.thekey = "agfdrtyhgfdvcgft";
		aes.iv = "afdgtrfesdergfbv";

		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("c:/arquivo1.txt"));
	
		aes.geraition();
        while(br.ready()){
            String linha = br.readLine();
            //System.out.println(linha);
            String message = new String();
		      message = linha;
		      //aqui eu mudo a opção que desejo ou encriptar que é = 2 ou decriptar
		      int op=2;
		      if(op==2) {
		    	  System.out.println(linha);
		    	 // Encrypted = aes.encrypt(linha);
					//System.out.println(Encrypted);
		    		  						//aqui muda o deslocamento
		     
		     
		        
		      }else {
		    	  Decrypted = aes.decrypt(linha);
					System.out.println(Decrypted);
		    	  						
		      
 } 
        }
        	         br.close();

	}

}
