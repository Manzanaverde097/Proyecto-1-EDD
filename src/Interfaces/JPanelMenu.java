/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author sofia
 */
public class JPanelMenu extends JPanel{
    public Image imagen;
    
    public JPanelMenu(String dir){
        imagen = new ImageIcon(dir).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(imagen, 0, 0, this);
    }
}
