package br.edu.fbv.Menu;

import javax.swing.JOptionPane;

import br.edu.fbv.conexao.EleitorDAO;
import br.edu.fbv.modelos.Eleitor;

public class UrnaMain {

	public static void main(String[] args) {
	Eleitor e = new Eleitor();
		
		EleitorDAO dao = new EleitorDAO();
		
		e.setNome("Silvio Santos");
		e.setTitulodeeleitor("983574825489765");
		
		dao.create(e);
		
		System.out.println("Gravado!");
		
		JOptionPane.showMessageDialog(null, "AGORA SIM");
		
		
		// TODO Auto-generated method stub

	}

}
