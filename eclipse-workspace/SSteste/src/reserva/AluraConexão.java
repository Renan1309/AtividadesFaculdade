package reserva;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AluraConexão {
	private Connection con = null;
	private Statement statement = null ;
	private ResultSet resultset = null;
	

	public Connection getConnection() {
        try {
            return DriverManager.getConnection(
          "jdbc:mysql:3306//localhost/teste", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////
	
	public boolean Estaconectado() {
		 if(this.con !=null){
			 return true;
		 }
		 else {
			 return false;
		 }
		 }
	 
	 
public void listarcontatos () {
	try {
		String query =" SELECT *FROM contato ORDER BY nome ";
		this.resultset = this.statement.executeQuery(query);
		this.statement = this.con.createStatement();
		while (this.resultset.next() ) {
			System.out.println("ID "+ this.resultset.getString("id")+ "- Nome: " +this.resultset.getString("nome") +"- Telefone : " +this.resultset.getString("nome"));
		}
	}catch (Exception e) {
		System.out.println("Erro "+e.getMessage());
	}
}
}
