
package EDD;

import javax.swing.JOptionPane;


public class Lista<T> {
    
    private Nodo<T> pFirst; //nodo apuntador al primero
    private int size; //tamaño de la lista

    public Nodo<T> getpFirst() {
        return pFirst;
    }

    public int getSize() {
        return size;
    }
   
   public boolean EsVacio() {
        return pFirst == null;
    }

   
    public Lista() {
        this.pFirst = null;
        this.size = 0;
    }

    public boolean esVacia() {
        return pFirst == null;
    }

    public int tamano() {
        return size;
    }

    // --- MODIFICAR ---: el parámetro y quizás el nombre si es necesario
    public void InsertarFinal(T valor) { // El parámetro ahora es de tipo T
        Nodo<T> nuevoNodo = new Nodo<>(valor); // Crea un Nodo de tipo T
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

    // --- MODIFICAR ---: el tipo de retorno
    public T ObtenerDato(int indice) { // Ahora retorna un T
        if (indice < 0 || indice >= size) {
            // Manejo de error, o lanzar una excepción
            return null; // O lanzar IndexOutOfBoundsException
        }
        Nodo<T> actual = pFirst;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getValor(); // Retorna el valor de tipo T
    }

    public T eliminarInicio() {
        if (esVacia()) {
            return null; // O lanzar una excepción como NoSuchElementException
        }
        T valorEliminado = pFirst.getValor();
        pFirst = pFirst.getSiguiente();
        size--;
        return valorEliminado;
    }
    
     public T get(int indice) { // Para poder usar .get(0) si lo necesitas temporalmente
        if (indice < 0 || indice >= size) {
            return null;
        }
        Nodo<T> actual = pFirst;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }
}
    // Puedes necesitar más modificaciones en otros métodos como eliminar, buscar, etc.
    // Asegúrate de que cualquier 'Object' se convierta a 'T' donde sea apropiado.
