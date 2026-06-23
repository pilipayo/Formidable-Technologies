package ABB;

//Ejercicio 9: Indice de Palabras

public class IndicePalabras{
    private NodoPalabra raiz;

    public void agregarPalabra(String palabra) {
        if (palabra == null) {
            return;
        }

        palabra = normalizar(palabra);

        if (palabra.isEmpty()) {
            return;
        }

        raiz = agregarPalabraRecursivo(raiz, palabra);
    }

    private NodoPalabra agregarPalabraRecursivo(NodoPalabra actual, String palabra) {
        if (actual == null) {
            return new NodoPalabra(palabra);
        }

        int comparacion = palabra.compareTo(actual.palabra);

        if (comparacion < 0) {
            actual.izquierdo = agregarPalabraRecursivo(actual.izquierdo, palabra);
        } else if (comparacion > 0) {
            actual.derecho = agregarPalabraRecursivo(actual.derecho, palabra);
        } else {
            actual.cantidadDeApariciones++;
        }

        return actual;
    }

    public void agregarTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            return;
        }

        String[] palabras = texto.split("\\s+");

        for (String palabra : palabras) {
            agregarPalabra(palabra);
        }
    }

    private String normalizar(String palabra) {
        return palabra
                .toLowerCase()
                .replaceAll("^[^a-záéíóúüñ]+|[^a-záéíóúüñ]+$", "");
    }

    public void mostrarInOrden() {
        mostrarInOrdenRecursivo(raiz);
    }

    private void mostrarInOrdenRecursivo(NodoPalabra actual) {
        if (actual == null) {
            return;
        }

        mostrarInOrdenRecursivo(actual.izquierdo);
        System.out.println(actual.palabra + " -> " + actual.cantidadDeApariciones);
        mostrarInOrdenRecursivo(actual.derecho);
    }
}