/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datosUI;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Oscar
 */
public class TableRenderer extends JLabel implements TableCellRenderer {

    private static final Color color = new Color(0x000000);
    private static final Border borde = BorderFactory.createLineBorder(color, 1);

    public TableRenderer() {

        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(final JTable table,
            final Object value, final boolean isSelected, final boolean hasFocus,
            final int row, final int column) {

        setText(value.toString());

        setBackground(new Color(231, 247, 252));
        setForeground(color);
        setBorder(null);

        if (hasFocus) {
            setBorder(borde);
        }
        if (isSelected) {

            setBackground(new Color(0x5bb1f9));
            setForeground(new Color(0xFFFFFF));
        }

        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AlphaComposite old = (AlphaComposite) g2.getComposite();
        g2.setComposite(AlphaComposite.SrcOver.derive(0.8f));
        super.paintComponent(g);

        g2.setComposite(old);
    }
}
