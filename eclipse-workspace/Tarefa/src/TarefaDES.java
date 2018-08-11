import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TarefaDES {
	private SecretKey key ;
	public String thekey ;


	public TarefaDES() {
		
	}
		private void generateKey() throws Exception {
			DESKeySpec deskeySpec = new DESKeySpec(thekey.getBytes());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			key = keyFactory.generateSecret(deskeySpec);
			
		}
		
		private String encrypt(String message) throws Exception {
			
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
			//Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			 return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
			//byte[] stringBytes = message.getBytes("UTF8");
			
			//byte[] raw = cipher.doFinal(stringBytes);
		
			
			
			//BASE64Encoder encoder = new BASE64Encoder();
			//String base64= encoder.encode(raw);
			
			//return base64;
			}
		private String decrypt(String encrypted)throws Exception {
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, key);
			 return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
			//BASE64Decoder decoder = new BASE64Decoder();
			//byte[]raw = decoder.decodeBuffer(encrypted);
			
		//	byte[]stringBytes = cipher.doFinal(raw);
			
			//String clear = new String(stringBytes,"UTF8");
			//return clear;
		}
		
	public static void main(String[] args) {
		

		
			String Message="tem que funcionar ";
			String Decrypted;
			String Encrypted;
			TarefaDES des = new TarefaDES();
			des.thekey="hojeeamanha";
			//senha bras da erro
			try 
			{ 
				BufferedReader br = new BufferedReader(new FileReader("c:/Arquivo2.txt"));
				//des.generateKey();
				 long tempoInicial = System.currentTimeMillis();
				 while(br.ready()){
					 
					 /**Apos entra no while professor eu mudo as funções que eu quero 
					  * as que eu não quero que execulte eu comento 
					  * se eu quiser so a encriptar eu comento // no decriptar e na saida e assim por diante
					  * Para o decriptar funcionar eu deixo o método Encrypted descomentado , comento o system e deixo apenas os do Decrypt
					  */
					 des.generateKey();
			            String linha = br.readLine();
			            String message = new String();
					      message = linha;
			            
					     // System.out.println(message );
					     Encrypted = des.encrypt(message);
					      //System.out.println(Encrypted );
					   //Decrypted=des.decrypt(Encrypted);
					//System.out.println(Decrypted);
					     
					        
					      
			        }  
				 
				 long tempoFinal = System.currentTimeMillis();
			        System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
				 
				 br.close();
			}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

}
