package conjuntistas.dinamicas;

public class TestArbolBB {

    public static void main(String[] args) {
        ArbolBB arb1 = new ArbolBB();
        ArbolBB arb2, arb3 = new ArbolBB();
        arb1.insertar(32);
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
        System.out.println("Clone despues de vaciar: "+arb1.toString());
        System.out.println("32 Pertenece: "+arb1.pertenece(32));
        System.out.println("Elimino el 56");
        System.out.println(arb1.eliminar(56));
        System.out.println("ToString: "+arb1.toString());
        /*arb3.insertar(50);
        arb3.insertar(45);
        arb3.insertar(60);
        arb3.insertar(30);
        arb3.insertar(67);
        arb3.insertar(32);
        arb3.insertar(63);
        
        System.out.println("ToString: "+arb3.toString());
        arb3.eliminar(30);
        System.out.println("ToString: "+arb3.toString());*/

        
    }
}
