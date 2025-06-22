/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

public class BuscadorPalabrasGrafo {

    private Grafo grafo;

    public BuscadorPalabrasGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public boolean buscarPalabraDFS(String palabra) {
        if (palabra == null) {
            return false;
        }
        if (palabra.length() < 3) {
            return false;
        }
        
        grafo.resetearVisitas();

        Vertice[] vertices = grafo.getVertices();
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            Vertice inicio = vertices[i];
            if (inicio.getLetra() == palabra.charAt(0)) {
                if (dfsRecursivo(inicio, palabra, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsRecursivo(Vertice actual, String palabra, int indicePalabra) {
        actual.setVisitado(true);

        if (indicePalabra == palabra.length() - 1) {
            return true;
        }

        Vertice[] adyacentes = actual.getAdyacentesArray();
        for (int i = 0; i < actual.getNumAdyacentes(); i++) {
            Vertice vecino = adyacentes[i];
            if (!vecino.isVisitado() && (indicePalabra + 1) < palabra.length() && 
                vecino.getLetra() == palabra.charAt(indicePalabra + 1)) {
                
                vecino.setPadre(actual);
                if (dfsRecursivo(vecino, palabra, indicePalabra + 1)) {
                    return true;
                }
            }
        }
        actual.setVisitado(false); 
        return false;
    }

    public Vertice buscarPalabraBFS_Path(String palabra) {
        if (palabra == null) {
            return null;
        }
        if (palabra.length() < 3) {
            return null;
        }

        grafo.resetearVisitas();

        Vertice[] vertices = grafo.getVertices();
        for (int i = 0; i < grafo.getNumVertices(); i++) {
            Vertice inicio = vertices[i];
            if (inicio.getLetra() == palabra.charAt(0)) {
                Cola cola = new Cola();
                
                EstadoBFS estadoInicial = new EstadoBFS(inicio, String.valueOf(inicio.getLetra()));
                cola.enqueue(estadoInicial);
                inicio.setVisitado(true);

                while (!cola.isEmpty()) {
                    EstadoBFS estadoActual = (EstadoBFS) cola.dequeue();
                    Vertice actual = estadoActual.vertice;
                    String palabraConstruida = estadoActual.palabraConstruida;

                    if (equals(palabraConstruida, palabra)) {
                        return actual;
                    }

                    if (palabraConstruida.length() >= palabra.length() ||
                        !startsWith(palabra, palabraConstruida)) { 
                        continue;
                    }

                    Vertice[] adyacentes = actual.getAdyacentesArray();
                    for (int j = 0; j < actual.getNumAdyacentes(); j++) {
                        Vertice vecino = adyacentes[j];
                        
                        if (!vecino.isVisitado() && 
                            palabraConstruida.length() < palabra.length() &&
                            vecino.getLetra() == palabra.charAt(palabraConstruida.length())) {
                            
                            vecino.setVisitado(true);
                            vecino.setPadre(actual);
                            
                            String nuevaPalabraConstruida = palabraConstruida + String.valueOf(vecino.getLetra());
                            cola.enqueue(new EstadoBFS(vecino, nuevaPalabraConstruida));
                        }
                    }
                }
                grafo.resetearVisitas(); 
            }
        }
        return null;
    }
    
    private boolean startsWith(String mainString, String prefix) {
        if (mainString == null || prefix == null) {
            return false;
        }
        if (prefix.length() > mainString.length()) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            if (mainString.charAt(i) != prefix.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean equals(String s1, String s2) {
        if (s1 == s2) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private static class EstadoBFS {
        Vertice vertice;
        String palabraConstruida;

        public EstadoBFS(Vertice v, String pc) {
            this.vertice = v;
            this.palabraConstruida = pc;
        }
    }
}