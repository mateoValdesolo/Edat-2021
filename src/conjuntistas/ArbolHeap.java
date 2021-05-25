package conjuntistas;

public class ArbolHeap {

    private int TAMANIO = 30;
    private Comparable[] heap;
    private int ultimo = 0;

    public ArbolHeap() {
        // Crea un árbol sin elementos.
        this.heap = new Comparable[this.TAMANIO];
        this.ultimo = 0;
    }

    public boolean insertar(Comparable elem) {
        /*
         * Recibe un elemento y lo inserta en el árbol según el algoritmo que se
         * explicará en la siguiente sección. Si la operación termina con éxito devuelve
         * verdadero y falso en caso contrario.
         */
        boolean exito = false;
        if (this.ultimo + 1 > this.TAMANIO) {
            exito = false;
        } else {
            this.ultimo++;
            this.heap[ultimo] = elem;
            if (!esVacio()) {
                hacerSubir(ultimo);
            }
            exito = true;
        }
        return exito;
    }

    public boolean eliminarCima() {
        /*
         * Elimina el elemento de la raíz (o cima del montículo) según el algoritmo que
         * se explicará en la siguiente sección. Si la operación termina con éxito
         * devuelve verdadero y falso si el árbol estaba vacío.
         */
        boolean exito = false;
        if (!esVacio()) {
            // Saca la raiz y pone la ultima hoja en su lugar.
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            // Reestablece la propeidad de heap minimo.
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    public Comparable recuperarCima() {
        /*
         * Devuelve el elemento que está en la raíz (cima del montículo). Precondición:
         * el árbol no está vacío (si está vacío no se puede asegurar el funcionamiento
         * de la operación).
         */
        return this.heap[1];
    }

    public boolean esVacio() {
        /*
         * Devuelve falso si hay al menos un elemento cargado en la tabla y verdadero en
         * caso contrario.
         */
        return this.ultimo == 0;
    }

    public void vaciar() {
        /*
         * Vacia la estructura
         */
        for (int i = 0; i <= this.ultimo; i++) {
            this.heap[i] = null;
        }
        this.ultimo = 0;
    }

    private void hacerBajar(int posPadre) {
        /*
         * Empuja el elemento que se colocó temporalmente en la raíz, intercambiándolo
         * repetidamente por el menor de sus hijos.
         */
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                // temp tiene al menos un hijo (izq) y lo considera menor.
                if (posH < this.ultimo) {
                    // hijoMenor tiene hermano derecho
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        // El hijo derecho es el menor de los dos.
                        posH++;
                    }
                }
                // Compara al hijo menor con el padre.
                if (this.heap[posH].compareTo(temp) < 0) {
                    // El hijo es menor que el padre, los intercambia.
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    // El padre es meno que sus hijos, esta bien ubicado.
                    salir = true;
                }
            } else {
                // El temp es una hoja, esta bien ubicado.
                salir = true;
            }
        }
    }

    private void hacerSubir(int posElem) {
        int posPadre = 1;
        boolean salir = false;
        while (!salir) {
            posPadre = posElem / 2;
            Comparable temp = this.heap[posPadre];
            if (posPadre > 0) {
                if (this.heap[posElem].compareTo(this.heap[posPadre]) < 0) {
                    this.heap[posPadre] = this.heap[posElem];
                    this.heap[posElem] = temp;
                    posElem = posPadre;
                } else {
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    

    public String toString() {
        // Devuelve la pila en un string
        String ret = "[";
        if (esVacio()) {
            ret = "[]";
        } else {
            for (int i = 1; i <= this.ultimo; i++) {
                if(i == this.ultimo){
                    ret = ret + this.heap[i];
                } else {
                    ret = ret + this.heap[i] + ", ";
                }
            }
            ret += "]";
        }
        return ret;
    }
}
