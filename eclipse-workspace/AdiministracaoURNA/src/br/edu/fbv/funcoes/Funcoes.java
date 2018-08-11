package br.edu.fbv.funcoes;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import br.edu.fbv.BancoDAO.CandidatoDAO;

import br.edu.fbv.BancoDAO.administradorDAO;
import br.edu.fbv.modelo.Administrador;
import br.edu.fbv.modelo.Candidato;
import br.edu.fbv.modelo.Mesario;

public class Funcoes {
	public static void main(String[] args) throws SQLException, IOException, NoSuchAlgorithmException {
	Mesario mesario = new Mesario();
	Candidato candidato = new Candidato();
	CandidatoDAO candidatoinse = new CandidatoDAO();
	Administrador administrador = new Administrador();
	administradorDAO administradorCHEF = new administradorDAO();
	
	
	OutputStream os = new FileOutputStream("c:/ok.txt",true);
	OutputStreamWriter osw = new OutputStreamWriter(os);
	BufferedWriter bw = new BufferedWriter(osw);
	Locale locale = new Locale("pt", "BR");
	GregorianCalendar calendar = new GregorianCalendar();
	//MesarioDAO mesarioinse = new MesarioDAO();
	int opção =8 ;

	if(opção==8) {
		//Método de autenticar o ADMINISTRADOR "AUDITOR"
		String cpf2;
		String senha;
		String existe;
		cpf2 = JOptionPane.showInputDialog("Digite seu CPF");
		senha = JOptionPane.showInputDialog("Digite sua senha");
		boolean resposta = administradorCHEF.login(cpf2, senha);
		
		
		if(resposta == true) {
			
			SimpleDateFormat formatador08= new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
			bw.newLine();
			bw.write("login de ADM "+formatador08.format(calendar.getTime()));
		
			
			//JOptionPane.showMessageDialog(null, "Autenticado !");
			int op = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção que voce deseja administrador !"+ "\n"+
			"1- cadastra candidatos"+ "\n"+"2- listar candidatos"+ "\n"+"3 para cadastra Mesario"+"\n"+"4-GERAR hash do log"+
					"\n"+"Fazer integridade do log"+"\n"+"0-Fechar Janela"));
			switch (op) {
			
			case 1:
			//	BufferedWriter bw = new BufferedWriter(new FileWriter("c:/EscritaUrna.txt", true));
			 JOptionPane.showMessageDialog(null, "Para inserir candidatos preencha ");
			 int numerodeeleicao = Integer.parseInt(JOptionPane.showInputDialog("Digie o numero a concorrer"));
				candidato.setNumerodeeleicao(numerodeeleicao);
				String nome = JOptionPane.showInputDialog("Digite o nome do candidado a concorrer");
				candidato.setNome(nome);
				String partido = JOptionPane.showInputDialog("Digite o partido que ele faz parte");
				candidato.setPartido(partido);
				int numerodevotos= 0;
				candidato.setNumerodevotos(numerodevotos);
				//String cpf = JOptionPane.showInputDialog("Digite seu cpf");
				//candidato.setCpf(cpf);
				candidatoinse.Adiciona(candidato);
				JOptionPane.showMessageDialog(null, "Candidato inserido-- "+nome);
				
				SimpleDateFormat formatador07= new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
				bw.newLine();
				bw.write("Colocar candidado a concorrer "+formatador07.format(calendar.getTime()));
			
				
			
			break;
			
			case 2:
				
				List<Candidato> candidatos = candidatoinse.getList();
				for (Candidato Candidato : candidatos) {
					System.out.println("Nome: " + Candidato.getNome());

					System.out.println("Título: " + Candidato.getPartido());
					System.out.println("Número de votos: " + Candidato.getNumerodevotos());
					
					
					
						
				}
				SimpleDateFormat formatador32 = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
				
				
				bw.newLine();
				bw.write("listar candidatos "+formatador32.format(calendar.getTime()));
			
				break;
				
			case 3:
				       JOptionPane.showMessageDialog(null, "Inserir Mesários ");
				 
						String cpf = JOptionPane.showInputDialog("cpf");
						mesario.setCpf(cpf);
						String nome1 = JOptionPane.showInputDialog("nome mesario");
						mesario.setNome(nome1);
						String Senha = JOptionPane.showInputDialog("senha");
						mesario.setSenha(Senha);
						administradorCHEF.AdicionaMesario(mesario);;
						//mesarioinse.Adiciona(mesario);
						JOptionPane.showMessageDialog(null, "Mesario inserido");
					
						SimpleDateFormat formatador321= new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
						//out.println("Inserir Mesario"+formatador321.format(calendar.getTime()));
						bw.newLine();
						bw.write("Adicao de mesario "+formatador321.format(calendar.getTime()));
						
					
				 break ;
			case 4:
				//hash
				JOptionPane.showMessageDialog(null, "Guarda HASH NO BANCO");
				byte [] data = Files.readAllBytes(Paths.get("c:/teste.txt"));
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				byte[] hashsalvo = md.digest(data);
				String codigo = JOptionPane.showInputDialog("Digite o seu CPF , Código para localizar o hash");
				administradorCHEF.receberhash(codigo,hashsalvo);
				JOptionPane.showMessageDialog(null, "Hash salvo");
			/**
				SimpleDateFormat formatador09= new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
				bw.newLine();
				bw.write("Gerar hash do log "+formatador09.format(calendar.getTime()));
				**/
				break;
				
			case 5:
				JOptionPane.showMessageDialog(null, "Comparar integriade do HASH");
				byte [] dados = Files.readAllBytes(Paths.get("c:/teste.txt"));
				
				 MessageDigest hs = MessageDigest.getInstance("SHA-256");
				 byte[] hashgerado = hs.digest(dados);
				 String id = JOptionPane.showInputDialog("Código para localizar e comparar o hash");
				
				 
				 byte [] resultadodobanco = administradorCHEF.hashdobanco(id);
				
				 
				 boolean comparacao = comparar(resultadodobanco,hashgerado);
				 JOptionPane.showMessageDialog(null, comparacao);

				/**
				 SimpleDateFormat formatador10= new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
					bw.newLine();
					bw.write("Comparar hash  "+formatador10.format(calendar.getTime()));
				**/
							
				break;
				
			case 0 :
				JOptionPane.showMessageDialog(null, "Fechar");
				SimpleDateFormat formatador12= new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
				bw.newLine();
				bw.write("Fechou Janela  "+formatador12.format(calendar.getTime()));
				}
							}else {
								JOptionPane.showMessageDialog(null, "Não Autenticado !");
								SimpleDateFormat formatador10= new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
								bw.newLine();
								bw.write("Acesso negado  "+formatador10.format(calendar.getTime()));
							
								
							}
						}
	
		
	bw.close();
	
	}
	public static boolean comparar (byte[] resultadobanco , byte[]hashgerado) {
		boolean resposta = true ;
		if (resultadobanco  != null && hashgerado != null) {
			
			if(resultadobanco.length == hashgerado.length) {
				for (int i = 0; i < hashgerado.length; i++) {
					for (int j = 0; j < resultadobanco.length; j++) {
						if(hashgerado[i]!=resultadobanco[i]){	
							resposta =  false;
							break;

						}
				}


				}
			}
		
		}
		return resposta;
	}
}

	

		
	
