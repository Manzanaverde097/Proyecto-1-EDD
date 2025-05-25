/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import EDD.Grafo;

public class SopaDeLetrasGui extends JFrame {
    private final Grafo grafo; 
    private final JLabel labelInfo; 

    public SopaDeLetrasGui(Grafo grafo) {
        this.grafo = grafo; 
        
        setTitle("Sopa de Letras");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        labelInfo = new JLabel();
        actualizarLabel(); 
        add(labelInfo); 
        
        setVisible(true);
    }

    private void actualizarLabel() {
        if (grafo != null) {
            labelInfo.setText("Número de vértices: " + grafo.getNumVertices());
            mostrarVertices(); 
        } else {
            labelInfo.setText("El grafo no ha sido inicializado.");
        }
    }

    private void mostrarVertices() {
        System.out.println("Lista de vértices en el grafo:");
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            System.out.println("Vertice " + i);
        }
    }
}