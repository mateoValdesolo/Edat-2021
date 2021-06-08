package jerarquicas;
import lineales.dinamicas.Lista;
public class TestArbolGen {

    public static void main(String[] args) {
        ArbolGen arb1 = new ArbolGen();
        ArbolGen arb2 = new ArbolGen();
        /*System.out.println("Arbol Vacio: "+arb1.toString());
        System.out.println("EsVacio: "+arb1.esVacio());
        System.out.println("Pertenece: "+arb1.pertenece('D'));
        System.out.println("Padre: "+arb1.padre('C'));
        System.out.println("Altura: "+arb1.altura());
        System.out.println("Nivel 'B': "+arb1.nivel('B'));
        System.out.println("Ancestros: "+arb1.ancestros('H'));
        arb2 = arb1.clone();
        System.out.println("Clone: \n"+arb2.toString());
        System.out.println(arb1.insertar('A', 'A'));
        arb1.insertar('B', 'A');
        arb1.insertar('C', 'A');
        arb1.insertar('D', 'A');
        arb1.insertar('E', 'B');
        arb1.insertar('F', 'B');
        arb1.insertar('G', 'B');
        arb1.insertar('H', 'D');
        System.out.println(arb1.toString());
        System.out.println("EsVacio: "+arb1.esVacio());
        System.out.println("Pertenece: "+arb1.pertenece('G'));
        System.out.println("Padre: "+arb1.padre('C'));
        System.out.println("Altura: "+arb1.altura());
        System.out.println("Nivel 'B': "+arb1.nivel('A'));
        System.out.println("Ancestros: "+arb1.ancestros('F'));
        arb2 = arb1.clone();
        System.out.println("Clone: \n"+arb2.toString());
        arb2.insertar('Z', 'D');
        arb1.insertar('K', 'D');
        System.out.println("Arb1: \n"+arb1.toString());
        System.out.println("Arb2: \n"+arb2.toString());
        System.out.println("Inorden: "+arb1.listarInorden());
        System.out.println("Posorden: "+arb1.listarPosorden());
        System.out.println("PorNiveles: "+arb1.listarPorNiveles());
        System.out.println("Preorden: "+arb1.listarPreorden());
        System.out.println("Inserto en pos inexistente: "+arb1.insertar('A', 'N'));*/
        ArbolGen arb3 = new ArbolGen();
        arb3.insertar('A', 'A');
        arb3.insertar('B', 'A');
        arb3.insertar('C', 'A');
        arb3.insertar('D', 'B');
        arb3.insertar('E', 'B');
        arb3.insertar('F', 'E');
        arb3.insertar('G', 'C');
        arb3.insertar('H', 'C');
        arb3.insertar('I', 'C');
        arb3.insertar('J', 'H');
        System.out.println(arb3.toString());
        System.out.println(arb3.listarEntreNiveles(2, 3));
        Lista lis2 = new Lista(), lis = new Lista();
        lis.insertar('A', 1);
        lis.insertar('C', 2);
        lis.insertar('I', 3);
        lis2.insertar('A', 1);
        lis2.insertar('B', 2);
        lis2.insertar('E', 3);
        lis2.insertar('F', 4);
        System.out.println("<A,C,I>: "+arb3.verificarCamino(lis));
        System.out.println("<A,B,E,F>: "+arb3.verificarCamino(lis2));


    }

}
