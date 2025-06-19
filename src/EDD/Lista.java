
package EDD;

import javax.swing.JOptionPane;

/**
 * Implementación de una lista enlazada 
 * Esta clase permite almacenar elementos de cualquier tipo (T) en una secuencia lineal,
 * con operaciones para insertar al final, obtener un elemento por índice y eliminar el primer elemento.
 *@author Vyckhy
 * @param <T> El tipo de elementos que se almacenarán en la lista.
 */
public class Lista<T> {
    //atributos
    /**
     * Nodo apuntador al primer elemento (cabeza) de la lista.
     * Si la lista está vacía, este será null.
     */
    private Nodo<T> pFirst; 
    /**
     * El número actual de elementos en la lista.
     */
    private int size; //tamaño de la lista

    //getters y setters
    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return El {@link Nodo} que es el primer elemento de la lista, o null si la lista está vacía.
     */
    public Nodo<T> getpFirst() {
        return pFirst;
    }
 /**
     * Obtiene el tamaño actual de la lista.
     *
     * @return El número de elementos contenidos en la lista.
     */
    public int getSize() {
        return size;
    }
   
   /**
     * Constructor para crear una nueva instancia de Lista vacía.
     * Inicializa el primer nodo a null y el tamaño a 0.
     */
    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }
 /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista no contiene elementos, false en caso contrario.
     */
    public boolean esVacia() {
        return pFirst == null;
    }
/**
     * Obtiene el tamaño actual de la lista.
     * Este método es un alias de {@link #getSize()}.
     *
     * @return El número de elementos contenidos en la lista.
     */
    public int tamano() {
        return size;
    }

     /**
     * Inserta un nuevo elemento al final de la lista.
     * Si la lista está vacía, el nuevo elemento se convierte en el primero.
     *
     * @param valor El valor de tipo T a insertar al final de la lista.
     */
    public void InsertarFinal(T valor) { 
        Nodo<T> nuevoNodo = new Nodo<>(valor); 
        if (esVacia()) {
            pFirst = nuevoNodo;
        } else {
            Nodo<T> actual = pFirst;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        size++;
    }

   /**
     * Obtiene el valor de un elemento en un índice específico de la lista.
     *
     * @param indice El índice del elemento a obtener (basado en cero).
     * @return El valor de tipo T en el índice especificado, o null si el índice está fuera de los límites.
     */
    public T ObtenerDato(int indice) { 
        if (indice < 0 || indice >= size) {
           
            return null; 
        }
        Nodo<T> actual = pFirst;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getValor(); 
    }

    /**
     * Elimina el primer elemento de la lista y retorna su valor.
     *
     * @return El valor de tipo T del elemento que fue eliminado del inicio de la lista,
     * o null si la lista estaba vacía.
     */
    public T eliminarInicio() {
        if (esVacia()) {
            return null;
        }
        T valorEliminado = pFirst.getValor();
        pFirst = pFirst.getSiguiente();
        size--;
        return valorEliminado;
    }
    
}