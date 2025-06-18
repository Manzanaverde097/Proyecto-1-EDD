package EDD;

/**
     *Esta clase representa mi estructira de datos Grafo
     *@author Vyckhy
    */
public class Grafo {

    private int numVertices;
    private int[][] matrizAdyacencia;
    private Vertice[] vertices;
    public String[] listaPalabras;

    //constructor
    public Grafo() {
      this.numVertices = 16;
      this.matrizAdyacencia = new int[this.numVertices][this.numVertices];
      this.vertices = new Vertice[this.numVertices];
      
        for (int i = 0; i < this.numVertices; i++) {
            for (int j = 0; j < this.numVertices; j++) {
                this.matrizAdyacencia[i][j] = 0;
            }
        }
    }
    
     public void agregarVertice(Vertice v) {
        // Usamos el 'indice' que ya está en el objeto Vertice
        if (v.getIndice() >= 0 && v.getIndice() < numVertices) {
            vertices[v.getIndice()] = v; // Colocamos el objeto Vertice en el array
        } else {
            System.err.println("Error: Índice de vértice fuera de rango al agregar.");
        }
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void setMatrizAdyacencia(int[][] matrizAdyacencia) {
        this.matrizAdyacencia = matrizAdyacencia;
    }

    public Vertice[] getVertices() {
        return vertices;
    }

    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }
    
    public void insertar(char letra, int indice){
        Vertice vertice = new Vertice(letra);
        if(this.indiceVacio() != -1){
            this.vertices[this.indiceVacio()] = vertice;
        }else{
            System.out.println("El arreglo esta lleno");
        }
    }
    
    private int indiceVacio(){
        for (int i = 0; i < this.vertices.length; i++) {
            if(vertices[i] == null){
                return i;
            }
        }
        
        return -1;
    }
    
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
     *Metodo que devuelve el numero de vertices que tiene el arreglo de vertices 
     *@return numero de vertices que tiene el arreglo
     *
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
    
     public void establecerAdyacencias() {
        // Imagina que el tablero es de 4x4 (gridSize será 4)
        int gridSize = (int) Math.sqrt(numVertices);

        // Recorremos cada casilla del tablero (del 0 al 15)
        for (int i = 0; i < numVertices; i++) {
            Vertice currentVertice = vertices[i]; // La casilla actual que estamos mirando
            if (currentVertice == null) {
                continue; // Si por alguna razón la casilla está vacía, la saltamos
            }

            // Calculamos en qué fila y columna está esta casilla (como si fuera una tabla)
            int r = i / gridSize;     // Por ejemplo, si i es 0, r es 0. Si i es 4, r es 1.
            int c = i % gridSize;     // Por ejemplo, si i es 0, c es 0. Si i es 1, c es 1.

            // Estas son las 8 direcciones posibles para buscar vecinos (arriba, abajo, lado, diagonales)
            int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1}; // Cambios en la fila para los vecinos
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1}; // Cambios en la columna para los vecinos

            // Miramos en cada una de las 8 direcciones
            for (int k = 0; k < 8; k++) {
                int newR = r + dr[k]; // Calculamos la fila del posible vecino
                int newC = c + dc[k]; // Calculamos la columna del posible vecino

                // Comprobamos que este posible vecino esté dentro del tablero (no fuera de los bordes)
                if (newR >= 0 && newR < gridSize && newC >= 0 && newC < gridSize) {
                    // Si el vecino está dentro, calculamos su número de identificación (índice)
                    int neighborIndex = newR * gridSize + newC;

                    // Si el vecino no es la misma casilla actual y realmente existe, ¡los conectamos!
                    if (neighborIndex != i && vertices[neighborIndex] != null) {
                        this.conectarVertice(i, neighborIndex); // Usamos tu función existente para conectar
                    }
                }
            }
        }
    }

    // *** NUEVA FUNCIÓN: REINICIA LAS MARCAS DE "VISITADO" EN TODAS LAS CASILLAS ***
    // Esto es vital para buscar cada palabra nueva. La pegas aquí.
    public void resetearVisitados() {
        // Recorremos todas las casillas del tablero
        for (Vertice v : vertices) {
            if (v != null) {
                v.setVisitado(false); // Le decimos que "no ha sido visitada"
            }
        }
    }
    
    public int buscarVertice(String letraBuscada) { // Si el parámetro es String
        if (letraBuscada == null || letraBuscada.isEmpty()) {
            return -1;
        }
        char charBuscado = Character.toLowerCase(letraBuscada.charAt(0)); //
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null && Character.toLowerCase(vertices[i].getLetra()) == charBuscado) { //
                return i;
            }
        }
        return -1; // No encontrado
    }
}