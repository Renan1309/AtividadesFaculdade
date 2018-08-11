
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Deletes {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = new ConnectionFactory().getConnection();
		//DELETE FROM table_name WHERE some_column = some_value
			//1 - 1 - 99
		   //2 -100 - 501
		  //3 - 502 - 1604
		
		for (int i = 100; i < 501; i++) {
	    	
	    	String update  = "DELETE FROM pedidos WHERE id = " + i;
	    	PreparedStatement stmtfo = con.prepareStatement(update);
	    	stmtfo.execute();
	        
	    	
		}
	    
	    
	    System.out.println("Executado!");

	}
	}