/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author mateo
 */
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object nuevoElem, int pos) {
        // Inserta nuevoELem en la posicion pos
        boolean exito = true;
        if (pos < 1 || pos > this.longitud() + 1) {
            // Si la posicion ivalida no se puede insertar
            exito = false;
        } else {
            if (pos == 1) {
                // Crea nuevo nodo y lo enlaza con la cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else {
                // Avanza hasta el elemento en pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                // Crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        // Nunca hay error de lista llena, entonces devuelve true
        return exito;
    }

    public boolean eliminar(int pos) {
        // Elimina el elemento en la posicion pos
        boolean exito = false;
        if (pos < 1 || pos > this.longitud()) {
            exito = false;
        } else {
            // Si pos = 1, le asigna el siguiente nodo a la cabecera
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                // Recorro la lista hasta el nodo anterior a eliminar
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                /*
                 * Enlazo aux con el siguiente del siguiente asi el garbage collector se lleva
                 * el nodo a eliminar
                 */
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            exito = true;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        // Devuelve el elemento de la lista en la posicion pos
        Object s;
        if (pos < 1 || pos > this.longitud()) {
            // Si la posicion no es valida, devuelve null
            s = null;
        } else {
            // Avanza hasta la posicion pos
            Nodo aux = this.cabecera;
            int i = 1;
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            s = aux.getElem();
        }
        return s;
    }

    public int localizar(Object elem) {
        // Devuelve la primera ocurrencia de elem en la lista
        int pos = -1;
        int cont = 1;
        Nodo aux = this.cabecera;
        if (!esVacia()) {
            while (aux != null && pos == -1) {
                if (aux.getElem() == elem) {
                    pos = cont;
                }
                aux = aux.getEnlace();
                cont++;
            }
        }
        return pos;
    }

    public void vaciar() {
        // Vacia la pila
        this.cabecera = null;
    }

    public boolean esVacia() {
        // Verifica si la lista esta vacia
        boolean ret = false;
        if (this.cabecera == null) {
            ret = true;
        }
        return ret;
    }

    public Lista clone() {
        // Clona la lista actual
        Lista clon = new Lista();
        if (!esVacia()) {
            clon.cabecera = new Nodo(this.cabecera.getElem(), null);
            Nodo aux = clon.cabecera;
            Nodo aux2 = this.cabecera.getEnlace();
            while (aux2 != null) {
                // Recorro la lista
                Nodo aux3 = new Nodo(aux2.getElem(), null);
                aux.setEnlace(aux3);
                aux = aux3;
                aux2 = aux2.getEnlace();
            }
        }
        return clon;
    }

    public int longitud() {
        int ret = 0;
        if (!esVacia()) {
            Nodo aux = this.cabecera;
            while (aux != null) {
                aux = aux.getEnlace();
                ret++;
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        String s = "[]";
        Nodo aux = this.cabecera;
        if (!esVacia()) {
            s = "[";
            while (aux != null) {
                s += aux.getElem();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ", ";
                }
            }
            s += "]";
        }
        return s;
    }

    public void eliminarApariciones(Object x) {
        /*
         * Elimina las apariciones del elemento x en la lista actual
         */
        Nodo aux = this.cabecera;

        if (!esVacia()) {
            while (aux != null) {
                if (this.cabecera.getElem().equals(x)) {
                    this.cabecera = this.cabecera.getEnlace();
                } else {
                    if ((aux.getEnlace() != null) && aux.getEnlace().getElem().equals(x)) {
                        aux.setEnlace(aux.getEnlace().getEnlace());
                    }
                }
                aux = aux.getEnlace();
            }
        }
    }

    public Lista obtenerMultiplos(int num) {
        /*
         * Recibe un número y devuelve una lista nueva que contiene todos los elementos
         * de las posiciones múltiplos de num, en el mismo orden encontrado
         */
        int i = 1;
        Lista lis = new Lista();
        boolean primera = false;

        if (!esVacia()) {
            Nodo copia = null;
            Nodo nuevo;
            Nodo aux = this.cabecera;

            while (aux != null) {
                if ((i % num) == 0) {
                    nuevo = new Nodo(aux.getElem(), null);
                    if (!primera) {
                        primera = true;
                        lis.cabecera = nuevo;
                        copia = nuevo;
                    }
                    copia.setEnlace(nuevo);
                    copia = copia.getEnlace();
                }
                aux = aux.getEnlace();
                i++;
            }
        }
        return lis;
    }

    public void insertarAnterior(Object elem1, Object elem2) {
        /*
         * Busca todas las apariciones de elem1 en la lista, e inserta un nodo con elem2
         * en la posicion anterior , si elem1 esta en la posicion 1, debe insertar a
         * elem2 antes y despues de elem1
         */
        Nodo aux = this.cabecera;
        if (!esVacia()) {
            if (this.cabecera.getElem().equals(elem1)) {
                Nodo aux1 = new Nodo(elem2, aux);
                this.cabecera = aux1;
                Nodo aux2 = new Nodo(elem2, aux.getEnlace());
                aux.setEnlace(aux2);
                aux = aux2;
            }
            while (aux.getEnlace() != null) {
                if (aux.getEnlace().getElem().equals(elem1)) {
                    Nodo aux1 = new Nodo(elem2, aux.getEnlace());
                    aux.setEnlace(aux1);
                    aux = aux1;
                }
                aux = aux.getEnlace();
            }
        }
    }

    public void eliminarAnterior(Object elem1) {
        /*
         * Elimina el elemento anteriror solo si es distinto de elem. Si el elemento
         * anterior es igual a elem, o bien elem está en la posicion 1 de la lista, no
         * se debe realizar eliminación.
         */
        Nodo aux = this.cabecera;
        if (!esVacia()) {
            while (aux.getEnlace() != null) {
                if (aux.getEnlace().getEnlace() != null && aux.getEnlace().getEnlace().getElem().equals(elem1)) {
                    if (!aux.getEnlace().getElem().equals(elem1)) {
                        aux.setEnlace(aux.getEnlace().getEnlace());
                    }
                }
                aux = aux.getEnlace();
            }
        }
    }
}
