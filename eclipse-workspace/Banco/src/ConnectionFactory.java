
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
            		
            		//"jdbc:mysql://192.168.15.8/bancovm", "renanvm", "password");
            		//"jdbc:mysql://192.168.15.28/bancodocker", "renandocker", "password");
            		
            		"jdbc:mysql://192.168.15.9/bancolocal", "renan", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}