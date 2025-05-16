
package EDD;

import javax.swing.JOptionPane;


public class Lista {
    
    private Nodo pFirst; //nodo apuntador al primero
    private int size; //tamaño de la lista
    private Nodo pLast;
    
    //Constructor de la clase Lista
    public Lista() {
        this.pFirst = null;
        this.size = 0; 
        this.pLast = null;
    }
    
    //Metodos get y set para los atrubutos

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public Nodo getpLast() {
        return pLast;
    }

    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }
    //Primitivas
    
    //Funcion para verificar si la lista es vacia
    public boolean EsVacio(){
        return this.pFirst == null;
    }
    
    //Metodo que vacia la lista
    public void vaciar(){
        this.pFirst = null;
        this.size = 0;   
    }
    
    //Metodo para insertar al inicio
    public Nodo InsertarInicio(Object dato){
        
        Nodo pNew = new Nodo();
        pNew.setDato(dato);
       
        if (EsVacio()) {   
            pFirst = pNew;
        } else{
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
        return pNew;
    }
    
    public void InsertarIncio2(Object dato){
        Nodo pNew = new Nodo();
        pNew.setDato(dato);
        
        if(EsVacio()){
            this.pFirst.setDato(dato);
            this.pFirst.setPnext(null);
        }else{
            pNew.setPnext(pFirst);
            pFirst = pNew;
        }
        size++;
    }

    //Metodo para insertar al final
    public void InsertarFinal(Object dato){
        Nodo nuevo = new Nodo(dato);
        if (EsVacio()){
          pFirst = nuevo;
          pLast = nuevo;
            
        }else {
            Nodo aux = pLast;
            aux.setPnext(nuevo);
            pLast = nuevo;
        }
       size++; 
    }
    
    public void insertarPorPosicion(int posicion, Object valor){
        if(posicion>=0 && posicion<size){
            Nodo nuevo = new Nodo(valor);
            if(posicion == 0){
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            }
            else{
                if(posicion == size-1){
                    Nodo aux = pFirst;
                    while(aux.getPnext() != null){
                        aux = aux.getPnext();
                    }
                    aux.setPnext(nuevo);              
                }
                else{
                    Nodo aux = pFirst;
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getPnext();
                    }
                    Nodo siguiente = aux.getPnext();
                    aux.setPnext(nuevo);
                    nuevo.setPnext(siguiente);
                }
            }
            size++;
        }
    }
    
    public void insertarDosPosicionesAdelante(int pos, Object valor){
        int posicion = pos + 2;
        if(posicion>=0 && posicion<size){
            Nodo nuevo = new Nodo(valor);
            if(posicion == 0){
                nuevo.setPnext(pFirst);
                pFirst = nuevo;
            }
            else{
                if(posicion == size-1){
                    Nodo aux = pFirst;
                    while(aux.getPnext() != null){
                        aux = aux.getPnext();
                    }
                    aux.setPnext(nuevo);              
                }
                else{
                    Nodo aux = pFirst;
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getPnext();
                    }
                    Nodo siguiente = aux.getPnext();
                    aux.setPnext(nuevo);
                    nuevo.setPnext(siguiente);
                }
            }
            size++;
        }
    }
    
    //Metodo para Insertar por referencia
    public void insertarPorReferencia(Object ref,Object valor){
        
        Nodo nuevo = new Nodo();
        nuevo.setDato(valor);
        
        if (!EsVacio()) {
            if (buscar(ref)) {
                Nodo aux = pFirst;
                // Recorre la lista hasta llegar al nodo de referencia.
                while (aux.getDato() != ref) {
                    aux = aux.getPnext();
                }
                // Crea un respaldo de la continuación de la lista.
                Nodo siguiente = aux.getPnext();
                // Enlaza el nuevo nodo despues del nodo de referencia.
                aux.setPnext(nuevo);
                // Une la continuacion de la lista al nuevo nodo.
                nuevo.setPnext(siguiente);
            
                size++;
            }
        }
    }
    
    //Metodo para transformar una lista en cadena de caracteres
    public String Transformar(){
        if(!EsVacio()){
            
            Nodo aux = pFirst;
            String expresion = "";
            
            for(int i = 0; i <size;i++){
            expresion += aux.getDato().toString() + "\n";
            aux = aux.getPnext();
            }
            return expresion;
        }
        return "Lista vacia";
    }
    
    public void mostrar(){
        if (!EsVacio()){
            Nodo aux = pFirst;
            String expresion = "";
            while(aux != null){
               expresion = expresion + aux.getDato().toString() + "\n";
               aux = aux.getPnext();
            }
            JOptionPane.showMessageDialog(null,expresion);
            
        }else{
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
        }
    }
    
    //Funcion para eliminar al inicio
    public boolean Eliminar_Inicio(){
        if(!EsVacio()){
            pFirst = pFirst.getPnext();
            size--;
            return true;
        }else{
            return false;
        }
    }
    
    public void Eliminar_Final(){
        if(!EsVacio()){
            if (getSize()==1) {
                vaciar();
            }else{
                Nodo pointer = getpFirst();
                while(pointer.getPnext() != null && pointer.getPnext().getPnext()!= null){
                    pointer = pointer.getPnext();
                }
                pointer.setPnext(null);
            }
            size --;
        }  
    }
    
    public void EliminarPorReferencia(Object referencia){

        if (buscar(referencia)) {
            if (pFirst.getDato() == referencia) {
                pFirst = pFirst.getPnext();
            } else{
                Nodo aux = pFirst;
                while(aux.getPnext().getDato() != referencia){
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext().getPnext();
                aux.setPnext(siguiente);  
            }
            size--;
        }
    }
    
    public void EliminarPorPosicion(int posicion){

        if(posicion>=0 && posicion<size){
            if(posicion == 0){
                pFirst = pFirst.getPnext();
            }
            else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getPnext();
                }
                Nodo siguiente = aux.getPnext();
                aux.setPnext(siguiente.getPnext());
            }
            size--;
        }
    }
    
    public void editarPorReferencia(Object referencia, Object dato){
        if (buscar(referencia)) {
            Nodo aux = pFirst;
            while(aux.getDato() != referencia){
                aux = aux.getPnext();
            }
            aux.setDato(dato);
        }
    }
    
    //Metodo para editar el valor de un nodo en una posicion
    public void editarPorPosicion(int posicion , Object dato){

        if(posicion>=0 && posicion<size){
            if(posicion == 0){
                pFirst.setDato(dato);
            }
            else{
                Nodo aux = pFirst;

                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                aux.setDato(dato);
            }
        }
    }
    
    //Metodo para obtener el valor de un nodo en una determinada posición
    public Object getValor(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst.getDato();
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux.getDato();
            }
        }
        return null;
    }
    
        //Metodo para obtener un nodo en una determinada posición
    public Nodo getNodo(int posicion){

        if(posicion>=0 && posicion<size){
            
            if (posicion == 0) {
                return pFirst;
            }else{
                Nodo aux = pFirst;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getPnext();
                }
                return aux;
            }
        }
        return null;
    }
    
    //Metodo para retornar la posicion de un nodo
    public int getIndex (Nodo nodito){
        if (!EsVacio()){
            Nodo aux = pFirst;
            int count = 0;
            while(aux != null){
                
                if (nodito == aux){
                    return count;     //posicion en memoria del nodo
                }
                count ++;
                aux = aux.getPnext();
            }
            return -1;
        }
    return -1;
    }
    
    //Consulta la posición de un elemento en la lista
    public int getPosicion(Object referencia){

        if (buscar(referencia)) {
            
            Nodo aux = pFirst;
            int cont = 0;
            while(referencia != aux.getDato()){
                cont ++;
                aux = aux.getPnext();
            }
            return cont;
        } else {
            return -1;
        }
    }
    
    // Funcion para buscar un elemento en la lista
    public boolean buscar(Object referencia){
        Nodo aux = pFirst;
        boolean encontrado = false;
        while(aux != null && encontrado != true){
            if (referencia == aux.getDato()){ 
                encontrado = true;
            }
            else{
                aux = aux.getPnext();
            }
        }
        return encontrado;
    }
    
    //Destructor
    public void eliminar(){
        pFirst = null;
        size = 0;
    }
   
    
}
