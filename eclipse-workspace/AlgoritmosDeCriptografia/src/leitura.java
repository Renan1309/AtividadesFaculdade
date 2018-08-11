import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import criptografiades.MontagemAES;

public class leitura {

	public static void main(String[] args) throws IOException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException {
		try {
			String Decrypted;
			String Encrypted;
			MontagemAES aes = new MontagemAES();
			aes.thekey = "agfdrtyhgfdvcgft";
			aes.iv = "afdgtrfesdergfbv";
			InputStream is = new FileInputStream("c:/teste.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String linha = reader.readLine();
				aes.geraition();
			while (linha != null) {
				//System.out.println(linha);
				Encrypted = aes.encrypt(linha);
				System.out.println(Encrypted);
				
				linha = reader.readLine();
				}
				reader.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
