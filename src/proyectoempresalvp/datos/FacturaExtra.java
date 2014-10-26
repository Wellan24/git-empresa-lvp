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
public class FacturaExtra extends Dato  implements Comparable<FacturaExtra>{

    public static String[] orden = {"NUMEROFACTURA", "DIA", "MES", "AÑO", "FECHA", "CIF", "NOMBRE", "DOMICILIO", "LOCALIDAD",
        "PROVINCIA", "CP", "TANTOIVA", "EUROSNETO", "CLIENTE"};
    
    /**
     *  Las claves son: NUMEROFACTURA, DIA, MES, AÑO, FECHA, CIF, NOMBRE, DOMICILIO, LOCALIDAD, PROVINCIA, CP, TANTOIVA,
     *              EUROSNETO, CLIENTE.
     * 
     * @param numeroFactura
     * @param dia
     * @param mes
     * @param año
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
    public FacturaExtra(int numeroFactura,int dia,String mes,int año,
            Date fecha,int cif,String nombre,String domicilio,String localidad,
            String provincia,int cp,int tantoIva,
            int eurosNeto,String cliente) {
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
        this.put("EUROSNETO",eurosNeto);
        this.put("CLIENTE",cliente);
    }

    
    
    
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "FACTURAEXTRA";
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
        
        for(String clave : orden){
            
            obj = this.get(clave);
            objO = o.get(clave);
            if(obj instanceof Integer){
                
                if((int)obj != (int)objO){
            
                    return (int)obj > (int)objO ? 1 : -1;            
                }
            }else if(obj instanceof String){
                if(c.compare((String)obj, (String)objO) != 0){
            
                    return c.compare((String)obj, objO);            
                }
            }else if(obj instanceof Float){
                
                if((float)obj != (float)objO){
            
                    return (float)obj > (float)objO ? 1 : -1;
                }
            }else if(obj instanceof Date){
                
                if(((Date)obj).compareTo((Date)objO) != 0){
            
                    return ((Date)obj).compareTo((Date)objO);
                }
            }         
            
        }
        
        return 0;
    }
    
}
