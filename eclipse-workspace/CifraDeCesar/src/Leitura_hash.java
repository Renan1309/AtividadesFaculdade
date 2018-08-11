import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Leitura_hash {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		  try {
			  File f = new File ("c:/teste.txt");
			  InputStream is = new FileInputStream("c:/teste.txt");
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader reader = new BufferedReader(isr);
				String linha = reader.readLine();
				//int tamanho = (int) f.length();
				//String gerasha[]= new String[tamanho];
				//byte[] buffer = new byte[8192];  
				
				byte [] data = Files.readAllBytes(Paths.get("c:/teste.txt"));
				//System.out.println(array);
				System.out.println(data);
				 MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		          byte messageDigest[] = algorithm.digest(data);
		          
		          //System.out.println(messageDigest);
		          StringBuilder hexString = new StringBuilder();
		          for (byte b1 : messageDigest) {
		            hexString.append(String.format("%02X", 0xFF & b1));
		          }
		          String senhahex = hexString.toString();
		          System.out.println(senhahex);
				/**
				while (linha != null) {
					
					
					

					System.out.println(linha);
					
					linha = reader.readLine();
					
					}
					reader.close();
				**/
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
