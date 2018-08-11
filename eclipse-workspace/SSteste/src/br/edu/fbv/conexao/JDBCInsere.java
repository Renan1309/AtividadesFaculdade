package br.edu.fbv.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.fbv.DAO.ConnectionFactory;

public class JDBCInsere {

	public static void main(String[] args) {
		new ConnectionFactory();
		// TODO Auto-generated method stub
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "insert into eleitor" +
                " (nome , titulodeeleitor)" +
                " values (?,?)";
        try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "Sebastião");
	        stmt.setString(2, "4324543543");
	        stmt.execute();
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
