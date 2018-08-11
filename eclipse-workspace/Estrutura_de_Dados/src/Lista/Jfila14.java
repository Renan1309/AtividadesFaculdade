package Lista;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Jfila14 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int q ;
		int e ;
		 String line ;
		
		q = sc.nextInt();
		int id [] = new int [q];
		
		
		for (int i = 0; i < id.length; i++) {
		
			id[i]= sc.nextInt();
			}
		
		//int ex = sc.nextInt();
		//int pa [] = new int [ex];
		
		  HashSet<Integer> gone = new HashSet<>();
		  int ex = sc.nextInt();
	      //String line =sc.nextLine();
	      
	      //os numeros
	     
	      line = sc.nextLine();
	       String [] s = line.split(" ");
	       for (int i = 0; i < ex; i++) {
	            gone.add(Integer.parseInt(s[i]));
	        }
	      
		int gg= q -ex;
		
	  int count = 0;
    
      for (int i = 0; i < ex; i++) {
          if (gone.contains(id[i])) {
              continue;
          }
          count++;
          if (count == gg) {
              System.out.println(id[i]+"\n");
              break;
          }
          System.out.println(id[i] + " ");
      }
		
	}
	}


/**
 * if (id[i] == pa[j]) {
					  break;
					} else if (j == (pa.length - 1)) {
					  System.out.print(id[i]+" ");
					}
					/**/