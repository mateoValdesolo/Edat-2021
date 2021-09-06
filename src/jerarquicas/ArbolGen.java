package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        /*
         * Dado un elemento elemNuevo y un elemento elemPadre, agrega elemNuevo como
         * hijo de la primer aparición de elemPadre. Para que la operación termine con
         * éxito debe existir un nodo en el árbol con elemento = elemPadre. No se
         * establece ninguna preferencia respecto a la posición del hijo respecto a sus
         * posibles hermanos. Esta operación devuelve verdadero cuando se pudo agregar
         * elemNuevo a la estructura y falso en caso contrario.
         */
        boolean exito = false;
        if (esVacio()) {
            this.raiz = new NodoGen(elemNuevo, null, null);
            exito = true;
        } else {
            NodoGen padre = obtenerNodo(this.raiz, elemPadre);
            if (padre != null) {
                padre.setHijoIzquierdo(new NodoGen(elemNuevo, null, padre.getHijoIzquierdo()));
                exito = true;
            }
        }
        return exito;
    }

    public boolean pertenece(Object elem) {
        /*
         * Devuelve verdadero si el elemento pasado por parámetro está en el árbol, y
         * falso en caso contrario.
         */
        boolean ret = false;
        if (obtenerNodo(this.raiz, elem) != null) {
            ret = true;
        }
        return ret;
    }

    public boolean esVacio() {
        /*
         * Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en
         * caso contrario.
         */
        return this.raiz == null;
    }

    public Object padre(Object elem) {
        /*
         * Dado un elemento devuelve el valor almacenado en su nodo padre (busca la
         * primera aparición de elemento).
         */
        return padreAux(this.raiz, elem);
    }

    private Object padreAux(NodoGen nodo, Object busc) {
        Object resultado = null;
        if (nodo != null) {
            if (!nodo.getElem().equals(busc)) {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && resultado == null) {
                    if (hijo.getElem().equals(busc)) {
                        resultado = nodo.getElem();
                    } else {
                        resultado = padreAux(hijo, busc);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
        return resultado;
    }

    public int altura() {
        /*
         * Devuelve la altura del árbol, es decir la longitud del camino más largo desde
         * la raíz hasta una hoja (Nota: un árbol vacío tiene altura -1 y una hoja tiene
         * altura 0)
         */
        return alturaAux(this.raiz, -1);
    }

    private int alturaAux(NodoGen nodo, int alt) {
        if (nodo != null) {
            int izq, der;
            izq = alturaAux(nodo.getHijoIzquierdo(), alt + 1);
            der = alturaAux(nodo.getHermanoDerecho(), alt);
            if (izq > der) {
                alt = izq;
            } else {
                alt = der;
            }
        }
        return alt;
    }

    public int nivel(Object element) {
        /*
         * Devuelve el nivel de un elemento en el árbol. Si el elemento no existe en el
         * árbol devuelve -1.
         */
        int ret;
        ret = nivelAux(this.raiz, element, -1);
        return ret;
    }

    private int nivelAux(NodoGen nodo, Object busc, int nivel) {
        if (nodo != null) {
            if (nodo.getElem().equals(busc)) {
                nivel++;
            } else {
                nivel = nivelAux(nodo.getHijoIzquierdo(), busc, nivel);
                if (nivel == -1) {
                    nivel = nivelAux(nodo.getHermanoDerecho(), busc, nivel);
                } else {
                    nivel++;
                }
            }
        }
        return nivel;
    }

    public Lista ancestros(Object element) {
        /*
         * Si el elemento se encuentra en el árbol, devuelve una lista con el camino
         * desde la raíz hasta dicho elemento (es decir, con los ancestros del
         * elemento). Si el elemento no está en el árbol devuelve la lista vacía.
         */
        Lista ret = new Lista();
        ancestrosAux(this.raiz, ret, element);
        return ret;
    }

    private boolean ancestrosAux(NodoGen nodo, Lista lis, Object elem) {
        boolean exito = false;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                exito = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !exito) {
                    exito = ancestrosAux(hijo, lis, elem);
                    hijo = hijo.getHermanoDerecho();
                }
                if (exito) {
                    lis.insertar(nodo.getElem(), lis.longitud() + 1);
                }
            }
        }
        return exito;
    }

    public ArbolGen clone() {
        /*
         * Genera y devuelve un árbol genérico que es equivalente (igual estructura y
         * contenido de los nodos) que el árbol original.
         */
        ArbolGen clon = new ArbolGen();
        if (!esVacio()) {
            clon.raiz = cloneAux(this.raiz);
        }
        return clon;
    }

    private NodoGen cloneAux(NodoGen nodo) {
        NodoGen aux = new NodoGen(null, null, null);
        if (nodo != null) {
            aux = new NodoGen(nodo.getElem(), cloneAux(nodo.getHijoIzquierdo()), cloneAux(nodo.getHermanoDerecho()));
        } else {
            aux = null;
        }
        return aux;
    }

    public void vaciar() {
        /*
         * Quita todos los elementos de la estructura. El manejo de memoria es similar
         * al explicado anteriormente para estructuras lineales dinámicas.
         */
        this.raiz = null;
    }

    public Lista listarPreorden() {
        /*
         * Devuelve una lista con los elementos del árbol en el recorrido en preorden
         */
        Lista ret = new Lista();
        listarPreordenAux(this.raiz, ret);
        return ret;
    }

    private void listarPreordenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                listarPreordenAux(hijo, lis);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public Lista listarInorden() {
        /*
         * Devuelve una lista con los elementos del árbol en el recorrido en preorden
         */
        Lista ret = new Lista();
        listarInordenAux(this.raiz, ret);
        return ret;
    }

    private void listarInordenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {
            // Llamado recursivo con primer llamado de nodo
            if (nodo.getHijoIzquierdo() != null) {
                listarInordenAux(nodo.getHijoIzquierdo(), lis);
            }
            // Visita del nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1);

            // Llamados recursivos con los otros hijos de nodo
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, lis);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        /*
         * Devuelve una lista con los elementos del árbol en el recorrido en posorden
         */
        Lista ret = new Lista();
        listarPosordenAux(this.raiz, ret);
        return ret;
    }

    private void listarPosordenAux(NodoGen nodo, Lista lis) {
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                listarPosordenAux(hijo, lis);
                hijo = hijo.getHermanoDerecho();
            }
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        /*
         * Devuelve una lista con los elementos del árbol en el recorrido por niveles
         */
        Lista ret = new Lista();
        listarPorNivelesAux(this.raiz, ret);
        return ret;
    }

    private void listarPorNivelesAux(NodoGen nodo, Lista lis) {
        Cola q = new Cola();
        q.poner(nodo);
        while (!q.esVacia()) {
            nodo = (NodoGen) q.obtenerFrente();
            q.sacar();
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                q.poner(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public String toString() {
        /*
         * Genera y devuelve una cadena de caracteres que indica cuál es la raíz del
         * árbol y quienes son los hijos de cada nodo.
         */
        return toStringAux(this.raiz);
    }

    public String toStringAux(NodoGen nodo) {
        String ret = "";
        if (nodo != null) {
            ret += nodo.getElem().toString() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                ret += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                ret += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return ret;
    }

    private NodoGen obtenerNodo(NodoGen nodo, Object elem) {
        /*
         * Metodo privado que busca un elemento y devuelve el nodo que lo contiene. Si
         * no lo encuentra devuelve null.
         */
        NodoGen ret = null;
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                ret = nodo;
            } else {
                ret = obtenerNodo(nodo.getHijoIzquierdo(), elem);
                if (ret == null) {
                    ret = obtenerNodo(nodo.getHermanoDerecho(), elem);
                }
            }
        }
        return ret;
    }

    public int grado() {
        /*
         * Retorna el mayor grado del arbol, cada nodo tiene un grado, que es el número
         * de hijos (subárboles) que posee.
         */
        int grado = -1;
        if (!esVacio()) {
            grado = gradoAux(this.raiz, 0);
        }
        return grado;
    }

    private int gradoAux(NodoGen nodo, int gradoRet) {
        int grad = 0;
        if (nodo != null && nodo.getHijoIzquierdo() != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                grad++;
                gradoRet = Math.max(grad, gradoAux(hijo, gradoRet));
                hijo = hijo.getHermanoDerecho();
            }
        }
        return gradoRet;
    }

    public int gradoSubarbol(Object elem) {
        /*
         * Retorna el grado del subarbol, cada nodo tiene un grado, que es el número de
         * hijos (subárboles) que posee.
         */
        int grado = -1;
        if (pertenece(elem)) {
            NodoGen nodo = obtenerNodo(this.raiz, elem);
            grado = gradoAux(nodo, 0);
        }
        return grado;
    }

    public boolean verificarCamino(Lista lis) {
        /*
         * Dada una lista, verifica si la misma corresponde a un camino desde la raíz
         * hasta algún elemento del árbol.
         */
        boolean ret = false;
        if (!esVacio()) {
            ret = verificarCaminoAux(this.raiz, lis, 1);
        }
        return ret;
    }

    private boolean verificarCaminoAux(NodoGen nodo, Lista lis, int cont) {
        boolean exito = true;
        int longitud = lis.longitud();
        if (nodo != null && exito && cont < longitud) {
            if (nodo.getElem().equals(lis.recuperar(cont))) {
                cont++;
                if (nodo.getHijoIzquierdo().getElem().equals(lis.recuperar(cont))) {
                    exito = verificarCaminoAux(nodo.getHijoIzquierdo(), lis, cont);
                } else {
                    NodoGen aux = nodo.getHijoIzquierdo();
                    boolean encontrado = false;
                    while (!encontrado && aux != null) {
                        if (aux.getElem().equals(lis.recuperar(cont))) {
                            encontrado = true;
                            exito = verificarCaminoAux(aux, lis, cont);
                        } else {
                            aux = aux.getHermanoDerecho();
                        }
                    }
                    if (!encontrado) {
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public Lista listarEntreNiveles(int niv1, int niv2) {
        /*
         * Recibe como parámetro dos elementos niv1 y niv2 y devuelve una lista con los
         * elementos del árbol que están entre los niveles niv1 y niv2 inclusive.
         */
        Lista lis = new Lista();
        if (!esVacio()) {
            listarEntreNivelesAux(this.raiz, niv1, niv2, lis, 0);
        }
        return lis;
    }

    private void listarEntreNivelesAux(NodoGen nodo, int niv1, int niv2, Lista lis, int nivActual) {
        if (nodo != null) {
            // Llamado recursivo con primer llamado de nodo.
            if (nodo.getHijoIzquierdo() != null) {
                listarEntreNivelesAux(nodo.getHijoIzquierdo(), niv1, niv2, lis, nivActual + 1);
            }
            // Visita del nodo.
            if (nivActual >= niv1 && nivActual <= niv2) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            }
            // Llamados recursivos con los otros hijos de nodo.
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarEntreNivelesAux(hijo, niv1, niv2, lis, nivActual + 1);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarHastaNivel(int niv) {
        /*
         * Recibe por parámetro el nivel niv y devuelve una lista con todos los
         * elementos de los nodos que se encuentran entre los niveles [0, niv]. El
         * método debe recorrer el árbol en preorden y sólo visitar los nodos a listar,
         * es decir que no debe recorrer nodos de más.
         */
        Lista lis = new Lista();
        if (!esVacio()) {
            listarHastaNivelAux(this.raiz, niv, lis, 0);
        }
        return lis;
    }

    private void listarHastaNivelAux(NodoGen nodo, int niv, Lista lis, int nivActual) {
        if (nodo != null && nivActual <= niv) {
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            NodoGen hijo = nodo.getHijoIzquierdo();
            nivActual += 1;
            while (hijo != null) {
                listarHastaNivelAux(hijo, niv, lis, nivActual);
                hijo = hijo.getHermanoDerecho();
            }
        }
    }

    public boolean esPadre(Object a, Object b) {
        /*
         * Que verifica si en el árbol el elemento a es padre del elemento b y devuelve
         * true en caso que sea cierto y falso en caso contrario.
         */
        boolean ret = false;
        if (!esVacio()) {
            ret = esPadreAux(this.raiz, a, b);
        }
        return ret;
    }

    private boolean esPadreAux(NodoGen nodo, Object padre, Object hijo) {
        boolean ret = false;
        if (nodo != null) {
            if (nodo.getElem().equals(padre)) {
                NodoGen aux = nodo.getHijoIzquierdo();
                if (aux.getElem().equals(hijo)) {
                    ret = true;
                } else {
                    while (aux != null && !ret) {
                        ret = esPadreAux2(aux, hijo);
                        aux = aux.getHermanoDerecho();
                    }
                }
            }
            if (!ret) {
                NodoGen aux2 = nodo.getHijoIzquierdo();
                while (aux2 != null && !ret) {
                    ret = esPadreAux(aux2, padre, hijo);
                    aux2 = aux2.getHermanoDerecho();
                }
            }
        }
        return ret;
    }

    private boolean esPadreAux2(NodoGen aux, Object hijo) {
        boolean ret = false;
        if (aux.getElem().equals(hijo)) {
            ret = true;
        }
        return ret;
    }

    public void insertarSobrino(Object t, Object h, Object s) {
        /*
         * Recibe los parámetros t=tío, h=hermano y s=sobrino, y si t está en el árbol y
         * tiene un hermano h, le agrega a s como hijo de h. En caso que la inserción no
         * sea posible retornará false y si es posible retornará true.
         */
        if (!esVacio()) {
            insertarSobrinoAux(this.raiz, t, h, s, false);
        }
    }


    private void insertarSobrinoAux(NodoGen nodo,Object t, Object h, Object s, boolean insertado) {
        if (nodo != null && !insertado) {
            if (nodo.getElem().equals(t)) {
                if (nodo.getHijoIzquierdo().getElem().equals(h)){
                    NodoGen aux = nodo.getHijoIzquierdo();
                    NodoGen sob = new NodoGen(s,null,aux.getHijoIzquierdo());
                    aux.setHijoIzquierdo(sob);
                    insertado = true;
                } else {
                    NodoGen aux = nodo.getHijoIzquierdo();
                    while (aux != null && !insertado) {
                        if (aux.getElem().equals(h)) {
                            NodoGen aux2 = nodo.getHijoIzquierdo();
                            NodoGen sob = new NodoGen(s,null,aux2.getHijoIzquierdo());
                            aux.setHijoIzquierdo(sob);
                            insertado = true;
                        } else {
                            insertarSobrinoAux(aux,t,h,s, insertado);
                            aux = aux.getHermanoDerecho();
                        }
                    }
                }
            } else {
                NodoGen aux = nodo.getHijoIzquierdo();
                while(aux != null && !insertado){
                    insertarSobrinoAux(aux, t, h, s, insertado);
                    if(!insertado){
                        aux = aux.getHermanoDerecho();
                    }
                }
            }
        }
    }
}