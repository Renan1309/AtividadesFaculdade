import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;




	public class MontagemAES {

		private IvParameterSpec ivParameterSpec;
		private SecretKeySpec secretKeySpec;
		private Cipher cipher;
		private SecretKey key ;
		public String thekey ;
		public String iv ;
		
		public MontagemAES(){
			//Este foi o primeiro que eu fiz
		}
		
		private void geraition() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
		    ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
		    secretKeySpec = new SecretKeySpec(thekey.getBytes("UTF-8"), "AES");
		    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		}
		
		public IvParameterSpec getIvParameterSpec() {
			return ivParameterSpec;
		}

		public void setIvParameterSpec(IvParameterSpec ivParameterSpec) {
			this.ivParameterSpec = ivParameterSpec;
		}

		public SecretKeySpec getSecretKeySpec() {
			return secretKeySpec;
		}

		public void setSecretKeySpec(SecretKeySpec secretKeySpec) {
			this.secretKeySpec = secretKeySpec;
		}

		public Cipher getCipher() {
			return cipher;
		}

		public void setCipher(Cipher cipher) {
			this.cipher = cipher;
		}

		public SecretKey getKey() {
			return key;
		}

		public void setKey(SecretKey key) {
			this.key = key;
		}

		private String encrypt(String message) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
			 return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
		/**
			byte[] encrypted = cipher.doFinal(message.getBytes("UTF8"));
		    byte[] raw = cipher.doFinal(encrypted);
		    BASE64Encoder encoder = new BASE64Encoder();
			String base64= encoder.encode(raw);
			
			return base64;
			 **/
			
		}
		
		public String decrypt(String encrypted) throws InvalidAlgorithmParameterException, InvalidKeyException,
	    BadPaddingException, IllegalBlockSizeException, IOException, NoSuchAlgorithmException, NoSuchPaddingException {
			
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
			 return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));
			
			/**
			BASE64Decoder decoder = new BASE64Decoder();
			byte[]raw = decoder.decodeBuffer(encrypted);
			byte[] decryptedBytes = cipher.doFinal(raw);
			String clear = new String(decryptedBytes,"UTF8");
			return clear;
			**/
		}


		public static void main(String[] args) {
			String Message="Tem que funcinar esse código jbujbguebqgueuafuleigliufwlgfwulfelgfueiwbvuaibauuuuuuuvaeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeevnjdibsv ";
			String Decrypted;
			String Encrypted;
			MontagemAES aes = new MontagemAES();
			aes.thekey="agfdrtyhgfdvcgft";
			aes.iv ="afdgtrfesdergfbv";
			
			try 
			
			{ aes.geraition();
				//des.generateKey();
				System.out.println("clear message: " + Message);
				Encrypted=aes.encrypt(Message);
				Decrypted=aes.decrypt(Encrypted);
				
				System.out.println("encrypted message:"+ Encrypted);
				System.out.println("decrypted message:"+ Decrypted);
			

		}catch(Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
	}
		}
	}

