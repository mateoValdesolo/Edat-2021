package jerarquicas;

public class TestArbol {

    public static void main(String[] args) {
        ArbolBin arb1 = new ArbolBin();
        /*arb1.insertar('A', 'A', 'I');
        arb1.insertar('B', 'A', 'I');
        arb1.insertar('C', 'A', 'D');
        arb1.insertar('D', 'B', 'I');
        arb1.insertar('E', 'C', 'I');
        arb1.insertar('F', 'C', 'D');
        arb1.insertar('G', 'E', 'I');
        arb1.insertar('H', 'E', 'D');
        /*System.out.println(arb1.listarPorNiveles());
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
        ArbolBin arb2 = new ArbolBin();
        arb2.insertar('F', 'F', 'I');
        arb2.insertar('A', 'F', 'I');
        arb2.insertar('T', 'F', 'D');
        arb2.insertar('H', 'A', 'I');
        arb2.insertar('F', 'A', 'D');
        arb2.insertar('P', 'T', 'D');
        arb2.insertar('X', 'P', 'I');
        System.out.println(arb2.toString());
        arb2.cambiarHijos('Z', 'T', 'Q');
        System.out.println(arb2.toString());*/
        arb1.insertar(34, 34, 'I');
        arb1.insertar(25, 34, 'I');
        arb1.insertar(17, 34, 'D');
        arb1.insertar(71, 25, 'I');
        arb1.insertar(63, 71, 'D');
        arb1.insertar(12, 17, 'I');
        arb1.insertar(23, 17, 'D');
        System.out.println("arb1: "+arb1.toString());

        ArbolBin arb2 = new ArbolBin();
        arb2.insertar(34, 34, 'I');
        arb2.insertar(25, 34, 'I');
        arb2.insertar(17, 34, 'D');
        arb2.insertar(71, 25, 'I');
        arb2.insertar(63, 71, 'D');
        arb2.insertar(12, 17, 'I');
        arb2.insertar(23, 17, 'D');
        System.out.println(arb1.verificarIguales(arb2));
    }
}
