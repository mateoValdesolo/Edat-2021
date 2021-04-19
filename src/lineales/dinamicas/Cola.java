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
public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object elemento) {
        // Pone un elemento en la cola
        Nodo otroNodo = new Nodo(elemento, null);
        if (esVacia()) {
            this.frente = otroNodo;
        } else {
            this.fin.setEnlace(otroNodo);
        }
        this.fin = otroNodo;
        return true;
    }

    public boolean sacar() {
        // Saca un elemento si la cola no esta vacia
        boolean exito = true;
        if (esVacia()) {
            exito = false;
        } else {
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        // Retorna el elemento que se encuentra en el frente de la cola
        Object ret = null;
        if (!esVacia()) {
            ret = this.frente.getElem();
        }
        return ret;
    }

    public boolean esVacia() {
        // Retorna true si esta vacia la cola, false en caso contrario
        return this.frente == null;
    }

    public void vaciar() {
        // Vacia la cola
        this.frente = null;
    }

    @Override
    public Cola clone() {
        // Retorna un clon de la cola actual
        Cola colaClon = new Cola();
        if (!this.esVacia()) {
            Nodo nodoClon = new Nodo(this.frente.getElem(), null);
            colaClon.frente = nodoClon;
            Nodo nodoOriginal = this.frente.getEnlace();
            Nodo nodoNuevo;
            while (nodoOriginal != null) {
                nodoNuevo = new Nodo(nodoOriginal.getElem(), null);
                colaClon.fin = nodoNuevo;
                nodoClon.setEnlace(nodoNuevo);
                nodoClon = nodoClon.getEnlace();
                nodoOriginal = nodoOriginal.getEnlace();
            }
        }
        return colaClon;
    }

    @Override
    public String toString() {
        // Retorna un string con los elementos de la cola
        String ret = "";
        if (esVacia()) {
            ret = "La cola está vacia";
        } else {
            // Se ubica para recorrer la pila
            Nodo aux = this.frente;
            ret = "[";
            while (aux != null) {
                // Agrega el texto del elem y avanza
                ret = ret + aux.getElem().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    ret += ",";
                }
            }
            ret += "]";
        }
        return ret;
    }
}
