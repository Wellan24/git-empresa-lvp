/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras.pdf;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import proyectoempresalvp.datos.Cliente;
import proyectoempresalvp.datos.FacturaExtra;
import proyectoempresalvp.datos.FacturaMensual;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.gestoras.Datos.GestoraDatos;
import proyectoempresalvp.gestoras.Gestora;

/**
 *
 * @author Oscar
 */
public class GestoraPDF implements JRDataSource {

    private ArrayList<HashMap<String, Object>> datos;
    private int indiceParticipanteActual = -1;

    public GestoraPDF(ArrayList<HashMap<String, Object>> datos) {

        this.datos = datos;
    }

    @Override
    public boolean next() throws JRException {
        
        return ++indiceParticipanteActual < datos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {

        
        System.out.println(indiceParticipanteActual);
        System.out.println(datos.get(indiceParticipanteActual).get(jrf.getName()));
        return datos.get(indiceParticipanteActual).get(jrf.getName()).toString();
    }

    public static void generarPDFExtra(ArrayList<HashMap<String, Object>> detalles, FacturaExtra factura) {

        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src/proyectoempresalvp/gestoras/pdf/FacturaPDF.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, factura, new GestoraPDF(detalles));

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(
                    GestoraArchivos.generarNombreCarpetaExtras() + "/" + factura.get("NUMEROFACTURA")
                    + "_fecha_" + factura.get("FECHA").toString().replace("/", "_")
                    + "_cliente_" + factura.get("NOMBRE").toString().replace("[/:;- ]", "_") + ".pdf"));
            exporter.exportReport();
        } catch(JRException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generarPDFMensual(FacturaMensual factura) {

        ArrayList<HashMap<String, Object>> detalles = new ArrayList();
        HashMap<String, Object> linea = new HashMap();
        linea.put("CONCEPTO", "FACTURA MENSUAL DE " + Gestora.getMes(((Fecha) factura.get("FECHA")).getMes() - 1));
        linea.put("IMPORTE", factura.get("EUROSMES").toString());
        detalles.add(factura);
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src/proyectoempresalvp/gestoras/pdf/FacturaPDF.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, factura, new GestoraPDF(detalles));

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File(
                    GestoraArchivos.generarNombreCarpetaCliente(GestoraDatos.dameGestora().get(Cliente.getTabla()).devuelveValorPorClave(factura.get("NUMCLIENTE")))));
            exporter.exportReport();
        } catch(JRException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
