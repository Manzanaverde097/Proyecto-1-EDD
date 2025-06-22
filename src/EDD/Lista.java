
package EDD;



public class Lista {
    private Object[] elementos;
    private int tamanoActual;
    private int capacidad;

    public Lista() {
        this(10);
    }
    
    public Lista(int capacidadInicial) {
        if (capacidadInicial <= 0) {
            capacidadInicial = 10;
        }
        this.capacidad = capacidadInicial;
        elementos = new Object[this.capacidad];
        tamanoActual = 0;
    }

    public void agregar(Object elemento) {
        if (elemento == null) {
            return;
        }
        if (tamanoActual == elementos.length) {
            redimensionar();
        }
        elementos[tamanoActual] = elemento;
        tamanoActual++;
    }

    public Object obtener(int indice) {
        if (indice < 0 || indice >= tamanoActual) {
            return null;
        }
        return elementos[indice];
    }

    public void eliminar(int indice) {
        if (indice < 0 || indice >= tamanoActual) {
            return;
        }
        for (int i = indice; i < tamanoActual - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanoActual - 1] = null;
        tamanoActual--;
    }
    
    public boolean contiene(Object elemento) {
        if (elemento == null) return false;
        for (int i = 0; i < tamanoActual; i++) {
            if (elemento.equals(elementos[i])) {
                return true;
            }
        }
        return false;
    }

    public int getTamano() {
        return tamanoActual;
    }

    public boolean estaVacia() {
        return tamanoActual == 0;
    }

    private void redimensionar() {
        int nuevaCapacidad = capacidad * 2;
        Object[] nuevoArray = new Object[nuevaCapacidad];
        for (int i = 0; i < tamanoActual; i++) {
            nuevoArray[i] = elementos[i];
        }
        elementos = nuevoArray;
        capacidad = nuevaCapacidad;
    }
    
    public void limpiar() {
        for (int i = 0; i < tamanoActual; i++) {
            elementos[i] = null;
        }
        tamanoActual = 0;
    }
}