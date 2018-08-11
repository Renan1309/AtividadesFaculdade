
public class testeArv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Arvoreb arv = new Arvoreb();
     /**
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
		arv.inserir(29);
	**/
       /**
       arv.inserir(50);
		arv.inserir(30);
		arv.inserir(100);
		arv.inserir(20);
		arv.inserir(40);
		arv.inserir(35);
		arv.inserir(45);
		arv.inserir(37);
       **/
     
       arv.inserir(15);
       arv.inserir(10);
		arv.inserir(6);
		arv.inserir(12);
		arv.inserir(9);
		arv.inserir(5);
		arv.inserir(8);
		arv.inserir(20);
		arv.inserir(18);
		arv.inserir(25);
		arv.inserir(16);
		arv.inserir(19);
		arv.inserir(17);
		
		arv.inserir(30);
		arv.inserir(27);
		
		arv.inordem(arv.Noraiz);
		System.out.println("------------------------");
		
		//arv.buscar(65);
		//No no = arv.buscar();
		
		//System.out.println("Valor encontrado- "+ no.value);
		
		 //No noant = arv.menorValorEsquerda(no.esquerda);
		//System.out.println("-----Antecessor-----"+ noant.value);
		//------------arv.Remover(30);
		//arv.Remover(30);
		//-------------------------------------arv.Remover(10);
		
		//arv.Remover(30);
		//arv.Remover(1);
		//arv.inordem(arv.Noraiz);
		
		System.out.println("------------------------");
		//arv.Remover(60);
		//arv.inordem(arv.Noraiz);
		//arv.prefixado(arv.Noraiz);
		//System.out.println(arv.builder);
		arv.imprimir(arv.Noraiz);
	}

}
