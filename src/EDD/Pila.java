/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 * La clase {@code Pila} representa una estructura de datos tipo pila (LIFO - Last In, First Out)
 * que permite insertar y eliminar elementos en la parte superior de la pila.
 * Utiliza internamente una {@code Lista} para almacenar los elementos.
 * 
 * @author Iker Solar, Vyckhy Sarmiento, Sofía Elasmar
 * 
 */

public class Pila {
    private Lista elementos;
    
    /**
     * Constructor. Crea una pila vacía.
     */
    public Pila() {
        elementos = new Lista();
    }
    
    /**
     * Agrega un elemento a la parte superior de la pila.
     * 
     * @param elemento El elemento que se desea agregar.
     */
    public void push(Object elemento) {
        elementos.agregar(elemento);
    }
    
    /**
     * Elimina y retorna el elemento en la parte superior de la pila.
     * 
     * @return El elemento que estaba en la parte superior, o {@code null} si la pila está vacía.
     */
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object elemento = elementos.obtener(elementos.getTamano() - 1);
        elementos.eliminar(elementos.getTamano() - 1);
        return elemento;
    }
    
    /**
     * Retorna el elemento en la parte superior de la pila sin eliminarlo.
     * 
     * @return El elemento en la parte superior, o {@code null} si la pila está vacía.
     */
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return elementos.obtener(elementos.getTamano() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return {@code true} si la pila no contiene elementos, {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return elementos.estaVacia();
    }
    
    /**
     * Obtiene la cantidad de elementos almacenados en la pila.
     * 
     * @return El tamaño actual de la pila.
     */
    public int getTamano() {
        return elementos.getTamano();
    }
}
