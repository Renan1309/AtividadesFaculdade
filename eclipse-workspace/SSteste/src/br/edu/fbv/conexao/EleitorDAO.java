package br.edu.fbv.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.fbv.DAO.ConnectionFactory;
import br.edu.fbv.modelos.Eleitor;

public class EleitorDAO {
	
	
	public void create(Eleitor e) {
		
		Connection con = ConnectionFactory.getConnection();
		  PreparedStatement stmt = null;
		  
		  try {
			stmt = con.prepareStatement("INSERT INTO eleitor (nome , titulodeeleitor ) VALUES (?,?,)");
			stmt.setString(1, e.getNome());
			stmt.setString(2, e.getTitulodeeleitor());
			
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Salvo ok");
			
		} catch (SQLException a) {
			JOptionPane.showMessageDialog(null, "NÃO SALVO "+a);
			
			// TODO Auto-generated catch block
			
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
		
		
		
	}

}
