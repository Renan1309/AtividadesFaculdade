import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import criptografiades.MontagemAES;

public class MaindoEncrypt {

	public static void main(String[] args) {
		// String Message="ola funcinar esse código
		// jbujbguebqgueuafuleigliufwlgfwulfelgfueiwbvuaibauuuuuuuvaeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeevnjdibsv
		// ";
		String Decrypted;
		String Encrypted;
		MontagemAES aes = new MontagemAES();
		aes.thekey = "agfdrtyhgfdvcgft";
		aes.iv = "afdgtrfesdergfbv";

		try {
			InputStream is = new FileInputStream("c:/arquivo1.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String linha = reader.readLine();

			aes.geraition();
			int p = 1;
			if (p == 1) {
				while (linha != null) {
					
				
					Encrypted = aes.encrypt(linha);
					System.out.println(Encrypted);
					Decrypted = aes.decrypt(Encrypted);
					System.out.println(Decrypted);
					linha = reader.readLine();
				}

				reader.close();
			}
			if (p == 2) {
				while (linha != null) {

					Decrypted = aes.decrypt(linha);
					System.out.println(Decrypted);
					linha = reader.readLine();
				}
				reader.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

}
