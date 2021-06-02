package conjuntistas.dinamicas;

public class NodoAVL {

    private Comparable elem;
    private int altura;
    private NodoAVL izquierdo;
    private NodoAVL derecho;

    public NodoAVL(Comparable elem, NodoAVL izq, NodoAVL der) {
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
        this.altura = 0;
    }

    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public void setIzquierdo(NodoAVL izq) {
        this.izquierdo = izq;
    }

    public void setDerecho(NodoAVL der) {
        this.derecho = der;
    }

    public Comparable getElem() {
        return this.elem;
    }

    public int getAltura() {
        return this.altura;
    }

    public NodoAVL getIzquierdo() {
        return this.izquierdo;
    }

    public NodoAVL getDerecho() {
        return this.derecho;
    }

    public void recalcularAltura() {
        int izq = -1, der = -1;
        if (izquierdo != null) {
            izq = this.izquierdo.altura;
        }
        if (derecho != null) {
            izq = this.derecho.altura;
        }
        this.altura = Math.max(izq, der) + 1;
    }
}
