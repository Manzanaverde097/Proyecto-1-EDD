/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Busquedas;

import EDD.Grafo;
/**
 * Clase que implementa la Búsqueda en Profundidad (DFS) para encontrar palabras en un grafo.
 * 
 * Esta clase recorre el grafo buscando una coincidencia con la palabra proporcionada,
 * iniciando desde cualquier vértice que coincida con la primera letra.
 * 
 * @author Sofia
 */
public class DFS {
     /** El grafo sobre el cual se realizará la búsqueda. */
    public Grafo grafo;
    /**
     * Constructor de la clase DFS.
     * 
     * @param g El grafo donde se ejecutará la búsqueda.
     */
    public DFS(Grafo g){
        this.grafo = g;
    }
    /**
     * Busca una palabra en el grafo usando búsqueda en profundidad (DFS).
     * 
     * @param palabra La palabra a buscar en el grafo.
     * @return La palabra encontrada si existe en el grafo; de lo contrario, null.
     */
    public String busqueda(String palabra){
        String[] letras = new String[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = String.valueOf(palabra.charAt(i));
        }
        String resultado = "";
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            if (String.valueOf(grafo.getVertices()[i].getLetra()).equals(letras[0])) {
                resultado =  this.busqueda_rec(palabra, 1, i, letras[0]);
                if(resultado.equals(palabra)){
                    return resultado;
                }
            }
        }
     return null;   
    }
    /**
 * Método recursivo que realiza una búsqueda en profundidad (DFS) en el grafo para encontrar una palabra.
 * 
 * A partir del vértice actual, este método explora los vecinos adyacentes que coincidan con la siguiente letra
 * de la palabra y que aún no hayan sido visitados. Si encuentra una coincidencia, continúa recursivamente hasta
 * reconstruir la palabra completa o hasta que no haya más coincidencias.
 * 
 * @param palabra   La palabra completa que se está buscando.
 * @param indice    La posición actual en la palabra que se está evaluando.
 * @param v         El índice del vértice actual desde donde se busca la siguiente letra.
 * @param resultado La cadena acumulada con las letras encontradas hasta el momento.
 * @return La palabra encontrada si se forma correctamente; de lo contrario, retorna la parte acumulada en resultado.
 */
    public String busqueda_rec(String palabra, int indice, int v, String resultado){
        if(palabra.equals(resultado) || palabra.length() == resultado.length()){
            return resultado;
        }
        if( grafo.getVertices()[v] != null){
            for (int i = 0; i < grafo.getNumVertices(); i++) {
                if (grafo.getMatrizAdyacencia()[v][i] == 1 &&
    String.valueOf(grafo.getVertices()[i].getLetra()).equals(String.valueOf(palabra.charAt(indice))) &&
    !grafo.getVertices()[i].visitado) {
                   grafo.getVertices()[i].visitado = true;
                   String nuevoResultado = resultado + palabra.charAt(indice);
                    resultado = this.busqueda_rec(palabra, indice+ 1, i, nuevoResultado);
                   
                   if(resultado.equals(palabra)){
                       return resultado;
                   }else{
                        grafo.getVertices()[i].visitado = false;

                   }
                }
        }
        }
        return resultado;
    }
}
        
