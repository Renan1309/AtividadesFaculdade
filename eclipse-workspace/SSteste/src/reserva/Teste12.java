package reserva;

import java.sql.Connection;

import br.edu.fbv.DAO.ConnectionFactory;
import br.edu.fbv.modelos.Eleitor;

public class Teste12 {

	public static void main(String[] args) {
		//AluraConexão acc = new AluraConexão();
		//acc.getConnection();
		ConexaoDba conexadba = new ConexaoDba() ;
	    conexadba.conectar();
	    Eleitor e = new Eleitor();
		
	    //Connection con ;
	   
	    //con = ConnectionFactory.getConnection();
	   // as.listarcontatos();
		
		if (conexadba.Estaconectado()) {
			conexadba.listarcontatos();
			e.setNome("Silvio Santos");
			e.setTitulodeeleitor("983574825489765");
			conexadba.inserircandidato(e);
			
		}
		else {
			System.out.println("Não foi possível");
		}
	}

}
