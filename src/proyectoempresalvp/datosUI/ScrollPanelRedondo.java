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
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author Oscar
 */
public class ScrollPanelRedondo extends JScrollPane{
    
    private final Color color = new Color(0xEFFBFB);
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

        Paint oldPaint = g2.getPaint();
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                0, 0, getWidth(), getHeight() - 1, arcw, arch);
        g2.clip(r2d);
        g2.setPaint(color);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setStroke(new BasicStroke(4f));
        g2.setPaint(Color.BLACK);
        g2.drawRoundRect(0, 0, getWidth() - 2, getHeight() - 2, 0, 0);

        g2.setPaint(oldPaint);
        super.paintComponent(g);
    }
}
