package ABB;

//Ejercicio 8: Implementar un Conjunto usando ABB

public class ConjuntoABB {
    private ABBEnterosImpl abb;

    public ConjuntoABB() {
        abb = new ABBEnterosImpl();
    }

    public void agregar(int valor) {
        abb.agregar(valor);
    }

    public boolean eliminar(int valor) {
        return abb.eliminar(valor);
    }

    public boolean contiene(int valor) {
        return abb.contiene(valor);
    }

    public int cantidad() {
        return abb.cantidad();
    }

    public int elegir() {
        if (cantidad() == 0) {
            throw new IllegalStateException("El conjunto está vacío");
        }

        return abb.minimo();
    }

    public ConjuntoABB interseccion(ConjuntoABB conjunto) {
        ConjuntoABB resultado = new ConjuntoABB();
        resultado.abb = this.abb.interseccion(conjunto.abb);
        return resultado;
    }

    public void mostrar() {
        abb.mostrarInOrden();
    }
}
