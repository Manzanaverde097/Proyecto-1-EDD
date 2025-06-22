/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

public class Diccionario {
    private Lista palabras;

    public Diccionario() {
        palabras = new Lista();
    }

    public void agregar(String palabra) {
        if (palabra == null) return;
        
        char[] chars = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) (c - 32);
            } else {
                chars[i] = c;
            }
        }
        String palabraMayusculas = new String(chars);
        
        if (palabras.contiene(palabraMayusculas)) {
            return;
        }
        palabras.agregar(palabraMayusculas);
    }

    public String obtener(int indice) {
        Object obj = palabras.obtener(indice);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public int getTamano() {
        return palabras.getTamano();
    }

    public boolean contiene(String palabra) {
        if (palabra == null) return false;
        
        char[] chars = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) (c - 32);
            } else {
                chars[i] = c;
            }
        }
        String palabraMayusculas = new String(chars);
        
        return palabras.contiene(palabraMayusculas);
    }
    
    public void limpiar() {
        for (int i = 0; i < tamanoActual; i++) {
            elementos[i] = null;
        }
        tamanoActual = 0;
    }
}