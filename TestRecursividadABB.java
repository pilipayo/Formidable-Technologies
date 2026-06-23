package ABB;
public class TestRecursividadABB {
    public static void main(String[] args) {

        ABBEnteros abb = new ABBEnterosImpl();

        int profundidad = 0;

        try {
            for (int i = 1; i <= 50000; i++) {
                abb.agregar(i);
                profundidad++;
            }

        } catch (StackOverflowError e) {
            System.out.println(
                "StackOverflow en profundidad: " + profundidad
            );
        }

        System.out.println("Fin del programa");
    }
}