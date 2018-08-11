package ArvoreB;

import java.util.Scanner;

public class BMain {

	/**Alunos: Renan Alexandre ,
	 * 		Cesar Augusto
	 * 
	**/
	public static void main(String[] args){
        Scanner sc = new Scanner( System.in );
		int numeroDaOrdem,numeroDevaloreAserADD,temp;
		System.out.print("Informe a Ordem da Classe: ");
		numeroDaOrdem=sc.nextInt();
		BTree tree = new BTree(numeroDaOrdem);
		int optEscolhida,k;
      
		System.out.print("\n qtd de valor que vai adicionar na árvore:  ");	
        numeroDevaloreAserADD = sc.nextInt();

        for ( int i=0;i< numeroDevaloreAserADD;i++)
		{
            System.out.print("\n Digite o valor:");
			System.out.println(i+1);
			temp=sc.nextInt();
			tree.insert(tree,temp);
		}
	

        boolean variavelParaManterOloop;
		variavelParaManterOloop=true;
	    System.out.println("1. para adicionar mais valores digite 1 , "
	    		+ "2. Printar os valores na tela");
		
	  while (variavelParaManterOloop) {

			System.out.print("Escolha uma opção:");
			optEscolhida = sc.nextInt();
			if (optEscolhida == 5) {

				System.exit(0);
				variavelParaManterOloop = false;
				break;
			}

			else {
				switch (optEscolhida) {
				case 1:
					System.out.print("qtd de valor que vai adicionar na árvore:");
					numeroDevaloreAserADD = sc.nextInt();

					for (int i = 0; i < numeroDevaloreAserADD; i++) {

						temp = sc.nextInt();
						tree.insert(tree, temp);
					}
					break;

				case 2:

					tree.ExibirBtree(tree.NoRaiz);
					System.out.println();
					break;

				default:
					System.out.println("\n  opt invalida\n");
					break;
				}
			} 
		} 
}
}