/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

public class Vertice {
    private char letra;
    private int fila;
    private int columna;
    private Lista adyacentes;

    private boolean visitado;
    private Vertice padre;

    public Vertice(char letra, int fila, int columna) {
        this.letra = letra;
        this.fila = fila;
        this.columna = columna;
        this.adyacentes = new Lista(8);
        this.visitado = false;
        this.padre = null;
    }

    public char getLetra() {
        return letra;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public void agregarAdyacente(Vertice v) {
        if (v == null) return;
        if (!adyacentes.contiene(v)) {
            adyacentes.agregar(v);
        }
    }

    public Vertice[] getAdyacentesArray() {
        Vertice[] actualAdyacentes = new Vertice[adyacentes.getTamano()];
        for (int i = 0; i < adyacentes.getTamano(); i++) {
            actualAdyacentes[i] = (Vertice) adyacentes.obtener(i);
        }
        return actualAdyacentes;
    }
    
    public int getNumAdyacentes(){
        return adyacentes.getTamano();
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public Vertice getPadre() {
        return padre;
    }

    public void setPadre(Vertice padre) {
        this.padre = padre;
    }
    
    public void resetearEstado() {
        this.visitado = false;
        this.padre = null;
    }

    @Override
    public String toString() {
        return String.valueOf(letra) + "(" + fila + "," + columna + ")";
    }
}