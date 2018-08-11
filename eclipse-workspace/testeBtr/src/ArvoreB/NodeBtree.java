package ArvoreB;

public class NodeBtree{
	static int tamanho;  

	int qtdchaveCount ;
	int ChaveNo[] ;  
	boolean SeEfolha;
	NodeBtree FilhoBtree[]; NodeBtree PaidaFolha;  



	public NodeBtree()  {
		
}
	public NodeBtree(int tamanho, NodeBtree parent) {
		this.tamanho = tamanho; 
		this.PaidaFolha = parent; 
		ChaveNo = new int[2 * tamanho - 1]; 
		FilhoBtree = new NodeBtree[2 * tamanho]; 
		SeEfolha = true;
		qtdchaveCount = 0; 
	}

	public int getValorDoNo(int valorRecebido){
		return ChaveNo[valorRecebido];
	}


	public NodeBtree getNofilho(int value){
		return FilhoBtree[value];
	}


}