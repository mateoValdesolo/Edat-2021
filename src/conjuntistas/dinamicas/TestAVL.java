package conjuntistas.dinamicas;

public class TestAVL {
    
    public static void main(String[] args) {
        ArbolAVL arb1 = new ArbolAVL(), arb2 = new ArbolAVL();

        arb1.insertar(4);
        arb1.insertar(2);
        arb1.insertar(8);
        arb1.insertar(6);
        arb1.insertar(10);
        System.out.println(arb1.toString());
        System.out.println("Inserto el 5: ");
        arb1.insertar(5);
        System.out.println(arb1.toString());

        arb2.insertar(16);
        arb2.insertar(10);
        arb2.insertar(24);
        arb2.insertar(7);
        arb2.insertar(18);
        arb2.insertar(26);
        arb2.insertar(22);
        System.out.println(arb2.toString());
        System.out.println("Inserto el 20: ");
        arb2.insertar(20);
        System.out.println(arb2.toString());
    }
}
