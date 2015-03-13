/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import proyectoempresalvp.datos.ArrayListDato;
import proyectoempresalvp.datos.Cliente;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.FacturaExtra;
import proyectoempresalvp.datos.FacturaExtraDetalles;
import proyectoempresalvp.datos.FacturaMensual;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.gestoras.Datos.GestoraDatos;
import proyectoempresalvp.gestoras.Gestora;
import proyectoempresalvp.gestoras.GestoraConfiguracion;

/**
 *
 * @author Oscar
 */
public class GestoraPDF implements JRDataSource {

    private final ArrayList<HashMap<String, Object>> datos;
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

        return datos.get(indiceParticipanteActual).get(jrf.getName()).toString();
    }
    
    public static void generarPDFExtra(FacturaExtra factura) {

        ArrayList<HashMap<String, Object>> detalles = new ArrayList(GestoraDatos.recuperarConDummy(new FacturaExtraDetalles(), null, " where NUMERO = " + factura.get("NUMEROFACTURA")));
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src/proyectoempresalvp/gestoras/pdf/FacturaPDF.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, factura, new GestoraPDF(detalles));

            String nombre = generarNombreExtra(factura);
            File f = new File(nombre);
            f.getParentFile().mkdirs();

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, f);
            exporter.exportReport();

            Desktop.getDesktop().open(f);
        } catch(JRException | IOException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generarPDFExtra(FacturaExtra factura, ArrayList<InputStream> pdfs) {

        ArrayList<HashMap<String, Object>> detalles = new ArrayList(GestoraDatos.recuperarConDummy(new FacturaExtraDetalles(), null, " where NUMERO = " + factura.get("NUMEROFACTURA")));
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src/proyectoempresalvp/gestoras/pdf/FacturaPDF.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, factura, new GestoraPDF(detalles));

            String nombre = generarNombreExtra(factura);
            File f = new File(nombre);
            f.getParentFile().mkdirs();

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, f);
            exporter.exportReport();

            pdfs.add(new FileInputStream(f));
        } catch(JRException | IOException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generarPDFExtras(int[] posGestora) {

        ArrayList<InputStream> pdfsGenerados = new ArrayList<>();
        
        for(int i :posGestora) {
            GestoraPDF.generarPDFExtra((FacturaExtra) GestoraDatos.dameGestora().get(FacturaExtra.getTabla()).get(i), pdfsGenerados);
        }

        File f = new File(GestoraConfiguracion.get("RUTA") + "/Temp/temporal.pdf");
        f.getParentFile().mkdirs();
        try {

            concatPDFs(pdfsGenerados, new FileOutputStream(f), false);
            Desktop.getDesktop().open(f);
        } catch(FileNotFoundException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generarPDFMensual(FacturaMensual factura, ArrayList<InputStream> pdfs) {

        ArrayList<HashMap<String, Object>> detalles = new ArrayList();
        HashMap<String, Object> linea = new HashMap();
        linea.put("CONCEPTO", "FACTURA MENSUAL DE " + Gestora.getMes(((Fecha) factura.get("FECHA")).getMes() - 1));
        linea.put("IMPORTE", factura.get("EUROSMES").toString());
        detalles.add(linea);
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src/proyectoempresalvp/gestoras/pdf/FacturaPDF.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, factura, new GestoraPDF(detalles));

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

            String nombre = generarNombreMensual(factura);
            File f = new File(nombre);
            f.getParentFile().mkdirs();

            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, f);
            exporter.exportReport();

            pdfs.add(new FileInputStream(f));
        } catch(JRException | IOException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generarPDFMensual(FacturaMensual factura) {

        ArrayList<HashMap<String, Object>> detalles = new ArrayList();
        HashMap<String, Object> linea = new HashMap();
        linea.put("CONCEPTO", "FACTURA MENSUAL DE " + Gestora.getMes(((Fecha) factura.get("FECHA")).getMes() - 1));
        linea.put("IMPORTE", factura.get("EUROSMES").toString());
        detalles.add(linea);
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile("src/proyectoempresalvp/gestoras/pdf/FacturaPDF.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, factura, new GestoraPDF(detalles));

            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

            String nombre = generarNombreMensual(factura);
            File f = new File(nombre);
            f.getParentFile().mkdirs();

            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, f);
            exporter.exportReport();

            Desktop.getDesktop().open(f);
        } catch(JRException | IOException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String generarNombreExtra(FacturaExtra factura) {

        if((int) factura.get("NUMEROCLIENTE") == -1) {

            return GestoraArchivos.generarNombreCarpetaExtras() + "/" + factura.get("NOMBRE").toString()
                    .replace("[/:;- ]", "_") + "/Nº " + factura.get("NUMEROFACTURA")
                    + " Fecha - " + factura.get("FECHA").toString().replace("/", "_") + ".pdf";
        } else {

            Dato c = GestoraDatos.recuperarConDummy(new Cliente(), null, " where NUMEROCLIENTE = " + factura.get("NUMEROCLIENTE")).get(0);
            return GestoraArchivos.generarNombreCarpetaCliente(c)
                    + "/Extra/Nº " + factura.get("NUMEROFACTURA")
                    + " Fecha - " + factura.get("FECHA").toString().replace("/", "_") + ".pdf";
        }
    }

    public static String generarNombreMensual(FacturaMensual factura) {

        Dato c = GestoraDatos.recuperarConDummy(new Cliente(), null, " where NUMEROCLIENTE = " + factura.get("NUMCLIENTE")).get(0);

        return GestoraArchivos.generarNombreCarpetaCliente(c)
                + "/" + ((Fecha) factura.get("FECHA")).getAño() + "/" + factura.get("NUMEROFACTURA")
                + "_" + Gestora.getMes(((Fecha) factura.get("FECHA")).getMes()).toUpperCase() + ".pdf";
    }

    public static void generarPDFFacturasMensuales(int numPeriodo) {

        ArrayListDato<Dato> facturas = GestoraDatos.recuperarConDummy(new FacturaMensual(), null, " where NUMPERIODO = " + numPeriodo);

        ArrayList<InputStream> pdfsGenerados = new ArrayList<>();
        facturas.stream().forEach((d) -> {
            generarPDFMensual((FacturaMensual) d, pdfsGenerados);
        });

        File f = new File(GestoraConfiguracion.get("RUTA") + "/Temp/temporal.pdf");
        f.getParentFile().mkdirs();
        try {

            concatPDFs(pdfsGenerados, new FileOutputStream(f), false);
            Desktop.getDesktop().open(f);
        } catch(FileNotFoundException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            Logger.getLogger(GestoraPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void concatPDFs(ArrayList<InputStream> streamOfPDFFiles,
            OutputStream outputStream, boolean paginate) {

        Document document = new Document();
        try {
            ArrayList<InputStream> pdfs = streamOfPDFFiles;
            ArrayList<PdfReader> readers = new ArrayList<PdfReader>();
            int totalPages = 0;
            Iterator<InputStream> iteratorPDFs = pdfs.iterator();

            while(iteratorPDFs.hasNext()) {
                InputStream pdf = iteratorPDFs.next();
                PdfReader pdfReader = new PdfReader(pdf);
                readers.add(pdfReader);
                totalPages += pdfReader.getNumberOfPages();
            }

            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            document.open();
            PdfContentByte cb = writer.getDirectContent();

            PdfImportedPage page;
            int currentPageNumber = 0;
            int pageOfCurrentReaderPDF = 0;
            Iterator<PdfReader> iteratorPDFReader = readers.iterator();

            while(iteratorPDFReader.hasNext()) {
                PdfReader pdfReader = iteratorPDFReader.next();

                while(pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {

                    Rectangle rectangle = pdfReader.getPageSizeWithRotation(1);
                    document.setPageSize(rectangle);
                    document.newPage();

                    pageOfCurrentReaderPDF++;
                    currentPageNumber++;
                    page = writer.getImportedPage(pdfReader,
                            pageOfCurrentReaderPDF);
                    switch(rectangle.getRotation()) {
                        case 0:
                            cb.addTemplate(page, 1f, 0, 0, 1f, 0, 0);
                            break;
                        case 90:
                            cb.addTemplate(page, 0, -1f, 1f, 0, 0, pdfReader
                                    .getPageSizeWithRotation(1).getHeight());
                            break;
                        case 180:
                            cb.addTemplate(page, -1f, 0, 0, -1f, 0, 0);
                            break;
                        case 270:
                            cb.addTemplate(page, 0, 1.0F, -1.0F, 0, pdfReader
                                    .getPageSizeWithRotation(1).getWidth(), 0);
                            break;
                        default:
                            break;
                    }
                    if(paginate) {
                        cb.beginText();
                        cb.getPdfDocument().getPageSize();
                        cb.endText();
                    }
                }
                pageOfCurrentReaderPDF = 0;
            }
            outputStream.flush();
            document.close();
            outputStream.close();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(document.isOpen())
                document.close();
            try {
                if(outputStream != null)
                    outputStream.close();
            } catch(IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
