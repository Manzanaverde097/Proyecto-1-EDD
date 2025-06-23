package EDD;

/**
 * La clase {@code Grafo} representa un grafo no dirigido de hasta 16 vértices,
 * organizado como una matriz de 4x4 (ideal para problemas como sopas de letras).
 * Permite agregar vértices, establecer adyacencias entre ellos y realizar búsquedas basadas en sus posiciones.
 * 
 * @author Iker Solar, Vyckhy Sarmiento, Sofía Elasmar
 * 
 */

public class Grafo {
    private Vertice[] vertices;
    private int numVertices;
    private final int MAX_VERTICES = 16;
    public Lista diccionario;
    
     /**
     * Constructor. Crea un grafo vacío con un máximo de 16 vértices y un diccionario asociado.
     */
    public Grafo() {
        this.vertices = new Vertice[MAX_VERTICES];
        this.numVertices = 0;
        this.diccionario = new Lista();
    }
    
    /**
     * Agrega un vértice al grafo si no se ha alcanzado el número máximo permitido.
     * 
     * @param v El vértice que se desea agregar. Si es {@code null}, no se realiza ninguna acción.
     */
    public void agregarVertice(Vertice v) {
        if (v == null) return;
        if (numVertices < MAX_VERTICES) {
            vertices[numVertices] = v;
            System.out.println(v.getLetra());
            numVertices++;
        }
    }
    
    /**
     * Busca y retorna un vértice en la posición indicada por fila y columna.
     * 
     * @param fila La fila del vértice.
     * @param columna La columna del vértice.
     * @return El vértice que se encuentra en la posición especificada, o {@code null} si no se encuentra.
     */
    public Vertice obtenerVertice(int fila, int columna) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getFila() == fila && vertices[i].getColumna() == columna) {
                return vertices[i];
            }
        }
        return null;
    }
    
    /**
     * Obtiene un vértice según su índice en el arreglo de vértices.
     * 
     * @param index La posición del vértice en el arreglo.
     * @return El vértice en la posición indicada, o {@code null} si el índice es inválido.
     */
    public Vertice obtenerVerticePorIndice(int index) {
        if (index >= 0 && index < numVertices) {
            return vertices[index];
        }
        return null;
    }
    
    /**
     * Establece las adyacencias de cada vértice considerando su posición en una matriz de 4x4.
     * Cada vértice se conecta con sus vecinos en las ocho direcciones posibles.
     * 
     * Este método solo funciona si el grafo contiene exactamente 16 vértices.
     */
    public void establecerAdyacencias() {
        if (numVertices != MAX_VERTICES) {
            return;
        }

        for (int i = 0; i < numVertices; i++) {
            Vertice actual = vertices[i];
            actual.resetearEstado();

            for (int df = -1; df <= 1; df++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (df == 0 && dc == 0) {
                        continue;
                    }

                    int nFila = actual.getFila() + df;
                    int nColumna = actual.getColumna() + dc;

                    if (nFila >= 0 && nFila < 4 && nColumna >= 0 && nColumna < 4) {
                        Vertice vecino = obtenerVertice(nFila, nColumna);
                        if (vecino != null) {
                            actual.agregarAdyacente(vecino);
                        }
                    }
                }
            }
        }
    }

    /**
     * Obtiene la cantidad actual de vértices en el grafo.
     * 
     * @return El número de vértices agregados al grafo.
     */
    public int getNumVertices() {
        return numVertices;
    }
    
     /**
     * Obtiene el arreglo de vértices que componen el grafo.
     * 
     * @return Un arreglo de vértices.
     */
    public Vertice[] getVertices() {
        return vertices;
    }
    
    /**
     * Reinicia el estado de visita de todos los vértices en el grafo.
     * Este método es útil para preparar el grafo antes de realizar búsquedas.
     */
    public void resetearVisitas() {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null) {
                vertices[i].resetearEstado();
            }
        }
    }
}