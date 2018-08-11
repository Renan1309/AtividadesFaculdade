package Arvore_Binaria;

public class Btree {
	

	
	public static void main(String[] args) {
		Arvore arv = new Arvore();
		Node no  ;
		arv.inserir(50);
		arv.inserir(25);
		arv.inserir(75);
		arv.inserir(10);
		arv.inserir(30);
		arv.inserir(60);
		arv.inserir(65);
		arv.inserir(80);
		arv.inserir(76);
		arv.inserir(77);
		arv.inserir(85);
		arv.inserir(1);
		arv.inserir(100);
		//no = arv.Noraiz;
		//arv.inordem(arv.Noraiz);
		
		arv.Remover(50);
		System.out.println("***********************************");
		no = arv.buscar(50);
		System.out.println(no);
		
		//arv.inordem(arv.Noraiz);
		
		

	   
		
	}
	
	

	

}
 