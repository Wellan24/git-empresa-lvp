/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gui;

import javax.swing.JOptionPane;
import proyectoempresalvp.datos.Empleado;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.datosUI.Boton;
import proyectoempresalvp.datosUI.JPanelTranslucido;
import proyectoempresalvp.datosUI.PanelImagen;
import proyectoempresalvp.gestoras.Gestora;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.Datos.GestoraDatos;

/**
 *
 * @author Administrador
 */
public class DialogoNuevoEmpleado extends javax.swing.JDialog {

    /**
     * Creates new form DialogoNuevoEmpleado
     */
    public DialogoNuevoEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        panelNuevoEmpleado = PanelImagen.dameNuevoPanelSinLetras();
        jPdatosPer = new JPanelTranslucido();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        ctEmpleN = new javax.swing.JTextField();
        ctEmpleDesc = new javax.swing.JTextField();
        ctEmpleNombre = new javax.swing.JTextField();
        ctEmpleDomicilio = new javax.swing.JTextField();
        ctEmpleLoc = new javax.swing.JTextField();
        ctEmpleCP = new javax.swing.JTextField();
        ctEmpleProv = new javax.swing.JTextField();
        ctEmpleNif = new javax.swing.JTextField();
        ctEmpleTelf = new javax.swing.JTextField();
        ctEmpleMovil = new javax.swing.JTextField();
        ctEmpleIBAN = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        ctEmpleAlta = new javax.swing.JTextField();
        jLabel158 = new javax.swing.JLabel();
        ctEmpleNac = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        ctEmpleNomina = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        ctEmpleSS = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        ctVacaciones1 = new javax.swing.JTextField();
        ctBajas1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        atNotas = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        bAñadir = new Boton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVO EMPLEADO");

        jPdatosPer.setBackground(new java.awt.Color(204, 204, 255));

        jLabel18.setText("Empleado");

        jLabel19.setText("Anagrama:");

        jLabel20.setText("Nombre");

        jLabel21.setText("Domicilio");

        jLabel22.setText("Localidad");

        jLabel23.setText("CP");

        jLabel24.setText("Provincia");

        jLabel25.setText("NIF/CIF");

        jLabel26.setText("Teléfono");

        jLabel27.setText("Móvil");

        ctEmpleN.setEditable(false);

        ctEmpleIBAN.setText("IBAN");

        jLabel155.setText("Últimas vacaciones:");

        jLabel156.setText("Último periodo de baja:");

        jLabel157.setText("Fecha Alta:");

        jLabel158.setText("Nacimiento:");

        jLabel159.setText("Nómina:");

        jLabel160.setText("Núm S.S:");

        jLabel161.setText("Cuenta Cobro:");

