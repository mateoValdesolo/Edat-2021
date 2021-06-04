package conjuntistas;

public class TablaHash {
    // Hash Cerrado

    public static final int TAMANIO = 25;
    private CeldaHash[] hash;
    private int cant;
    public static final int VACIO = 0;
    public static final int OCUPADO = 1;
    public static final int BORRADO = -1;

    public TablaHash() {
        this.hash = new CeldaHash[this.TAMANIO];
        cant = 0;
    }

    public boolean pertenece(Object elem) {
        /*
         * Verifica si el elemento se encuentra en la estructura.
         */

    }

    public boolean insertar(Object elem) {
        /*
         * Inserta el elemento en la estructura.
         */

    }

    public boolean eliminar(Object buscado) {
        /*
         * Elimina el elemento de la estructura.
         */
        // Calcula posicion inicial e incremento
        int pos = buscado.hashCode() % this.TAMANIO;
        int incremento = funciones.rehash(buscado) % this.TAMANIO;
        boolean encontrado = false;
        int intento = 1;
        // Busca el elemento hasta encontrarlo o encontrar una celda vacia
        // o para despues de TAM intentos
        while (!encontrado && intento < this.TAMANIO && this.hash[pos].getEstado() != VACIO) {
            if (this.hash[pos].getEstado() == OCUPADO) {
                encontrado = this.hash[pos].getElem() == buscado;
                if (encontrado) {
                    // Si lo encuentra lo marca y para el ciclo
                    this.hash[pos].setEstado(BORRADO);
                    this.cant--;
                }
            }
            pos = (pos + intento * incremento) & this.TAMANIO;
            intento++;
        }
        return encontrado;
    }

}
