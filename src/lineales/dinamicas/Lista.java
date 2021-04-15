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
        //Inserta nuevoELem en la posicion pos
        boolean exito = true;
        if (pos < 1 || pos > this.longitud() + 1) {
            //Si la posicion ivalida no se puede insertar
            exito = false;
        } else {
            if (pos == 1) {
                //Crea nuevo nodo y lo enlaza con la cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else {
                //Avanza hasta el elemento en pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //Crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        //Nunca hay error de lista llena, entonces devuelve true
        return exito;
    }

    public boolean eliminar(int pos) {
        //Elimina el elemento en la posicion pos
        boolean exito = false;
        if (pos < 1 || pos > this.longitud()) {
            exito = false;
        } else {
            //Si pos = 1, le asigna el siguiente nodo a la cabecera
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                //Recorro la lista hasta el nodo anterior a eliminar
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                /*Enlazo aux con el siguiente del siguiente
                asi el garbage collector se lleva el nodo a eliminar
                 */
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            exito = true;
        }
        return exito;
    }

    public Object recuperar(int pos) {
        //Devuelve el elemento que se encuentra en la posicion de la lista
        Object ret = null;
        if (!esVacia()) {
            if (pos >= 1 || pos <= this.longitud()) {
                //Posiciones validas para acceder
                if (pos == 1) {
                    //Si pos == 1, asigno el elemento que se encuentra en la cabecera
                    ret = this.cabecera.getElem();
                } else {
                    //Caso general
                    Nodo aux = this.cabecera;
                    int i = 1;
                    while (i < pos) {
                        //Recorro la lista hasta llegar a la posicion del elemento a recuperar
                        aux = aux.getEnlace();
                        i++;
                    }
                    //Asigno el elemento que se encuentra en la posicion pos
                    ret = aux.getElem();
                }
            }
        }
        return ret;
    }

    public int localizar(Object elem) {
        //Devuelve la primera ocurrencia de elem en la lista
        int pos = -1;
        if (!esVacia()) {
            int i = 1;
            Nodo aux = this.cabecera;
            boolean corte = false;
            while (i <= this.longitud() && corte == false) {
                //Recorre la lista
                if (aux.getElem().equals(elem)) {
                    /*Si encuentra el elemento, sale de la repetitiva
                asignando true a corte
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
        //Vacia la pila
        this.cabecera = null;
    }

    public boolean esVacia() {
        //Verifica si la lista esta vacia
        boolean ret = false;
        if (this.cabecera == null) {
            ret = true;
        }
        return ret;
    }

    public Lista clone() {
        //Clona la lista actual
        Lista clon = new Lista();
        if (!esVacia()) {
            clon.cabecera = new Nodo(this.cabecera.getElem(),null);
            Nodo aux = clon.cabecera;
            Nodo aux2 = this.cabecera.getEnlace();
            while (aux2 != null) {
                //Recorro la lista
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
        //Devuelve un string con los elementos de la lista
        String ret = "Lista vacia";
        if (!esVacia()) {
            Nodo aux = this.cabecera;
            ret = "[";
            while (aux != null) {
                ret += aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    ret += ", ";
                }
            }
            ret += "]";
        }
        return ret;
    }
}
