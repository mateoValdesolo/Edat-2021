package jerarquicas;

public class TestArbol {

    public static void main(String[] args) {
        ArbolBin arb1 = new ArbolBin();
        arb1.insertar('A', 'A', 'I');
        arb1.insertar('B', 'A', 'I');
        arb1.insertar('C', 'A', 'D');
        arb1.insertar('D', 'B', 'I');
        arb1.insertar('E', 'C', 'I');
        arb1.insertar('F', 'C', 'D');
        arb1.insertar('G', 'E', 'I');
        arb1.insertar('H', 'E', 'D');
        System.out.println(arb1.listarPorNiveles());
        System.out.println(arb1.esVacio());
        System.out.println(arb1.altura());
        System.out.println(arb1.padre('F'));
        //arb1.vaciar();
        System.out.println(arb1.nivel('D'));
        System.out.println(arb1.listarInorden());
        System.out.println(arb1.toString());
        ArbolBin arb2 =  new ArbolBin();
        arb2 = arb1.clone();
        arb2.insertar('J', 'H', 'I');
        arb1.insertar('X', 'H', 'I');
        System.out.println(arb1.listarPorNiveles());
        System.out.println(arb2.listarPorNiveles());
        System.out.println(arb1.padre('H'));
    }
}
