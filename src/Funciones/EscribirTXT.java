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
 * Clase encargada de guardar una lista de palabras en un archivo de texto.
 * 
 * Utiliza reflexión para acceder a una lista privada dentro del objeto {@code Lista}
 * y escribe su contenido línea por línea en un archivo llamado {@code diccionario.txt}.
 * 
 * Esta clase está diseñada para exportar diccionarios o conjuntos de palabras a texto plano.
 * 
 * @author Iker
 */
public class EscribirTXT {
    
    /**
     * Guarda las palabras contenidas en el objeto {@code Lista} en un archivo de texto.
     * 
     * @param palabras Objeto {@code Lista} que contiene las palabras a guardar.
     * @throws NullPointerException Si el campo {@code elementos} es null.
     */
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
