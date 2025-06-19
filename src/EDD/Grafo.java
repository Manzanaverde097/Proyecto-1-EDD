package EDD;

/**
     *@author Vyckhy
    */
///**
// * Representa un grafo no dirigido para el juego de sopa de letras.
// * Gestiona un conjunto de vértices (letras del tablero) y sus conexiones
// * (adyacencias) utilizando una matriz de adyacencia
// 
public class Grafo {
//atributos
   /**
     * El número actual de vértices en el grafo, que también define el tamaño
     * de la matriz de adyacencia y el arreglo de vértices.
     */
    private int numVertices;
     /**
     * Matriz de adyacencia que representa las conexiones entre los vértices.
     * Un valor de 1 indica una conexión (arista), 0 indica ausencia de conexión.
     */
    private int[][] matrizAdyacencia;
     /**
     * Arreglo que almacena los objetos {@link Vertice} del grafo.
     * El índice en este arreglo corresponde al índice único del vértice.
     */
    private Vertice[] vertices;
    /**
     * Un arreglo de cadenas que puede almacenar palabras relevantes para el juego
     * (ej. el diccionario de palabras a buscar).
     */
    public String[] listaPalabras;

    //constructor
    /**
     * Constructor por defecto para crear un nuevo objeto Grafo.
     * Inicializa el grafo con un tamaño fijo de 16 vértices, adecuado para un tablero 4x4.
     * La matriz de adyacencia se inicializa a ceros, indicando que no hay conexiones iniciales.
     */
    public Grafo() {
      this.numVertices = 16;
      this.matrizAdyacencia = new int[this.numVertices][this.numVertices];
      this.vertices = new Vertice[this.numVertices];
      // Inicializa la matriz de adyacencia con ceros (sin conexiones)
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.matrizAdyacencia[i][j] = 0;
            }
        }
    }
     /**
     * Agrega un vértice al arreglo de vértices del grafo en su posición de índice.
     * Es crucial que el vertice 'v' ya tenga su índice asignado.
     *
     * @param v El vertice a agregar al grafo.
     */
     public void agregarVertice(Vertice v) {
        if (v.getIndice() >= 0 && v.getIndice() < numVertices) {
            vertices[v.getIndice()] = v; 
        } else {
            System.err.println("Error: Índice de vértice fuera de rango al agregar.");
        }
    }
/**
     * Obtiene el número total de vértices que el grafo puede almacenar (su capacidad).
     *
     * @return El número máximo de vértices para los cuales el grafo fue inicializado.
     */
    public int getNumVertices() {
        return numVertices;
    }
/**
     * Establece el número de vértices.
     * Nota: Cambiar este valor después de la inicialización puede llevar a inconsistencias
     * si no se redimensionan la matriz de adyacencia y el arreglo de vértices adecuadamente.
     *
     * @param numVertices El nuevo número de vértices.
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }
 /**
     * Obtiene la matriz de adyacencia del grafo.
     *
     * @return La matriz de adyacencia ({@code int[][]}).
     */
    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }
/**
     * Establece una nueva matriz de adyacencia para el grafo.
     *
     * @param matrizAdyacencia La nueva matriz de adyacencia a asignar.
     */
    public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
        this.matrizAdyacencia = matrizAdyacencia;
    }
/**
     * Obtiene el arreglo de todos los vértices del grafo.
     *
     * @return El arreglo de objetos {@link Vertice}.
     */
    public Vertice[] getVertices() {
        return vertices;
    }
