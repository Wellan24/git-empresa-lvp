/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class FacturaExtra extends Dato implements Comparable<FacturaExtra> {

    private static final String[] orden = {"NUMEROFACTURA", "FECHA", "CIF", "NOMBRE", "DOMICILIO", "LOCALIDAD",
        "PROVINCIA", "CP", "TANTOIVA", "EUROSNETO", "NUMEROCLIENTE"};
    private static final String tabla = "FACTURAEXTRA";

    /**
     * Las claves son: NUMEROFACTURA,FECHA, CIF, NOMBRE, DOMICILIO, LOCALIDAD, PROVINCIA, CP,
     * TANTOIVA, EUROSNETO, CLIENTE.
     *
     * @param numeroFactura
     * @param fecha
     * @param cif
     * @param nombre
     * @param domicilio
     * @param localidad
     * @param provincia
     * @param cp
     * @param tantoIva
     * @param eurosNeto
     * @param cliente
     */
    public FacturaExtra(int numeroFactura, Fecha fecha, String cif, String nombre, String domicilio, String localidad,
            String provincia, int cp, int tantoIva,
            String eurosNeto, int numerocliente) {
        super(11);
        this.put("NUMEROFACTURA", numeroFactura);
        this.put("FECHA", fecha);
        this.put("CIF", cif);
        this.put("NOMBRE", nombre);
        this.put("DOMICILIO", domicilio);
        this.put("LOCALIDAD", localidad);
        this.put("PROVINCIA", provincia);
        this.put("CP", cp);
        this.put("TANTOIVA", tantoIva);
        this.put("EUROSNETO", eurosNeto);
        this.put("NUMEROCLIENTE", numerocliente);
    }

    private FacturaExtra(FacturaExtra c) {
        super(c);
    }

    public FacturaExtra() {
        super(11);
        this.put("NUMEROFACTURA", 0);
        this.put("FECHA", new Fecha("1/1/2015"));
        this.put("CIF", "");
        this.put("NOMBRE", "");
        this.put("DOMICILIO", "");
        this.put("LOCALIDAD", "");
        this.put("PROVINCIA", "");
        this.put("CP", 0);
        this.put("TANTOIVA", 0);
        this.put("EUROSNETO", "");
        this.put("NUMEROCLIENTE", 0);
    }

    @Override
    public String devuelveNombreTablaDato() {

        return tabla;
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {

        return orden;
    }

    @Override
    public int compareTo(FacturaExtra o) {

        Collator c = Collator.getInstance();
        c.setStrength(Collator.PRIMARY);

        Object obj;
        Object objO;

        for(String clave :orden) {

            obj = this.get(clave);
            objO = o.get(clave);
            if(obj instanceof Integer) {

                if((int) obj != (int) objO) {

                    return (int) obj > (int) objO ? 1 : -1;
                }
            } else if(obj instanceof String) {
                if(c.compare((String) obj, (String) objO) != 0) {

                    return c.compare(obj, objO);
                }
            } else if(obj instanceof Float) {

                if((float) obj != (float) objO) {

                    return (float) obj > (float) objO ? 1 : -1;
                }
            } else if(obj instanceof Date) {

                if(((Date) obj).compareTo((Date) objO) != 0) {

                    return ((Date) obj).compareTo((Date) objO);
                }
            }

        }

        return 0;
    }

    /**
     * La clave es NUMEROFACTURA
     *
     * @return
     */
    @Override
    public Object devuelveValorClave() {

        return this.get("NUMEROFACTURA");
    }

    public static String[] getOrden() {
        return orden;
    }

    public static String getTabla() {
        return tabla;
    }

    @Override
    public String devuelveClave() {

        return "NUMEROFACTURA";
    }

    @Override
    public Dato copia() {

//        return (Dato) this.clone();
        return new FacturaExtra(this);
    }
}
