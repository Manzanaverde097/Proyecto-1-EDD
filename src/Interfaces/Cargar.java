/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import EDD.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import EDD.Lista;
import EDD.Vertice;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author vyckh
 */
public class Cargar extends javax.swing.JFrame {
static Grafo grafo;
String texto;
static Lista<String> diccionarioDePalabras;
    /**
     * Creates new form Bienvenida
     */
    public Cargar(Grafo g) {
        this.grafo = g;
        this.texto = "";
        initComponents();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
    
    private void abrirArchivo() {
        String aux = "";
        String texto = "";
        String palabra = "";

        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);

            File abre = file.getSelectedFile();

            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                int modo = 1;

                // --- AÑADIR: Declaramos el 'indice' aquí ---
                int indice = 0; // Este número nos ayudará a identificar cada casilla del 0 al 15

                // --- ESTE ES TU CÓDIGO EXISTENTE: El bucle principal que lee el archivo ---
                while ((aux = lee.readLine()) != null) {
                    if (aux.equals("dic") || aux.equals("/dic") || aux.equals("/dic")) {
                        modo = 1; // Modo diccionario
                        // --- ESTE ES TU CÓDIGO EXISTENTE: Lógica para cargar el diccionario ---
                        diccionarioDePalabras = new Lista<>(); // Reinicia el diccionario
                        while ((aux = lee.readLine()) != null) { // Lee las palabras del diccionario
                            diccionarioDePalabras.InsertarFinal(aux.trim().toUpperCase());
                        }
                        JOptionPane.showMessageDialog(this, "Diccionario cargado exitosamente. (" + diccionarioDePalabras.tamano() + " palabras)", "Carga Exitosa", JOptionPane.INFORMATION_MESSAGE);

                    } else if (aux.equals("tab")) {
                        modo = 2; // Modo tablero

                        // --- AÑADIR: Bucle para leer las 4 líneas del tablero ---
                        for (int fila = 0; fila < 4; fila++) {
                            // --- MODIFICAR: Lee la siguiente línea para la fila del tablero ---
                            if ((aux = lee.readLine()) != null) { // 'aux' ahora contiene la línea de letras (ej. "ABCD")
                                // --- AÑADIR: Bucle para recorrer cada letra en la línea ---
                                for (int columna = 0; columna < 4; columna++) {
                                    char letra = aux.charAt(columna); // Obtenemos la letra

                                    // --- AÑADIR: Creamos el Vertice y lo agregamos al grafo ---
                                    Vertice v = new Vertice(letra); // Creamos una casilla con la letra y su número
                                    grafo.agregarVertice(v); // Ponemos la casilla en nuestro mapa (grafo)
                                    indice++; // Aumentamos el número para la siguiente casilla
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "El archivo del tablero no tiene suficientes líneas.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
                                lee.close();
                                return;
                            }
                        }
                        // --- AÑADIR: Después de que todas las casillas están en el grafo, ¡las conectamos! ---
                        grafo.establecerAdyacencias(); // Conecta las casillas vecinas automáticamente

                        JOptionPane.showMessageDialog(this, "Tablero cargado exitosamente.", "Carga Exitosa", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        // --- ESTE ES TU CÓDIGO EXISTENTE: Si el formato no es reconocido ---
                        JOptionPane.showMessageDialog(this, "Formato de archivo desconocido. La primera línea debe ser 'dic' o 'tab'.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                        lee.close();
                        return;
                    }
                    // --- AÑADIR: Salimos del bucle principal 'while' una vez que hemos procesado un bloque ('dic' o 'tab') ---
                    break;
                }

                lee.close(); // Cerramos el archivo una vez que terminamos de leerlo
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCargado = new javax.swing.JTextArea();
        buscar = new javax.swing.JButton();
        cargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Cargue el txt por favor:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 340, 40));

        txtCargado.setColumns(20);
        txtCargado.setRows(5);
        jScrollPane1.setViewportView(txtCargado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 310, 240));

        buscar.setText("Buscar TXT");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        cargar.setText("Cargar");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });
        jPanel1.add(cargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    catch (IOException ex) {
        Logger.getLogger(Cargar.class.getName()).log(Level.SEVERE, null, ex);
}
    catch (IOException ex) {
        Logger.getLogger(Cargar.class.getName()).log(Level.SEVERE, null, ex);

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        this.abrirArchivo(); 

    }//GEN-LAST:event_buscarActionPerformed

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        // TODO add your handling code here:
        
        Bienvenida m = new Bienvenida(grafo);
        this.dispose();
    }//GEN-LAST:event_cargarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cargar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cargar(grafo).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JButton cargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtCargado;
    // End of variables declaration//GEN-END:variables
}
