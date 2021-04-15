package test.lineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class PruebaLista {
    public static void main(String[] args) {
        Lista l1, l2, l3, l4;
        l1 = new Lista();
        l2 = new Lista();
        l1.insertar(1, 1);
        l1.insertar(2, 2);
        l2.insertar(3, 1);
        l2.insertar(4, 2);
        l3 = concatenar(l1, l2);
        System.out.println("Lista concatenada: " + l3.toString());
        l4 = new Lista();
        l4.insertar(1, 1);
        l4.insertar(2, 2);
        l4.insertar(3, 3);
        l4.insertar(0, 4);
        l4.insertar(1, 5);
        l4.insertar(2, 6);
        l4.insertar(3, 7);
        l4.insertar(0, 8);
        l4.insertar(3, 9);
        l4.insertar(2, 10);
        l4.insertar(1, 11);
        System.out.println("Lista l4 Comprobar: " + comprobar(l4));

    }

    public static Lista concatenar(Lista l1, Lista l2) {
        // Concatena 2 listas
        Lista ret = new Lista();
        int i = 1, pos = 0;
        while (i <= l1.longitud()) {
            ret.insertar(l1.recuperar(i), i);
            i++;
            pos = i;
        }
        i = 1;
        while (i <= l2.longitud()) {
            ret.insertar(l2.recuperar(i), pos);
            pos++;
            i++;
        }
        return ret;
    }

    public static boolean comprobar(Lista l1) {
        /*
         * Recibe una lista L1 cargada con dígitos enteros (de 0 a 9) y veri ca si los
         * elementos que contiene tienen la forma cadena0cadena0cadena' (donde cadena'
         * es cadena invertida). Ej: si L1=[9,6,5,0,9,6,5,0,5,6,9], cadena=965 y
         * cadena'=569, entonces la lista L1 cumple con la condición deseada.
         */
        boolean ret = false;
        Lista clonLista = l1.clone();
        if (!clonLista.esVacia()) {
            // Si la lista no es vacia resolver
            Cola col = new Cola();
            Pila pil = new Pila();
            while ((int) clonLista.recuperar(1) != 0) {
                // Se ponen los elementos de la lista hasta el primer 0 en la cola
                col.poner(clonLista.recuperar(1));
                clonLista.eliminar(1);
            }
            // Elimina el 0
            clonLista.eliminar(1);
            while (!clonLista.esVacia() && (int)clonLista.recuperar(1) != 0 ) {
                // Se ponen los elementos de la lista hasta el primer 0 en la cola
                if (clonLista.recuperar(1).equals(col.obtenerFrente())) {
                    // Verifico que el elemento a ingresar en col2 sea igual a el de col
                    pil.apilar(clonLista.recuperar(1));
                    clonLista.eliminar(1);
                    col.sacar();
                } else {
                    // Vacio la lista asi corto la iteracion
                    clonLista.vaciar();
                }
            }
            // Elimina el 0
            clonLista.eliminar(1);
            while (!clonLista.esVacia()) {
                if (clonLista.recuperar(1).equals(pil.obtenerTope())) {
                    clonLista.eliminar(1);
                    pil.desapilar();
                } else {
                    // Vacio la lista asi corto la iteracion
                    clonLista.vaciar();
                }
            }
            if (clonLista.esVacia() && pil.esVacia()) {
                ret = true;
            }
        }
        return ret;
    }
}