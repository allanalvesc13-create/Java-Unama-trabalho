public class ListaSimples {
    private No inicio;
    private int tamanho;

    public ListaSimples() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public void inserirNoInicio(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio = novoNo;
        }
        tamanho++;
        System.out.println("Inserido " + valor + " no início da lista.");
    }

    public void inserirNoFim(int valor) {
        No novoNo = new No(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
        System.out.println("Inserido " + valor + " no fim da lista.");
    }

    public void inserirNaPosicao(int valor, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        if (posicao == 0) {
            inserirNoInicio(valor);
            return;
        }
        No novoNo = new No(valor);
        No atual = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
        tamanho++;
        System.out.println("Inserido " + valor + " na posição " + posicao + ".");
    }

    public void removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        if (posicao == 0) {
            int valorRemovido = inicio.valor;
            inicio = inicio.proximo;
            tamanho--;
            System.out.println("Removido " + valorRemovido + " do início da lista.");
            return;
        }
        No atual = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
        int valorRemovido = atual.proximo.valor;
        atual.proximo = atual.proximo.proximo;
        tamanho--;
        System.out.println("Removido " + valorRemovido + " da posição " + posicao + ".");
    }
    public void removerDoFim() {
        if (tamanho == 0) {
            System.out.println("Lista vazia. Nada para remover.");
            return;
        }
        if (tamanho == 1) {
            int valorRemovido = inicio.valor;
            inicio = null;
            tamanho--;
            System.out.println("Removido " + valorRemovido + " do fim da lista.");
            return;
        }
        No atual = inicio;
        while (atual.proximo.proximo != null) {
            atual = atual.proximo;
        }
        int valorRemovido = atual.proximo.valor;
        atual.proximo = null;
        tamanho--;
        System.out.println("Removido " + valorRemovido + " do fim da lista.");
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }
        No atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
    public int getTamanho() {
        return tamanho;
    }

}