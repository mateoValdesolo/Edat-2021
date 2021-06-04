package conjuntistas;

public class CeldaHash {
    
    private Object elem;
    private int estado;

    public CeldaHash(Object elem, int estado){
        this.elem = elem;
        this.estado = estado;
    }

    public void setElem(Object elem){
        this.elem = elem;
    }

    public void setEstado(int estado){
        this.estado = estado;
    }

    public Object getElem(){
        return this.elem;
    }

    public int getEstado(){
        return this.estado;
    }
}
