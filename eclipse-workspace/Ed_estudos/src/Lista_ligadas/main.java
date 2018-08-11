package Lista_ligadas;


import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista lista = new Lista();
		Scanner sc = new Scanner(System.in);
		int qtdpessoa = sc.nextInt();
		int qtdexcluir;
		for (int i = 0; i < qtdpessoa; i++) {
			int valor = sc.nextInt();
			lista.adiciona(valor);
			
			
		}
			//System.out.println(lista);
	   qtdexcluir = sc.nextInt();
	   for (int i = 0; i < qtdexcluir; i++) {
		   int valorex = sc.nextInt();
		   lista.Deletarcomobj(valorex);
		
	}
	   System.out.println(lista);
	}

}
 class lista {
	
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

	    public void adiciona(int posicao, Object elemento) {
	    	if(posicao == 0) {
	            adicionaNoComeco(elemento);
	        } else if (posicao == this.totalDeElementos) {
	            this.adiciona(elemento);
	        } else {
	            Celula anterior = pegaCelula(posicao - 1);
	            Celula proxima = anterior.getProximo();

	            Celula nova = new Celula(anterior.getProximo(), elemento);
	            nova.setAnterior(anterior);
	            anterior.setProximo(nova);
	            proxima.setAnterior(nova);
	            this.totalDeElementos++;
	    }
	    	
	    }
	    
	    private Celula pegaCelula(int posicao) {
	    	Celula atual = primeira;
	    	for (int i = 0; i < posicao; i++) {
	    		
	    		atual = atual.getProximo();
				
			}
	    	return atual;
	    }

	    public Object pega(int posicao) { 
	    	
	    	return this.pegaCelula(posicao).getElemento();
	    	
	    }
	    
	    public void removeDoComeco(){
	    	if(totalDeElementos==0) return;
	    	this.primeira = this.primeira.getProximo();
	    	this.totalDeElementos--;
	    	
	    	if(totalDeElementos ==0) {
	    		this.ultima = null;
	    	}
	    	
	    	
	    }
	    
	    public void removeDoFim() {
	    	 if(this.totalDeElementos == 1) {
	    	        this.removeDoComeco();
	    	    } else {
	    	        Celula penultima = this.ultima.getAnterior();
	    	        penultima.setProximo(null);
	    	        this.ultima = penultima;
	    	        this.totalDeElementos--;
	    	    }
	    	}
	    

	    public void remove(int posicao) {
	    	
	    	if(posicao == 0) {
	            this.removeDoComeco();
	        } else if (posicao == this.totalDeElementos - 1) {
	            this.removeDoFim();
	        } else {
	            Celula anterior = this.pegaCelula(posicao - 1);
	            Celula atual = anterior.getProximo();
	            Celula proxima = atual.getProximo();

	            anterior.setProximo(proxima);
	            proxima.setAnterior(anterior);

	            this.totalDeElementos--;
	        }
	    }

	    public int tamanho() { return totalDeElementos; }

	    public boolean contem(Object o) { 
	    	Celula atual = this.primeira;

	        while(atual != null) {
	            if(atual.getElemento().equals(o)) {
	            	
	                return true;
	            }
	            atual = atual.getProximo();
	        }
	        return false;
	    }
	    
	public void Deletarcomobj(Object elemento) {

		Celula atual = this.primeira;
		int count = 0;
		while (atual != null) {
			
			if (atual.getElemento().equals(elemento)) {
			
				break;				
			}
				
			atual = atual.getProximo();
			count++;	
		
		}if(count==0) {
			
			removeDoComeco();
		}else {
			remove(count);
		}
			 
	}
 }

 
