package criptografiades;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class testedeverificacaoleitura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			InputStream is = new FileInputStream("c://teste.txt");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			String linha = reader.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = reader.readLine();
				}
				reader.close();
				} catch (IOException e) {
				System.out.println("Erro ao tentar ler o arquivo " + e);
				}
			
	}

}
