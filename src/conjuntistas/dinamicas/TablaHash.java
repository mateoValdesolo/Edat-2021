package conjuntistas.dinamicas;

import lineales.dinamicas.Lista;

public class TablaHash {
    // Hash Abierto

    private static final int TAMANIO = 20;
    private Nodo[] hash;
    private int cant;

    public TablaHash() {
        this.hash = new Nodo[this.TAMANIO];
        this.cant = 0;
    }


    public boolean insertar(Object nuevoElem) {
        /*
         * Recibe un elemento e intenta insertarlo en la tabla. Si todo funciona OK (no
         * está repetido y hay lugar su ciente en la tabla) devuelve verdadero, si hay
         * algún problema devuelve falso.
         */
        // Primero verifica si el elemento ya esta cargado.
        // Si no lo encuentra, lo pone adelante del resto.
        int pos = nuevoElem.hashCode() % this.TAMANIO;
        Nodo aux = this.hash[pos];
        boolean encontrado = false;
        while (!encontrado && aux != null) {
            encontrado = aux.getElem().equals(nuevoElem);
            aux = aux.getEnlace();
        }
        if (!encontrado) {
            this.hash[pos] = new Nodo(nuevoElem, this.hash[pos]);
            this.cant++;
        }
        return !encontrado;
    }

    public boolean eliminar(Object elem) {
        /*
         * Recibe el elemento que se desea eliminar y se procede a quitarlo de la tabla.
         * Si todo funciona OK (el elemento estaba cargado previamente en la tabla)
         * devuelve verdadero, si hay algún problema devuelve falso.
         */

    }

    public boolean pertenece(Object elem) {
        /*
         * Verifica si el elemento se encuentra en la estructura.
         */
    }

    public boolean esVacia() {
        /*
         * Devuelve falso si hay al menos un elemento cargado en la tabla y verdadero en
         * caso contrario.
         */
        return this.cant == 0;
    }

    public void vaciar() {
        /*
         * Vacia la la tabla.
         */

    }

    public Lista listar() {
        /*
         * Recorre la tabla completa y devuelve una lista con los elementos que se
         * encuentran almacenados en la tabla.
         */

    }

}
