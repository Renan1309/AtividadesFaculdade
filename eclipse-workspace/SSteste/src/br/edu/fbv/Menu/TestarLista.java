package br.edu.fbv.Menu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

import br.edu.fbv.BancoDAO.CandidatoDAO;
import br.edu.fbv.BancoDAO.InserirDAO;
import br.edu.fbv.BancoDAO.MesarioDAO;
import br.edu.fbv.BancoDAO.administradorDAO;
import br.edu.fbv.funcoes.AESfuncao;
import br.edu.fbv.function.Funcionalidades;
import br.edu.fbv.modelo.Administrador;
import br.edu.fbv.modelo.Boletim;
import br.edu.fbv.modelo.Candidato;
import br.edu.fbv.modelo.Eleitor;
import br.edu.fbv.modelo.Encriptado;

public class TestarLista {

	public static void main(String[] args) throws IOException, SQLException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		
		Eleitor eleitor = new Eleitor();
		Candidato candidato = new Candidato();
		Administrador administrador = new Administrador();
		InserirDAO inserirdao = new InserirDAO();
		CandidatoDAO candidatoinse = new CandidatoDAO();
		administradorDAO administradorCHEF = new administradorDAO();
		MesarioDAO mesariodao = new MesarioDAO();
		Funcionalidades funcionalidades = new Funcionalidades();
		AESfuncao aes = new AESfuncao();
		Boletim votosurna = new Boletim();
		Encriptado encriptado = new Encriptado();
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("c:/EscritaUrna.txt", true));
		Locale locale = new Locale("pt","BR");
        GregorianCalendar calendar = new GregorianCalendar(); 
        
        String cpf2;
		String senha;
		String existe;
		cpf2 = JOptionPane.showInputDialog("Digite seu CPF");
		senha = JOptionPane.showInputDialog("Digite sua senha");
		boolean resposta = mesariodao.loginMesario(cpf2, senha);
		
		if (resposta == true) {
		
	 int  codigo;
		codigo  = Integer.parseInt(JOptionPane.showInputDialog("Inicialização da urna senha!"));
		 
		if (codigo ==200) {
			while(codigo == 200 ) {
				 
				String titulo ;
				titulo = JOptionPane.showInputDialog("digite seu titulo");
				String encerramento = "1111"  ;
				if(titulo.equals(encerramento)) {
					
					codigo = 800;
					
					JOptionPane.showMessageDialog(null, "votação encerrada no código ");
				}else if(titulo.equals(titulo)) {
					
					boolean avalia = inserirdao.confirmarTitulo(titulo);
					if (avalia == true) {
						JOptionPane.showMessageDialog(null, "Titulo Aprovado =)");
						int numerodeeleicao;
						int numerodeputado;
						
						numerodeeleicao = Integer.parseInt(JOptionPane.showInputDialog("Digite  número do seu  Presidente"));
						funcionalidades.buscacandidato(numerodeeleicao);
						numerodeputado = Integer.parseInt(JOptionPane.showInputDialog("Digite  número do seu  Presidente"));
						funcionalidades.buscacandidato(numerodeputado);

						int confir = JOptionPane.showConfirmDialog(null,
								"Seu candidato esta correto" + JOptionPane.YES_NO_OPTION);
						if (confir == 0) {
							String senhaAES = JOptionPane.showInputDialog("Digete uma senha de 16 Dígitos");
							JOptionPane.showMessageDialog(null, "voto computado =)");
							bw.newLine();
							bw.write("Voto Computado Dia");
							bw.newLine();
							 SimpleDateFormat formatador2 = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
							bw.write(formatador2.format(calendar.getTime()));
							
							candidatoinse.InserirVoto(numerodeeleicao);
							String numeroDoVoto = String.valueOf(numerodeeleicao);
							inserirdao.computarvotoparaoauditor(titulo, numeroDoVoto,senhaAES);
							aes.geraition(senhaAES);
							String tencript =aes.encrypt(titulo);
							encriptado.setTituloEncrypted(tencript);
							String vencript = aes.encrypt(numeroDoVoto);
							encriptado.setVotoEncrypted(vencript);
							String hasht=aes.gerarhash(tencript);
							encriptado.setHashTitulo(hasht);
							String hashv =aes.gerarhash(vencript);
							encriptado.setHashVoto(hashv);
							
							inserirdao.AdicionaEncriptados(encriptado);
							//JOptionPane.showMessageDialog(null,tencript+"*--*"+vencript+"*HASH-->"+hasht);
							
							
							
						} else {
							JOptionPane.showMessageDialog(null, "recomece a votação");
							bw.newLine();
							bw.write("Erro candidato não encontrado");
							bw.newLine();
							 SimpleDateFormat formatador32 = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
							bw.write(formatador32.format(calendar.getTime()));
							

						}

					} else {
						JOptionPane.showMessageDialog(null, "Titulo não encontrado");
						bw.newLine();
						bw.write("Título não autenticado");
						bw.newLine();
						 SimpleDateFormat formatador2 = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
						bw.write(formatador2.format(calendar.getTime()));
						bw.close();
						
					}
					
					
				}
			}
			JOptionPane.showMessageDialog(null, "Emitir Boletim");
			bw.newLine();
			SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
			bw.write(formatador.format(calendar.getTime()));
			bw.close();
			

			List<Candidato> candidatos = candidatoinse.getList();
			for (Candidato Candidato : candidatos) {
				String leitura1 = "Nome: " + Candidato.getNome();

				String leitura2 = "Partido: " + Candidato.getPartido();
				String leitura3 = "Número de votos: " + Candidato.getNumerodevotos();
				JOptionPane.showMessageDialog(null,
						"Boletim de Urna " + "\n" + "Eleições 2017" + "\n" + "Votos computados por candidatos"
								+ "\n" + leitura1 + "---- " + leitura2 + "----" + leitura3);
		}   
		JOptionPane.showMessageDialog(null, "***---VOTAÇÃO-ENCERRADA---***");
		
		}
	}
		else {
			JOptionPane.showMessageDialog(null, "Mesario não autenticado !");
			
		}
}
}
	


