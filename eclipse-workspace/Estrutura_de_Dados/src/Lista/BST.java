package Lista;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BST {

    static class No {

        int valor;
        No esq;
        No dir;

        public No(int valor) {
            this.valor = valor;
            esq = null;
            dir = null;
        }
    }

    static class Arvore{

        public No raiz;
        public int count;

        public Arvore() {
            raiz = null;
            count = 0;
        }

        public void inserirRaiz(int x) {

            No aux = new No(x);
            raiz = aux;

        }

        public void inserir(int x, No n) {

            count++;

            if (x < n.valor) {
                if (n.esq == null) {
                    No esqNo = new No(x);
                    n.esq = esqNo;
                } else {
                    inserir(x, n.esq);

                }
            } else if (x > n.valor) {
                if (n.dir == null) {
                    No dirNo = new No(x);
                    n.dir = dirNo;
                } else {
                    inserir(x, n.dir);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        try {
            Arvore arvore = new Arvore();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int len = Integer.parseInt(in.readLine());

            for (int i = 0; i < len; i++) {

                String input = in.readLine();
                int x = Integer.parseInt(input);

                if (i == 0) {
                    arvore.inserirRaiz(x);
                } else {
                    No n;
                    arvore.inserir(x, arvore.raiz);
                }
                System.out.println(arvore.count);
            }
        }catch(Exception e){
            //System.out.println(err);
        }

    }

}