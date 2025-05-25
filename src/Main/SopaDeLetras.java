/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import Interfaces.SopaDeLetrasGui;
import EDD.Grafo;
/**
 *
 * @author Iker
 */
public class SopaDeLetras {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        new SopaDeLetrasGui(grafo).setVisible(true);
    }
}
