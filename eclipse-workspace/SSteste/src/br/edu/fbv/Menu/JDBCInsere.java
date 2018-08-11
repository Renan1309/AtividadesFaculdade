
package br.edu.fbv.Menu;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

import Cripografia.AESfuncao;
import br.edu.fbv.BancoDAO.CandidatoDAO;
import br.edu.fbv.BancoDAO.InserirDAO;
import br.edu.fbv.BancoDAO.administradorDAO;
import br.edu.fbv.conexão.ConnectionFactory;
import br.edu.fbv.function.Funcionalidades;
import br.edu.fbv.modelo.Administrador;
import br.edu.fbv.modelo.Boletim;
import br.edu.fbv.modelo.Candidato;
import br.edu.fbv.modelo.Eleitor;

public class JDBCInsere {
	public static void main(String[] args) throws SQLException, IOException {
		Eleitor eleitor = new Eleitor();
		Candidato candidato = new Candidato();
		Administrador administrador = new Administrador();
		InserirDAO inserirdao = new InserirDAO();
		CandidatoDAO candidatoinse = new CandidatoDAO();
		administradorDAO administradorCHEF = new administradorDAO();
		Funcionalidades funcionalidades = new Funcionalidades();
		AESfuncao aesfunca = new AESfuncao();
		Boletim votosurna = new Boletim();

		BufferedWriter bw = new BufferedWriter(new FileWriter("c:/EscritaUrna.txt", true));
		Locale locale = new Locale("pt", "BR");
		GregorianCalendar calendar = new GregorianCalendar();

		/////////////////// METODO DE INICIAÇÃO DE
		/////////////////// VOTAÇÃO///////////////////////////////////

		int opção = 8;

		if (opção == 8) {
			// Método de autenticar o ADMINISTRADOR "AUDITOR"
			String cpf2;
			String senha;
			String existe;
			cpf2 = JOptionPane.showInputDialog("Digite seu CPF");
			senha = JOptionPane.showInputDialog("Digite sua senha");
			boolean resposta = administradorCHEF.login(cpf2, senha);

			if (resposta == true) {
				bw.newLine();
				bw.write("acesso realizado pelo Mesário");
				bw.newLine();
				SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
				bw.write(formatador.format(calendar.getTime()));

				// funcionalidades.metodovotação();
				int escolha = Integer.parseInt(JOptionPane.showInputDialog("desaja iniciar a votação ou apurar votos"));
				if (escolha == 0) {
					String ti = JOptionPane.showInputDialog("informe o titulo");
					boolean avalia = inserirdao.confirmarTitulo(ti);
					String conf= "não";
					String conferirsevotou = inserirdao.Conferir(ti);
					if (avalia == true && conferirsevotou.equals(conf)) {
						JOptionPane.showMessageDialog(null, "Titulo Aprovado =)");
						int numerodeeleicao;
						numerodeeleicao = Integer
								.parseInt(JOptionPane.showInputDialog("Digite  número do seu  candidato"));
						funcionalidades.buscacandidato(numerodeeleicao);

						int confir = JOptionPane.showConfirmDialog(null,
								"Seu candidato esta correto" + JOptionPane.YES_NO_OPTION);
						if (confir == 0) {
							JOptionPane.showMessageDialog(null, "voto computado =)");
							bw.newLine();
							bw.write("Voto Computado Dia");
							bw.newLine();
							SimpleDateFormat formatador2 = new SimpleDateFormat(
									"dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
							bw.write(formatador2.format(calendar.getTime()));
							
							candidatoinse.InserirVoto(numerodeeleicao);
							inserirdao.Javotou(ti);

						} else {
							JOptionPane.showMessageDialog(null, "recomece a votação");
							bw.newLine();
							bw.write("Erro candidato não encontrado");
							bw.newLine();
							SimpleDateFormat formatador32 = new SimpleDateFormat(
									"dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
							bw.write(formatador32.format(calendar.getTime()));

						}

					} else {
						JOptionPane.showMessageDialog(null, "Titulo não encontrado");
						bw.newLine();
						bw.write("Título não autenticado");
						bw.newLine();
						SimpleDateFormat formatador2 = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",
								locale);
						bw.write(formatador2.format(calendar.getTime()));

					}

				}

				else if (escolha == 1) {
					bw.newLine();
					SimpleDateFormat formatador5 = new SimpleDateFormat(
							"Impressão do boletim :dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
					bw.write(formatador5.format(calendar.getTime()));

					List<Candidato> candidatos = candidatoinse.getList();
					for (Candidato Candidato : candidatos) {
						String leitura1 = "Nome: " + Candidato.getNome();

						String leitura2 = "Partido: " + Candidato.getPartido();
						String leitura3 = "Número de votos: " + Candidato.getNumerodevotos();
						JOptionPane.showMessageDialog(null,
								"Boletim de Urna " + "\n" + "Eleições 2017" + "\n" + "Votos computados por candidatos"
										+ "\n" + leitura1 + "---- " + leitura2 + "----" + leitura3);
					}
				}
			} else {

				System.out.println("Acesso Negado");
				bw.newLine();
				bw.write("Não autenticado");
				bw.newLine();
				SimpleDateFormat formatador2 = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'", locale);
				bw.write(formatador2.format(calendar.getTime()));

			}
			bw.close();
		}
	}
}

		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/**
int opcao = Integer.parseInt(JOptionPane.showInputDialog(
		"Bem vindo a urna " + "\n" + "1 Cadastrar para votar" + "\n" + "2 Inserir Candidato"
				+ "\n" + "4 Listar Candidatos e Votos" + "\n" + "5 Consultar Candidato "+"\n" +"7 Inserir Votos"+
				"\n"+"Listar Eleitores" + "\n"+ "8 Para login na urna" + "\n"+"titulo encrypt e voto"));
*/
		
		
		
		
		
		
		/**
		
		if (opcao == 1) {
			//CADASTRAR PARA PODER VOTAR

			try {
				String nome = JOptionPane.showInputDialog("Digite seu nome, caro usuário.");
				eleitor.setNome(nome);
				String titulo = JOptionPane.showInputDialog("Digite seu título, caro usuário.");
				eleitor.setTitulodeeleitor(titulo);

				// InserirDAO inserirdao = new InserirDAO();
				inserirdao.Adiciona(eleitor);

				//OBS NISSO AQUI PARA BOTAR UM LAÇO PARA VERIFICAR SE FOI ADICIONADO !
				System.out.println("ADD COM SUCESSO");

			} catch (Exception e) {

				// TODO: handle exception
			}

		} 
		else if (opcao == 2) {
			// INSERIR CANDIDATO PARA QUE ELE POSSA CONCORRER
			int numerodeeleicao = Integer.parseInt(JOptionPane.showInputDialog("Digie o numero a concorrer"));
			candidato.setNumerodeeleicao(numerodeeleicao);
			String nome = JOptionPane.showInputDialog("Digite o nome do candidado a concorrer");
			candidato.setNome(nome);
			String partido = JOptionPane.showInputDialog("Digite o partido que ele faz parte");
			candidato.setPartido(partido);
			
			//String cpf = JOptionPane.showInputDialog("Digite seu cpf");
			//candidato.setCpf(cpf);
			candidatoinse.Adiciona(candidato);
			System.out.println("ADD COM SUCESSO");
			bw.newLine();
			bw.write("Candidato Inserido");
			bw.newLine();
			 SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
			bw.write(formatador.format(calendar.getTime()));
			bw.close();

		} else if (opcao == 3) {
			String nome = JOptionPane.showInputDialog("Digite seu nome, caro usuário.");
			eleitor.setNome(nome);
			String titulo = JOptionPane.showInputDialog("Digite seu título, caro usuário.");
			eleitor.setTitulodeeleitor(titulo);
			// inserirdao.confirmarsejatem();

		} else if (opcao == 4) {
			// Funcionalidades.listarcandidatos();
			//LISTAR CANDIDATOS E VOTOS

			List<Candidato> candidatos = candidatoinse.getList();
			for (Candidato Candidato : candidatos) {
				System.out.println("Nome: " + Candidato.getNome());

				System.out.println("Título: " + Candidato.getPartido());
				System.out.println("Número de votos: " + Candidato.getNumerodevotos());

			}

		} else if (opcao == 5) {
			//BUSCAR CANDIDATOS
			System.out.println("Consultar Candidato");

			try {

				int numerodeeleicao = 0;

				// Validação do código digitado
				while (true) {
					numerodeeleicao = Integer.parseInt(JOptionPane.showInputDialog("Digie do seu candidato"));
					if (numerodeeleicao < 0)
						System.out.println("Código inválido.");
					else
						break;
				}
				Candidato candidatos = candidatoinse.retornarCandidato(numerodeeleicao);
				System.out
						.println("Nome: " + candidatos.getNome() + "\n" + "Número: " + candidatos.getNumerodeeleicao());

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		}else if(opcao==7){
			
			//INSERIR VOTOS
			int numerodeeleicao = Integer.parseInt(JOptionPane.showInputDialog("Digie do seu candidato"));
			
			candidatoinse.InserirVoto(numerodeeleicao);
			
			bw.newLine();
			bw.write("Voto Computado Dia");
			bw.newLine();
			 SimpleDateFormat formatador = new SimpleDateFormat("dd' de 'MMMMM' de 'yyyy' - 'HH':'mm'h'",locale);
			bw.write(formatador.format(calendar.getTime()));
			bw.close();
			
		}else if(opcao==8) {
			//Método de autenticar o ADMINISTRADOR "AUDITOR"
			String cpf;
			String senha;
			String existe;
			cpf = JOptionPane.showInputDialog("Digite seu CPF");
			senha = JOptionPane.showInputDialog("Digite sua senha");
			boolean resposta = administradorCHEF.login(cpf, senha);
			
			
			if(resposta == true) {
				
				JOptionPane.showMessageDialog(null, "Autenticado !");
				
			}else {
				JOptionPane.showMessageDialog(null, "Não Autenticado !");
			}
			
			
		}
		else if (opcao==9) {
			//verificação de criptografica 
			try {
				String cpf = JOptionPane.showInputDialog("Digite seu CPF.");
				administrador.setCpf(cpf);
				String nome = JOptionPane.showInputDialog("Digite seu nome.");
				administrador.setNome(nome);
				String  senha = JOptionPane.showInputDialog("Digite sua senha.");
				administrador.setSenha(senha);
				
				administradorCHEF.adiciona(administrador);

				System.out.println("ADD COM SUCESSO");

			} catch (Exception e) {

				// TODO: handle exception
			}
			
			
		} else if (opcao==10) {
			//fazendo o inseri na tabela com o titulo encriptado e o voto
			String titulo = JOptionPane.showInputDialog("Digite seu titulo");
			int voto = Integer.parseInt(JOptionPane.showInputDialog("Digite seu voto"));
			
			inserirdao.computarvotoparaoauditor(titulo, voto);
		}
		

		else {

			// InserirDAO inserirdao = new InserirDAO();

			List<Eleitor> eleitores = inserirdao.getList();
			for (Eleitor Eleitor : eleitores) {
				// JOptionPane.showMessageDialog(null, "Nome: " + Eleitor.getNome());

				System.out.println("Nome: " + Eleitor.getNome());

				System.out.println("Título: " + Eleitor.getTitulodeeleitor());

			}

		}
	}
}
*/

/**
 * new ConnectionFactory(); // TODO Auto-generated method stub Connection con =
 * ConnectionFactory.getConnection(); ListarEleitores ll = new
 * ListarEleitores(); ll.listarcontatos();
 * 
 * String sql = "insert into candidato" + " (nome , titulodeeleitor)" + " values
 * (?,?)"; try { //PreparedStatement stmt = con.prepareStatement(sql);
 * stmt.setString(1, "Elton Mota"); stmt.setString(2, "908764576398");
 * stmt.execute(); } catch (SQLException e) { System.out.println(e); // TODO
 * Auto-generated catch block
 * 
 * }finally { con.close(); }
 * 
 * } }
 */
