package conjuntistas;

public class TestHeap {

    public static void main (String[] args){
        ArbolHeap heap1 = new ArbolHeap();
        heap1.insertar(100);
        heap1.insertar(15);
        heap1.insertar(23);
        heap1.insertar(10);
        heap1.insertar(20);
        heap1.insertar(50);
        heap1.insertar(7);
        heap1.insertar(2);
        System.out.println("ToString(): "+heap1.toString());
        System.out.println("Vacio: "+heap1.esVacio());
        System.out.println("EliminarCima: "+heap1.eliminarCima());
        System.out.println("ToString(): "+heap1.toString());
        heap1.vaciar();        
        System.out.println("Vacio: "+heap1.esVacio());
        System.out.println("ToString(): "+heap1.toString());
    }
}
