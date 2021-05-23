package conjuntistas;

public class TestHeap {

    public static void main (String[] args){
        ArbolHeap heap1 = new ArbolHeap();
        heap1.insertar(20);
        heap1.insertar(15);
        heap1.insertar(10);
        heap1.insertar(50);
        heap1.insertar(2);
        System.out.println("ToString(): "+heap1.toString());
        
    }
}
