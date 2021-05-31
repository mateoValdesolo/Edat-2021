package conjuntistas;

import java.util.HashSet;
import java.util.Stack;

import lineales.dinamicas.Lista;

public class TablaHash {

    private static final int TAMANIO = 20;
    private Nodo[] tabla;
    private int cant;

    public TablaHash() {
        this.tabla = new Nodo[this.TAMANIO];
        this.cant = 0;
    }

    public boolean pertenece(Object elem) {

    }

    public boolean insertar(Object elem) {
        //Primero verifica si el elemento ya esta cargado.
        //Si no lo encuentra, lo pone adelante del resto.
        int pos = nuevoElem.hashCode() % this.TAMANIO;
        Nodo aux = this.hash[pos];
        boolean encontrado = false;
        while (!encontrado && aux != null) {
            
        }
        
    }

    public boolean eliminar(Object elem) {

    }

    public boolean esVacia() {
        return cant == 0;
    }

    public void vaciar() {
        
    }

    public Lista listar() {

    }

}
