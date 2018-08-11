import java.util.Scanner;









class Lista {
	int array [];

	private Celula primeira = null;
	private int totalDeElementos;
	private Celula ultima = null;

	public void adicionaNoComeco(int elemento) {
		if (this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;

	}
	public void adiciona(int elemento) {
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

	public String toString() {
		if (totalDeElementos == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("");

		Celula atual = primeira;
	    array  = new  int  [totalDeElementos ];
		for (int i = 0; i < totalDeElementos ; i++) {
			array[i]=(int) atual.getElemento();
			//builder.append(atual.getElemento()+" ");
			builder.append(" ");
			atual = atual.getProximo();
		}
		//builder.append(atual.getElemento());
		//builder.append(" ");

		return builder.toString();

	}
	public void mostra() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	public void resultado(int number) {
		System.out.println(array[number]);
	}

	public void removeDoComeco() {
		if (totalDeElementos == 0)
			return;
		this.primeira = this.primeira.getProximo();
		this.totalDeElementos--;

		if (totalDeElementos == 0) {
			this.ultima = null;
		}

	}

	public int tamanho() {
		return totalDeElementos;
	}

	public int conferir(Object o) {
		Celula atual = this.primeira;
		int count = 0;
		for (int i = 0; i < totalDeElementos; i++) {
			if (atual.getElemento().equals(o)) {

				// count++ ;
				break;
			} else {
				count++;
			}
			atual = atual.getProximo();
		}
		return count;

	}

	class Celula {
		private int elemento;
		private Celula proximo;
		private Celula anterior;

		public Celula(int elemento) {
			this.elemento = elemento;
		}

		public Celula(Celula proximo, int elemento) {
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

		public void setElemento(int elemento) {
			this.elemento = elemento;
		}
	}
}

 class caixaBtre {
	public  static Node Noraiz; 
	 static int count = 0;
	 

	public static  void inserirNo(Node no ,int value) {
      Node novoNo = new Node(value);
		
		if(no == null) {
			Noraiz = novoNo;
			  //System.out.println("Raiz "+Noraiz.value);
		}
		else {
			count++;
			if(value  < no.value) {
			  if(no.esquerda != null) {
				  inserirNo(no.esquerda, value);
			  }else {
				  //System.out.println("Inse "+value+"a esq "+no.value);
				  no.esquerda = new Node(value);
			  }
				
			}
			else {
				if(no.direita !=null) {
					inserirNo(no.direita , value);
					
				}else {
					//System.out.println("Inse "+value+"a dir "+no.value);
					 no.direita= new Node(value);
				}
				
			}
			
			
			
		}
}
		
	
	 public static  void Raiz(int valor) {
		 Node novoNo = new Node(valor);
		 Noraiz = novoNo;
	 }
	
	public  void inserir(int valor) {
       inserirNo(Noraiz, valor);
   }

	
	

	public static void main(String[] args) {
		Lista lista = new Lista();
		
		Scanner sc = new Scanner(System.in);
		
		int qtdinser =sc.nextInt();
		
		for (int i = 0; i < qtdinser; i++) {
			
				
				int valor = sc.nextInt();
				caixaBtre .inserirNo(Noraiz , valor);
				lista.adiciona(caixaBtre .count);
				//lista.toString();
				///lista.resultado(i);
				
				System.out.println(count);

			}
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
