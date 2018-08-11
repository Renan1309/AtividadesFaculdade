

public class Arvoreb {
	StringBuilder builder = new StringBuilder();
	 
	No Noraiz;
	public  void inserirNo(No no ,int value) {
		No novoNo = new No(value);
		
		if(no == null) {
			Noraiz = novoNo;
			  System.out.println("Raiz "+Noraiz.value);
			  builder.append(Noraiz.value);
		}
		else {
			if(value  < no.value) {
			  if(no.esquerda != null) {
				  inserirNo(no.esquerda, value);
			  }else {
				  System.out.println("Inse / "+value+"a esq "+no.value);
				  builder.append("  /"+"/n" + no.value);
				  no.esquerda = new No(value);
				  no.esquerda.pai = no;
			  }
			
			}
			else {
				if(no.direita !=null) {
					inserirNo(no.direita , value);
					
				}else {
					System.out.println("Inse \\ "+value+"a dir "+no.value);
					builder.append("  \\"+"/n" + no.value);
					 no.direita= new No(value);
					 no.direita.pai= no;
				}
				
			}
			
			
			
		}
		
	}
	public  void inserir(int valor) {
        inserirNo(Noraiz, valor);
    }
	
        
	public  void inordem(No no) {
        if(no != null){
        	inordem(no.esquerda);
		System.out.println(no.value + " ");
        	inordem(no.direita);
        }
    }
	 public   No buscar(int valor) {
			
		 if(Noraiz != null) {
			 return buscaAvan(Noraiz , new No(valor));
			}
		 return null;
	 }
		private No buscaAvan(No no1 , No no)	{ 
			 if(no1 == null) {
				 return null ;
				 //System.out.println("Árvore :"+no.value);
			 }
			 if(no1.value == no.value) {
				 
				return no1 ; 
			 }
			 else   {
				No retornaNo = buscaAvan(no1.esquerda , no);
				if(retornaNo == null) {
					retornaNo = buscaAvan(no1.direita , no);
			 }
				return retornaNo;
		   }
		   
		 }
public  boolean Remover (int valor) {
			
			No Nobuscado = buscar(valor);
			
			if(Nobuscado != null) {
				if(Nobuscado.esquerda == null && Nobuscado.direita == null) {
					RemoveCaso1(Nobuscado);
					//RemoveCasoUmfilho(Nobuscado);
				}
			  else if(Nobuscado.esquerda != null && Nobuscado.direita !=  null) {
				//RemoveCaso4(Nobuscado);
				RemoveCasoteste(Nobuscado);
			}
			   else if(Nobuscado.esquerda != null) {
				   
				  RemoveCaso2(Nobuscado);
				   //RemoveCasoUmfilho(Nobuscado);
				
			}
			  else if(Nobuscado.direita !=null) {
				  RemoveCaso2(Nobuscado);
				 //RemoveCaso3(Nobuscado);
				  //RemoveCasoUmfilho(Nobuscado);
				
			}
			}
			return false;
			
			}

		private void RemoveCaso4(No nobuscado) {
	     No NoAntecessor = Antecessor(nobuscado.esquerda);
	   
	 	NoAntecessor.pai = nobuscado.pai;
		NoAntecessor.esquerda = nobuscado.esquerda;
		NoAntecessor.direita = nobuscado.direita;
		/**
		if (nobuscado.pai.direita.value == nobuscado.value) {
			NoAntecessor.pai = nobuscado.pai;
			NoAntecessor.esquerda = nobuscado.esquerda;
			NoAntecessor.direita = nobuscado.direita;

			nobuscado.pai.esquerda = NoAntecessor;
		
		}
	     
	**/
}
		private void RemoveCaso3(No nobuscado) {
			if (nobuscado.pai.direita.value == nobuscado.value) {
				nobuscado.pai.direita = nobuscado.direita;
			}
			else if(nobuscado.pai.esquerda.value == nobuscado.value) {
				nobuscado.pai.esquerda = nobuscado.direita;
			}
	
}
		private void RemoveCaso1(No nobuscado) {
			if (nobuscado.pai.esquerda.value == nobuscado.value) {
				nobuscado.pai.esquerda = null;
			} else if (nobuscado.pai.direita.value == nobuscado.value) {
				nobuscado.pai.direita = null;
			}
		}

	

