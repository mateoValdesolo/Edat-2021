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
public class TestLista {

    public static void main(String[] args) {
        Lista lista1 = new Lista();
        lista1.insertar(2, 1);
        lista1.insertar(3, 2);
        lista1.insertar(4, 3);
        lista1.insertar(5, 4);
        System.out.println(lista1.toString());
        System.out.println("Longitud l1: "+lista1.longitud());
        Lista lista2;
        System.out.println("Clono lista 1");
        lista2 = lista1.clone();
        System.out.println("Lista2: "+lista2.toString());
        System.out.println("Longitud l2: "+lista2.longitud());
        lista1.eliminar(1);
        System.out.println("Elimino pos 1 de l1\n"+lista1.toString());
                System.out.println("Lista2: "+lista2.toString());
        System.out.println("Intento localizar 2 en l1: "+lista1.localizar(2));
        System.out.println("Intento recuperar el elemento en la posicion 1 de l1: "+lista1.recuperar(1));
        System.out.println("Vacio la lista l1");
        lista1.vaciar();
        System.out.println("Es vacia: "+lista1.esVacia());
        System.out.println("toString: "+lista1.toString());
        System.out.println("Intento recuperar el elemento en la posicion 1: "+lista1.recuperar(1));
        System.out.println("Intento localizar 2: "+lista1.localizar(2));
        lista1.insertar(2, 1);
        lista1.insertar(2, 2);
        lista1.insertar(3, 3);
        lista1.insertar(4, 4);
        lista1.insertar(5, 5);
        lista1.insertar(2, 6);
        lista1.insertar(7, 7);
        lista1.insertar(8, 8);
        lista1.insertar(2, 9);
        System.out.println(lista1.toString());
        System.out.println("Longitud: "+lista1.longitud());
        System.out.println(lista1.obtenerMultiplos(3).toString());
        lista1.eliminarApariciones(2);
        System.out.println(lista1);
    }

}
