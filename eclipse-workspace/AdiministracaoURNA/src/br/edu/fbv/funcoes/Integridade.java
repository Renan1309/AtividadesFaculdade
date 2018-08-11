package br.edu.fbv.funcoes;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.swing.JOptionPane;

import br.edu.fbv.BancoDAO.CandidatoDAO;
import br.edu.fbv.BancoDAO.administradorDAO;
import br.edu.fbv.modelo.Administrador;
import br.edu.fbv.modelo.Candidato;
import br.edu.fbv.modelo.Mesario;

public class Integridade {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, SQLException {
		Mesario mesario = new Mesario();
		Candidato candidato = new Candidato();
		CandidatoDAO candidatoinse = new CandidatoDAO();
		Administrador administrador = new Administrador();
		administradorDAO administradorCHEF = new administradorDAO();
		// TODO Auto-generated method stub
	
		
		
		
		JOptionPane.showMessageDialog(null, "Comparar integriade do HASH");
		
		byte [] dados = Files.readAllBytes(Paths.get("c:/teste.txt"));
		
		 MessageDigest hs = MessageDigest.getInstance("SHA-256");
		 
		 byte[] hashgerado = hs.digest(dados);
		 String codigo = JOptionPane.showInputDialog("Cpf do ADM para identificar");
		 administradorCHEF.receberhash(codigo,hashgerado);
		
		
		 String id = JOptionPane.showInputDialog("Cpf do Mesario para localizar   hash");
		 
		 byte [] resultadodobanco = administradorCHEF.hashdobanco(id);
		 byte[] num = administradorCHEF.hashdobanco(codigo);
		 boolean comparacao = comparar(resultadodobanco,num);
		 
		 JOptionPane.showMessageDialog(null, comparacao);
		

	}
	public static boolean comparar (byte[] resultadobanco , byte[]hashgerado) {
		boolean resposta = true ;
		if (resultadobanco  != null && hashgerado != null) {
		
			if(resultadobanco.length == hashgerado.length) {
				 for (int i = 0; i < resultadobanco.length; i++) {
						if (resultadobanco [i] != hashgerado[i]) {
							resposta = false ;
							break;
			}
			}
			}
				
				
				/**
				 for (int i = 0; i < resultadobanco.length; i++) {
					if (resultadobanco [i] != hashgerado[i]) {
						resposta = false ;
						break;
			
			for (int i = 0; i < hashgerado.length; i++) {
				
				
				for (int j = 0; j < resultadobanco.length; j++) {
					if(hashgerado[i]!=resultadobanco[i]){	
						resposta =  false;
				
				}


				}
			}
			
			for (int i = 0; i < hashgerado.length; i++) {
				for (int j = 0; j < resultadobanco.length; j++) {
					if(hashgerado[i]!=resultadobanco[i]){	
						resposta =  false;
						break;
					}
				}
		
				
				
			}
			**/
		
		else {
			resposta = false ;
		}
	}
	else {
		resposta = false ;
	}

		return resposta;
	}
}