		private void RemoveCaso2(No nobuscado) {
			if (nobuscado.pai.esquerda.value == nobuscado.value) {
				nobuscado.pai.esquerda = nobuscado.esquerda;
			}
			else if(nobuscado.pai.direita.value == nobuscado.value) {
				nobuscado.pai.direita = nobuscado.esquerda;
			}
			
	
}
		private No antecessor (No noAexcluir) {
			 No sucessor = noAexcluir;
				
			if(sucessor.esquerda == null) {
				noAexcluir.value = sucessor.value;
			//	q = sucessor;
				//sucessor = sucessor.direita
			}
			
			
			return antecessor(noAexcluir.direita);
	
		}
		public static No Antecessor(No no) {
			
			if(no.direita == null) {
				//menorValorEsquerda(no.direita);
				return no;
			}
			return Antecessor(no.direita);
		
			
			
		}

/**
private void RemoveCaso1(No nobuscado) {
	if (nobuscado.pai.esquerda.value == nobuscado.value) {
		nobuscado.pai.esquerda = null;
	} else if (nobuscado.pai.direita.value == nobuscado.value)
		nobuscado.pai.direita = null;
}
**/

private  void RemoveCasoUmfilho(No nobuscado) {
	if (nobuscado.pai.esquerda.value == nobuscado.value) {
		if (nobuscado.esquerda != null) {
			nobuscado.pai.esquerda = nobuscado.esquerda;
		} else if (nobuscado.direita != null) {
			nobuscado.pai.esquerda = nobuscado.direita;
		}
	} 
	else {
		if (nobuscado.pai.direita.value == nobuscado.value) {
          if (nobuscado.esquerda != null) {
			nobuscado.pai.direita = nobuscado.esquerda;
		} else if (nobuscado.direita != null) {
			nobuscado.pai.direita = nobuscado.direita;
		}
	}
	}
}


	private void RemoveCasoteste(No nobuscado) {
		No menorValor =Antecessor(nobuscado.esquerda);
       
		//RemoveCaso2(menorValor);
		menorValor.pai = nobuscado.pai;
		menorValor.esquerda = nobuscado.esquerda;
		menorValor.direita = nobuscado.direita;
		RemoveCasoUmfilho(menorValor);
		if(nobuscado.pai == null) {
			Noraiz = menorValor;
		}
		else {
		if (nobuscado.pai.esquerda.value == nobuscado.value) {
			menorValor.pai = nobuscado.pai;
			menorValor.esquerda = nobuscado.esquerda;
			menorValor.direita = nobuscado.direita;

			nobuscado.pai.esquerda = menorValor;

		} else if (nobuscado.pai.direita.value == nobuscado.value) {
			menorValor.pai = nobuscado.pai;
			menorValor.esquerda = nobuscado.esquerda;
			menorValor.direita = nobuscado.direita;

			nobuscado.pai.direita = menorValor;
		}
	}
	}
	public void prefixado(No no) {
        if(no != null){
            System.out.println("     /"+"\n"+no.value + " ");
            prefixado(no.esquerda);
            prefixado(no.direita);
	}
        else {
        	
        }
	}
	public void imprimir(No no) {
		
        if(no != null){
        	 System.out.println(no.value);
        	 System.out.println(no.esquerda);
        	 System.out.println(no.direita);
            prefixado(no.esquerda);
            prefixado(no.direita);
	}
	}
}
/**
	private static No menorValorEsquerda(No no) {
		if (no.esquerda == null) {
			return no;
		}
		return menorValorEsquerda(no.esquerda);
	}
}
	/**
	No Noraiz ;
	public  void inserir(int value) {
		No novoNo = new No(value);
		
		if(Noraiz == null) {
			Noraiz = novoNo;
			  System.out.println("Raiz "+Noraiz.value);
			 
		} InserirSub(Noraiz , novoNo);
	}
	
			
		

	private  void InserirSub(No no, No novoNo) {
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
	/*
	public void metodosPesquisa() {
		
		if(Noraiz != null) {
			No Nodocomecar = Noraiz;
			if (Nodocomecar.esquerda !=null) {
				inordem(Nodocomecar.esquerda);
			}else {
				System.out.println(Nodocomecar.value+" " +"No raiz não tem valor a Esq");
			}
		}
	}
	*/
	/**
	public  void inordem(No no) {
        if(no != null){
        	inordem(no.esquerda);
        }
		System.out.println(no.value + " ");
		if(no.direita!=null) {
        	inordem(no.direita);
        }System.out.println(no.value + " ");
}
**/

