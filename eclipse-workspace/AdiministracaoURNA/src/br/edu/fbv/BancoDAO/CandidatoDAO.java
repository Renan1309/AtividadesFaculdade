package br.edu.fbv.BancoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fbv.conexão.ConnectionFactory;
import br.edu.fbv.modelo.Candidato;

public class CandidatoDAO {
	private Connection connection;

	public CandidatoDAO() {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();

	}

	public void Adiciona(Candidato candidato) {
		String sql = "insert into candidato" + " (numerodeeleicao, nome, partido,numerodevotos)" + " values (?,?,?,?)";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, candidato.getNumerodeeleicao());
			stmt.setString(2, candidato.getNome());
			stmt.setString(3, candidato.getPartido());
			stmt.setInt(4, candidato.getNumerodevotos());
		
			//stmt.setString(4, candidato.getCpf());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
			// TODO Auto-generated catch block

		}
	}

	public List<Candidato> getList() {

		try {
			List<Candidato> candidatos = new ArrayList<Candidato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from candidato");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Candidato candidato = new Candidato();
				// Eleitor eleitor = new Eleitor();

				candidato.setNome(rs.getString("nome"));
				candidato.setPartido(rs.getString("partido"));
				candidato.setNumerodevotos(rs.getInt("numerodevotos"));

				candidatos.add(candidato);

			}

			rs.close();
			stmt.close();

			return candidatos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	

}
