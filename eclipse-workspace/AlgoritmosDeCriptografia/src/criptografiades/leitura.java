package criptografiades;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class leitura {


	public static void main(String[] args)  {
	
		try {
			Scanner sc = new Scanner(new File("teste.txt"));
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
	}


	



