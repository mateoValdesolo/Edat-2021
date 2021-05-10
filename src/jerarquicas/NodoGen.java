package jerarquicas;

public class NodoGen {

    private Object elem;
    private NodoGen hijoIzquierdo;
    private NodoGen hermanoDerecho;

    public NodoGen(Object elemen, NodoGen hijoIzq, NodoGen hermanDer){
        this.elem = elemen;
        this.hijoIzquierdo = hijoIzq;
        this.hermanoDerecho = hermanDer;
    }

    public Object getElem(){
        return this.elem;
    }

    public NodoGen getHijoIzquierdo(){
        return this.hijoIzquierdo;
    }

    public NodoGen getHermanoDerecho(){
        return this.hermanoDerecho;
    }

    public void setElem(Object element){
        this.elem = element;
    }

    public void setHijoIzquierdo(NodoGen hijoIzq){
        this.hijoIzquierdo = hijoIzq;
    }

    public void setHermanoDerecho(NodoGen hermanDer){
        this.hermanoDerecho = hermanDer;
    }
}
