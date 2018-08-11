
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	//Renan Alexandre e Cesar Augusto
	
	public static void main(String[] args) throws IOException {
		
		 BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
         //array para entrada com tamanho indeterminado
         String [] ArrayDeentradaDinamica = sc.readLine().split(" ");
		 
		    
		//converter para array de int , para realizar o merge
	        int [] ArrayPrincipalDoMerge = new int [ArrayDeentradaDinamica.length];
	        for (int i = 0; i < ArrayDeentradaDinamica.length; i++) {
	        	ArrayPrincipalDoMerge[i] = Integer.parseInt(ArrayDeentradaDinamica[i]);
	        }
		   
			int []arraySuporte = new int [ArrayPrincipalDoMerge.length];
			
			mergeSort(ArrayPrincipalDoMerge,arraySuporte,0,ArrayPrincipalDoMerge.length-1);
	
		for (int i = 0; i < ArrayPrincipalDoMerge.length; i++) {
			System.out.print(ArrayPrincipalDoMerge[i] + " ");
		}
	}
	
	private static void mergeSort(int[] Aprincipal, int[] Asuporte, int inicio, int fim) {
		if (inicio<fim){
			int meio = (inicio+fim)/2;
			mergeSort(Aprincipal,Asuporte,inicio,meio);
			mergeSort(Aprincipal,Asuporte,meio+1,fim);
			intercalarMergeSort(Aprincipal,Asuporte,inicio,meio,fim);
		}
	}
	
	private static void intercalarMergeSort (int[] Aprincipal, int[] Asuporte, int inicio, int meio, int fim){
		
		
		for (int variavelsuporte = inicio; variavelsuporte <= fim; variavelsuporte++) {
			
			Asuporte[variavelsuporte] = Aprincipal[variavelsuporte];
		}
		
		
		int ini = inicio;
		int mei = meio+1;
		
		
		for(int i =inicio; i<=fim; i++){
			
			   if(ini > meio) Aprincipal[i] = Asuporte[mei++];
			
			   else if (mei > fim) Aprincipal[i] = Asuporte[ini++];
			
			   else if (Asuporte[ini] < Asuporte[mei]) Aprincipal[i] = Asuporte[ini++];
			
			   else Aprincipal[i] = Asuporte[mei++];
		}
	}

}