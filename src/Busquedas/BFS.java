/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Busquedas;

import EDD.Grafo;
import EDD.Lista;
import EDD.Vertice;

/**
 *
 * @author vyckh
 */
public class BFS {
    public Grafo grafo;
    
    public BFS(Grafo g){
        this.grafo = g;
    }
    
    public String busqueda(String palabra){
        for (int i = 0; i < palabra.length(); i++) {
            if(String.valueOf(palabra.charAt(0)).equals(grafo.getVertices()[i].getLetra())){
                Lista recorrido = new Lista();
                recorrido.InsertarInicio(grafo.getVertices()[i]);
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
    
    public String busquedaBFS(String palabra, Lista recorrido) {
        String[] letras = new String[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = String.valueOf(palabra.charAt(i));
        }
        int cont = 1;
        String encontrada = letras[0];
        while (!recorrido.EsVacio() && cont < palabra.length()) {
            Vertice actual = (Vertice) recorrido.eliminarFinal().getDato(); 
            int indice = grafo.buscarVertice(actual.getLetra());

            for (int i = 0; i < grafo.getNumVertices(); i++) {
                if (grafo.getMatrizAdyacencia()[indice][i] == 1 && !grafo.getVertices()[i].visitado && grafo.getVertices()[i].getLetra().equals(letras[cont])) {
                    encontrada += grafo.getVertices()[i].getLetra();
                    recorrido.InsertarFinal(grafo.getVertices()[i]);
                    grafo.getVertices()[i].visitado = true;

                    if (encontrada.equals(palabra)) {
                        return encontrada; 
                    }
                }
            }
            cont++;
        }

        return null; 
    }

    
}
