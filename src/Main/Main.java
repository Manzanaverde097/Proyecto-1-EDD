/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import EDD.Lista;
import EDD.Nodo;

/**
 *
 * @author vyckh
 */
public class Main {
    
    public static void main(String[] args){
        Object num = 13;
        Nodo nodo = new Nodo(num);
        System.out.println(nodo.getDato());
        
        Lista list = new Lista();
        list.InsertarInicio(1);
        list.mostrar();
        
    }
    
    
}
