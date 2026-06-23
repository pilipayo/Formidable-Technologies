package ABB;

public class NodoPalabra {
    String palabra;
    int cantidadDeApariciones;
    NodoPalabra izquierdo;
    NodoPalabra derecho;

    public NodoPalabra(String palabra) {
        this.palabra = palabra;
        this.cantidadDeApariciones = 1;
    }
}