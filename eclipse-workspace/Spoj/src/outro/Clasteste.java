package outro;
import java.util.Scanner;

import Lista;
import outro.Lista.Celula;

class Lista {
	int array [];
	//int count;

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

 class Clasteste {
	

	public static void main(String[] args) {
		Lista lista = new Lista();
		int count=0;
		Scanner sc = new Scanner(System.in);
		
		int qtdinser =sc.nextInt();
		
		for (int i = 0; i < qtdinser; i++) {
			if(i ==0) {
				int valor = sc.nextInt();
				System.out.println(count);
			}else {
				int valor = sc.nextInt();
				count++;
				//caixaBtre .inserirNo(Noraiz , valor);
				//lista.adiciona(caixaBtre .count);
				//lista.toString();
				///lista.resultado(i);
				
				System.out.println(count);
			}
			}
				}
		
	}	