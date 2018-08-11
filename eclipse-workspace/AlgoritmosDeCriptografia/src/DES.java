import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DES {
	
		
		private SecretKey key ;
		public String thekey ;


		public DES() {
			
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
				
				byte[] stringBytes = message.getBytes("UTF8");
				
				byte[] raw = cipher.doFinal(stringBytes);
			
				
				
				BASE64Encoder encoder = new BASE64Encoder();
				String base64= encoder.encode(raw);
				
				return base64;
				}
			private String decrypt(String encrypted)throws Exception {
				Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
				cipher.init(Cipher.DECRYPT_MODE, key);
				
				BASE64Decoder decoder = new BASE64Decoder();
				byte[]raw = decoder.decodeBuffer(encrypted);
				
				byte[]stringBytes = cipher.doFinal(raw);
				
				String clear = new String(stringBytes,"UTF8");
				return clear;
			}
			
		public static void main(String[] args) {
			

			
				String Message="tem que funcionar ";
				String Decrypted;
				String Encrypted;
				DES des = new DES();
				des.thekey="hojeeamanha";
				//senha bras da erro
				try 
				{
					des.generateKey();
					System.out.println("clear message " + Message);
					Encrypted=des.encrypt(Message);
					Decrypted=des.decrypt(Encrypted);
					
					System.out.println("encrypted message:"+ Encrypted);
					System.out.println("decrypted message:"+ Decrypted);

					

			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}

		}

