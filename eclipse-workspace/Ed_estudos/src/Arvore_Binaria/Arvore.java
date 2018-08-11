package Arvore_Binaria;

public class Arvore {
	
		
	Node Noraiz; 
		

		public  void inserir(int value) {
			Node novoNo = new Node(value);
			
			if(Noraiz == null) {
				Noraiz = novoNo;
				  System.out.println("Raiz "+Noraiz.value);
				 
			} InserirSub(Noraiz , novoNo);
		}
		
				
			

		private  void InserirSub(Node no, Node novoNo) {
			if(novoNo.value  < no.value) {
				if(no.esquerda ==null) {
					no.pai= no;
				no.esquerda = novoNo;
				 System.out.println("Inse "+novoNo.value+" a esq "+no.value);
			}else {
				InserirSub(no.esquerda , novoNo);
			}
		}
			else if (novoNo.value > no.value) {
				if(no.direita ==null) {
					no.pai= no;
					no.direita = novoNo;
					 System.out.println("Inse "+novoNo.value+"a dir "+no.value);
				}else {
					InserirSub(no.direita , novoNo);
				}
			}
				  
			
		}
		 public void prefixado(Node no) {
		        if(no != null){
		            System.out.print(no.value + " ");
		            prefixado(no.esquerda);
		            prefixado(no.direita);
		        }
		    }
		public  void inordem(Node no) {
	        if(no != null){
	        	inordem(no.esquerda);
			System.out.println(no.value + " ");
	        	inordem(no.direita);
	        }
	    }
		 
		 public   Node buscar(int valor) {
			
			 if(Noraiz != null) {
				 return buscaAvan(Noraiz , new Node(valor));
				}
			 return null;
		 }
			private Node buscaAvan(Node no1 , Node no)	{ 
				 if(no1 == null) {
					 return null ;
					 //System.out.println("Árvore :"+no.value);
				 }
				 if(no1.value == no.value) {
					 
					return no1 ; 
				 }
				 else  {
					Node retornaNo = buscaAvan(no1.esquerda , no);
					if(retornaNo == null) {
						retornaNo = buscaAvan(no1.direita , no);
				 }
					return retornaNo;
			   }
			
			 }
		 
		public  boolean Remover (int valor) {
			
			Node Nobuscado = buscar(valor);
			
			if(Nobuscado != null) {
				if(Nobuscado.esquerda == null && Nobuscado.direita == null) {
					RemoveCaso1(Nobuscado);
					
				}
			else if(Nobuscado.esquerda != null && Nobuscado.direita !=  null) {
				RemoveCaso3(Nobuscado);
				
			}
			else if(Nobuscado.esquerda != null) {
				RemoveCaso2(Nobuscado);
				
			}
			else if(Nobuscado.direita !=null) {
				RemoveCaso2(Nobuscado);
				
			}else {
				
			}
			}
			return false;
			
		}
		
		private void RemoveCaso1(Node nobuscado) {
			if (nobuscado.pai.esquerda == nobuscado) {
				nobuscado.pai.esquerda = null;
			} else if (nobuscado.pai.direita == nobuscado)
				nobuscado.pai.direita = null;
		}

		private  void RemoveCaso2(Node nobuscado) {
			if (nobuscado.pai.esquerda == nobuscado) {
				if (nobuscado.esquerda != null) {
					nobuscado.pai.esquerda = nobuscado.esquerda;
				} else if (nobuscado.direita != null) {
					nobuscado.pai.esquerda = nobuscado.direita;
				}
			} else if (nobuscado.pai.direita == nobuscado) {
				if (nobuscado.esquerda != null) {
					nobuscado.pai.direita = nobuscado.esquerda;
				} else if (nobuscado.direita != null) {
					nobuscado.pai.direita = nobuscado.direita;
				}
			}
		}

		private  void RemoveCaso3(Node nobuscado) {
			Node menorValor = menorValorEsquerda(nobuscado.direita);
		  
		RemoveCaso2(menorValor);
		menorValor.pai = nobuscado.pai;
		menorValor.esquerda = nobuscado.esquerda;
		menorValor.direita = nobuscado.direita;
		
		if(nobuscado.pai.esquerda == nobuscado) {
			menorValor.pai = nobuscado.pai;
			menorValor.esquerda = nobuscado.esquerda;
			menorValor.direita = nobuscado.direita;
			
			nobuscado.pai.esquerda = menorValor;
			
		}
		else if(nobuscado.pai.direita == nobuscado) {
			menorValor.pai = nobuscado.pai;
			menorValor.esquerda = nobuscado.esquerda;
			menorValor.direita = nobuscado.direita;
			
			nobuscado.pai.direita = menorValor;
			}
		}
		
		private static Node menorValorEsquerda(Node no) {
			if(no.esquerda == null) {
				return no;
			}
			return menorValorEsquerda(no.esquerda);
		}
}
