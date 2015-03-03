/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datosUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JScrollPane;

/**
 *
 * @author Oscar
 */
public class ScrollPanelRedondo extends JScrollPane{
    
    private final Color color = new Color(0xd4ebfa);
    private final int arcw = 2;
    private final int arch = 2;

    public ScrollPanelRedondo() {
        super();
        setOpaque(false);
//        getViewport().setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);


        g2.setPaint(color);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setStroke(new BasicStroke(4f));
        g2.setPaint(Color.BLACK);
        g2.drawRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
    }
}
