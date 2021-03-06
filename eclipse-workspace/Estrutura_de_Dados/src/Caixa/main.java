package Caixa;

import java.util.Scanner;





class Lista {

	private Celula primeira = null;
	private int totalDeElementos;
	private Celula ultima = null;

	public void adicionaNoComeco(Object elemento) {
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

	public String toString() {
		if (totalDeElementos == 0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");

		Celula atual = primeira;

		for (int i = 0; i < totalDeElementos - 1; i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			atual = atual.getProximo();
		}
		builder.append(atual.getElemento());
		builder.append("]");

		return builder.toString();

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
		private Object elemento;
		private Celula proximo;
		private Celula anterior;

		public Celula(Object elemento) {
			this.elemento = elemento;
		}

		public Celula(Celula proximo, Object elemento) {
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
}

class main {
	public  static Node Noraiz; 
	 static int count = 0;
	 

	public static  void inserirNo(Node no ,int value) {
		count++;
	
	
		
		
			
			if(value  < no.value) {
			  if(no.esquerda != null) {
				  inserirNo(no.esquerda, value);
			  }else {
				 // System.out.println("Inse "+value+"a esq "+no.value);
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
		
	
	 public static  void Raiz(int valor) {
		 Node novoNo = new Node(valor);
		 Noraiz = novoNo;
	 }
	
	public  void inserir(int valor) {
       inserirNo(Noraiz, valor);
   }

	
	public class main {

	public static void main(String[] args) {
		Lista lista = new Lista();
		
		Scanner sc = new Scanner(System.in);
		
		int qtdinser =sc.nextInt();
		if(qtdinser >=1 && qtdinser <= 300000) {
		for (int i = 0; i < qtdinser; i++) {
			if(i==0) {
				
				int valor = sc.nextInt();
				main.Raiz(valor);
				lista.adiciona(main.count);
				
			}
			else {
				
				int valor = sc.nextInt();
				main.inserirNo(Noraiz , valor);
				lista.adiciona(main.count);
			}
			}
		System.out.println(lista);
		}
		
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



