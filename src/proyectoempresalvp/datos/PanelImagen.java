/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Oscar
 */
public class PanelImagen extends JPanel implements Cloneable {

    private static ImageIcon img;
    private static PanelImagen panel;

    public PanelImagen() {
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(img.getImage(), 0, 0, 1200, 840, null);
        super.paintComponent(g);
    }

    public static PanelImagen dameNuevoPanel() {

        if (img == null) {

            ImageIcon imagenFondo = new ImageIcon(PanelImagen.class.getResource("/images/fondo1.jpg"));
            Image imagen = imagenFondo.getImage();
            imagen = imagen.getScaledInstance(1200, 840, 0);
            img = new ImageIcon(imagen);
        }
        
        PanelImagen dev = new PanelImagen();
        dev.setOpaque(false);

        return dev;
    }
}
