package test.lineales;

public class MixLineales {
    
    public static void main(String [] args){

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
        Lista nueva = new Lista();
        Cola clon = c1.clone();
        clon.poner('$');
        Cola col = new Cola();
        Pila pil = new Pila();
        int pos = 1;
        int cont = 1;

        while (!clon.esVacia()) {
            if (clon.obtenerFrente().equals('$')) {
                if (cont % 2 != 0) {
                    while (!pil.esVacia()) {
                        nueva.insertar(pil.obtenerTope(), pos);
                        pil.desapilar();
                        pos++;
                    }
                    col.vaciar();
                } else {
                    while (!col.esVacia()) {
                        nueva.insertar(col.obtenerFrente(), pos);
                        col.sacar();
                        pos++;
                    }
                    pil.vaciar();
                }
                nueva.insertar('$', pos);
                pos++;
                cont++;
            } else {
                pil.apilar(clon.obtenerFrente());
                col.poner(clon.obtenerFrente());
            }
            clon.sacar();
        }
        nueva.eliminar(pos-1);
        return nueva;
    }
}
