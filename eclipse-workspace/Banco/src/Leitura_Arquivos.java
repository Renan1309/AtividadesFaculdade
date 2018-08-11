
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Random;

public class Leitura_Arquivos {
	public static void main(String[] args) throws SQLException, IOException {
		
		Connection con = new ConnectionFactory().getConnection();
									//alteramos o arquivo que queriamos ler
		FileInputStream stream = new FileInputStream("/home/renan/trabanalise/createtable");
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder builder = new StringBuilder();
        String linha = br.readLine();
        
        while(linha != null) {
          
            builder.append(linha);
            linha = br.readLine();
        }
        
        PreparedStatement stmtx = con.prepareStatement(builder.toString());
        
        stmtx.execute();
        stmtx.close();
         
         
        
        
        
        System.out.println("Executado!");
       
        
        
       
	}

}
