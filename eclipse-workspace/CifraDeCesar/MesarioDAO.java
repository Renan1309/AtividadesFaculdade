package br.edu.fbv.BancoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.fbv.conexão.ConnectionFactory;
import br.edu.fbv.modelo.Mesario;

public class MesarioDAO {
	
	private Connection connection;
	public MesarioDAO() {
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	}
	
	public void Adiciona(Mesario mesario) {
 String sql = "insert into mesario (cpf, nome , senha ) values ('?', '?', SHA2('?', 512))";
 try {

 PreparedStatement stmt = connection.prepareStatement(sql);
       stmt.setString(1, mesario.getCpf());
       stmt.setString(2, mesario.getNome());
       stmt.setString(3, mesario.getSenha());
       stmt.execute();
       stmt.close();
	} catch (SQLException e) {
	return ;
	
	// TODO Auto-generated catch block
	
	}
	
	}


}
