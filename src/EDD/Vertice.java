/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author vyckh
 */
public class Vertice {
    private char letra;
    private int columna;
    private int fila;
    public boolean visitado;
    public int indice;
    
    public Vertice(char letra) {
        this.letra = letra;
        this.columna = -1;
        this.fila = -1;
        this.visitado = false;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }  
    
    public boolean isVisitado() {
        return visitado;
    }
    
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

     public int getIndice() {
        return indice;
    }
    
}
