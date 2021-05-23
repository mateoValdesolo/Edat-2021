package test.lineales;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class MixLineales {

    public static void main(String[] args) {
        Lista l1 = new Lista();
        Cola c1 = new Cola();
        l1.insertar(8, 1);
        l1.insertar(6, 2);
        l1.insertar(2, 3);
        l1.insertar(7, 4);
        l1.insertarAnterior(7, 5);
        System.out.println(l1.toString());
        c1.poner('a');
        c1.poner('b');
        c1.poner('c');
        c1.poner('$');
        c1.poner('d');
        c1.poner('e');
        c1.poner('$');
        c1.poner('f');
        c1.poner('g');
        System.out.println(c1.toString());
        System.out.println(generar(c1));

    }

    public static boolean verificarBalanceo(Cola q) {
        Pila pila1 = new Pila();
        Cola clon = q.clone();
        Object aux = q.obtenerFrente();
        boolean ret = true;
        while (aux != null && ret) {
            if (aux.equals('(') || aux.equals('[') || aux.equals('{')) {
                pila1.apilar(aux);
            } else {
                if (aux.equals(')')) {
                    if (!pila1.obtenerTope().equals('(')) {
                        ret = false;
                    } else {
                        pila1.desapilar();
                    }
                } else {
                    if (aux.equals(']')) {
                        if (!pila1.obtenerTope().equals('[')) {
                            ret = false;
                        } else {
                            pila1.desapilar();
                        }
                    } else {
                        if (aux.equals('}')) {
                            if (!pila1.obtenerTope().equals('{')) {
                                ret = false;
                            } else {
                                pila1.desapilar();
                            }
                        }
                    }
                }
            }
            clon.sacar();
            aux = clon.obtenerFrente();
        }
        if (!pila1.esVacia()) {
            ret = false;
        }
        return ret;
    }

    public static Cola generar(Cola c1) {

        Cola clon = c1.clone();
        Cola nueva = new Cola();

        if (!clon.esVacia()) {
            Pila pila = new Pila();
            Lista lista = new Lista();
            int pos = 0;
            Object aux = clon.obtenerFrente();
            while (aux != null) {
                if ((char) aux == '#') {
                    while (!pila.esVacia()) {
                        nueva.poner(pila.obtenerTope());
                        pila.desapilar();
                    }
                    while (!lista.esVacia()) {
                        nueva.poner(lista.recuperar(1));
                        lista.eliminar(1);
                        pos--;
                    }
                    nueva.poner('#');
                } else {
                    pila.apilar(aux);
                    lista.insertar(aux, pos + 1);
                    nueva.poner(aux);
                    pos++;
                }
                clon.sacar();
                aux = clon.obtenerFrente();
            }
            while (!pila.esVacia()) {
                nueva.poner(pila.obtenerTope());
                pila.desapilar();
            }
            while (!lista.esVacia()) {
                nueva.poner(lista.recuperar(1));
                lista.eliminar(1);
            }
        }
        return nueva;

    }

    public static Cola generarOtraCola(Cola c1) {
        Cola nueva = new Cola();
        Cola clon = c1.clone();
        Pila aux = new Pila();

        while (!clon.esVacia()) {
            if ((char) clon.obtenerFrente() == '$') {
                while (!aux.esVacia()) {
                    nueva.poner(aux.obtenerTope());
                    aux.desapilar();
                }
            } else {
                aux.apilar(clon.obtenerFrente());
            }
            nueva.poner(clon.obtenerFrente());
            clon.sacar();

            if (clon.esVacia()) {
                while (!aux.esVacia()) {
                    nueva.poner(aux.obtenerTope());
                    aux.desapilar();
                }
            }
        }
        return nueva;
    }

    public static Lista crearLista(Cola c1) {
        /*
         * Recibe por parametro una cola que tiene el siguiente formato:
         * c1$c2$c3$....$cn, donde cada ci es una sucesion de elementos de la cola, se
         * debe generar como salida una lista con todas las secuencias impares
         * invertidas y las pares igual que la original
         */
        Lista nueva = new Lista();
        Cola clon = c1.clone();
        Pila pil = new Pila();
        int pos = 1;
        int cont = 1;

        if (!clon.esVacia()) {
            while (!clon.esVacia()) {
                if (cont % 2 == 0) {
                    if ((char) clon.obtenerFrente() == '$') {
                        cont++;
                    }
                    nueva.insertar('$', pos);
                    nueva.insertar(clon.obtenerFrente(), pos);
                    pos++;
                    
                } else {
                    if ((char) clon.obtenerFrente() == '$') {
                        cont++;
                        while (!pil.esVacia()) {
                            nueva.insertar(pil.obtenerTope(), pos);
                            pil.desapilar();
                            pos++;
                        }
                        nueva.insertar('$', pos);
                        pos++;
                    } else {
                        pil.apilar(clon.obtenerFrente());
                    }
                }
                clon.sacar();
            }
            if (cont % 2 != 0) {
                while (!pil.esVacia()) {
                    nueva.insertar(pil.obtenerTope(), pos);
                    pil.desapilar();
                    pos++;
                }
            }
        }
        return nueva;
    }
}
