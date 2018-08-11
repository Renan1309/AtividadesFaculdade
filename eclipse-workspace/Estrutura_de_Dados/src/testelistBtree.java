import java.util.Scanner;



public class testelistBtree {
	public static int count =0;
	 
	public static  int result [] ;
	private static Celula primeira = null;
	 private static int totalDeElementos ;
	 private static Celula ultima = null;
	
	 public static void adicionaNoComeco(Object elemento) {
		 count++;
		 if(totalDeElementos == 0) {
		        Celula nova = new Celula(elemento);
		        primeira = nova;
		      ultima = nova;
		    } else {
		        Celula nova = new Celula(primeira , elemento);
		        primeira.setAnterior(nova);
		        primeira = nova;
		    }
		    totalDeElementos++;
		 
	 }
	 public static void adiciona(Object elemento) {
		 count++;
	    	if(totalDeElementos == 0) {
	            adicionaNoComeco(elemento);
	        } else {
	            Celula nova = new Celula(elemento);
	            ultima.setProximo(nova);
	            nova.setAnterior(ultima);
	            ultima = nova;
	           totalDeElementos++;
	        }
	     }
	
	public static void contador(int num) {
		for (int i = 1; i < result.length; i++) {
			 if(result[i]==0) {
					result[i]=main.count;
					break;
			 }
		}
	}
	public static void contadorRaiz(int num) {
		for (int i = 0; i < result.length; i++) {
			 if(result[i]==0) {
					result[i]=main.count;
					break;
			 }
		}
	}
	public static void criaArray(int num) {
		result =new int [num];
}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Lista lista = new Lista();
		
		int soma = sc.nextInt();
		criaArray(soma);
		
		if(soma >= 1 && soma <= 300000) {
		for (int i = 0; i < soma; i++) {
			int valor = sc.nextInt();
			
			 if (i == 0) {
				 adicionaNoComeco(valor);
                contadorRaiz(main.count);
                
              
         
             } else {
                 
            	
                 contador(main.count);
               adiciona(valor);
         
         }
		
		
			
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	//}
		
	}
	}
}
 

 class Celula {

	  private Object elemento;
	  private Celula proximo;
	  private Celula anterior;
	  
	  public Celula(Object elemento) {
		  this.elemento = elemento;
		}

	public Celula( Celula proximo, Object elemento) {
	    this.elemento = elemento;
	    this.proximo = proximo;
	}

	public Celula getProximo() {
	    return proximo;
	}

	public void setProximo(Celula proximo) {
	    this.proximo = proximo;
	}

	public Object getElemento() {
	    return elemento;
	}
	
	public Celula getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}

	
}