package reserva;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.edu.fbv.modelos.Eleitor;

public class ConexaoDba {

	private Connection con = null;
	
		private Statement statement = null ;
	

	private ResultSet resultset = null;
//aqui obs
	private PreparedStatement stmt;
	public boolean conectar() {
		
		String servidor = "jdbc:mysql://localhost/urna";
		String usuario = "root";
		String senha = "";
		String drive = "com.mysql.jdbc.Driver";
		 try {
			  Class.forName(drive );
			  this.con = DriverManager.getConnection(servidor, usuario, senha);
			  this.statement = this.con.createStatement();
		 }catch (Exception e) {
			// TODO: handle exception
			 System.out.println("Erro "+ e.getMessage() );
		}
		return false;
	}

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
			String query =" SELECT *FROM candidato ";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.con.createStatement();
			while (this.resultset.next() ) {
				//JOptionPane.showConfirmDialog(null, "ID "+ this.resultset.getString("id")+ "- Nome: " +this.resultset.getString("nome") +"- Título de eleitor : " +this.resultset.getString("nome"));
				System.out.println("ID "+ this.resultset.getString("id")+ "- Nome: " +this.resultset.getString("nome") +"- Título de eleitor : " +this.resultset.getString("titulodeeleitor"));
			}
		}catch (Exception e) {
			System.out.println("Erro "+e.getMessage());
		}
}
	public void inserircandidato (Eleitor e) {
		//stmt = null;
				try {
					String query = "\"INSERT INTO candidato (nome , titulodeeleitor ) VALUES (?,?,)\"";
					stmt.setString(1, e.getNome());
					stmt.setString(2, e.getTitulodeeleitor());
					this.resultset = this.statement.executeQuery(query);
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
}
