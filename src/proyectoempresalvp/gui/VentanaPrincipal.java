/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gui;

import com.sun.javafx.font.FontConstants;

/**
 *
 * @author Administrador
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jLabelImagen = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        jMenuClientes = new javax.swing.JMenu();
        jMenuContratos = new javax.swing.JMenu();
        jMenuItemGestion = new javax.swing.JMenuItem();
        jMenuItemEstudios = new javax.swing.JMenuItem();
        jMenuFacMens = new javax.swing.JMenu();
        jMenuFacEx = new javax.swing.JMenu();
        jMenuEmpleados = new javax.swing.JMenu();
        jMenuOtros = new javax.swing.JMenu();
        jMenuItemHistorico = new javax.swing.JMenuItem();
        jMenuItemHojasBan = new javax.swing.JMenuItem();
        jMenuItemRecibos = new javax.swing.JMenuItem();
        jMenuItemEtiquetas = new javax.swing.JMenuItem();
        jMenuPrograma = new javax.swing.JMenu();
        jMenuItemCerrar = new javax.swing.JMenuItem();
        jMenuItemContraseña = new javax.swing.JMenuItem();
        jMenuItemIpc = new javax.swing.JMenuItem();
        jMenuItemNumFac = new javax.swing.JMenuItem();
        jMenuItemCopSeg = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Limpiezas VERDEJO PELAEZ C.B                                                                                                                C/Olivo,18            47140 - Laguna de Duero                    VALLADOLID");
        setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        PanelPrincipal.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N

        jLabelImagen.setBackground(new java.awt.Color(102, 153, 255));
        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo1.jpg"))); // NOI18N

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelImagen)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabelImagen)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        MenuPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        MenuPrincipal.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N

        jMenuClientes.setBackground(new java.awt.Color(255, 255, 255));
        jMenuClientes.setForeground(new java.awt.Color(0, 0, 153));
        jMenuClientes.setText("      CLIENTES      ");
        jMenuClientes.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        MenuPrincipal.add(jMenuClientes);

        jMenuContratos.setForeground(new java.awt.Color(0, 0, 153));
        jMenuContratos.setText("      CONTRATOS      ");
        jMenuContratos.setFont(new java.awt.Font("Rockwell Extra Bold", 0, 14)); // NOI18N

        jMenuItemGestion.setText("GESTIÓN");
        jMenuContratos.add(jMenuItemGestion);

        jMenuItemEstudios.setText("ESTUDIOS ACTIVOS");
        jMenuContratos.add(jMenuItemEstudios);

        MenuPrincipal.add(jMenuContratos);

        jMenuFacMens.setForeground(new java.awt.Color(0, 0, 153));
        jMenuFacMens.setText("      FACTURACIÓN MENSUAL      ");
        jMenuFacMens.setFont(new java.awt.Font("Felix Titling", 0, 14)); // NOI18N
        MenuPrincipal.add(jMenuFacMens);

        jMenuFacEx.setForeground(new java.awt.Color(0, 0, 153));
        jMenuFacEx.setText("      FACTURAS EXTRA      ");
        jMenuFacEx.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 14)); // NOI18N
        MenuPrincipal.add(jMenuFacEx);

        jMenuEmpleados.setForeground(new java.awt.Color(0, 0, 153));
        jMenuEmpleados.setText("      EMPLEADOS      ");
        jMenuEmpleados.setFont(new java.awt.Font("Papyrus", 0, 14)); // NOI18N
        MenuPrincipal.add(jMenuEmpleados);

        jMenuOtros.setForeground(new java.awt.Color(0, 0, 153));
        jMenuOtros.setText("      OTROS      ");
        jMenuOtros.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N

        jMenuItemHistorico.setText("HISTÓRICO DE FACTURAS");
        jMenuOtros.add(jMenuItemHistorico);

        jMenuItemHojasBan.setText("HOJAS BANCO");
        jMenuOtros.add(jMenuItemHojasBan);

        jMenuItemRecibos.setText("RECIBOS");
        jMenuOtros.add(jMenuItemRecibos);

        jMenuItemEtiquetas.setText("ETIQUETAS");
        jMenuOtros.add(jMenuItemEtiquetas);

        MenuPrincipal.add(jMenuOtros);

        jMenuPrograma.setForeground(new java.awt.Color(0, 0, 153));
        jMenuPrograma.setText("      PROGRAMA      ");
        jMenuPrograma.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N

        jMenuItemCerrar.setText("CERRAR PROGRAMA");
        jMenuPrograma.add(jMenuItemCerrar);

        jMenuItemContraseña.setText("CAMBIAR CONTRASEÑA");
        jMenuPrograma.add(jMenuItemContraseña);

        jMenuItemIpc.setText("ACTUALIZAR IPC");
        jMenuPrograma.add(jMenuItemIpc);

        jMenuItemNumFac.setText("AJUSTAR NUM. FACTURA");
        jMenuPrograma.add(jMenuItemNumFac);

        jMenuItemCopSeg.setText("COPIAS SEGURIDAD");
        jMenuPrograma.add(jMenuItemCopSeg);

        MenuPrincipal.add(jMenuPrograma);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuContratos;
    private javax.swing.JMenu jMenuEmpleados;
    private javax.swing.JMenu jMenuFacEx;
    private javax.swing.JMenu jMenuFacMens;
    private javax.swing.JMenuItem jMenuItemCerrar;
    private javax.swing.JMenuItem jMenuItemContraseña;
    private javax.swing.JMenuItem jMenuItemCopSeg;
    private javax.swing.JMenuItem jMenuItemEstudios;
    private javax.swing.JMenuItem jMenuItemEtiquetas;
    private javax.swing.JMenuItem jMenuItemGestion;
    private javax.swing.JMenuItem jMenuItemHistorico;
    private javax.swing.JMenuItem jMenuItemHojasBan;
    private javax.swing.JMenuItem jMenuItemIpc;
    private javax.swing.JMenuItem jMenuItemNumFac;
    private javax.swing.JMenuItem jMenuItemRecibos;
    private javax.swing.JMenu jMenuOtros;
    private javax.swing.JMenu jMenuPrograma;
    // End of variables declaration//GEN-END:variables
}
