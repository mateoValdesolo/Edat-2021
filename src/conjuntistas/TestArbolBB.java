package conjuntistas;

public class TestArbolBB {

    public static void main(String[] args) {
        ArbolBB arb1 = new ArbolBB();
        ArbolBB arb2, arb3 = new ArbolBB();
        /*arb1.insertar(32);
        arb1.insertar(9);
        arb1.insertar(56);
        arb1.insertar(5);
        arb1.insertar(19);
        arb1.insertar(43);
        arb1.insertar(72);
        arb1.insertar(1);
        arb1.insertar(8);
        arb1.insertar(17);
        arb1.insertar(23);
        arb1.insertar(41);
        arb1.insertar(53);
        arb1.insertar(64);
        arb1.insertar(80);

        System.out.println("Listar: "+arb1.listar());
        System.out.println("MaximoElem: "+arb1.maximoElem());
        System.out.println("MinimoElem: "+arb1.minimoElem());
        System.out.println("43 Pertenece: "+arb1.pertenece(43));
        System.out.println("ToString: "+arb1.toString());
        System.out.println("ListarRango [8,50]"+arb1.listarRango(8, 50));
        arb2 = arb1.clone();
        System.out.println("Clone: "+arb2.toString());
        arb2.vaciar();
        System.out.println("Clone despues de vaciar: "+arb1.toString());*/
        arb3.insertar(50);
        arb3.insertar(20);
        arb3.insertar(65);
        arb3.insertar(15);
        arb3.insertar(75);
        
        System.out.println("ToString: "+arb3.toString());
        arb3.eliminar(65);
        System.out.println("ToString: "+arb3.toString());

        
    }
}
