package ArvoreB;

public class BTree{
	static int order; 
	NodeBtree NoRaiz; 

public BTree(int order){
		this.order = order;

		NoRaiz = new NodeBtree(order, null);

	}

public void split(NodeBtree Norecebido, int i, NodeBtree y){
		NodeBtree NovoNodaSepracao = new NodeBtree(order,null);

		NovoNodaSepracao.SeEfolha = y.SeEfolha;

		NovoNodaSepracao.qtdchaveCount = order - 1;

		for(int j = 0; j < order - 1; j++){
			NovoNodaSepracao.ChaveNo[j] = y.ChaveNo[j+order]; 

		}
		if(!y.SeEfolha){
			for(int k = 0; k < order; k++){
				NovoNodaSepracao.FilhoBtree[k] = y.FilhoBtree[k+order];
			}
		}
		y.qtdchaveCount = order - 1; 

		for(int j = Norecebido.qtdchaveCount ; j> i ; j--){				

			Norecebido.FilhoBtree[j+1] = Norecebido.FilhoBtree[j]; 

		}
		Norecebido.FilhoBtree[i+1] = NovoNodaSepracao;
		for(int j = Norecebido.qtdchaveCount; j> i; j--){
			Norecebido.ChaveNo[j + 1] = Norecebido.ChaveNo[j]; 
		}
		Norecebido.ChaveNo[i] = y.ChaveNo[order-1];
		y.ChaveNo[order-1 ] = 0; 
				for(int j = 0; j < order - 1; j++){
			y.ChaveNo[j + order] = 0;
		}
		Norecebido.qtdchaveCount ++;  
	}



	public void inserirNoNvazio(NodeBtree x, int key){
		int i = x.qtdchaveCount; 
		if(x.SeEfolha){
			while(i >= 1 && key < x.ChaveNo[i-1])
			{
				x.ChaveNo[i] = x.ChaveNo[i-1];
				i--;
			}	x.ChaveNo[i] = key;
			x.qtdchaveCount ++; 
		}
		else{
			int j = 0;
			while(j < x.qtdchaveCount  && key > x.ChaveNo[j]){			           		
				j++;
			}
			if(x.FilhoBtree[j].qtdchaveCount == order*2 - 1){
				split(x,j,x.FilhoBtree[j]);

				if(key > x.ChaveNo[j]){
					j++;
				}
			}

			inserirNoNvazio(x.FilhoBtree[j],key);
		}
	}


	public void insert(BTree t, int key)
	{
		NodeBtree r = t.NoRaiz;
		if(r.qtdchaveCount == 2*order - 1){
			NodeBtree s = new NodeBtree(order,null);
			t.NoRaiz = s;   
			s.SeEfolha = false;
			s.qtdchaveCount = 0;  
			s.FilhoBtree[0] = r;
			split(s,0,r);
			inserirNoNvazio(s, key); 
		}
		else
			inserirNoNvazio(r,key);
	}

  public void ExibirBtree(NodeBtree n){
		for(int i = 0; i < n.qtdchaveCount; i++){//valor do No
			System.out.print(n.getValorDoNo(i)+" " );
		}
		//raiz não é folha;
		if(!n.SeEfolha){
				for(int j = 0; j <= n.qtdchaveCount  ; j++)	{				  
				if(n.getNofilho(j) != null){			  
				System.out.println();
				ExibirBtree(n.getNofilho(j));  
				}
			}
		}
	}



	






}
