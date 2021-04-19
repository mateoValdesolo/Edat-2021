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
        if (!esVacia()) {
            int i = 1;
            Nodo aux = this.cabecera;
            boolean corte = false;
            while (i <= this.longitud() && corte == false) {
                // Recorre la lista
                if (aux.getElem().equals(elem)) {
                    /*
                     * Si encuentra el elemento, sale de la repetitiva asignando true a corte
                     */
                    corte = true;
                    pos = i;
                } else {
                    aux = aux.getEnlace();
                    i++;
                }
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

    public void invertir() {
        //Invierte la lista actual
        Nodo aux = this.cabecera;
        invertirAux(this.cabecera);
        if (aux != null) {
            aux.setEnlace(null);
        }
    }

    private void invertirAux(Nodo nodo) {
        if (nodo != null) {
            this.cabecera = nodo;
            invertirAux(nodo.getEnlace());
            if (nodo.getEnlace() != null) {
                nodo.getEnlace().setEnlace(nodo);
            }
        }
    }

    public void eliminarApariciones(Object x) {
        //Elimina las apariciones del elemento x en la lista actual
        Nodo aux, aux2;
        for (int i = 1; i <= this.longitud(); i++) {
            if (this.recuperar(i).equals(x)) {
                if(i == 1){ 
                    this.cabecera = this.cabecera.getEnlace();
                } else {
                    aux = this.cabecera;
                    aux = aux.getEnlace();
                    aux.setEnlace(aux.getEnlace().getEnlace());
                }
                
            }
        }
    }
}
