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
        System.out.println(arb1.padre('H'));
        System.out.println(arb2.toString());
        System.out.println(arb2.altura());
        System.out.println(arb1.frontera());
        System.out.println(arb2.toString());
    }
}
