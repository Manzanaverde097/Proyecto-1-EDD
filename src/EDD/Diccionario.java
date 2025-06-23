/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 * La clase {@code Diccionario} representa una colección de palabras almacenadas en mayúsculas.
 * Permite agregar, buscar, obtener y limpiar palabras del diccionario, asegurando que todas
 * se almacenen sin duplicados y en formato de mayúsculas para facilitar las búsquedas.
 * 
 * @author Iker Solar, Vyckhy Sarmiento, Sofía Elasmar
 * 
 */

public class Diccionario {
    private Lista palabras;
    
    /**
     * Constructor. Crea un diccionario vacío.
     */
    public Diccionario() {
        palabras = new Lista();
    }
    
    /**
     * Agrega una palabra al diccionario si no existe previamente.
     * La palabra se convierte automáticamente a mayúsculas.
     * 
     * @param palabra La palabra a agregar. Si es {@code null}, no se realiza ninguna acción.
     */
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

    /**
     * Obtiene la palabra almacenada en el índice especificado.
     * 
     * @param indice La posición de la palabra en el diccionario.
     * @return La palabra en el índice indicado o {@code null} si no es una instancia válida.
     */
    public String obtener(int indice) {
        Object obj = palabras.obtener(indice);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
    
    /**
     * Obtiene la cantidad de palabras almacenadas en el diccionario.
     * 
     * @return El número de palabras en el diccionario.
     */
    public int getTamano() {
        return palabras.getTamano();
    }

    /**
     * Verifica si una palabra existe en el diccionario.
     * 
     * @param palabra La palabra a buscar.
     * @return {@code true} si la palabra existe en el diccionario, {@code false} en caso contrario.
     */
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
    
    /**
     * Elimina todas las palabras almacenadas en el diccionario.
     */
    public void limpiar() {
        this.palabras.limpiar();
    }
}