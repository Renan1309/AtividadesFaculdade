import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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





public class TarefaAES {

	private IvParameterSpec ivParameterSpec;
	private SecretKeySpec secretKeySpec;
	private Cipher cipher;
	private SecretKey key;
	public String thekey;
	public String iv;

	public TarefaAES() {
	}

	public void geraition() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {
		ivParameterSpec = new IvParameterSpec(iv.getBytes("UTF-8"));
		secretKeySpec = new SecretKeySpec(thekey.getBytes("UTF-8"), "AES");
		cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	}

	public String encrypt(String message) throws InvalidKeyException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes("UTF-8")));
		/**
		 * byte[] encrypted = cipher.doFinal(message.getBytes("UTF8")); byte[] raw =
		 * cipher.doFinal(encrypted); BASE64Encoder encoder = new BASE64Encoder();
		 * String base64= encoder.encode(raw);
		 * 
		 * return base64;
		 **/

	}

	public String decrypt(String encrypted)
			throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException, IOException, NoSuchAlgorithmException, NoSuchPaddingException {

		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		return new String(cipher.doFinal(Base64.getDecoder().decode(encrypted)));

		/**
		 * BASE64Decoder decoder = new BASE64Decoder(); byte[]raw =
		 * decoder.decodeBuffer(encrypted); byte[] decryptedBytes = cipher.doFinal(raw);
		 * String clear = new String(decryptedBytes,"UTF8"); return clear;
		 **/
	}

	public static void main(String[] args) {
		String Decrypted;
		String Encrypted;
		TarefaAES aes = new TarefaAES();
		aes.thekey = "agfdrtyhgfdvcgft";
		aes.iv = "afdgtrfesdergfbv";

		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("c:/Arquivo1.txt"));
			// BufferedReader br = new BufferedReader(new FileReader("c:/Earquivo2.txt"));
			aes.geraition();
			long tempoInicial = System.currentTimeMillis();
			while (br.ready()) {
				/**
				 * Apos entra no while professor eu mudo as funções que eu quero as que eu não
				 * quero que execulte eu comento se eu quiser so a encriptar eu comento // no
				 * decriptar e na saida e assim por diante Para o decriptar funcionar eu deixo o
				 * método Encrypted descomentado , comento o system e deixo apenas os do Decrypt
				 */

				String linha = br.readLine();

				String message = new String();
				message = linha;
				// System.out.println(message );
				Encrypted = aes.encrypt(message);
				System.out.println(Encrypted);
				// Decrypted = aes.decrypt(Encrypted);
				// System.out.println(Decrypted);

			}
			long tempoFinal = System.currentTimeMillis();
			System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
			br.close();

		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}
}
