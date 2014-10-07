/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.util.Date;

/**
 *
 * @author Administrador
 */
public class FacturaExtra extends Dato{

    public FacturaExtra(int numeroFactura,int dia,String mes,int año,
            Date fecha,int cif,String nombre,String domicilio,String localidad,
            String provincia,int cp,int tantoIva,int ivaCalculado,
            int totalEuros,String cliente) {
        this.put("NUMEROFACTURA",numeroFactura);
        this.put("DIA",dia);
        this.put("MES",mes);
        this.put("AÑO",año);
        this.put("FECHA",fecha);
        this.put("CIF",cif);
        this.put("NOMBRE",nombre);
        this.put("DOMICILIO",domicilio);
        this.put("LOCALIDAD",localidad);
        this.put("PROVINCIA",provincia);
        this.put("CP",cp);
        this.put("TANTOIVA",tantoIva);
        this.put("IVACALCULADO",ivaCalculado);
        this.put("TOTALEUROS",totalEuros);
        this.put("CLIENTE",cliente);
    }

    
    
    
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "FACTURAEXTRA";
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
