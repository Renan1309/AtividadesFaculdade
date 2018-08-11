import java.util.Scanner;

public class HeapMain {

	//RENAN ALEXANDRE && CESAR AUGUSTO
	
    
  public static void main(String[] args) {
	  Heapteste ArrayHeap = new Heapteste();
	  Scanner sc = new Scanner ( System.in );

	  while(sc.hasNextInt()) {
		  int number;
		  number = sc.nextInt();
		  ArrayHeap.insersao(number);
	  }
	
    
        
        for(int i = 0; i < ArrayHeap.inicio;i++){
            System.out.print(" "+ArrayHeap.vetor[i]);
        }
    }

}