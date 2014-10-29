/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datosUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Oscar
 */
public class PanelImagen extends JPanel implements Cloneable {

    private static ImageIcon imagenSinLetras;
    private static ImageIcon imagenConLetras;
    private ImageIcon imagen;

    public PanelImagen(ImageIcon imagen) {
        
        this.imagen = imagen;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(imagen.getImage(), 0, 0, 1200, 840, null);
        super.paintComponent(g);
    }

    public static PanelImagen dameNuevoPanelSinLetras() {

        if (imagenSinLetras == null) {

            ImageIcon imagenFondo = new ImageIcon(PanelImagen.class.getResource("/images/fondoSinLetras.jpg"));
            Image imagen = imagenFondo.getImage();
            imagen = imagen.getScaledInstance(1200, 840, 0);
            imagenSinLetras = new ImageIcon(imagen);
        }
        
        PanelImagen dev = new PanelImagen(imagenSinLetras);
        dev.setOpaque(false);

        return dev;
    }
    
    public static PanelImagen dameNuevoPanelConLetras() {

        if (imagenConLetras == null) {
            
            ImageIcon imagenFondo = new ImageIcon(PanelImagen.class.getResource("/images/fondoInicio.jpg"));
            Image imagen = imagenFondo.getImage();
            imagen = imagen.getScaledInstance(1200, 840, 0);
            imagenConLetras = new ImageIcon(imagen);
        }
        
        PanelImagen dev = new PanelImagen(imagenConLetras);
        dev.setOpaque(false);

        return dev;
    }
}
