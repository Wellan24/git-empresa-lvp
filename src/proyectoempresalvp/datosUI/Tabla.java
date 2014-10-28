/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datosUI;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTable;

/**
 *
 * @author Oscar
 */
public class Tabla extends JTable{

    private final Color color = new Color(0xEFFBFB);
    private final int arcw = 20;
    private final int arch = 20;

    public Tabla() {        
        super();
        setOpaque(false);
    }   
    

    @Override
    public void paintComponents(Graphics g) {
       
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setStroke(new BasicStroke(4f));
        g2.setPaint(Color.BLACK);
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 2, 18, 18);
        
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AlphaComposite old = (AlphaComposite) g2.getComposite();
        g2.setComposite(AlphaComposite.SrcOver.derive(0.5f));
        
        super.paintComponent(g);
        
        g2.setComposite(old);
    }

    
    
    
}
