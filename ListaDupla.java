class NoDuplo {
    int valor;
    NoDuplo proximo;
    NoDuplo anterior;

    public NoDuplo(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

public class ListaDupla {
    private NoDuplo inicio;
    private NoDuplo fim;
    private int tamanho;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserirNoInicio(int valor) {
        NoDuplo novoNo = new NoDuplo(valor);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
        tamanho++;
        System.out.println("Inserido " + valor + " no início da lista.");
    }

    public void inserirNoFim(int valor) {
        NoDuplo novoNo = new NoDuplo(valor);
        if (fim == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
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
        if (posicao == tamanho) {
            inserirNoFim(valor);
            return;
        }
        NoDuplo novoNo = new NoDuplo(valor);
        NoDuplo atual = inicio;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
        novoNo.proximo = atual.proximo;
        novoNo.anterior = atual;
        atual.proximo.anterior = novoNo;
        atual.proximo = novoNo;
        tamanho++;
        System.out.println("Inserido " + valor + " na posição " + posicao + ".");
    }

    public void removerDoInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia. Nada para remover.");
            return;
        }
        int valorRemovido = inicio.valor;
        inicio = inicio.proximo;
        if (inicio != null) {
            inicio.anterior = null;
        } else {
            fim = null;
        }
        tamanho--;
        System.out.println("Removido " + valorRemovido + " do início da lista.");
    }

    public void removerDoFim() {
        if (fim == null) {
            System.out.println("Lista vazia. Nada para remover.");
            return;
        }
        int valorRemovido = fim.valor;
        fim = fim.anterior;
        if (fim != null) {
            fim.proximo = null;
        } else {
            inicio = null;
        }
        tamanho--;
        System.out.println("Removido " + valorRemovido + " do fim da lista.");
    }

    public void removerDaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição inválida.");
            return;
        }
        if (posicao == 0) {
            removerDoInicio();
            return;
        }
        if (posicao == tamanho - 1) {
            removerDoFim();
            return;
        }
        NoDuplo atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        int valorRemovido = atual.valor;
        atual.anterior.proximo = atual.proximo;
        atual.proximo.anterior = atual.anterior;
        tamanho--;
        System.out.println("Removido " + valorRemovido + " da posição " + posicao + ".");
    }

    public int tamanho() {
        return tamanho;
    }

    public void exibir() {
        if (inicio == null) {
            System.out.println("Lista vazia.");
            return;
        }
        NoDuplo atual = inicio;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void exibirReverso() {
        if (fim == null) {
            System.out.println("Lista vazia.");
            return;
        }
        NoDuplo atual = fim;
        System.out.print("Lista reversa: ");
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }
}