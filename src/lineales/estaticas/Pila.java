/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author mateo
 */
public class Pila {

    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 10;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        //Agrega un elemento de la pila
        boolean exito;

        if (this.tope + 1 >= this.TAMANIO) {
            exito = false;
        } else {
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        //Quita un elemento de la pila
        boolean exito;
        if (this.tope < 0) {
            //La pila esta vacia
            exito = false;
        } else {
            this.arreglo[tope] = null;
            tope--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        //Retorna el elemento del tope de la pila
        Object elemento = null;
        if (this.tope >= 0) {
            elemento = this.arreglo[tope];
        }
        return elemento;
    }

    public boolean esVacia() {
        //Verifica si la pila está vacia
        return tope == -1;
    }

    public void vaciar() {
        //Vacia la pila
        while (tope > -1) {
            arreglo[tope] = null;
            tope--;
        }
    }

    public Pila clone() {
        //Clona la pila actual
        Pila clon = new Pila();
        if (!esVacia()) {
            clon.tope = this.tope;
            for (int i = 0; i <= this.tope; i++) {
                clon.arreglo[i] = this.arreglo[i];
            }
        }
        return clon;
    }

    public String toString() {
        //Devuelve la pila en un string
        String ret = "";
        if (this.tope == -1) {
            ret = "La pila está vacia";
        } else {
            for (int i = 0; i <= this.tope; i++) {
                ret = ret + this.arreglo[i] + " ";
            }
        }
        return ret;
    }
}
