import javax.swing.JOptionPane;

import br.edu.fbv.BancoDAO.InserirDAO;

public class TesteWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int parar =2;
		InserirDAO inserirdao = new InserirDAO();
		int codigo ;
		codigo = Integer.parseInt(JOptionPane.showInputDialog("digite"));
		if (codigo ==200) {
			while(codigo == 200 ) {
				int titulo ;
				titulo = Integer.parseInt(JOptionPane.showInputDialog("digite seu titulo"));
				if(titulo == 1111 ) {
					codigo  = 800 ;
					JOptionPane.showMessageDialog(null, "votação");
				}else {
					boolean avalia = inserirdao.confirmarTitulo(titulo);
					if (avalia == true) {
						JOptionPane.showMessageDialog(null, "Titulo Aprovado =)");
					
					
				}
				
				/**if (v== 2) {
				}
					codigo =600;
					JOptionPane.showMessageDialog(null, "ta ok ");
				}
				**/
			}JOptionPane.showMessageDialog(null, "terminou o laço");
			
		}
		

	}

}