        atNotas.setColumns(20);
        atNotas.setRows(5);
        jScrollPane3.setViewportView(atNotas);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 153, 153));
        jLabel37.setText("Notas sobre el empleado:");

        javax.swing.GroupLayout jPdatosPerLayout = new javax.swing.GroupLayout(jPdatosPer);
        jPdatosPer.setLayout(jPdatosPerLayout);
        jPdatosPerLayout.setHorizontalGroup(
            jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPdatosPerLayout.createSequentialGroup()
                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel156)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ctBajas1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosPerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ctVacaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosPerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel159)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ctEmpleNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ctEmpleN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosPerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel160)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ctEmpleSS, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ctEmpleDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20)
                                .addGap(31, 31, 31)
                                .addComponent(ctEmpleNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21)
                                .addGap(28, 28, 28)
                                .addComponent(ctEmpleDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ctEmpleTelf, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addGap(24, 24, 24)
                                        .addComponent(ctEmpleLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel157)
                                            .addComponent(jLabel158))
                                        .addGap(107, 143, Short.MAX_VALUE)
                                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ctEmpleNac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ctEmpleAlta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ctEmpleMovil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ctEmpleProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ctEmpleCP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ctEmpleNif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                                        .addComponent(jLabel161)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ctEmpleIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPdatosPerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPdatosPerLayout.setVerticalGroup(
            jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPdatosPerLayout.createSequentialGroup()
                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18)
                                .addComponent(ctEmpleN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ctEmpleAlta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addComponent(jLabel157)
                                .addGap(18, 18, 18)
                                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel158)
                                    .addComponent(ctEmpleDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))))
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(ctEmpleNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ctEmpleNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel25)))))
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ctEmpleNif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel21))
                            .addComponent(ctEmpleDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel22))
                            .addComponent(ctEmpleLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(ctEmpleCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(ctEmpleProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(ctEmpleMovil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ctEmpleIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPdatosPerLayout.createSequentialGroup()
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel26))
                            .addGroup(jPdatosPerLayout.createSequentialGroup()
                                .addComponent(ctEmpleTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ctEmpleSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel160)
                                    .addComponent(jLabel161))))
                        .addGap(18, 18, 18)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel159)
                            .addComponent(ctEmpleNomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel155)
                            .addComponent(ctVacaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPdatosPerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel156)
                            .addComponent(ctBajas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        bAñadir.setText("Añadir");
        bAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNuevoEmpleadoLayout = new javax.swing.GroupLayout(panelNuevoEmpleado);
        panelNuevoEmpleado.setLayout(panelNuevoEmpleadoLayout);
        panelNuevoEmpleadoLayout.setHorizontalGroup(
            panelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevoEmpleadoLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
            .addGroup(panelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelNuevoEmpleadoLayout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(jPdatosPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(131, Short.MAX_VALUE)))
        );
        panelNuevoEmpleadoLayout.setVerticalGroup(
            panelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNuevoEmpleadoLayout.createSequentialGroup()
                .addContainerGap(530, Short.MAX_VALUE)
                .addComponent(bAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(panelNuevoEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelNuevoEmpleadoLayout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(jPdatosPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelNuevoEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelNuevoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAñadirActionPerformed
        
        insertarEmpleado();
    }//GEN-LAST:event_bAñadirActionPerformed
    
    private void insertarEmpleado() {

        String alta = ctEmpleAlta.getText(), nac = ctEmpleNac.getText(), IBAN = ctEmpleIBAN.getText();
        if(!Gestora.comprobarFormatoFechaCorrecto(alta) || !Gestora.comprobarFormatoFechaCorrecto(nac)) {
            JOptionPane.showMessageDialog(this, "Comprueba las fechas, el formato es dd/mm/aaaa");
        } else if(!Gestora.esValidoIBAN(IBAN)) {

            JOptionPane.showMessageDialog(this, "Comprueba el IBAN");
        } else if(!comprobarNumero(ctEmpleNomina.getText()) || !comprobarNumero(ctEmpleTelf.getText())
                || !comprobarNumero(ctEmpleMovil.getText()) || !comprobarNumero(ctEmpleSS.getText())
                || !comprobarNumero(ctEmpleCP.getText())) {

            JOptionPane.showMessageDialog(this, "Comprueba que los telefonos, la nomina y el numero de la seguridad social son numeros");
        } else {

            Empleado nuevoEmpleado = new Empleado(Integer.parseInt(ctEmpleN.getText()), ctEmpleNif.getText(),
                    ctEmpleDesc.getText(), ctEmpleNombre.getText(), ctEmpleDomicilio.getText(),
                    ctEmpleLoc.getText(), Integer.parseInt(ctEmpleCP.getText()), ctEmpleProv.getText(),
                    Integer.parseInt(ctEmpleTelf.getText()), Integer.parseInt(ctEmpleMovil.getText()),
                    ctEmpleIBAN.getText(), new Fecha(alta), new Fecha(nac), Integer.parseInt(ctEmpleNomina.getText()),
                    ctEmpleSS.getText(), "23", "23");

            if(GestoraBaseDatos.insertarDato(nuevoEmpleado)) {

                GestoraDatos.actualizaDatos(GestoraDatos.ACTUALIZAR_EMPLEADOS);
            }

        }

    }
    
    private boolean comprobarNumero(String n) {

        return Gestora.comprobarNumero(n);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atNotas;
    private javax.swing.JButton bAñadir;
    private javax.swing.JTextField ctBajas1;
    private javax.swing.JTextField ctEmpleAlta;
    private javax.swing.JTextField ctEmpleCP;
    private javax.swing.JTextField ctEmpleDesc;
    private javax.swing.JTextField ctEmpleDomicilio;
    private javax.swing.JTextField ctEmpleIBAN;
    private javax.swing.JTextField ctEmpleLoc;
    private javax.swing.JTextField ctEmpleMovil;
    private javax.swing.JTextField ctEmpleN;
    private javax.swing.JTextField ctEmpleNac;
    private javax.swing.JTextField ctEmpleNif;
    private javax.swing.JTextField ctEmpleNombre;
    private javax.swing.JTextField ctEmpleNomina;
    private javax.swing.JTextField ctEmpleProv;
    private javax.swing.JTextField ctEmpleSS;
    private javax.swing.JTextField ctEmpleTelf;
    private javax.swing.JTextField ctVacaciones1;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JPanel jPdatosPer;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelNuevoEmpleado;
    // End of variables declaration//GEN-END:variables
}
