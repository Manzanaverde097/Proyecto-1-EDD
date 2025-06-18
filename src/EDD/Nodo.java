
package EDD;

public class Nodo<T> {
    public T valor; // El valor que almacena el nodo es de tipo T
    public Nodo<T> siguiente; // La referencia al siguiente nodo es también de tipo Nodo<T>
     
    public Nodo(T valor) {
    this.valor = valor;
    this.siguiente = null;
        }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }
    
    
    }
   