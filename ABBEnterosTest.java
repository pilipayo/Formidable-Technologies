package ABB;

public class ABBEnterosTest {

    public static void main(String[] args) {

        testArbolVacio();
        testAgregarYContiene();
        testCantidad();
        testAltura();
        testMinimoMaximo();
        testEliminacionHoja();
        testEliminacionUnHijo();
        testEliminacionDosHijos();
        testEliminacionRaiz();
        testEliminacionInexistente();
        testDuplicados();

        System.out.println("\nTODOS LOS TESTS PASARON OK");
    }

    // -------------------------
    // TESTS
    // -------------------------

    static void testArbolVacio() {
        ABBEnteros abb = new ABBEnterosImpl();

        assert abb.cantidad() == 0 : "Cantidad inicial debe ser 0";
        assert abb.altura() == 0 : "Altura inicial debe ser 0";

        System.out.println("testArbolVacio OK");
    }

    static void testAgregarYContiene() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(10);
        abb.agregar(5);
        abb.agregar(15);

        assert abb.contiene(10);
        assert abb.contiene(5);
        assert abb.contiene(15);
        assert !abb.contiene(99);

        System.out.println("testAgregarYContiene OK");
    }

    static void testCantidad() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(8);
        abb.agregar(3);
        abb.agregar(10);

        assert abb.cantidad() == 3 : "Cantidad debe ser 3";

        System.out.println("testCantidad OK");
    }

    static void testAltura() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(1);
        abb.agregar(2);
        abb.agregar(3);

        assert abb.altura() == 3 : "Altura de lista degenerada debe ser 3";

        System.out.println("testAltura OK");
    }

    static void testMinimoMaximo() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(8);
        abb.agregar(3);
        abb.agregar(10);
        abb.agregar(1);
        abb.agregar(14);

        assert abb.minimo() == 1;
        assert abb.maximo() == 14;

        System.out.println("testMinimoMaximo OK");
    }

    static void testEliminacionHoja() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(8);
        abb.agregar(3);
        abb.agregar(10);

        assert abb.eliminar(3);

        assert !abb.contiene(3);
        assert abb.cantidad() == 2;

        System.out.println("testEliminacionHoja OK");
    }

    static void testEliminacionUnHijo() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(8);
        abb.agregar(3);
        abb.agregar(1);

        assert abb.eliminar(3);

        assert !abb.contiene(3);
        assert abb.contiene(1);

        System.out.println("testEliminacionUnHijo OK");
    }

    static void testEliminacionDosHijos() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(8);
        abb.agregar(3);
        abb.agregar(1);
        abb.agregar(6);
        abb.agregar(4);
        abb.agregar(7);

        assert abb.eliminar(3);

        assert !abb.contiene(3);
        assert abb.contiene(1);
        assert abb.contiene(4);
        assert abb.contiene(6);
        assert abb.contiene(7);

        System.out.println("testEliminacionDosHijos OK");
    }

    static void testEliminacionRaiz() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(8);
        abb.agregar(3);
        abb.agregar(10);

        assert abb.eliminar(8);

        assert !abb.contiene(8);
        assert abb.cantidad() == 2;

        System.out.println("testEliminacionRaiz OK");
    }

    static void testEliminacionInexistente() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(5);

        assert !abb.eliminar(99);
        assert abb.cantidad() == 1;

        System.out.println("testEliminacionInexistente OK");
    }

    static void testDuplicados() {
        ABBEnteros abb = new ABBEnterosImpl();

        abb.agregar(5);
        abb.agregar(5);
        abb.agregar(5);

        assert abb.cantidad() == 1 : "No debe permitir duplicados";

        System.out.println("testDuplicados OK");
    }
}