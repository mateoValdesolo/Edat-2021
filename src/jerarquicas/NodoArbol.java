package jerarquicas;

public class NodoArbol {
    
    private Object elem;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Object elemento, NodoArbol izq, NodoArbol der){
        this.elem = elemento;
        this.izquierdo = izq;
        this.derecho = der;
    }

    public Object getElem(){
        return this.elem;
    }

    public NodoArbol getIzquierdo(){
        return this.izquierdo;
    }

    public NodoArbol getDerecho(){
        return this.derecho;
    }

    public void setElem(Object elemento){
        this.elem = elemento;
    }

    public void setIzquierdo(NodoArbol izq){
        this.izquierdo = izq;
    }

    public void setDerecho(NodoArbol der){
        this.derecho = der;
    }
}
