/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Busquedas;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;
/**
 * Esta clase implementa el algoritmo de búsqueda en anchura (BFS) 
 * sobre un grafo representado por la clase {@code Grafo}.
 * Permite buscar una palabra a través de los vértices conectados.
 * 
 * @author sofia
 */
public class BFS {
    /** Referencia al grafo sobre el cual se realiza la búsqueda. */
    public Grafo grafo;
    /**
     * Construye una nueva instancia de BFS con el grafo especificado.
     *
     * @param g el grafo donde se realizará la búsqueda
     */
    public BFS(Grafo g){
        this.grafo = g;
    }
     /**
     * Ejecuta una búsqueda BFS para determinar si una palabra puede formarse
     * navegando entre los vértices del grafo, comenzando por un vértice cuya letra
     * coincida con el primer carácter de la palabra.
     *
     * @param palabra la palabra que se desea buscar en el grafo
     * @return la palabra encontrada si existe, o una cadena vacía si no fue encontrada
     */
    public String busqueda(String palabra){
        for (int i = 0; i < palabra.length(); i++) {
            if(String.valueOf(palabra.charAt(0)).equals(grafo.getVertices()[i].getLetra())){
                Lista recorrido = new Lista();
                recorrido.InsertarFinal(grafo.getVertices()[i]);
                grafo.getVertices()[i].visitado = true;
                String resultado = this.busquedaBFS(palabra, recorrido);
                if(resultado.equals(palabra)){
                    return resultado;
                }
                grafo.getVertices()[i].visitado = false;

            }
        }
        return "";
    }
    /**
 * Realiza la búsqueda en anchura (BFS) para encontrar si es posible formar una palabra
 * navegando por los vértices del grafo a partir de un recorrido inicial.
 * 
 * La búsqueda continúa mientras haya vértices en el recorrido y no se hayan 
 * verificado todas las letras de la palabra. Compara letras secuenciales de la palabra 
 * con letras de vértices adyacentes no visitados.
 *
 * @param palabra la palabra que se desea formar buscando en el grafo
 * @param recorrido la lista de vértices que representan el camino actual en la búsqueda
 * @return la palabra encontrada si se logra formar, o {@code null} si no fue posible
 */
    public String busquedaBFS(String palabra, Lista recorrido) {
        String[] letras = new String[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = String.valueOf(palabra.charAt(i));
        }
        int cont = 1;
        String encontrada = letras[0];
        while (!recorrido.esVacia() && cont < palabra.length()) {
            Vertice actual = (Vertice) recorrido.eliminarInicio(); 
            int indiceActual = grafo.buscarVertice(actual.getLetra());

            for (int i = 0; i < grafo.getNumVertices(); i++) { 
                if (grafo.getMatrizAdyacencia()[indiceActual][i] == 1 && 
                    !grafo.getVertices()[i].isVisitado() && 
                    Character.toLowerCase(grafo.getVertices()[i].getLetra()) == Character.toLowerCase(letras[cont].charAt(0))) { 
                    encontrada += grafo.getVertices()[i].getLetra(); 
                    recorrido.InsertarFinal(grafo.getVertices()[i]); 
                    grafo.getVertices()[i].setVisitado(true); //
                    if (encontrada.equals(palabra)) { //
                        return encontrada; //
                    }
                }
            }
            cont++; 
        }

        return null; 
    }

    
}

    

