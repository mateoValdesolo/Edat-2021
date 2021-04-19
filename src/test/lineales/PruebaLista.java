package test.lineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class PruebaLista {
    public static void main(String[] args) {
        Lista l1, l2, l3, l4, l5, l6;
        l1 = new Lista();
        l2 = new Lista();
        l1.insertar(1, 1);
        l1.insertar(2, 2);
        l2.insertar(3, 1);
        l2.insertar(4, 2);
        l3 = concatenar(l1, l2);
        System.out.println("Lista concatenada l3: " + l3.toString());
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
        System.out.println("l3 invertida: " + invertir(l3).toString());
        l5 = intercalar(l1, l2);
        System.out.println(l5.toString());
        l5.invertir();
        System.out.println(l5.toString());
        System.out.println(contarRecur(l4, 1));
        l4.eliminarApariciones(1);
        System.out.println(l4.toString());
        l6 = new Lista();
        l6.insertar(1, 1);
        l6.insertar(2, 2); 
        l6.insertar(2, 3);
        l6.insertar(1, 4);
        System.out.println("Es capicua?: " + esCapicua(l6));

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
        Cola cola = new Cola();
        Pila pila = new Pila();
        int i = 1;
        boolean ret = true;
        while ((int) l1.recuperar(i) != 0) {
            cola.poner(l1.recuperar(i));
            pila.apilar(l1.recuperar(i));
            i++;
        }
        i++;
        while ((int) l1.recuperar(i) != 0 && !cola.esVacia() && ret) {
            ret = (l1.recuperar(i) == cola.obtenerFrente()) && (!cola.esVacia());
            cola.sacar();
            i++;
        }
        i++;
        while ((l1.recuperar(i) != null) && !pila.esVacia() && ret) {
            ret = (l1.recuperar(i) == pila.obtenerTope()) && (!pila.esVacia());
            pila.desapilar();
            i++;
        }
        return ret;
    }

    public static Lista invertir(Lista l1) {
        // Invierte la lista ingresada por parametro
        Lista invert = new Lista();
        Lista listaClon = l1.clone();
        int i = 1, longi = l1.longitud();
        if (!l1.esVacia()) {
            // Si la lista no es vacia hacer
            while (longi > 0) {
                invert.insertar(listaClon.recuperar(longi), i);
                longi--;
                i++;
            }
        } else {
            invert = listaClon;
        }
        return invert;
    }

    public static Lista intercalar(Lista l1, Lista l2) {
        //Recibe dos listas L1 y L2 y devuelve una lista nueva con los elementos de L1 y L2 concatenados
        int longi = l1.longitud() + l2.longitud(), j = 1, k = 1;
        Lista ret = new Lista();
        for (int i = 1; i <= longi; i++) {
            if ((i % 2) == 0) {
                ret.insertar(l2.recuperar(j), i);
                j++;
            } else {
                ret.insertar(l1.recuperar(k), i);
                k++;
            }

        }
        return ret;
    }

    public static int contarIter(Lista l1, Object elem) {
        //Cuenta iterativamente las apariciones de elem en l1
        int longi = l1.longitud(), ret = 0;
        for (int i = 1; i <= longi; i++) {
            if (l1.recuperar(i).equals(elem)) {
                ret++;
            }
        }
        return ret;
    }

    public static int contarRecur(Lista l1, Object elem) {
        //Cuenta recursivamente las apariciones de elem en l1 
        return contarRecurAux(l1, elem, 1, 0);
    }

    private static int contarRecurAux(Lista l1, Object elem, int cont, int veces) {
        int ret = 0;
        if (cont > l1.longitud()) {
            ret = veces;
        } else {
            if (l1.recuperar(cont).equals(elem)) {
                veces++;
            }
            cont++;
            ret = contarRecurAux(l1, elem, cont, veces);
        }
        return ret;
    }

    public static boolean esCapicua(Lista l1) {
        //Verifica si la lista es capicua
        boolean ret = true;
        int longi = l1.longitud(), cont = 1, j = l1.longitud();
        Cola c1 = new Cola(), c2 = new Cola();
        for (int i = 1; i == longi; i++) {
            c1.poner(l1.recuperar(i));
            c2.poner(l1.recuperar(j));
            j--;
        }
        while (!c1.esVacia() && !c2.esVacia() && ret == true) {
            if(c1.obtenerFrente().equals(c2.obtenerFrente())){
                ret = true;
                c1.sacar();
                c2.sacar();
            } else {
                ret = false;
            }
        }
        return ret;
    }
}