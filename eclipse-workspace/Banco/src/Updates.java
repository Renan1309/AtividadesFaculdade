
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Updates {
	public static void main(String[] args) throws SQLException {
		
	
	Connection con = new ConnectionFactory().getConnection();
	Random gerador = new Random();
    //   i inicia - i final 	
	//1 - 1-101	
	//2 -101-501
	//3 - 501 -1604
    for (int i = 501; i < 1604; i++) {
    	
    	String update  = "UPDATE pedidos SET valor='"+gerador.nextInt(200)+"' WHERE id = " + i;
    	PreparedStatement stmtfo = con.prepareStatement(update);
    	stmtfo.execute();
        
    	
	}
    
    
    System.out.println("Executado!");

}
}