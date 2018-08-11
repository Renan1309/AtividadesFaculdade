import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CifraDecesar {
	 public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	 public static void main(String[] args) throws IOException{
		 long start = System.currentTimeMillis();
		 
	        BufferedReader br = new BufferedReader(new FileReader("c:/arquivo1.txt"));
	        
	        while(br.ready()){
	            String linha = br.readLine();
	            //System.out.println(linha);
	            String message = new String();
			      message = linha;
			      //aqui eu mudo a opção que desejo ou encriptar que é = 2 ou decriptar
			      int op=0;
			      if(op==2) {
			    		  						//aqui muda o deslocamento
			      System.out.println(encrypt(message, 21));
			     
			        
			      }else {
			    	  							//aqui a mudo o deslocamento
			       System.out.println(decrypt(encrypt(message, 21), 21));
			       //long time2 = System.currentTimeMillis();
			      
	 } 
	        }long elapsed = System.currentTimeMillis() - start;
	       //System.out.println("O tempo: "+elapsed);
	        	         br.close();
	          
	 }
	
	     
	 
	 
	 
	 
	 
	 
	 
	 public static String encrypt(String plainText, int shiftKey)
	    {
	    	
	        plainText = plainText.toLowerCase();
	        String cipherText = "";
	        for (int i = 0; i < plainText.length(); i++)
	        {
	            int charPosition = ALPHABET.indexOf(plainText.charAt(i));
	            int keyVal = (shiftKey + charPosition) % 26;
	            char replaceVal = ALPHABET.charAt(keyVal);
	            cipherText += replaceVal;
	        }
	        return cipherText;
	    }
	    public static String decrypt(String cipherText, int shiftKey)
	    {
	        cipherText = cipherText.toLowerCase();
	        String plainText = "";
	        for (int i = 0; i < cipherText.length(); i++)
	        {
	            int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
	            int keyVal = (charPosition - shiftKey) % 26;
	            if (keyVal < 0)
	            {
	                keyVal = ALPHABET.length() + keyVal;
	            }
	            char replaceVal = ALPHABET.charAt(keyVal);
	            plainText += replaceVal;
	        }
	        return plainText;
	    }
}



