/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datosUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import proyectoempresalvp.gestoras.Gestora;

/**
 *
 * @author Oscar
 */
public class TableRenderer extends JLabel implements TableCellRenderer {

    private static final Color colorNegro = new Color(0x000000);
    private static final Color colorAzulClaro = new Color(231, 247, 252);
    private static final Color colorAzulOscuro = new Color(0x74b8f1);
    private static final Color colorAzulSeleccionado = new Color(0xa4d2f9);

    boolean isSelected;

    public TableRenderer() {

        setOpaque(true);
        isSelected = false;
    }

    @Override
    public Component getTableCellRendererComponent(final JTable table,
            final Object value, final boolean isSelected, final boolean hasFocus,
            final int row, final int column) {

        setHorizontalAlignment(JLabel.LEFT);

        if(value != null && value instanceof Boolean) {
            JCheckBox check = new JCheckBox();
            check.setHorizontalAlignment(JLabel.CENTER);
            check.setSelected(((Boolean) value));
            check.setOpaque(true);
            check.setBackground(colorAzulClaro);
            check.setForeground(colorNegro);
            check.setBorder(null);
            if(isSelected) {
                check.setBackground(colorAzulOscuro);
            }
            if(hasFocus) {
                check.setBackground(colorAzulSeleccionado);
            }
            return check;
        }
        if(value != null)
            setText(value.toString());
        setBackground(colorAzulClaro);
        setForeground(colorNegro);
        setBorder(null);
        if(isSelected) {
            setBackground(colorAzulOscuro);
        }
        if(hasFocus) {
            setBackground(colorAzulSeleccionado);
        }
        if(value == null)
            setText("");
        else if(value instanceof Number && Gestora.comprobarNumero(value.toString()))
            setHorizontalAlignment(JLabel.RIGHT);

        setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 2));
        return this;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(!isSelected) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            AlphaComposite old = (AlphaComposite) g2.getComposite();
            g2.setComposite(AlphaComposite.SrcOver.derive(0.8f));
            super.paintComponent(g);

            g2.setComposite(old);
        } else {
            super.paintComponent(g);
        }
    }
}
