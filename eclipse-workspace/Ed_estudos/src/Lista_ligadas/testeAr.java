package Lista_ligadas;

public class testeAr {
	public class No {
	No esquerda;
    No direita;
    int valor;
    public No(int valor) {
        this.valor = valor;
    }
}
	

public void inserir(No node, int valor) {
  
     if (node != null) {
   
      if (valor < node.valor) {
    
          if (node.esquerda != null) {
              inserir(node.esquerda, valor);
          } else {
              
              System.out.println("  Inserindo " + valor + " a esquerda de " + node.valor);
              node.esquerda = new No(valor);
          }
     
      } else if (valor > node.valor) {
         
          if (node.direita != null) {
              inserir(node.direita, valor);
          } else {
            
              System.out.println("  Inserindo " + valor + " a direita de " + node.valor);
              node.direita = new No(valor);
          }
      }
    }
}
public static void main(String[] args) {
	testeAr btree = new testeAr();
	
	
	btree.inserir();
}
}

