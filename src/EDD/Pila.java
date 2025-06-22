/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

public class Pila {
    private Lista elementos;

    public Pila() {
        elementos = new Lista();
    }

    public void push(Object elemento) {
        elementos.agregar(elemento);
    }

    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        Object elemento = elementos.obtener(elementos.getTamano() - 1);
        elementos.eliminar(elementos.getTamano() - 1);
        return elemento;
    }

    public Object peek() {
        if (isEmpty()) {
            return null;
        }
        return elementos.obtener(elementos.getTamano() - 1);
    }

    public boolean isEmpty() {
        return elementos.estaVacia();
    }
    
    public int getTamano() {
        return elementos.getTamano();
    }
}
