/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;
/**
 * Representa un vértice en el tablero del juego de sopa de letras.
 * Cada vértice contiene una letra, su posición en el tablero (columna y fila),
 * un estado de visita para los algoritmos de búsqueda, y un índice único.
 *
 * @author vyckhy
 */
public class Vertice {
    //atributos
    /**
     * La letra que este vértice representa en el tablero.
     */
    private char letra;
     /**
     * La posición de la columna del vértice en el tablero.
     * Un valor de -1 indica que la columna no ha sido establecida.
     */
    private int columna;
     /**
     * La posición de la fila del vértice en el tablero.
     * Un valor de -1 indica que la fila no ha sido establecida.
     */
    private int fila;
     /**
     * Un indicador booleano que es verdadero si el vértice ha sido visitado
     * durante un recorrido de grafo (ej. BFS), y falso en caso contrario.
     */
    public boolean visitado;
    /**
     * El índice único de este vértice, utilizado para identificarlo dentro
     * de estructuras de datos como un arreglo de vértices en un grafo.
     * Nota: Este campo no se inicializa en el constructor actual.
     */
    public int indice;
    
    
    /**
     * Constructor para crear una nueva instancia de Vertice con una letra específica.
     * Inicializa la columna y fila a -1, y el estado de visita a falso.
     * El índice no se inicializa en este constructor y tendrá su valor por defecto (0 para int).
     *
     * @param letra La letra que este vértice representará.
     */
    public Vertice(char letra) {
        this.letra = letra;
        this.columna = -1;
        this.fila = -1;
        this.visitado = false;
    }
/**
     * Obtiene la letra asociada a este vértice.
     *
     * @return El carácter que representa la letra del vértice.
     */
    public char getLetra() {
        return letra;
    }
/**
     * Establece la letra para este vértice.
     *
     * @param letra La nueva letra a asignar al vértice.
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }
/**
     * Obtiene la posición de la columna de este vértice en el tablero.
     *
     * @return El número entero que representa la columna del vértice.
     */
    public int getColumna() {
        return columna;
    }
 /**
     * Establece la posición de la columna para este vértice en el tablero.
     *
     * @param columna El número entero de la columna a asignar.
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Obtiene la posición de la fila de este vértice en el tablero.
     *
     * @return El número entero que representa la fila del vértice.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Establece la posición de la fila para este vértice en el tablero.
     *
     * @param fila El número entero de la fila a asignar.
     */
    public void setFila(int fila) {
        this.fila = fila;
    }  
     /**
     * Verifica si este vértice ha sido marcado como visitado.
     *
     * @return true si el vértice ha sido visitado, false en caso contrario.
     */
    public boolean isVisitado() {
        return visitado;
    }
     /**
     * Establece el estado de visita de este vértice.
     *
     * @param visitado true para marcar el vértice como visitado, false para marcarlo como no visitado.
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
 /**
     * Obtiene el índice único de este vértice.
     *
     * @return El número entero que representa el índice del vértice.
     */
     public int getIndice() {
        return indice;
    }
    
}
