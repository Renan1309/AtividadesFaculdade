package br.edu.fbv.funcoes;
import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.fbv.BancoDAO.administradorDAO;


public class hashdotexto {
	  public static void main(String[] args) throws IOException, NoSuchAlgorithmException, SQLException {
		
		  administradorDAO addao =new administradorDAO() ;
		  
		byte [] data = Files.readAllBytes(Paths.get("c:/teste.txt"));
		
		 MessageDigest md = MessageDigest.getInstance("SHA-256");
		 byte[] hashsalvo = md.digest(data);
		 
		
		 
		// addao.receberhash(hashgerado);
		// byte [] dados2 = Files.readAllBytes(Paths.get("c:/teste.txt"));
			
		 MessageDigest ss = MessageDigest.getInstance("SHA-256");
		 byte[] hashgerado = ss.digest(data);
		 
		 System.out.println(hashgerado);
		 int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código para localizar o hash"));
		 
		 addao.receberhash(codigo,hashgerado);
		byte [] resultadodobanco = addao.hashdobanco(codigo);
		
		 System.out.println(resultadodobanco);
		boolean comparacao = comparar(resultadodobanco,hashgerado );
		
		System.out.println(comparacao);
		 
	}
	  
	 
	
public static boolean comparar (byte[] resultadobanco , byte[]hashgerado) {
	boolean resposta = true ;
	if (resultadobanco  != null && hashgerado != null) {
		for (int i = 0; i < hashgerado.length; i++) {
			for (int j = 0; j < hashgerado.length; j++) {
				if(resultadobanco[i]!=hashgerado[i]){	
					return false;
			}
			
		}
				
				
			}
		}
	
	return resposta;

	
}

}

