/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Busquedas;

import EDD.Grafo;
import EDD.Vertice;

/**
 *
 * @author vyckh
 */
public class DFS {
    public Grafo grafo;
    
    public DFS(Grafo g){
        this.grafo = g;
    }
    
    public String busqueda(String palabra){
        String[] letras = new String[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = String.valueOf(palabra.charAt(i));
        }
        String resultado = "";
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            if(grafo.getVertices()[i].getLetra().equals(letras[0])){
                resultado =  this.busqueda_rec(palabra, 1, i, letras[0]);
                if(resultado.equals(palabra)){
                    return resultado;
                }
            }
        }
     return null;   
    }
    
    public String busqueda_rec(String palabra, int indice, int v, String resultado){
        if(palabra.equals(resultado) || palabra.length() == resultado.length()){
            return resultado;
        }
        if( grafo.getVertices()[v] != null){
            for (int i = 0; i < grafo.getNumVertices(); i++) {
                if( grafo.getMatrizAdyacencia()[v][i] == 1 && grafo.getVertices()[i].getLetra().equals(palabra.charAt(indice)) && !grafo.getVertices()[i].visitado){
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
        
