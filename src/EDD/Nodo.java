
package EDD;

public class Nodo {
    
    //Atributos
     private Object dato; //Variable donde se guardará el valor
     private Nodo pnext; //Variable para enlazar los nodos
    
    //Constructor vacio
    public Nodo(){
       this.dato = null;
       this.pnext = null; 
    }
    
    //Constructor de la clase nodo si le paso solo la info
    public Nodo(Object dato) {
        this.dato = dato;
        this.pnext = null;
    }
    
    //Constructor Completo
    public Nodo(Object dato, Nodo node){
        this.dato = dato;
        this.pnext = node;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getPnext() {
        return pnext;
    }

    public void setPnext(Nodo pnext) {
        this.pnext = pnext;
    }
    
    
    
    
}
