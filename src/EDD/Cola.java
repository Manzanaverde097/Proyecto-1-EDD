/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

public class Cola {
    private Lista elementos;

    public Cola() {
        elementos = new Lista();
    }

    public void enqueue(Object elemento) {
        elementos.agregar(elemento);
    }

    public Object dequeue() {
        if (isEmpty()) {
            return null;
        }
        Object elemento = elementos.obtener(0);
        elementos.eliminar(0);
        return elemento;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return elementos.obtener(0);
    }

    public boolean isEmpty() {
        return elementos.estaVacia();
    }
    
    public int getTamano() {
        return elementos.getTamano();
    }
}
