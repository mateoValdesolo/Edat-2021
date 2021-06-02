package conjuntistas.dinamicas;

public class NodoABB {

    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB(Comparable elem, NodoABB izq, NodoABB der) {
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
    }

    public Comparable getElem() {
        return this.elem;
    }

    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public NodoABB getIzquierdo() {
        return this.izquierdo;
    }

    public void setIzquierdo(NodoABB izq) {
        this.izquierdo = izq;
    }

    public NodoABB getDerecho() {
        return this.derecho;
    }

    public void setDerecho(NodoABB der) {
        this.derecho = der;
    }

}
