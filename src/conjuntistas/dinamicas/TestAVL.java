package conjuntistas.dinamicas;

public class TestAVL {
    
    public static void main(String[] args) {
        ArbolAVL arb1 = new ArbolAVL();

        arb1.insertar(4);
        arb1.insertar(2);
        arb1.insertar(8);
        arb1.insertar(6);
        arb1.insertar(10);
        System.out.println(arb1.toString());
        System.out.println("Inserto el 5: ");
        arb1.insertar(5);
        System.out.println(arb1.toString());
        /*arb1.insertar('f');
        arb1.insertar('d');
        arb1.insertar('g');
        arb1.insertar('b');
        arb1.insertar('e');
        arb1.insertar('a');
        arb1.insertar('c');
        System.out.println(arb1.toString());*/

    }
}
