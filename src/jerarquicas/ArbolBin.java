package jerarquicas;
import lineales.dinamicas.Lista;

public class ArbolBin {
    
    private NodoArbol raiz;

    public ArbolBin(){
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar){
        /*Inserta elemNuevo como hijo del primer nodo encontrado en preorden
        igual a elemPadre, como hijo izquierdo (I) o derecho (D), segun
        lo indique el parametro lugar
        */
        boolean exito = true;
        if (esVacio()) {
            //Si el arbol esta vacio ponemos elemNuevo en la raiz
            this.raiz = new Nodo(elemNuevo);
        } else {
            //Si el arbol no esta vacio, busca el padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    //Si el padre existe y no tiene HI se lo agrega
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        //Si el padre existe y no tiene HD se lo agrega
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo));
                    } else {
                        //Si el padre no existe o ya tiene ese hijo, da error
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public boolean esVacio(){
        return this.raiz == null;
    }

    public Object padre(Object elem){

    }

    public int altura(){

    }

    public int nivel(Object elem){

    }

    public void vaciar(){
        this.raiz = null;
    }

    public ArbolBin clone(){

    }

    public String toString(){

    }

    public Lista listarPreorden(){

    }

    public Lista listarPosorden(){

    }

    public Lista listarInorden(){

    }

    public Lista listarPorNiveles(){

    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado){
        /*
        Metodo privado que busca un elemento y devuelve el nodo
        que lo contiene. Si no lo encuentra devuelve null.
         */
        NodoArbol resultado = null;
        if(n != null){
            if (n.getElem().equals(buscado)) {
                //Si el buscado es n lo devuelve
                resultado = n;
            } else {
                //No es el buscado, busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //Si no lo encuentra en el HI, lo busca en el HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }

    }
}
