/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 * La clase {@code Cola} representa una estructura de datos tipo cola (FIFO - First In, First Out)
 * que permite insertar elementos al final y eliminar elementos al principio.
 * Utiliza una lista interna para almacenar los elementos.
 * 
 * @author Iker Solar, Vyckhy Sarmiento, Sofía Elasmar
 * 
 */

public class Cola {
    private Lista elementos;

    /**
     * Constructor de la clase. Crea una nueva cola vacía.
     */
    public Cola() {
        elementos = new Lista();
    }
    
    /**
     * Agrega un elemento al final de la cola.
     * 
     * @param elemento El elemento que se desea agregar.
     */
    public void enqueue(Object elemento) {
        elementos.agregar(elemento);
    }
    
    /**
     * Elimina y retorna el primer elemento de la cola.
     * 
     * @return El primer elemento de la cola, o {@code null} si la cola está vacía.
     */
    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object elemento = elementos.obtener(0);
        elementos.eliminar(0);
        return elemento;
    }

    /**
     * Retorna el primer elemento de la cola sin eliminarlo.
     * 
     * @return El primer elemento de la cola, o {@code null} si la cola está vacía.
     */
    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return elementos.obtener(0);
    }
    
    /**
     * Verifica si la cola está vacía.
     * 
     * @return {@code true} si la cola no contiene elementos, {@code false} en caso contrario.
     */
    public boolean isEmpty() {
        return elementos.estaVacia();
    }
    
    /**
     * Obtiene el número de elementos que contiene la cola.
     * 
     * @return La cantidad de elementos en la cola.
     */
    public int getTamano() {
        return elementos.getTamano();
    }
}
