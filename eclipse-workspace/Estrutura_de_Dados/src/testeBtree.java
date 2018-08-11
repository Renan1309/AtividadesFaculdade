import java.util.HashSet;
import java.util.Scanner;





public class main {
	public static int count =0;
	 static Node Noraiz; 
	public static  int result [] ;

	public static void inserirNo(Node no ,int value) {
		count++;
		

		
			if(value  < no.value) {
			  if(no.esquerda != null) {
				  inserirNo(no.esquerda, value);
			  }
			
			  else {
			
				 // System.out.println("Inse "+value+" a esq "+no.value+" contador "+count);
				  no.esquerda = new Node(value);
			  }
				
			}
			else {
				if(no.direita !=null) {
					inserirNo(no.direita , value);
					
				}else {
					
					//System.out.println("Inse "+value+" a dir "+no.value+" contador "+ count);
					 no.direita= new Node(value);
				}
				
			}
			
			
			
		}
		

		
		
		
		

		
	
	 public static void inserir(int valor) {
	        inserirNo(Noraiz, valor);
	    }
	 
	 public static void Raiz(int valor) {
		 Node novoNo = new Node(valor);
		 Noraiz = novoNo;
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
		//int result [] = new int[soma];
		//if(soma >= 1 && soma <= 300000) {
		for (int i = 0; i < soma; i++) {
			int valor = sc.nextInt();
			
			 if (i == 0) {
                Raiz(valor);
                contadorRaiz(main.count);
               // lista.adiciona(main.count);
               // gone.add(main.count);
                 //System.out.println(BST.count);
            /**
                 for (int j = 0; j < result.length; j++) {
                	 if(result[j]==0) {
					result[j]=main.count;
					break;
				}
                 }
       **/
             } else {
                 
                 inserirNo( Noraiz, valor);
                 contador(main.count);
                // lista.adiciona(main.count);
                 //gone.add(main.count);
                // System.out.println(BST.count);
                /**
                 for (int j = 1; j <= result.length; j++) {
                	 if(result[j]==0) {
					result[j]=main.count;
					break;
				}
                
             }
		**/
         
         }
		
		
			
		}
		//System.out.println(lista);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	//}
		
	}
	
	
	}



 class Node {
	 
	 int value ;
	 
	 Node esquerda;
	 Node direita;
	 

	 
	 Node(int value){
		 
		 this.value = value;
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
  class Lista {
		
		 private Celula primeira = null;
		 private int totalDeElementos ;
		 private Celula ultima = null;
		
		 public void adicionaNoComeco(Object elemento) {
			 if(this.totalDeElementos == 0) {
			        Celula nova = new Celula(elemento);
			        this.primeira = nova;
			        this.ultima = nova;
			    } else {
			        Celula nova = new Celula(this.primeira , elemento);
			        this.primeira.setAnterior(nova);
			        this.primeira = nova;
			    }
			    this.totalDeElementos++;
			 
		 }
		 public String toString() {
			 if(totalDeElementos == 0) {
				 return "[]";
			 }
			 StringBuilder builder = new StringBuilder();
			 
			 Celula atual = primeira;
			 
			 for (int i = 0; i < totalDeElementos - 1; i++) {
				 builder.append(atual.getElemento());
				 builder.append(" ");
				 atual = atual.getProximo();
			}
			 builder.append(atual.getElemento());
			 //builder.append("");
			 
			 return builder.toString();
			 
			 
			 
		 }

		    public void adiciona(Object elemento) {
		    	if(this.totalDeElementos == 0) {
		            adicionaNoComeco(elemento);
		        } else {
		            Celula nova = new Celula(elemento);
		            this.ultima.setProximo(nova);
		            nova.setAnterior(this.ultima);
		            this.ultima = nova;
		            this.totalDeElementos++;
		        }
		     }
}
  