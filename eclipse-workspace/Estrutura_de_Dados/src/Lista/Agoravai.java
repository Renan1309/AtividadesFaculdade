package Lista;


	import java.util.Scanner;

	public class Agoravai {

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int q ;
			int e ;
			
			q = sc.nextInt();
			int id [] = new int [q];
			
			
			for (int i = 0; i < id.length; i++) {
			
				id[i]= sc.nextInt();
				}
			
			int ex = sc.nextInt();
			int pa [] = new int [ex];
			
			
			
			for (int i = 0; i < pa.length; i++) {
				pa[i]= sc.nextInt();
				}
			
			for (int i = 0; i < id.length; i++) {
			
				for (int j = 0; j < pa.length; j++) {
					if (id[i] == pa[j]) {
						  break;
						} else if (j == (pa.length - 1)) {
						  System.out.print(id[i]+" ");
						}
				
				
			
		}
		}
		}

	}

	

