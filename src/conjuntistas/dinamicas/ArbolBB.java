package conjuntistas.dinamicas;

import lineales.dinamicas.Lista;

public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean pertenece(Comparable elem) {
        /*
         * Devuelve verdadero si el elemento recibido por parámetro está en el árbol y
         * falso en caso contrario.
         */
        boolean exito = false;
        if (!esVacio()) {
            exito = perteneceAux(this.raiz, elem);
        }
        return exito;
    }

    private boolean perteneceAux(NodoABB nodo, Comparable elem) {
        boolean exito = false;
        int res = nodo.getElem().compareTo(elem);
        if (res == 0) {
            exito = true;
        } else {
            if (res < 0) {
                if (nodo.getDerecho() != null) {
                    exito = perteneceAux(nodo.getDerecho(), elem);
                }
            } else {
                if (nodo.getIzquierdo() != null) {
                    exito = perteneceAux(nodo.getIzquierdo(), elem);
                }
            }
        }
        return exito;
    }

    public boolean insertar(Comparable elem) {
        /*
         * Recibe un elemento y lo agrega en el árbol de manera ordenada. Si el elemento
         * ya se encuentra en el árbol no se realiza la inserción. Devuelve verdadero si
         * el elemento se agrega a la estructura y falso en caso contrario.
         */
        boolean exito = true;
        if (esVacio()) {
            this.raiz = new NodoABB(elem, null, null);
        } else {
            exito = insertarAux(this.raiz, elem);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB nodo, Comparable elem) {
        boolean exito = true;
        int compar = elem.compareTo(nodo.getElem());
        if (compar == 0) {
            // Elemento repetido
            exito = false;
        } else {
            if (compar < 0) {
                // Elem es menor a nodo.getElem()
                // Si tiene HI baja a la izquierda, sino agrega elem
                if (nodo.getIzquierdo() != null) {
                    exito = insertarAux(nodo.getIzquierdo(), elem);
                } else {
                    nodo.setIzquierdo(new NodoABB(elem, null, null));
                }
            } else {
                // Elemento mayor que nodo.getElem()
                // Si tiene HD baja a la derecha, sino agrega elemento
                if (nodo.getDerecho() != null) {
                    exito = insertarAux(nodo.getDerecho(), elem);
                } else {
                    nodo.setDerecho(new NodoABB(elem, null, null));
                }
            }
        }
        return exito;
    }

    public boolean eliminar(Comparable elem) {
        /*
         * Recibe el elemento que se desea eliminar y se procede a removerlo del árbol.
         * Si no se encuentra el elemento no se puede realizar la eliminación. Devuelve
         * verdadero si el elemento se elimina de la estructura y falso en caso
         * contrario.
         */
        boolean ret = false;
        if (pertenece(elem)) {
            ret = eliminarAux(this.raiz, elem, null);
        }
        return ret;
    }

    private boolean eliminarAux(NodoABB nodo, Comparable elem, NodoABB padre) {
        int res = nodo.getElem().compareTo(elem);
        boolean ret = true;
        if (nodo != null) {
            if (res == 0) {
                // Caso 1: Sin hijos.
                if (nodo.getDerecho() == null && nodo.getIzquierdo() == null) {
                    caso1(padre, elem);
                } else {
                    // Caso 2: Con hijo derecho o izquierdo.
                    if (nodo.getDerecho() != null && nodo.getIzquierdo() == null) {
                        caso2(nodo, padre, 'D');
                    } else {
                        if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
                            caso2(nodo, padre, 'I');
                        } else {
                            // Caso 3: con ambos hijos.
                            caso3(nodo);
                        }
                    }
                }
            } else {
                padre = nodo;
                if (res > 0) {
                    ret = eliminarAux(nodo.getIzquierdo(), elem, padre);
                } else {
                    ret = eliminarAux(nodo.getDerecho(), elem, padre);
                }
            }
        }
        return ret;
    }

    private void caso1(NodoABB padre, Comparable elem) {
        // Eliminacion de hoja.
        if (padre == null) {
            this.raiz = null;
        } else {
            if (padre.getDerecho().getElem().compareTo(elem) == 0) {
                padre.setDerecho(null);
            } else {
                padre.setIzquierdo(null);
            }
        }
    }

    private void caso2(NodoABB nodo, NodoABB padre, char pos) {
        // Eliminacion con 1 hijo.
        /*
         * if(padre.getIzquierdo() != null &&
         * padre.getIzquierdo().getElem().compareTo(nodo.getElem()) == 0){ if (pos ==
         * 'D'){ padre.setIzquierdo(nodo.getDerecho()); } else {
         * padre.setIzquierdo(nodo.getIzquierdo()); } }else { if (pos == 'D'){
         * padre.setDerecho(nodo.getDerecho()); } else {
         * padre.setDerecho(nodo.getIzquierdo()); } }
         */
        if (pos == 'D') {
            if (padre.getIzquierdo() != null && padre.getIzquierdo().getElem().compareTo(nodo.getElem()) == 0) {
                padre.setIzquierdo(nodo.getDerecho());
            } else {
                padre.setDerecho(nodo.getDerecho());
            }
        } else {
            if (padre.getIzquierdo() != null && padre.getIzquierdo().getElem().compareTo(nodo.getElem()) == 0) {
                padre.setIzquierdo(nodo.getIzquierdo());
            } else {
                padre.setDerecho(nodo.getIzquierdo());
            }
        }
    }

    private void caso3(NodoABB nodo) {
        // Eliminacion con dos hijos.
        NodoABB aux, aux2 = null, padr = null;
        if (nodo.getIzquierdo().getDerecho() == null) {
            nodo.setElem(nodo.getIzquierdo().getElem());
            nodo.setIzquierdo(nodo.getIzquierdo().getIzquierdo());
        } else {
            aux = nodo.getIzquierdo();
            while (aux.getDerecho() != null) {
                padr = aux;
                aux = aux.getDerecho();
            }
            padr.setDerecho(null);
            nodo.setElem(aux.getElem());
        }
    }

    public Lista listar() {
        /*
         * Recorre el árbol completo y devuelve una lista ordenada con los elementos que
         * se encuentran almacenados en él.
         */
        Lista ret = new Lista();
        listarAux(this.raiz, ret);
        return ret;
    }

    private void listarAux(NodoABB nodo, Lista lis) {
        if (nodo != null) {
            listarAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        /*
         * Recorre parte del árbol (sólo lo necesario) y devuelve una lista ordenada con
         * los elementos que se encuentran en el intervalo [elemMinimo, elemMaximo].
         */
        Lista ret = new Lista();
        listarRangoAux(this.raiz, elemMinimo, elemMaximo, ret);
        return ret;
    }

    private void listarRangoAux(NodoABB nodo, Comparable minim, Comparable maxim, Lista lis) {
        if (nodo != null) {
            if (nodo.getElem().compareTo(minim) > 0) {
                listarRangoAux(nodo.getIzquierdo(), minim, maxim, lis);
            }
            if (nodo.getElem().compareTo(minim) >= 0 && nodo.getElem().compareTo(maxim) <= 0) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            }
            if (nodo.getElem().compareTo(maxim) < 0) {
                listarRangoAux(nodo.getDerecho(), minim, maxim, lis);
            }
        }
    }

    public Comparable minimoElem() {
        /*
         * Recorre la rama correspondiente y devuelve el elemento más pequeño almacenado
         * en el árbol.
         */
        NodoABB nodo = this.raiz;
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo.getElem();
    }

    public Comparable maximoElem() {
        /*
         * Recorre la rama correspondiente y devuelve el elemento más grande almacenado
         * en el árbol.
         */
        NodoABB nodo = this.raiz;
        while (nodo.getDerecho() != null) {
            nodo = nodo.getDerecho();
        }
        return nodo.getElem();
    }

    public boolean esVacio() {
        /*
         * Devuelve falso si hay al menos un elemento en el árbol y verdadero en caso
         * contrario.
         */
        return this.raiz == null;
    }

    public void vaciar() {
        /*
         * Vacia la estructura.
         */
        this.raiz = null;
    }

    public ArbolBB clone() {
        /*
         * Genera y devuelve un árbol binario que es equivalente (igual estructura y
         * contenido de los nodos) que el árbol original.
         */
        ArbolBB clon = new ArbolBB();
        if (!esVacio()) {
            NodoABB nod = new NodoABB(this.raiz.getElem(), null, null);
            clon.raiz = nod;
            cloneAux(nod, this.raiz);
        }
        return clon;
    }

    private void cloneAux(NodoABB aux, NodoABB nodo) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                aux.setIzquierdo(new NodoABB(nodo.getIzquierdo().getElem(), null, null));
                cloneAux(aux.getIzquierdo(), nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                aux.setDerecho(new NodoABB(nodo.getDerecho().getElem(), null, null));
                cloneAux(aux.getDerecho(), nodo.getDerecho());
            }
        }
    }

    public String toString() {
        /*
         * Genera y devuelve una cadena de caracteres que indica cuál es la raíz del
         * árbol y quienes son los hijos de cada nodo.
         */
        String ret = "[]";
        if (!esVacio()) {
            ret = toStringAux(this.raiz, "");
        }
        return ret;
    }

    private String toStringAux(NodoABB nodo, String str) {
        if (nodo != null) {
            NodoABB izq = nodo.getIzquierdo(), der = nodo.getDerecho();
            str += "Nodo: " + nodo.getElem();
            if (izq != null && der != null) {
                str += " HI: " + izq.getElem();
                str += " HD: " + der.getElem() + "\n";
            } else {
                if (izq == null && der == null) {
                    str += " HI: - ";
                    str += " HD: - " + "\n";
                } else {
                    if (izq == null) {
                        str += " HI: -";
                        str += " HD: - " + der.getElem() + "\n";
                    } else {
                        if (der == null) {
                            str += " HI: " + izq.getElem();
                            str += " HD: - " + "\n";
                        }
                    }
                }
            }
            str = toStringAux(izq, str);
            str = toStringAux(der, str);
        }
        return str;
    }

    public int diferenciaCandidatos(Comparable elem) {
        /*
         * Retorna la diferencia entre el menor elemento del lado derecho y el mayor del
         * lado izquierdo, del subarbol cuya raiz es el elemento pasado por parametro.
         * Si el elemento no existe, retorna -1, y si alguno de los subarboles es nulo
         * retorna -2.
         */
        int ret = -1;
        if (pertenece(elem)) {
            ret = diferenciaCandidatosAux(this.raiz, elem);
        }
        return ret;
    }

    private int diferenciaCandidatosAux(NodoABB nodo, Comparable elem) {
        int ret = -2, compar, maxIzq, minDer;
        if (nodo != null) {
            compar = elem.compareTo(nodo.getElem());
            if (compar == 0) {
                if (nodo.getDerecho() != null && nodo.getIzquierdo() != null) {
                    NodoABB aux = nodo.getIzquierdo(), aux1 = nodo.getDerecho();
                    while (aux.getDerecho() != null) {
                        aux = aux.getDerecho();
                    }
                    while (aux1.getIzquierdo() != null) {
                        aux1 = aux1.getIzquierdo();
                    }
                    maxIzq = (int) aux.getElem();
                    minDer = (int) aux1.getElem();
                    ret = maxIzq - minDer;
                }
            } else {
                if (compar < 0) {
                    if (nodo.getIzquierdo() != null) {
                        ret = diferenciaCandidatosAux(nodo.getIzquierdo(), elem);
                    }
                } else {
                    if (nodo.getDerecho() != null) {
                        ret = diferenciaCandidatosAux(nodo.getDerecho(), elem);
                    }
                }
            }
        }
        return ret;
    }

    public int amplitudSubarbol(Comparable elem) {
        /*
         * Retorna la diferencia entre el mayor y el menor elemento del subarbol cuya
         * raiz es el elemento pasado por parametro. Si el elemento no existe, retorna
         * -1 y si alguno de los subarboles es nulo retorna la diferencia entre el hijo
         * que esta y la raiz del subarbol.
         */
        int ret = -1;
        if (pertenece(elem)) {
            ret = amplitudSubarbolAux(this.raiz, elem);
        }
        return ret;
    }

    private int amplitudSubarbolAux(NodoABB nodo, Comparable elem) {
        int ret = 0, compar, maxIzq, minDer;
        if (nodo != null) {
            compar = elem.compareTo(nodo.getElem());
            if (compar == 0) {
                if (nodo.getDerecho() != null && nodo.getIzquierdo() != null) {
                    NodoABB aux = nodo.getIzquierdo(), aux1 = nodo.getDerecho();
                    while (aux.getDerecho() != null) {
                        aux = aux.getDerecho();
                    }
                    while (aux1.getIzquierdo() != null) {
                        aux1 = aux1.getIzquierdo();
                    }
                    maxIzq = (int) aux.getElem();
                    minDer = (int) aux1.getElem();
                    ret = maxIzq - minDer;
                } else {
                    if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
                        NodoABB aux = nodo.getIzquierdo();
                        while (aux.getDerecho() != null) {
                            aux = aux.getDerecho();
                        }
                        ret = ((int) elem) - ((int) aux.getElem());
                    } else {
                        if (nodo.getDerecho() != null) {
                            NodoABB aux = nodo.getDerecho();
                            while (aux.getIzquierdo() != null) {
                                aux = aux.getIzquierdo();
                            }
                            ret = ((int) elem) - ((int) aux.getElem());
                        }
                    }
                }
            } else {
                if (compar < 0) {
                    if (nodo.getIzquierdo() != null) {
                        ret = amplitudSubarbolAux(nodo.getIzquierdo(), elem);
                    }
                } else {
                    if (nodo.getDerecho() != null) {
                        ret = amplitudSubarbolAux(nodo.getDerecho(), elem);
                    }
                }
            }
        }
        return ret;
    }

    public Lista listarMayoresQue(int valor, Comparable elem) {
        /*
         * Devuelve una Lista con los elementos mayores que valor del subárbol con raíz
         * elem. Si no existe elem en el árbol, el método deberá devolver una lista
         * vacía.
         */
        Lista ret = new Lista();
        if (!esVacio()) {
            listarMayoresQueAux(this.raiz, valor, elem, ret);
        }
        return ret;
    }

    private void listarMayoresQueAux(NodoABB nodo, Comparable valor, Comparable elem, Lista lis) {
        boolean exito = false;
        int res = nodo.getElem().compareTo(elem);
        if (res == 0) {
            agregarListaMayores(nodo, valor, lis);
        } else {
            if (res < 0) {
                if (nodo.getDerecho() != null) {
                    listarMayoresQueAux(nodo.getDerecho(), valor, elem, lis);
                }
            } else {
                if (nodo.getIzquierdo() != null) {
                    listarMayoresQueAux(nodo.getIzquierdo(), valor, elem, lis);
                }
            }
        }
    }

    private void agregarListaMayores(NodoABB nodo, Comparable valor, Lista lis) {
        if (nodo != null) {
            int compar = nodo.getElem().compareTo(valor);
            if (nodo.getIzquierdo() != null && compar > 0) {
                agregarListaMayores(nodo.getIzquierdo(), valor, lis);
            }
            if (compar > 0) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            }
            if (nodo.getDerecho() != null) {
                agregarListaMayores(nodo.getDerecho(), valor, lis);
            }
        }
    }

    public ArbolBB clonarParteInvertida(Comparable elem) {
        /*
         * Devuelve un nuevo árbol que es una copia del subárbol original, cuya raíz es
         * el elemento dado y cada hijo está cambiado de lugar . Si el elemento no
         * existe, el árbol que devuelve es vacío.
         */
        ArbolBB clon = new ArbolBB();
        if (!esVacio()) {
            clonarParteInvertidaAux(this.raiz, clon, elem);
        }
        return clon;
    }

    private void clonarParteInvertidaAux(NodoABB nodo, ArbolBB clon, Comparable elem) {
        if (nodo != null) {
            int res = nodo.getElem().compareTo(elem);
            if (res == 0) {
                clon.raiz = new NodoABB(nodo.getElem(), null, null);
                clonarInvertido(nodo, clon.raiz);
            } else {
                if (res < 0) {
                    if (nodo.getDerecho() != null) {
                        clonarParteInvertidaAux(nodo.getDerecho(), clon, elem);
                    }
                } else {
                    if (nodo.getIzquierdo() != null) {
                        clonarParteInvertidaAux(nodo.getIzquierdo(), clon, elem);
                    }
                }
            }
        }
    }

    private void clonarInvertido(NodoABB nodo, NodoABB clon) {
        if (nodo != null) {
            if (nodo.getDerecho() != null) {
                clon.setIzquierdo(new NodoABB(nodo.getDerecho().getElem(), null, null));
                clonarInvertido(nodo.getDerecho(), clon.getIzquierdo());
            }
            if (nodo.getIzquierdo() != null) {
                clon.setDerecho(new NodoABB(nodo.getIzquierdo().getElem(), null, null));
                clonarInvertido(nodo.getIzquierdo(), clon.getDerecho());
            }
        }
    }

    public Comparable mejorCandidato(Comparable elem) {
        /*
         * Retorna la diferencia entre el menor elemento del lado derecho y el mayor del
         * lado izquierdo, del subarbol cuya raiz es el elemento pasado por parametro.
         * Si el elemento no existe, retorna -1, y si alguno de los subarboles es nulo
         * retorna -2.
         */
        int ret = 0;
        if (pertenece(elem)) {
            ret = mejorCandidatoAux(this.raiz, elem);
        }
        return ret;
    }

    private int mejorCandidatoAux(NodoABB nodo, Comparable elem) {
        int ret = -1, compar, maxIzq, minDer;
        if (nodo != null) {
            compar = elem.compareTo(nodo.getElem());
            if (compar == 0) {
                if (nodo.getDerecho() != null && nodo.getIzquierdo() != null) {
                    NodoABB aux = nodo.getIzquierdo(), aux1 = nodo.getDerecho();
                    while (aux.getDerecho() != null) {
                        aux = aux.getDerecho();
                    }
                    while (aux1.getIzquierdo() != null) {
                        aux1 = aux1.getIzquierdo();
                    }
                    maxIzq = (int) aux.getElem();
                    minDer = (int) aux1.getElem();
                    if (Math.abs(maxIzq - (int) elem) > Math.abs(minDer - (int) elem)) {
                        ret = minDer;
                    } else {
                        ret = maxIzq;
                    }
                }
            } else {
                if (compar < 0) {
                    if (nodo.getIzquierdo() != null) {
                        ret = mejorCandidatoAux(nodo.getIzquierdo(), elem);
                    }
                } else {
                    if (nodo.getDerecho() != null) {
                        ret = mejorCandidatoAux(nodo.getDerecho(), elem);
                    }
                }
            }
        }
        return ret;
    }

    public Lista listarMenores(Comparable elem) {
        /*
         * Dado un elemento devuelve una lista con los elementos estrictamente menores
         * que elem ordenados de menor a mayor.
         */
        Lista lis = new Lista();
        if (pertenece(elem)) {
            listarMenoresAux(this.raiz, lis, elem);
        }
        return lis;
    }

    private void listarMenoresAux(NodoABB nodo, Lista lis, Comparable elem) {
        int compar;
        if (nodo != null) {
            compar = elem.compareTo(nodo.getElem());
            if (compar == 0) {
                agregarListaMenores(nodo, elem, lis);
            } else {
                if (compar < 0) {
                    if (nodo.getIzquierdo() != null) {
                        listarMenoresAux(nodo.getIzquierdo(), lis, elem);
                    }
                } else {
                    if (nodo.getDerecho() != null) {
                        listarMenoresAux(nodo.getDerecho(), lis, elem);
                    }
                }
            }
        }
    }

    private void agregarListaMenores(NodoABB nodo, Comparable elem, Lista lis) {
        if (nodo != null) {
            int compar = nodo.getElem().compareTo(elem);
            if (nodo.getIzquierdo() != null) {
                agregarListaMenores(nodo.getIzquierdo(), elem, lis);
            }
            if (compar < 0) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            }
            if (nodo.getDerecho() != null) {
                agregarListaMenores(nodo.getDerecho(), elem, lis);
            }
        }
    }

    public int sumarPreorden(Comparable elem, int k) {
        /*
         * Recibe como parámetro el elemento elem y el valor entero k. Se debe encontrar
         * elem en el árbol, y para ese subárbol de raíz elem, recorrer en preorden y
         * sumar los valores de cada nodo visitado hasta que esa suma llegue a superar
         * el valor k, y ahí detener el recorrido. (elem se debe incluir en la suma.) El
         * método deberá devolver el valor de la suma acumulada. Si el subárbol se
         * recorre por completo sin llegar a sumar el valor k, se deberá devolver el
         * valor negativo de la suma acumulada. Si el árbol es vacío, o bien no existe
         * elem, el método deberá devolver 0.
         */
        int ret = 0;
        if (!esVacio()) {
            ret = sumarPreordenAux(this.raiz, elem, k);
        }
        return ret;
    }

    private int sumarPreordenAux(NodoABB nodo, Comparable elem, int valor) {
        int compar, sum = 0;
        if (nodo != null) {
            compar = elem.compareTo(nodo.getElem());
            if (compar == 0) {
                sum = sumaPreorden(nodo, valor, 0);
                if (sum < valor) {
                    sum = -sum;
                }
            } else {
                if (compar < 0) {
                    if (nodo.getIzquierdo() != null) {
                        sum = sumarPreordenAux(nodo.getIzquierdo(), elem, valor);
                    }
                } else {
                    if (nodo.getDerecho() != null) {
                        sum = sumarPreordenAux(nodo.getDerecho(), elem, valor);
                    }
                }
            }
        }
        return sum;
    }

    private int sumaPreorden(NodoABB nodo, int valor, int suma) {
        if (nodo != null && valor > suma) {
            suma += (int) nodo.getElem();
            suma = sumaPreorden(nodo.getIzquierdo(), valor, suma);
            suma = sumaPreorden(nodo.getDerecho(), valor, suma);
        }
        return suma;
    }
}
