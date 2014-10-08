/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.util.Date;


public class FacturaMensual extends Dato implements Comparable<FacturaMensual>{

    /**
     *  las claves son: NUMFACTURA, FECHA,NUMCLIENTE, DESCRIPCION,NUMCONTACTO, CIF,
     *  NOMBRE, DOMICILIO, LOCALIDAD, PROVINCIA, EUROSMES, TANTOIVA, IVA, TOTAL,
     *  REFMONEDA,DIACOBRO, FORMAPAGO, PERIODO, NUMPERIODO,NUMCUENTA,REFBANCO,
     *  BANCOCOBRO,NUMBREBANCO
     * @param numFactura
     * @param fecha
     * @param numCliente
     * @param descripcion
     * @param numContacto
     * @param cif
     * @param nombre
     * @param domicilio
     * @param localidad
     * @param cpProvincia
     * @param eurosMes
     * @param tantoIva
     * @param iva
     * @param total
     * @param refMoneda
     * @param diaCobro
     * @param formaPago
     * @param periodo
     * @param numPeriodo
     * @param numCuenta
     * @param refBanco
     * @param bancoCobro
     * @param nombreBanco 
     */
    public FacturaMensual(int numFactura,Date fecha,int numCliente,
            String descripcion,int numContacto,int cif,String nombre,
            String domicilio,String localidad,int cpProvincia,int eurosMes,
            int tantoIva,int iva,int total,String refMoneda,int diaCobro,
            String formaPago,String periodo,int numPeriodo,int numCuenta,
            int refBanco,int bancoCobro,String nombreBanco) {
        this.put("NUMFACTURA",numFactura);
        this.put("FECHA",fecha);
        this.put("NUMCLIENTE",numCliente);
        this.put("DESCRIPCION",descripcion);
        this.put("NUMCONTACTO",numContacto);
        this.put("CIF",cif);
        this.put("NOMBRE",nombre);
        this.put("DOMICILIO",domicilio);
        this.put("LOCALIDAD",localidad);
        this.put("PROVINCIA",cpProvincia);
        this.put("EUROSMES",eurosMes);
        this.put("TANTOIVA",tantoIva);
        this.put("IVA",iva);
        this.put("TOTAL",total);
        this.put("REFMONEDA",refMoneda);
        this.put("DIACOBRO",diaCobro);
        this.put("FORMAPAGO",formaPago);
        this.put("PERIODO",periodo);
        this.put("NUMPERIODO",numPeriodo);
        this.put("NUMCUENTA",numCuenta);
        this.put("REFBANCO",refBanco);
        this.put("BANCOCOBRO",bancoCobro);
        this.put("NOMBREBANCO",nombreBanco);
    }

    
    
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "FACTURAMENSUAL";
    }

    @Override
    public int compareTo(FacturaMensual o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
