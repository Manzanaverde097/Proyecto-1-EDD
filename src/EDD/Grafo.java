package EDD;

/**
     *Esta clase representa mi estructira de datos Grafo
     *@author Vyckhy
    */
public class Grafo {

    private int numVertices;
    private int[][] matrizAdyacencia;
    private Vertice[] vertices;

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
//javadoc
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
    
    public void insertar(String letra){
        Vertice vertice = new Vertice(letra);
        if(this.indiceVacio() != -1){
            this.vertices[this.indiceVacio()] = vertice;
        }else{
            System.out.println("El aareglo esta lleno");
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
    
    public void conectarVertice(String letra1, String letra2){
        if(this.buscarVertice(letra1) != -1 && this.buscarVertice(letra2) != -1){
            int i = this.buscarVertice(letra1);
            int j = this.buscarVertice(letra2);
            this.matrizAdyacencia[i][j] = 1;
            this.matrizAdyacencia[j][i] = 1;
        }else{
            System.out.println("Alguna de las letras no se encuentra en el grafo.");
        }
    }
    
    /**
     *Metodo que devuelve el numero de vertices que tiene el arreglo de vertices 
     *@param letra
     *@return numero de vertices que tiene el arreglo
     *
    */
    public int buscarVertice(String letra){
        for (int i = 0; i < this.vertices.length; i++) {
            if(vertices[i] != null){
                if(vertices[i].getLetra().equalsIgnoreCase(letra)){
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
}