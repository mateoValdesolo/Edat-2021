package jerarquicas;

import lineales.dinamicas.Lista;

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
            
        }

    }

    public boolean pertenece(Object element) {
        /*
         * Devuelve verdadero si el elemento pasado por parámetro está en el árbol, y
         * falso en caso contrario.
         */

    }

    public boolean esVacio() {
        /*
         * Devuelve falso si hay al menos un elemento cargado en el árbol y verdadero en
         * caso contrario.
         */
        return this.raiz == null;
    }

    public Object padre(Object element) {
        /*
         * Dado un elemento devuelve el valor almacenado en su nodo padre (busca la
         * primera aparición de elemento).
         */

    }

    public int altura() {
        /*
         * Devuelve la altura del árbol, es decir la longitud del camino más largo desde
         * la raíz hasta una hoja (Nota: un árbol vacío tiene altura -1 y una hoja tiene
         * altura 0)
         */

    }

    public int nivel(Object element) {

    }

    public Lista ancestros(Object element) {
        /*
         * Si el elemento se encuentra en el árbol, devuelve una lista con el camino
         * desde la raíz hasta dicho elemento (es decir, con los ancestros del
         * elemento). Si el elemento no está en el árbol devuelve la lista vacía.
         */

    }

    public ArbolGen clone() {
        /*
         * Genera y devuelve un árbol genérico que es equivalente (igual estructura y
         * contenido de los nodos) que el árbol original.
         */

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

    }

    public Lista listarPorNiveles() {
        /*
         * Devuelve una lista con los elementos del árbol en el recorrido por niveles
         */

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

}