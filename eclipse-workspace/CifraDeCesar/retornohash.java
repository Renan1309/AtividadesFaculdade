package br.edu.fbv.funcoes;

import javax.swing.JOptionPane;

import br.edu.fbv.BancoDAO.administradorDAO;

public class retornohash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 administradorDAO addao =new administradorDAO() ;
         int codigo = Integer.parseInt(JOptionPane.showInputDialog("Código para localizar o hash"));
		 
		byte[] receber = addao.receberhash(codigo);
	}

}
