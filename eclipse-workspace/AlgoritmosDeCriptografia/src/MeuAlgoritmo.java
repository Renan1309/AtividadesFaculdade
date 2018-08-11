import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MeuAlgoritmo {public static void main(String[] args) throws IOException {
	File file = new File("c:/algoritmo.txt");
	BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
	String line = null;
	List<String> arrayDeLetras = new ArrayList<String>();
	while((line = bufferedReader.readLine()) != null) {
		line = line.trim();
		for (int i = 0; i < line.length(); i++) {
			arrayDeLetras.add(""+line.charAt(i));
		}
	}
	for (String string : arrayDeLetras) {
		System.out.println(string);
	}
}
	

}