/**
     * Establece un nuevo arreglo de vértices para el grafo.
     *
     * @param vertices El nuevo arreglo de objetos {@link Vertice} a asignar.
     */
    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }
    /**
     * Inserta un nuevo vértice en la primera posición vacía disponible en el arreglo de vértices.
     * Este método crea un nuevo {@link Vertice} utilizando la letra y el índice encontrado.
     * Si el arreglo está lleno, imprime un mensaje de error.
     *
     * @param letra La letra del nuevo vértice a insertar.
     * @param indice Este parámetro se ignora ya que se usa {@link #indiceVacio()} para encontrar la posición.
     * Considera eliminar este parámetro si no se usa para evitar confusiones.
     */
    public void insertar(char letra, int indice){
        Vertice vertice = new Vertice(letra);
        if(this.indiceVacio() != -1){
            this.vertices[this.indiceVacio()] = vertice;
        }else{
            System.out.println("El arreglo esta lleno");
        }
    }
    /**
     * Busca la primera posición nula (vacía) en el arreglo de vértices.
     * Esto es útil para saber dónde se puede agregar un nuevo vértice.
     *
     * @return El índice de la primera posición vacía, o -1 si el arreglo está lleno.
     */
    private int indiceVacio(){
        for (int i = 0; i < this.vertices.length; i++) {
            if(vertices[i] == null){
                return i;
            }
        }
        
        return -1;
    }
    /**
     * Conecta dos vértices en el grafo, estableciendo una adyacencia bidireccional
     * en la matriz de adyacencia. Esto es adecuado para un grafo no dirigido.
     *
     * @param i El índice del primer vértice a conectar.
     * @param j El índice del segundo vértice a conectar.
     */
   public void conectarVertice(int i, int j) { // Acepta dos números enteros (índices)
    if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
        matrizAdyacencia[i][j] = 1;
        matrizAdyacencia[j][i] = 1; // Para un grafo no dirigido
    }
}
    
    /**
     *Metodo que devuelve el numero de vertices que tiene el arreglo de vertices 
     *@param letra
     *@return numero de vertices que tiene el arreglo
     *
    */
    public int buscarVertice(char letra){
        for (int i = 0; i < this.vertices.length; i++) {
            if(vertices[i] != null){
                if(Character.toLowerCase(vertices[i].getLetra()) == Character.toLowerCase(letra)){
                    return i;
                }
            }
        }   
        return -1;
    }
    /**
     * Cuenta el número de vértices no nulos (válidos) actualmente en el arreglo de vértices.
     * Esto representa la cantidad de espacios ocupados por vértices.
     *
     * @return El número de vértices que no son nulos en el arreglo.
     */
    public int contarVertices(){
        int count = 0;
        for (int i = 0; i < this.numVertices; i++) {
            if(vertices[i] != null){
                count++;
            }
        }
        
        return count;
    }
     /**
     * Asigna las coordenadas de fila y columna a los vértices, asumiendo
     * un tablero de 4x4 y que ya hay exactamente 16 vértices en el grafo.
     * Los vértices se asignan secuencialmente de izquierda a derecha, de arriba a abajo.
     * Si no hay 16 vértices, imprime un mensaje de advertencia.
     */
    public void asignarCoordenadas(){
        int cantidadVertices = this.contarVertices();
        if(cantidadVertices == 16){
            int count = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    Vertice verticeActual = vertices[count];
                    verticeActual.setFila(i);
                    verticeActual.setColumna(j);
                    count++;
                }
            }
        }else{
            System.out.println("No estan los 16 vertices. Hay " + cantidadVertices);
        }
    }
    
    /**
     * Establece las adyacencias entre los vértices basándose en su posición
     * en una cuadrícula cuadrada (asumiendo un tablero de 4x4 para 16 vértices).
     * Conecta cada vértice con sus 8 vecinos circundantes (horizontales, verticales y diagonales),
     * siempre que los vecinos existan y estén dentro de los límites de la cuadrícula.
     */
     public void establecerAdyacencias() {
        int gridSize = (int) Math.sqrt(numVertices);
        for (int i = 0; i < numVertices; i++) {
            Vertice currentVertice = vertices[i]; 
            if (currentVertice == null) {
                continue; 
            }
            int r = i / gridSize;     
            int c = i % gridSize;     

            int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; 
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1}; 
            for (int k = 0; k < 8; k++) {
                int newR = r + dr[k]; 
                int newC = c + dc[k]; 
                if (newR >= 0 && newR < gridSize && newC >= 0 && newC < gridSize) {
                    int neighborIndex = newR * gridSize + newC;
                    if (neighborIndex != i && vertices[neighborIndex] != null) {
                        this.conectarVertice(i, neighborIndex); 
                    }
                }
            }
        }
    }

    
    /**
     * Restablece el estado de "visitado" de todos los vértices a {@code false}.
     * Esto es fundamental antes de ejecutar cualquier algoritmo de búsqueda o recorrido
     * que utilice el estado de visita de los vértices (ej. BFS o DFS).
     */
    public void resetearVisitados() {
        for (Vertice v : vertices) {
            if (v != null) {
                v.setVisitado(false); 
            }
        }
    }
    /**
     * Busca un vértice por su letra (ignorando mayúsculas y minúsculas).
     * Este método es una sobrecarga de {@link #buscarVertice(char)} y
     * está diseñado para aceptar un {@code String} como entrada, usando solo
     * el primer carácter.
     *
     * @param letraBuscada La cadena que contiene la letra a buscar (se utilizará solo el primer carácter).
     * @return El índice del primer vértice encontrado que coincide con la letra, o -1 si no se encuentra ningún vértice.
     */
    public int buscarVertice(String letraBuscada) { 
        if (letraBuscada == null || letraBuscada.isEmpty()) {
            return -1;
        }
        char charBuscado = Character.toLowerCase(letraBuscada.charAt(0)); 
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null && Character.toLowerCase(vertices[i].getLetra()) == charBuscado) { 
                return i;
            }
        }
        return -1; 
    }
}


