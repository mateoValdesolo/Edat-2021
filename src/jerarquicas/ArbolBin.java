package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        /*
         * Inserta elemNuevo como hijo del primer nodo encontrado en preorden igual a
         * elemPadre, como hijo izquierdo (I) o derecho (D), segun lo indique el
         * parametro lugar
         */
        boolean exito = true;
        if (esVacio()) {
            // Si el arbol esta vacio ponemos elemNuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo, null, null);
        } else {
            // Si el arbol no esta vacio, busca el padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    // Si el padre existe y no tiene HI se lo agrega
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo, null, null));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        // Si el padre existe y no tiene HD se lo agrega
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo, null, null));
                    } else {
                        // Si el padre no existe o ya tiene ese hijo, da error
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public boolean esVacio() {
        // Verifica si el arbol binario esta vacio
        return this.raiz == null;
    }

    public Object padre(Object elem) {
        // Dado un elemento devuelve el valor almacenado en su nodo padre (busca la
        // primera aparición de elemento)
        Object ret = null;
        if (!esVacio()) {
            if (this.raiz.getElem().equals(elem)) {
                ret = null;
            } else {
                ret = padreAux(this.raiz, elem);
            }
        }
        return ret;
    }

    private Object padreAux(NodoArbol nodo, Object elem) {
        Object ret = null;
        NodoArbol izq, der;
        if (nodo != null) {
            der = nodo.getDerecho();
            izq = nodo.getIzquierdo();
            if (izq != null && der != null) {
                if ((izq.getElem().equals(elem)) || (der.getElem().equals(elem))) {
                    ret = nodo.getElem();
                } else {
                    ret = padreAux(der, elem);
                    if (ret == null) {
                        ret = padreAux(izq, elem);
                    }
                }
            }
        }
        return ret;
    }

    public int altura() {
        // Devuelve la altura del árbol, es decir la longitud del camino más largo desde
        // la raíz hasta una hoja
        int ret = -1;
        if (!esVacio()) {
            ret = alturaAux(this.raiz, -1);
        }
        return ret;
    }

    private int alturaAux(NodoArbol nodo, int altura) {
        int izq, der, ret = -1;
        if (nodo != null) {
            der = alturaAux(nodo.getDerecho(), altura) + 1;
            izq = alturaAux(nodo.getIzquierdo(), altura) + 1;
            if (izq > der) {
                ret = izq;
            } else {
                ret = der;
            }
        }
        return ret;
    }

    public int nivel(Object elem) {
        // Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el
        // árbol devuelve -1.
        int ret = -1;
        if (!esVacio()) {
            ret = nivelAux(this.raiz, elem);
        }
        return ret;
    }

    private int nivelAux(NodoArbol nodo, Object elem) {
        int ret = -1;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                // Verifica si esta en la raiz
                ret = 0;
            } else {
                // Busca en el hijo izquierdo
                ret = nivelAux(nodo.getIzquierdo(), elem);
                if (ret == -1) {
                    ret = nivelAux(nodo.getDerecho(), elem);
                }
                if (ret != -1) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public void vaciar() {
        // Vacia el arbol
        this.raiz = null;
    }

    public ArbolBin clone() {
        /*
         * Genera y devuelve un árbol binario que es equivalente (igual estructura y
         * contenido de los nodos) que el árbol original.
         */
        ArbolBin clon = new ArbolBin();
        if (!esVacio()) {
            NodoArbol nod = new NodoArbol(this.raiz.getElem(), null, null);
            clon.raiz = nod;
            cloneAux(nod, this.raiz);
        }
        return clon;
    }

    private void cloneAux(NodoArbol aux, NodoArbol nodo) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                aux.setIzquierdo(new NodoArbol(nodo.getIzquierdo().getElem(), null, null));
                cloneAux(aux.getIzquierdo(), nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                aux.setDerecho(new NodoArbol(nodo.getDerecho().getElem(), null, null));
                cloneAux(aux.getDerecho(), nodo.getDerecho());
            }
        }
    }

    public String toString() {
        /*
         * Genera y devuelve una cadena de caracteres que indica cuál es la raíz del
         * árbol y quienes son los hijos de cada nodo.
         */
        String ret = "[]";
        if (!esVacio()) {
            ret = toStringAux(this.raiz, "");
        }
        return ret;
    }

    private String toStringAux(NodoArbol nodo, String str) {

        if (nodo != null) {
            NodoArbol izq = nodo.getIzquierdo(), der = nodo.getDerecho();
            str += "Nodo: " + nodo.getElem();
            if (izq != null && der != null) {
                str += " HI: " + izq.getElem();
                str += " HD: " + der.getElem() + "\n";
            } else {
                if (izq == null && der == null) {
                    str += " HI: - ";
                    str += " HD: - " + "\n";
                } else {
                    if (izq == null) {
                        str += " HI: -";
                        str += " HD: - " + der.getElem() + "\n";
                    } else {
                        if (der == null) {
                            str += " HI: " + izq.getElem();
                            str += " HD: - " + "\n";
                        }
                    }
                }

            }
            str = toStringAux(izq, str);
            str = toStringAux(der, str);
        }
        return str;

    }

    public Lista listarPreorden() {
        // Retorna una lista con los elementos del arbol en preorden
        Lista aux = new Lista();
        listarPreordenAux(this.raiz, aux);
        return aux;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        // Metodo recursivo privado porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            // Visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            // Recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis);
            listarPreordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        // Retorna una lista con los elementos del arbol en posorden
        Lista aux = new Lista();
        listarPosordenAux(this.raiz, aux);
        return aux;
    }

    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }

    public Lista listarInorden() {
        // Retorna una lista con los elementos del arbol en inorden
        Lista aux = new Lista();
        listarInordenAux(this.raiz, aux);
        return aux;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPorNiveles() {
        // Devuelve una lista con los elementos del árbol binario en el recorrido por
        // niveles
        Lista lis = new Lista();
        if (!this.esVacio()) {
            listarPorNivelesAux(this.raiz, lis);
        }
        return lis;
    }

    private void listarPorNivelesAux(NodoArbol nodo, Lista lis) {
        Cola col = new Cola();
        col.poner(nodo);
        int pos = 1;
        while (!col.esVacia()) {
            nodo = (NodoArbol) col.obtenerFrente();
            col.sacar();
            lis.insertar(nodo.getElem(), pos);
            pos++;
            if (nodo.getIzquierdo() != null) {
                col.poner(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                col.poner(nodo.getDerecho());
            }
        }
    }

    public Lista frontera() {
        /*
         * Retorna en una lista la secuencia formada por los elementos almacenados en
         * las hojas del árbol, tomadas de izquierda a derecha.
         */
        Lista ret = new Lista();
        if (!esVacio()) {
            fronteraAux(this.raiz, ret);
        }
        return ret;
    }

    public void fronteraAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            if (nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            }
            fronteraAux(nodo.getIzquierdo(), lis);
            fronteraAux(nodo.getDerecho(), lis);
        }
    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        /*
         * Metodo privado que busca un elemento y devuelve el nodo que lo contiene. Si
         * no lo encuentra devuelve null.
         */
        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                // Si el buscado es n lo devuelve
                resultado = n;
            } else {
                // No es el buscado, busca primero en el HI
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                // Si no lo encuentra en el HI, lo busca en el HD
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public void cambiarHijos(Object izq, Object p, Object der) {
        if (!esVacio()) {
            cambiarHijosAux(this.raiz, izq, p, der);
        }
    }

    private boolean cambiarHijosAux(NodoArbol nodo, Object izq, Object p, Object der) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElem().equals(p)) {
                exito = true;
                if (nodo.getIzquierdo() == null) {
                    NodoArbol aux = new NodoArbol(izq, null, null);
                    nodo.setIzquierdo(aux);
                } else {
                    nodo.getIzquierdo().setElem(izq);
                }
                if (nodo.getDerecho() == null) {
                    NodoArbol aux = new NodoArbol(der, null, null);
                    nodo.setDerecho(aux);
                } else {
                    nodo.getDerecho().setElem(der);
                }
            } else {
                exito = cambiarHijosAux(nodo.getIzquierdo(), izq, p, der);
                if(!exito){
                    exito = cambiarHijosAux(nodo.getDerecho(), izq, p, der);
                }
            }
        }
        return exito;
    }

    public ArbolBin clonarInvertido() {
        ArbolBin a = new ArbolBin();
        if (!esVacio()) {
            a.raiz = clonarAux(this.raiz);
        }
        return a;
    }

    private NodoArbol clonarAux(NodoArbol n) {
        NodoArbol nClon = null;
        if (n != null) {
            nClon = new NodoArbol(n.getElem(), null, null);
            nClon.setIzquierdo(clonarAux(n.getDerecho()));
            nClon.setDerecho(clonarAux(n.getIzquierdo()));
        }
        return nClon;
    }

    public boolean verificarPatron(Lista patron) {
        boolean ret = false;
        if (this.raiz != null) {
            ret = verificarAux(patron, this.raiz, ret, 1);
        }
        return ret;

    }

    private boolean verificarAux(Lista lis, NodoArbol nodo, boolean ret, int pos) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                if (nodo.getElem().equals(lis.recuperar(pos))) {
                    ret = true;
                    pos++;
                    ret = verificarAux(lis, nodo.getIzquierdo(), ret, pos);
                } else {
                    ret = false;
                    pos--;
                }
                if (!ret) {
                    ret = verificarAux(lis, nodo.getDerecho(), ret, pos);
                }
            }
        }
        return ret;
    }
}
