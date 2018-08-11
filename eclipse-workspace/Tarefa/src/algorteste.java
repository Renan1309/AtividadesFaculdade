
public class algorteste {
	  public static void main(String[] args) {
	        // pegando as posicoes e os lugares validos para andar
		  int[] vetor1 = {1,2,3,4,5,6,7,8,9,10};
          int i = 0;
          int[] lista2 = new int[vetor1.length];
          while (vetor1.length < i) {

              lista2[i] = vetor1[i] + vetor1[i + 1];

              i++;
              for (int i1 = 0; i1 < lista2.length; i1++) {
                  System.out.println(lista2[i1]);
             
              }
          

      }  
	  }
}


