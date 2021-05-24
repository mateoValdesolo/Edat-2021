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
        if (this.ultimo < this.TAMANIO - 1) {
            this.heap[this.ultimo + 1] = elem;

            this.ultimo++;
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
                 if(posH < this.ultimo){
                    //hijoMenor tiene hermano derecho
                    if(this.heap[posH + 1].compareTo(this.heap[posH]) < 0){
                        //El hijo derecho es el menor de los dos.
                        posH++;
                    }
                 }
                 //Compara al hijo menor con el padre.
                 if(this.heap[posH].compareTo(temp) < 0){
                    //El hijo es menor que el padre, los intercambia.
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                 } else {
                     //El padre es meno que sus hijos, esta bien ubicado.
                     salir = true;
                 }
            } else {
                //El temp es una hoja, esta bien ubicado.
                salir = true;
            }
        }
    }

    private void hacerSubir(int posElem) {

    }

    public String toString() {
        String ret = "";
        for (int i = 1; i <= ultimo; i++) {
            ret += "Padre: " + this.heap[i];
            if (i * 2 <= this.ultimo) {
                ret += " HI: " + this.heap[i * 2];
            } else {
                ret += " HI: - ";
            }
            if ((i * 2) + 1 <= this.ultimo) {
                ret += " HD : " + this.heap[(i * 2) + 1] + "\n";
            } else {
                ret += " HD : - \n";
            }
        }
        return ret;
    }
}
