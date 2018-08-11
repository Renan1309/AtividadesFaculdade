package Lista;

import java.util.Scanner;

public class Original {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String line = sc.next();
        int qtdpessoa = Integer.parseInt(line);
        
        String [] idpessoa = new String[qtdpessoa];
        
        for (int i = 0; i < idpessoa.length; i++) {
        	
           idpessoa[i] =sc.next();
        }
        
        int nexclui = sc.nextInt();
        StringBuilder nome = new StringBuilder();
        
        for (int i = 0; i < nexclui; i++) {
			nome.append(sc.next());
		}
        
      
        
        for (int j = 0; j < idpessoa.length; j++) {
			int op =nome.indexOf(idpessoa[j]);
        	if(op !=-1) {
        		continue;
        	}else {
        		 System.out.print(idpessoa[j] + " ");
        	}
        	
        	
		}
       
        
	}
	


}