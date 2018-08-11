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
			
	          no.esquerda = new Node(value);
			  }
				
			}
			else {
				if(no.direita !=null) {
					inserirNo(no.direita , value);
					
				}else {
					
					
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
		
		
		int soma = sc.nextInt();
		criaArray(soma);
		
		if(soma >= 1 && soma <= 300000) {
		for (int i = 0; i < soma; i++) {
			int valor = sc.nextInt();
			
			 if (i == 0) {
                Raiz(valor);
                contadorRaiz(main.count);
              
         
             } else {
                 
                 inserirNo( Noraiz, valor);
                 contador(main.count);
               
         
         }
		
		
			
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
	//}
		
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
 
