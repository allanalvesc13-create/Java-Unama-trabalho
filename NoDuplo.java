public class NoDuplo {
    public int valor;
    public NoDuplo proximo;
    public NoDuplo anterior;

    public NoDuplo(int valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}