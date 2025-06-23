
package EDD;

/**
* La clase {@code Lista} implementa una lista dinámica simple que permite almacenar, agregar,
* eliminar y buscar elementos de cualquier tipo. Internamente utiliza un arreglo que se redimensiona 
* automáticamente cuando se alcanza la capacidad máxima.
* 
* @author Iker Solar, Vyckhy Sarmiento, Sofía Elasmar
* 
*/

public class Lista {
    private Object[] elementos;
    private int tamanoActual;
    private int capacidad;

    /**
     * Comstructor. Crea una lista vacía con una capacidad inicial de 10 elementos.
     */
    public Lista() {
        this(10);
    }
    
    /**
     * Crea una lista vacía con una capacidad inicial específica.
     * 
     * @param capacidadInicial La capacidad inicial de la lista. Si es menor o igual a cero, se asigna una capacidad de 10.
     */
    public Lista(int capacidadInicial) {
        if (capacidadInicial <= 0) {
            capacidadInicial = 10;
        }
        this.capacidad = capacidadInicial;
        elementos = new Object[this.capacidad];
        tamanoActual = 0;
    }
    
    /**
     * Agrega un elemento al final de la lista. Si la lista alcanza su capacidad máxima, se redimensiona automáticamente.
     * 
     * @param elemento El elemento que se desea agregar. Si es {@code null}, no se agrega.
     */
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
    
    
    /**
     * Obtiene el elemento almacenado en la posición especificada.
     * 
     * @param indice El índice del elemento a obtener.
     * @return El elemento en la posición indicada, o {@code null} si el índice es inválido.
     */
    public Object obtener(int indice) {
        if (indice < 0 || indice >= tamanoActual) {
            return null;
        }
        return elementos[indice];
    }
    
    /**
     * Elimina el elemento en la posición especificada, desplazando los elementos posteriores hacia la izquierda.
     * 
     * @param indice La posición del elemento a eliminar. Si el índice es inválido, no se realiza ninguna acción.
     */
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
    
    /**
     * Verifica si la lista contiene un elemento específico.
     * 
     * @param elemento El elemento que se desea buscar.
     * @return {@code true} si el elemento está en la lista, {@code false} en caso contrario.
     */
    public boolean contiene(Object elemento) {
        if (elemento == null) return false;
        for (int i = 0; i < tamanoActual; i++) {
            if (elemento.equals(elementos[i])) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Retorna la cantidad actual de elementos almacenados en la lista.
     * 
     * @return El tamaño de la lista.
     */
    public int getTamano() {
        return tamanoActual;
    }
    
    /**
     * Verifica si la lista está vacía.
     * 
     * @return {@code true} si la lista no contiene elementos, {@code false} en caso contrario.
     */
    public boolean estaVacia() {
        return tamanoActual == 0;
    }

    /**
     * Aumenta la capacidad de la lista al doble de su tamaño actual.
     * Este método se llama automáticamente cuando la lista alcanza su capacidad máxima.
     */
    private void redimensionar() {
        int nuevaCapacidad = capacidad * 2;
        Object[] nuevoArray = new Object[nuevaCapacidad];
        for (int i = 0; i < tamanoActual; i++) {
            nuevoArray[i] = elementos[i];
        }
        elementos = nuevoArray;
        capacidad = nuevaCapacidad;
    }
    
    /**
     * Elimina todos los elementos de la lista y la deja vacía.
     */
    public void limpiar() {
        for (int i = 0; i < tamanoActual; i++) {
            elementos[i] = null;
        }
        tamanoActual = 0;
    }
}