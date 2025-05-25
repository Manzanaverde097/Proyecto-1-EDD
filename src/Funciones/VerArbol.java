/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Grafo;
/**
 *
 * @author Iker
 */
public class VerArbol {
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
