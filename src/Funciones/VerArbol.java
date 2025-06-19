/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Grafo;
/**
 * Clase para visualizar la estructura de un grafo mediante su matriz de adyacencia.
 * 
 * Proporciona un método estático para mostrar en consola los vértices y sus conexiones.
 * Esta visualización es útil para depurar o verificar la configuración del grafo.
 * 
 * @author Iker
 */
public class VerArbol {
    /**
     * Muestra por consola la estructura del grafo a través de su matriz de adyacencia.
     *
     * @param grafo El objeto Grafo cuya estructura se desea visualizar.
     */
    public static void mostrarArbol(Grafo grafo) {
        System.out.println("Estructura del grafo:");
        
        int[][] matriz = grafo.getMatrizAdyacencia();
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            System.out.print("Vertice " + i + ": ");
            for (int j = 0; j < grafo.getNumVertices(); j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
