/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;


/**
 * La clase {@code Vertice} representa un nodo dentro de un grafo, identificado por una letra
 * y su posición en una matriz (fila y columna). Cada vértice puede tener múltiples adyacentes 
 * y mantiene información de estado para algoritmos de búsqueda como BFS y DFS.
 * 
 * @author Iker Solar, Vyckhy Sarmiento, Sofía Elasmar
 * 
 */

public class Vertice {
    private char letra;
    private int fila;
    private int columna;
    private Lista adyacentes;

    private boolean visitado;
    private Vertice padre;
    
    
    
    /**
     * Constructor. Crea un vértice con una letra y su posición dentro de una matriz.
     * 
     * @param letra La letra que representa este vértice.
     * @param fila La fila donde se encuentra el vértice.
     * @param columna La columna donde se encuentra el vértice.
     */
    public Vertice(char letra, int fila, int columna) {
        this.letra = letra;
        this.fila = fila;
        this.columna = columna;
        this.adyacentes = new Lista(8);
        this.visitado = false;
        this.padre = null;
    }
    
    /**
     * Retorna la letra asociada al vértice.
     * 
     * @return La letra del vértice.
     */
    public char getLetra() {
        return letra;
    }
    
    /**
     * Retorna la fila donde se encuentra el vértice.
     * 
     * @return La posición de la fila.
     */
    public int getFila() {
        return fila;
    }
    
    /**
     * Retorna la columna donde se encuentra el vértice.
     * 
     * @return La posición de la columna.
     */
    public int getColumna() {
        return columna;
    }
    
    
    /**
     * Agrega un vértice adyacente si aún no está en la lista de adyacencias.
     * 
     * @param v El vértice adyacente a agregar.
     */
    public void agregarAdyacente(Vertice v) {
        if (v == null) return;
        if (!adyacentes.contiene(v)) {
            adyacentes.agregar(v);
        }
    }
    
    /**
     * Retorna un arreglo con los vértices adyacentes.
     * 
     * @return Un arreglo de vértices adyacentes.
     */
    public Vertice[] getAdyacentesArray() {
        Vertice[] actualAdyacentes = new Vertice[adyacentes.getTamano()];
        for (int i = 0; i < adyacentes.getTamano(); i++) {
            actualAdyacentes[i] = (Vertice) adyacentes.obtener(i);
        }
        return actualAdyacentes;
    }
    
    
    /**
     * Retorna la cantidad de vértices adyacentes.
     * 
     * @return El número de adyacentes.
     */
    public int getNumAdyacentes(){
        return adyacentes.getTamano();
    }
    
    /**
     * Verifica si el vértice ha sido visitado.
     * 
     * @return {@code true} si el vértice fue visitado, {@code false} en caso contrario.
     */
    public boolean isVisitado() {
        return visitado;
    }
    
    
    /**
     * Establece el estado de visita del vértice.
     * 
     * @param visitado {@code true} si el vértice debe marcarse como visitado, {@code false} si no.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    /**
     * Retorna el vértice padre asociado en el recorrido.
     * 
     * @return El vértice padre.
     */
    public Vertice getPadre() {
        return padre;
    }
    
    
    /**
     * Establece el vértice padre asociado en el recorrido.
     * 
     * @param padre El vértice padre.
     */
    public void setPadre(Vertice padre) {
        this.padre = padre;
    }
    
    /**
     * Reinicia el estado del vértice para futuros recorridos.
     * Establece {@code visitado} como {@code false} y {@code padre} como {@code null}.
     */
    public void resetearEstado() {
        this.visitado = false;
        this.padre = null;
    }
    
    /**
     * Retorna una representación en texto del vértice, mostrando su letra y posición.
     * 
     * @return Una cadena con la letra y las coordenadas del vértice.
     */
    
    @Override
    public String toString() {
        return String.valueOf(letra) + "(" + fila + "," + columna + ")";
    }
}