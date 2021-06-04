package conjuntistas.dinamicas;

public class Nodo {
    
    private Object elem;
    private Nodo enlace;

    public Nodo(Object elem, Nodo enlace){
        this.elem = elem;
        this.enlace = enlace;
    }

    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }

    public Nodo getEnlace(){
        return this.enlace;
    }

    public Object getElem(){
        return this.elem;
    }

    public Nodo getNodo(){
        return this.enlace;
    }
}
