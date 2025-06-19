
package EDD;
/**
 * Clase que representa un nodo individual en una lista enlazada genérica.
 * Cada nodo contiene un valor de tipo genérico T y una referencia al siguiente nodo en la secuencia.
 *
 * @param <T> El tipo de dato del valor que se almacenará en este nodo.
 */
public class Nodo<T> {
    //atributos
    /**
     * El valor de tipo genérico T almacenado en este nodo.
     */
    public T valor; 
    /**
     * La referencia al siguiente nodo en la lista. 
     */
    public Nodo<T> siguiente; 
     /**
     * Constructor para crear una nueva instancia de Nodo.
     * Inicializa el nodo con un valor dado y establece su referencia al siguiente nodo como null.
     *
     * @param valor El valor de tipo T que se almacenará en el nodo.
     */
    public Nodo(T valor) {
    this.valor = valor;
    this.siguiente = null;
        }
 /**
     * Obtiene el valor almacenado en este nodo.
     *
     * @return El valor de tipo T de este nodo.
     */
    public T getValor() {
        return valor;
    }
/**
     * Establece un nuevo valor para este nodo.
     *
     * @param valor El nuevo valor de tipo T a asignar al nodo.
     */
    public void setValor(T valor) {
        this.valor = valor;
    }
/**
     * Obtiene la referencia al siguiente nodo en la lista.
     *
     * @return El siguiente {@link Nodo} en la secuencia, o null si este es el último nodo.
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
/**
     * Establece la referencia al siguiente nodo en la lista.
     *
     * @param siguiente El {@link Nodo} que será el siguiente en la secuencia. Puede ser null si este es el último nodo.
     */
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
    }
   