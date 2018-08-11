package Lista_ligadas;

public class MenuLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Lista lista = new Lista();
		/**
		Lista lista2 = new Lista();
		lista.adicionaNoComeco("1");
		lista.adicionaNoComeco("2");
		lista.adicionaNoComeco("3");
		lista.adicionaNoComeco("4");
		lista.adicionaNoComeco("5");
		lista.adicionaNoComeco("6");
		lista.adicionaNoComeco("7");
		lista.adicionaNoComeco("8");
		
		lista2.adicionaNoComeco("9");
		lista2.adicionaNoComeco("10");
		lista2.adicionaNoComeco("11");
		lista2.adicionaNoComeco("12");
		lista2.adicionaNoComeco("13");
		lista2.adicionaNoComeco("14");
		lista2.adicionaNoComeco("15");
		lista2.adicionaNoComeco("16");
		
		**/
		
		//System.out.println(lista);
		//System.out.println(lista2);
		//lista.removeDoComeco();
		
		lista.adiciona("1");
		lista.adiciona("2");
		lista.adiciona("3");
		lista.adiciona("4");
		lista.adiciona("5");
		lista.adiciona("6");
		lista.adiciona("7");
		lista.adiciona("8");
		lista.adiciona("9");
		lista.adiciona("10");
		lista.adiciona("11");
		lista.adiciona("12");
		lista.adiciona("13");
		//lista.adiciona("Messi");
		System.out.println(lista);
	
       // lista.pega(1);
        //lista.removeDoComeco();
      // lista.removeDoComeco();
      

		
	
       
		lista.Deletarcomobj("1");
		System.out.println(lista);
		lista.Deletarcomobj("8");
		System.out.println(lista);
		lista.Deletarcomobj("4");
		
		System.out.println(lista);
		
		
	}

}
