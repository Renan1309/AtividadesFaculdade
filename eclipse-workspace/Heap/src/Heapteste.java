public class Heapteste {

public int[] vetor = new int[3000];
public int comeco = 0;
public int inicio = 0;

public int getPai(int i){
    return (i)/2;
}

public int getEsquerda(int i){
    return 2*i+1;
}

public int getDireita(int i){
    return 2*i+2;
}

public void insersao(int valor) {

    vetor[inicio] = valor;

    int i = inicio;
    int guardaOvalorParaAlocar;
    int pai;
    while(i > 0){
        pai = getPai(i);

  
        if(vetor[pai] < vetor[i]){
            guardaOvalorParaAlocar = vetor[pai];
            vetor[pai] = vetor[i];	
            vetor[i] = guardaOvalorParaAlocar;
        } else{
            break;
        }

        i = pai;

    }
    inicio++;
}

}
