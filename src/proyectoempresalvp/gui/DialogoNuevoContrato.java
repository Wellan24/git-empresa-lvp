/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import proyectoempresalvp.datos.Contrato;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.datosUI.JPanelTranslucido;
import proyectoempresalvp.datosUI.PanelImagen;
import proyectoempresalvp.gestoras.Gestora;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.GestoraDatos;

/**
 *
 * @author Administrador
 */
public class DialogoNuevoContrato extends javax.swing.JDialog {

    /**
     * Creates new form DialogoNuevoEmpleado
     *
     * @param parent
     * @param modal
     */
    public DialogoNuevoContrato(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        comboNumeroCliente.setModel(new DefaultComboBoxModel(GestoraDatos.dameGestora().get("CLIENTES").devuelveTodasLasClaves()));
        ctNumCon.setText("" + GestoraDatos.dameGestora().get("CONTRATOS").devuelveNumeroSiguiente());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNuevoContrato = PanelImagen.dameNuevoPanelSinLetras();
        jPanelDatosCli = new JPanelTranslucido();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        ctDes = new javax.swing.JTextField();
        ctNombre = new javax.swing.JTextField();
        ctDomicili = new javax.swing.JTextField();
        ctLocali = new javax.swing.JTextField();
        ctCodP = new javax.swing.JTextField();
        ctProvinci = new javax.swing.JTextField();
        ctNifiCif = new javax.swing.JTextField();
        ctTelefon = new javax.swing.JTextField();
        ctContratosIBAN = new javax.swing.JTextField();
        comboNumeroCliente = new javax.swing.JComboBox();
        jPanelDatosContr = new JPanelTranslucido();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        ctNumCon = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        ctIvaCon = new javax.swing.JTextField();
        ctPerIn = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        ctPerFin = new javax.swing.JTextField();
        ctIAeur = new javax.swing.JTextField();
        ctIMeur = new javax.swing.JTextField();
        ctFormPag = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        ctSitua = new javax.swing.JTextField();
        ctDiaCobro2 = new javax.swing.JTextField();
        ctDiaCobr1 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        ctRefHojBan = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        bCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVO CONTRATO");

        jPanelDatosCli.setBackground(new java.awt.Color(102, 153, 255));

        jLabel60.setText("Nº Cliente:");

        jLabel61.setText("Descripción:");

        jLabel62.setText("Nombre:");

        jLabel63.setText("Domicilio:");

        jLabel64.setText("Localidad:");

        jLabel65.setText("CP:");

        jLabel66.setText("Provincia:");

        jLabel67.setText("NIF/CIF:");

        jLabel68.setText("Teléfono:");

        jLabel69.setText("IBAN");

        comboNumeroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNumeroClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosCliLayout = new javax.swing.GroupLayout(jPanelDatosCli);
        jPanelDatosCli.setLayout(jPanelDatosCliLayout);
        jPanelDatosCliLayout.setHorizontalGroup(
            jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctContratosIBAN)
                    .addGroup(jPanelDatosCliLayout.createSequentialGroup()
                        .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosCliLayout.createSequentialGroup()
                                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ctNombre)
                            .addComponent(ctDomicili)
                            .addComponent(ctLocali)
                            .addComponent(ctCodP)
                            .addComponent(ctProvinci)
                            .addComponent(ctNifiCif)
                            .addComponent(ctTelefon)
                            .addGroup(jPanelDatosCliLayout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ctDes, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanelDatosCliLayout.setVerticalGroup(
            jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosCliLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(ctDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNumeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(ctNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(ctDomicili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(ctLocali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(ctCodP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(ctProvinci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(ctNifiCif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosCliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(ctTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ctContratosIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanelDatosContr.setBackground(new java.awt.Color(102, 153, 255));

        jLabel70.setText("Nº Contrato:");

        jLabel71.setText("Periodo Contrato:");

        jLabel72.setText("Importe Anual sin IVA (Euros):");

        jLabel73.setText("Importe Mensual sin IVA (Euros):");

        jLabel74.setText("Forma de Pago:");

        jLabel75.setText("IVA Contrato:");

        jLabel76.setText("A");

        ctIAeur.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ctIAeur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ctIAeurKeyTyped(evt);
            }
        });

        ctIMeur.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ctIMeur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ctIMeurKeyTyped(evt);
            }
        });

        jLabel81.setText("Situación:");

        jLabel83.setText("Ref Hoja Banco:");

        jLabel77.setText("Día Cobro:");

        javax.swing.GroupLayout jPanelDatosContrLayout = new javax.swing.GroupLayout(jPanelDatosContr);
        jPanelDatosContr.setLayout(jPanelDatosContrLayout);
        jPanelDatosContrLayout.setHorizontalGroup(
            jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosContrLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosContrLayout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addGap(18, 18, 18)
                        .addComponent(ctNumCon, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel75))
                    .addGroup(jPanelDatosContrLayout.createSequentialGroup()
                        .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDatosContrLayout.createSequentialGroup()
                                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ctPerIn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72)
                            .addComponent(jLabel74)
                            .addComponent(jLabel83)
                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosContrLayout.createSequentialGroup()
                        .addComponent(ctDiaCobr1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(ctIvaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosContrLayout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(ctDiaCobro2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosContrLayout.createSequentialGroup()
                            .addComponent(jLabel76)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ctPerFin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ctIAeur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctIMeur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctSitua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctFormPag, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctRefHojBan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelDatosContrLayout.setVerticalGroup(
            jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosContrLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(ctNumCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel75)
                    .addComponent(ctDiaCobro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(ctPerIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76)
                    .addComponent(ctPerFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ctIAeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel72))
                .addGap(2, 2, 2)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(ctIMeur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(ctFormPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81)
                    .addComponent(ctSitua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ctDiaCobr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel77))
                    .addComponent(ctIvaCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDatosContrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel83)
                    .addComponent(ctRefHojBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        bCrear.setBackground(new java.awt.Color(51, 255, 204));
        bCrear.setText("Crear");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNuevoContratoLayout = new javax.swing.GroupLayout(panelNuevoContrato);
        panelNuevoContrato.setLayout(panelNuevoContratoLayout);
        panelNuevoContratoLayout.setHorizontalGroup(
            panelNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevoContratoLayout.createSequentialGroup()
                .addContainerGap(625, Short.MAX_VALUE)
                .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(panelNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelNuevoContratoLayout.createSequentialGroup()
                    .addGap(170, 170, 170)
                    .addGroup(panelNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanelDatosCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelDatosContr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(171, Short.MAX_VALUE)))
        );
        panelNuevoContratoLayout.setVerticalGroup(
            panelNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevoContratoLayout.createSequentialGroup()
                .addContainerGap(563, Short.MAX_VALUE)
                .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelNuevoContratoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevoContratoLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatosCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jPanelDatosContr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNuevoContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNuevoContrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboNumeroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNumeroClienteActionPerformed

        if(comboNumeroCliente.getSelectedItem() != null && GestoraDatos.dameGestora().get("CLIENTES") != null) {

            Dato d = GestoraDatos.dameGestora().get("CLIENTES").devuelveValorPorClave(comboNumeroCliente.getSelectedItem());
            ctDes.setText(d.get("DESCRIPCION").toString());
            ctNombre.setText(d.get("NOMBRE").toString());
            ctLocali.setText(d.get("LOCALIDAD").toString());
            ctDomicili.setText(d.get("DOMICILIO").toString());
            ctCodP.setText(d.get("CP").toString());
            ctProvinci.setText(d.get("PROVINCIA").toString());
            ctNifiCif.setText(d.get("CIF").toString());
            ctTelefon.setText(d.get("TLFCLIENTE").toString());
            ctContratosIBAN.setText(d.get("IBAN").toString());
        }
    }//GEN-LAST:event_comboNumeroClienteActionPerformed

    private void ctIAeurKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ctIAeurKeyTyped
        char car = evt.getKeyChar();
        if(((car < '0' || car > '9') && car != '.') || ctIAeur.getText().contains(".") && car == '.') {
            evt.consume();
        }

        if(car != '.') {
            ctIMeur.setText("" + (Double.parseDouble(ctIAeur.getText().isEmpty() ? "0" : ctIAeur.getText() + car) / 12));
        }
    }//GEN-LAST:event_ctIAeurKeyTyped

    private void ctIMeurKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ctIMeurKeyTyped
        char car = evt.getKeyChar();
        if(((car < '0' || car > '9') && car != '.') || ctIMeur.getText().contains(".") && car == '.') {
            evt.consume();
        }

        if(car != '.') {
            ctIAeur.setText("" + (Double.parseDouble(ctIMeur.getText().isEmpty() ? "0" : ctIMeur.getText() + car) * 12));
        }
    }//GEN-LAST:event_ctIMeurKeyTyped

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        insertarContrato();
    }//GEN-LAST:event_bCrearActionPerformed

    private void insertarContrato() {

        String inicio = ctPerIn.getText(), fin = ctPerFin.getText();

        if(comboNumeroCliente.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona un Cliente");
        } else if(!Gestora.comprobarFormatoFechaCorrecto(inicio) || !Gestora.comprobarFormatoFechaCorrecto(fin)) {
            JOptionPane.showMessageDialog(this, "Comprueba las fechas, el formato es dd/mm/aaaa");
        } else if(!comprobarNumero(comboNumeroCliente.getSelectedItem().toString())
                || !comprobarNumero(ctIAeur.getText()) || !comprobarNumero(ctIMeur.getText())
                || !comprobarNumero(ctDiaCobr1.getText()) || !comprobarNumero(ctIvaCon.getText())) {

            JOptionPane.showMessageDialog(this, "Comprueba que has introducido en los campos numéricos números correctamente.");
        } else {

            Contrato nuevoContrato = new Contrato(Integer.parseInt(ctNumCon.getText()), //NUMCONTRATO
                    Integer.parseInt(comboNumeroCliente.getSelectedItem().toString()), //NUMCLIENTE
                    ctDes.getText(), new Fecha(inicio), new Fecha(fin), //DESCRIPCION,INICIO,FIN
                    ctIAeur.getText(), //EUROSAÑO
                    ctIMeur.getText(), //EUROSMES
                    ctSitua.getText(), ctFormPag.getText(), //SITUACION,FORMAPAGO
                    Integer.parseInt(ctDiaCobr1.getText()), //DIACOBRO
                    Integer.parseInt(ctIvaCon.getText()));//TANTO IVA

            if(GestoraBaseDatos.insertarDato(nuevoContrato)) {

                GestoraDatos.actualizaDatos(GestoraDatos.ACTUALIZAR_CONTRATOS);
            }
        }
    }

    private boolean comprobarNumero(String n) {

        return Gestora.comprobarNumero(n);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrear;
    private javax.swing.JComboBox comboNumeroCliente;
    private javax.swing.JTextField ctCodP;
    private javax.swing.JTextField ctContratosIBAN;
    private javax.swing.JTextField ctDes;
    private javax.swing.JTextField ctDiaCobr1;
    private javax.swing.JTextField ctDiaCobro2;
    private javax.swing.JTextField ctDomicili;
    private javax.swing.JTextField ctFormPag;
    private javax.swing.JTextField ctIAeur;
    private javax.swing.JTextField ctIMeur;
    private javax.swing.JTextField ctIvaCon;
    private javax.swing.JTextField ctLocali;
    private javax.swing.JTextField ctNifiCif;
    private javax.swing.JTextField ctNombre;
    private javax.swing.JTextField ctNumCon;
    private javax.swing.JTextField ctPerFin;
    private javax.swing.JTextField ctPerIn;
    private javax.swing.JTextField ctProvinci;
    private javax.swing.JTextField ctRefHojBan;
    private javax.swing.JTextField ctSitua;
    private javax.swing.JTextField ctTelefon;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JPanel jPanelDatosCli;
    private javax.swing.JPanel jPanelDatosContr;
    private javax.swing.JPanel panelNuevoContrato;
    // End of variables declaration//GEN-END:variables
}
