/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datosUI;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableModel;
import org.apache.commons.collections.ListUtils;

/**
 *
 * @author Oscar
 */
public class Tabla extends JTable {

    int[] seleccionAnterior;
    int con = 0;

    public Tabla() {
        super();
        setOpaque(false);
        setDefaultRenderer(Object.class, new TableRenderer());
        setDefaultRenderer(Boolean.class, new TableRenderer());
        setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        setAutoCreateRowSorter(true);
        setRowHeight(20);

    }

    @Override
    public void paintComponents(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        AlphaComposite old = (AlphaComposite) g2.getComposite();
        g2.setComposite(AlphaComposite.SrcOver.derive(0.5f));

        super.paintComponent(g);

        g2.setComposite(old);
    }

    @Override
    public void setModel(TableModel dataModel) {
        super.setModel(dataModel);
    }

}
