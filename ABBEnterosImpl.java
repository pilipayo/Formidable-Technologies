package ABB;

public class ABBEnterosImpl implements ABBEnteros {
    private Nodo raiz;

    @Override
    //Ejercicio 1: Incercion recursiva
    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo actual, int valor) {
            if (actual == null) {
                return new Nodo(valor);
            }
            if (valor < actual.valor) {
                actual.izquierdo = agregarRecursivo(actual.izquierdo, valor);
            } else if (valor > actual.valor) {
                actual.derecho = agregarRecursivo(actual.derecho, valor);
            }
            return actual;}

    // Ejercicio 2: Insercion iterativa
    public void agregarIterativo(int valor) {
    if (raiz == null) {
        raiz = new Nodo(valor);
        return;
    }

    Nodo actual = raiz;

    while (true) {
        if (valor < actual.valor) {
            if (actual.izquierdo == null) {
                actual.izquierdo = new Nodo(valor);
                return;
            }
            actual = actual.izquierdo;
        } else if (valor > actual.valor) {
            if (actual.derecho == null) {
                actual.derecho = new Nodo(valor);
                return;
            }
            actual = actual.derecho;
        } else {
            return;
        }
    }
}

// Ejercicio 3: Busqueda
    @Override
    public boolean contiene(int valor) {
        return contieneRecursivo(raiz, valor);
    }

    private boolean contieneRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return false;
        }

        if (valor == actual.valor) {
            return true;
        }

        if (valor < actual.valor) {
            return contieneRecursivo(actual.izquierdo, valor);
        } else {
            return contieneRecursivo(actual.derecho, valor);
        }
    }
// Ejercicio 6: Eliminacion
    @Override
    public boolean eliminar(int valor) {
        if (!contiene(valor)) {
            return false;
        }

        raiz = eliminarRecursivo(raiz, valor);
        return true;
    }

    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return null;
        }

        if (valor < actual.valor) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = eliminarRecursivo(actual.derecho, valor);
        } else {
            if (actual.esHoja()) {
                return null;
            }

            if (actual.izquierdo == null) {
                return actual.derecho;
            }

            if (actual.derecho == null) {
                return actual.izquierdo;
            }

            Nodo sucesor = minimoRecursivo(actual.derecho);
            actual.valor = sucesor.valor;
            actual.derecho = eliminarRecursivo(actual.derecho, sucesor.valor);
        }

        return actual;
    }

    @Override
    public int cantidad() {
        return cantidadRecursivo(raiz);
    }

    private int cantidadRecursivo(Nodo actual) {
        if (actual == null) {
            return 0;
        }

        return 1 + cantidadRecursivo(actual.izquierdo)
                + cantidadRecursivo(actual.derecho);
    }

    // Ejercicio 4: Estadisticas del arbol
    @Override
    public int altura() {
        return alturaRecursivo(raiz);
    }

    private int alturaRecursivo(Nodo actual) {
        if (actual == null) {
            return 0;
        }

        int alturaIzquierda = alturaRecursivo(actual.izquierdo);
        int alturaDerecha = alturaRecursivo(actual.derecho);

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    @Override
    public int minimo() {
        if (raiz == null) {
            throw new IllegalStateException("El árbol está vacío");
        }

        return minimoRecursivo(raiz).valor;
    }

    private Nodo minimoRecursivo(Nodo actual) {
        if (actual.izquierdo == null) {
            return actual;
        }

        return minimoRecursivo(actual.izquierdo);
    }

    @Override
    public int maximo() {
        if (raiz == null) {
            throw new IllegalStateException("El árbol está vacío");
        }

        return maximoRecursivo(raiz).valor;
    }

    private Nodo maximoRecursivo(Nodo actual) {
        if (actual.derecho == null) {
            return actual;
        }

        return maximoRecursivo(actual.derecho);
    }
// Ejercicio 5: Recorridos
    @Override
    public void mostrarInOrden() {
        mostrarInOrdenRecursivo(raiz);
    }

    private void mostrarInOrdenRecursivo(Nodo actual) {
        if (actual != null) {
            mostrarInOrdenRecursivo(actual.izquierdo);
            System.out.print(actual.valor + " ");
            mostrarInOrdenRecursivo(actual.derecho);
        }
    }

    @Override
    public void mostrarPreOrden() {
        mostrarPreOrdenRecursivo(raiz);
    }

    private void mostrarPreOrdenRecursivo(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.valor + " ");
            mostrarPreOrdenRecursivo(actual.izquierdo);
            mostrarPreOrdenRecursivo(actual.derecho);
        }
    }

    @Override
    public void mostrarPostOrden() {
        mostrarPostOrdenRecursivo(raiz);
    }

    private void mostrarPostOrdenRecursivo(Nodo actual) {
        if (actual != null) {
            mostrarPostOrdenRecursivo(actual.izquierdo);
            mostrarPostOrdenRecursivo(actual.derecho);
            System.out.print(actual.valor + " ");
        }
    }
    // Ejercicio 7: Validacion de Rango en ABB
    public boolean enRango(int desde, int hasta) {
        return enRangoRecursivo(raiz, desde, hasta);
    }

    private boolean enRangoRecursivo(Nodo actual, int desde, int hasta) {
        if (actual == null) {
            return true;
        }

        if (actual.valor < desde || actual.valor > hasta) {
            return false;
        }

        return enRangoRecursivo(actual.izquierdo, desde, hasta)
                && enRangoRecursivo(actual.derecho, desde, hasta);
    }
    public ABBEnterosImpl interseccion(ABBEnterosImpl otro) {
        ABBEnterosImpl resultado = new ABBEnterosImpl();
        cargarInterseccionRecursivo(this.raiz, otro, resultado);
        return resultado;
    }

    private void cargarInterseccionRecursivo(Nodo actual, ABBEnterosImpl otro, ABBEnterosImpl resultado) {
        if (actual == null) {
            return;
        }

        cargarInterseccionRecursivo(actual.izquierdo, otro, resultado);

        if (otro.contiene(actual.valor)) {
            resultado.agregar(actual.valor);
        }

        cargarInterseccionRecursivo(actual.derecho, otro, resultado);
    }
}
