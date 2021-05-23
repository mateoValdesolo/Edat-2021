package conjuntistas;

public class TestArbolBB {

    public static void main(String[] args) {
        ArbolBB arb1 = new ArbolBB();
        arb1.insertar(41);
        arb1.insertar(5);
        arb1.insertar(8);
        arb1.insertar(9);
        arb1.insertar(17);
        arb1.insertar(19);
        arb1.insertar(23);
        arb1.insertar(32);
        arb1.insertar(1);
        arb1.insertar(43);
        arb1.insertar(53);
        arb1.insertar(56);
        arb1.insertar(64);
        arb1.insertar(72);
        arb1.insertar(80);
        System.out.println(arb1.listar());
        System.out.println(arb1.maximoElem());
        System.out.println(arb1.minimoElem());
        System.out.println(arb1.pertenece(26));
        System.out.println(arb1.toString());
        System.out.println(arb1.listarRango(8, 50));
    }
}
