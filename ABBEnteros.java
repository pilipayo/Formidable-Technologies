package ABB;
/**
 * Árbol Binario de Búsqueda (ABB) que almacena valores enteros.
 *
 * Para cada nodo:
 * <ul>
 * <li>Los valores del subárbol izquierdo son menores que el valor del
 * nodo.</li>
 * <li>Los valores del subárbol derecho son mayores que el valor del nodo.</li>
 * </ul>
 */
public interface ABBEnteros {

    /**
     * Inserta un valor en el árbol.
     * Si el valor ya existe la operación no tiene efecto.
     * @param valor valor a insertar.
     */
    void agregar(int valor);

    /**
     * Determina si un valor se encuentra almacenado en el árbol.
     *
     * @param valor valor a buscar.
     * @return {@code true} si el valor está presente;
     *         {@code false} en caso contrario.
     */
    boolean contiene(int valor);

    /**
     * Elimina un valor del árbol si se encuentra presente.
     *
     * @param valor valor a eliminar.
     * @return {@code true} si el valor fue eliminado;
     *         {@code false} si el valor no estaba en el árbol.
     */
    boolean eliminar(int valor);

    /**
     * Devuelve la cantidad de nodos almacenados en el árbol.
     *
     * @return cantidad de nodos.
     */
    int cantidad();

    /**
     * Devuelve la altura del árbol.
     *
     * Se considera que:
     * <ul>
     * <li>La altura de un árbol vacío es 0.</li>
     * <li>La altura de un árbol formado únicamente por la raíz es 1.</li>
     * </ul>
     *
     * @return altura del árbol.
     */
    int altura();

    /**
     * Devuelve el menor valor almacenado en el árbol.
     *
     * @return valor mínimo.
     * @throws IllegalStateException si el árbol está vacío.
     */
    int minimo();

    /**
     * Devuelve el mayor valor almacenado en el árbol.
     *
     * @return valor máximo.
     * @throws IllegalStateException si el árbol está vacío.
     */
    int maximo();

    /**
     * Imprime los elementos del árbol en inorden
     * (izquierdo, raíz, derecho).
     */
    void mostrarInOrden();

    /**
     * Imprime los elementos del árbol en preorden
     * (raíz, izquierdo, derecho).
     */
    void mostrarPreOrden();

    /**
     * Imprime los elementos del árbol en posorden
     * (izquierdo, derecho, raíz).
     */
    void mostrarPostOrden();
}