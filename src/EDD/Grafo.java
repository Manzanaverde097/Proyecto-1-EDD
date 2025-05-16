package EDD;

public class Grafo {

    private int numVertices;
    private int[][] matrizAdyacencia;
    private Vertice[] vertices;

    //constructor
    public Grafo() {
      this.numVertices = 16;
      this.matrizAdyacencia = new int[this.numVertices][this.numVertices];
      this.vertices = new Vertice[this.numVertices];
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
}