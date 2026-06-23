package ABB;

public class Test2 {
    public static void main(String[] args) {
    ABBEnterosImpl abb = new ABBEnterosImpl();
    abb.agregar(8);
    abb.agregar(3);
    abb.agregar(10);
    abb.agregar(1);
    abb.agregar(6);
    abb.agregar(14);
    abb.agregar(4);
    abb.agregar(7);
    abb.agregar(13);

    System.out.println("Inorden:");
    abb.mostrarInOrden();
    System.out.println("\nPreorden:");
    abb.mostrarPreOrden();
    System.out.println("\nPostorden:");
    abb.mostrarPostOrden();

    System.out.println("\nCantidad: " + abb.cantidad());
    System.out.println("\nAltura: " + abb.altura());
    System.out.println("\nMínimo: " + abb.minimo());
    System.out.println("\nMáximo: " + abb.maximo());
    System.out.println("\nContiene 7: " + abb.contiene(7));
    System.out.println("\nEn rango [1,14]: " + abb.enRango(1, 14));
    System.out.println("\nEn rango [2,14]: " + abb.enRango(2, 14));

    abb.eliminar(3);
    System.out.println("\nLuego de eliminar 3:");
    abb.mostrarInOrden();

    ConjuntoABB a = new ConjuntoABB();
    a.agregar(1);
    a.agregar(2);
    a.agregar(3);

    ConjuntoABB b = new ConjuntoABB();
    b.agregar(2);
    b.agregar(3);
    b.agregar(4);

    System.out.println("\nIntersección de conjuntos:");
    a.interseccion(b).mostrar();

    IndicePalabras indice = new IndicePalabras();
    indice.agregarTexto("casa árbol casa río árbol árbol");
    System.out.println("Índice de palabras:");
    indice.mostrarInOrden();
}
}

