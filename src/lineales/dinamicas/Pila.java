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
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        //Agrega un elemento de la pila
        Nodo nuevo = new Nodo(nuevoElem, this.tope);
        this.tope = nuevo;
        return true;
    }

    public boolean desapilar() {
        //Quita un elemento de la pila
        boolean exito;
        if (this.tope == null) {
            //La pila esta vacia
            exito = false;
        } else {
            this.tope = tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        //Retorna el elemento del tope de la pila
        Object elemento = null;
        if (!esVacia()) {
            elemento = tope.getElem();
        }
        return elemento;
    }

    public boolean esVacia() {
        //Verifica si la pila está vacia
        return tope == null;
    }

    public void vaciar() {
        //Vacia la pila
        this.tope = null;
    }

    public Pila clone() {
        //Clona la pila actual
        Pila pilaClon = new Pila();
        if (!esVacia()) {
            pilaClon.tope = new Nodo(this.tope.getElem(), null);//Apila prier elemento
            Nodo nodoClon = pilaClon.tope;
            Nodo nodoOriginal = this.tope.getEnlace();//Recorre pila original
            Nodo nodoNuevo;
            while (nodoOriginal != null) {
                nodoNuevo = new Nodo(nodoOriginal.getElem(), null);
                nodoClon.setEnlace(nodoNuevo);
                nodoClon = nodoNuevo;
                nodoOriginal = nodoOriginal.getEnlace();
            }
        }
        return pilaClon;
    }

    @Override
    public String toString() {
        //Devuelve la pila en un string
        String ret = "";
        if (this.tope == null) {
            ret = "La pila está vacia";
        } else {
            //Se ubica para recorrer la pila
            Nodo aux = this.tope;
            ret = "[";
            while (aux != null) {
                //Agrega el texto del elem y avanza
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
