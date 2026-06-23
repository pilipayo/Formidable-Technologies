package ABB;

public class Nodo {

    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int valor) {
        this.valor = valor;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}