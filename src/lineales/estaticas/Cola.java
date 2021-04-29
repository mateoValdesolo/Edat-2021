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
public class Cola {

    private Object[] arreglo;
    private int frente;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        this.arreglo = new Object[this.TAMANIO];
        this.frente = 0;
        this.fin = 0;
    }

    public boolean poner(Object elemento) {
        /*
         * Pone un elemento en la cola, si la cola esta llena retorna false, caso
         * contrario retorna true y pone el elemento
         */
        boolean exito = false;
        if ((this.fin + 1) % this.TAMANIO != this.frente) {
            arreglo[this.fin] = elemento;
            this.fin = (this.fin + 1) % this.TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        /* Saca un elemento si la cola no esta vacia */
        boolean exito = true;
        if (this.esVacia()) {
            exito = false;
        } else {
            this.arreglo[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente() {
        // Retorna el elemento que se encuentra en el frente de la cola
        Object ret = null;
        if (!esVacia()) {
            ret = this.arreglo[this.frente];
        }
        return ret;
    }

    public boolean esVacia() {
        // Retorna true si esta vacia la cola, false en caso contrario
        boolean ret = false;
        if (this.frente == this.fin) {
            ret = true;
        }
        return ret;
    }

    public void vaciar() {
        // Vacia la cola
        while (arreglo[this.frente] != null) {
            arreglo[frente] = null;
            frente = (this.frente + 1) % this.TAMANIO;
        }
    }

    public Cola clone() {
        // Retorna un clon de la cola actual
        Cola clon = new Cola();
        int cont = frente;
        if (!esVacia()) {
            clon.frente = this.frente;
            clon.fin = this.fin;
            while (cont != fin) {
                clon.arreglo[cont] = this.arreglo[cont];
                cont = (cont + 1) % this.TAMANIO;
            }
        }
        return clon;
    }

    @Override
    public String toString() {
        // Retorna un string con los elementos de la cola
        String cad = "";
        if (esVacia()) {
            cad = "La cola esta vacia";
        } else {
            cad = "[";
            int aux = this.frente;
            while (aux != this.fin) {
                cad = cad + this.arreglo[aux];
                aux = (aux + 1) % this.TAMANIO;
                if (aux != fin) {
                    cad += ",";
                }
            }
            cad += "] " + "Frente: " + this.frente + " Fin: " + this.fin;
        }
        return cad;
    }

}
