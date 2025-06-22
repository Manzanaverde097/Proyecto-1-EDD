package EDD;

public class Grafo {
    private Vertice[] vertices;
    private int numVertices;
    private final int MAX_VERTICES = 16;

    public Grafo() {
        this.vertices = new Vertice[MAX_VERTICES];
        this.numVertices = 0;
    }

    public void agregarVertice(Vertice v) {
        if (v == null) return;
        if (numVertices < MAX_VERTICES) {
            vertices[numVertices] = v;
            numVertices++;
        }
    }

    public Vertice obtenerVertice(int fila, int columna) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].getFila() == fila && vertices[i].getColumna() == columna) {
                return vertices[i];
            }
        }
        return null;
    }
    
    public Vertice obtenerVerticePorIndice(int index) {
        if (index >= 0 && index < numVertices) {
            return vertices[index];
        }
        return null;
    }

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

    public int getNumVertices() {
        return numVertices;
    }

    public Vertice[] getVertices() {
        return vertices;
    }
    
    public void resetearVisitas() {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null) {
                vertices[i].resetearEstado();
            }
        }
    }
}