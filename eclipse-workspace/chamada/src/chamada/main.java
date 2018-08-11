package chamada;

import java.util.Arrays;
import java.util.Scanner;

 class main {

	public static void main(String[] args) {
		  Scanner sc = new Scanner ( System.in );
		  int entradas [] =new int [2];
		  for (int i = 0; i < entradas.length; i++) {
			entradas[i] = sc.nextInt(); 
		}
		 
		  String[] participantes = new String[entradas[0]];
		  
		  for (int i = 0; i < participantes.length; i++) {
			participantes[i] = sc.next();
		}
		  
		 
		 
		     Arrays.sort(participantes);
		     
		     
		     
		     System.out.println(participantes[entradas[1]-1]);
		    
	}
	
}
