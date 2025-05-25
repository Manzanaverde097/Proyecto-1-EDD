/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funciones;

import EDD.Lista;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 *
 * @author iker
 */
public class EscribirTXT {
    public static void guardarDiccionario(Lista palabras) {
        try {
            Field field = Lista.class.getDeclaredField("elementos");
            field.setAccessible(true);
            List<String> elementos = (List<String>) field.get(palabras);

            if (elementos == null || elementos.isEmpty()) {
                System.out.println("La lista de palabras está vacía o no inicializada.");
                return;
            }

            try (FileWriter writer = new FileWriter("diccionario.txt")) {
                for (String palabra : elementos) {
                    writer.write(palabra + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.err.println("Error accediendo a la lista de elementos: " + e.getMessage());
        }
    }
}
