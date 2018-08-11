package br.edu.fbv.BancoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.fbv.conexão.ConnectionFactory;
import br.edu.fbv.modelo.Administrador;
import br.edu.fbv.modelo.Candidato;
import br.edu.fbv.modelo.Mesario;

public class administradorDAO {
private Connection connection;
	
	//Administrador administrador = new  Administrador();
	
	public administradorDAO() {
		new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();

	}
	public boolean login(String cpf , String senha) {
		boolean existe = false;
		PreparedStatement stm;
		try {                                 //testando o login com o SHA2
			stm = connection.prepareStatement("SELECT * FROM administrador WHERE cpf = ? AND senha = SHA2(?,256) ");
			stm.setString(1, cpf);
			stm.setString(2, senha);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				existe = true;
				
				
				}
				
				return existe;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return existe;
		
		
		
	}
	/**
	public void adiciona (Administrador administrador) {
		String sql = "insert into testeaes (cpf,nome,senha) values ( ? , ? , AES_ENCRYPT( ?, 'renan'))";
		//String sql = "insert into testeAES (cpf , nome , senha)" + " values (?,?,?)";
		//String sql =" insert into administrador (cpf, nome , senha ) values (?, ?, ?)";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, administrador.getCpf());
			stmt.setString(2, administrador.getNome());
			stmt.setString(3, administrador.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			return ;
			
			// TODO Auto-generated catch block

		}
	}
	**/
	
	
	public void receberhash  (String codigo ,byte[] hashtexto) {
		String sql = "insert into integridade_txt (codigo ,bytes_hash ) values ( ?,? )";
		
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, codigo);
			stmt.setBytes(2, hashtexto);
			
			stmt.execute();
			stmt.close();
			
				
				
		} catch (SQLException e) {
			
			
			// TODO Auto-generated catch block

		}
}			
	
	public byte[] hashdobanco(String codigo) throws SQLException {
		byte[] hashconsultado = null;
		String sql = "SELECT * FROM integridade_txt WHERE codigo = ?";
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, codigo);
		
		ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
        	 hashconsultado  = rs.getBytes("bytes_hash");
    		    		
		}
      //hashconsultado  = rs.getBytes("bytes_hash");
			return hashconsultado;	
		
	
	}
	
	public void AdicionaMesario (Mesario Mesario) {
		String sql = "insert into mesario" + " (cpf, nome,senha)" + " values (?,?,SHA2(?,256))";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, Mesario.getCpf());
			stmt.setString(2, Mesario.getNome());
			stmt.setString(3,Mesario.getSenha());
			
		
			//stmt.setString(4, candidato.getCpf());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
			// TODO Auto-generated catch block

		}
	}
		
		
		
		
		
	
	
}

