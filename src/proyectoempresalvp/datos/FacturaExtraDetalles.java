/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;

/**
 *
 * @author Administrador
 */
public class FacturaExtraDetalles extends Dato implements Comparable<FacturaExtraDetalles>{

    
    private static final String[] orden = {"NUMERO","ORDEN", "CONCEPTO", "IMPORTE"};
    private static final String tabla = "FACTURAEXTRADETALLES";
    /**
     *  Las claves son: ORDEN, NUMERO, CONCEPTO, IMPORTE
     * 
     * @param orden
     * @param numero
     * @param concepto
     * @param importe 
     */
    public FacturaExtraDetalles(int numero, int orden, String concepto, String importe) {
        
        this.put("ORDEN", orden);
        this.put("NUMERO", numero);
        this.put("CONCEPTO", concepto);
        this.put("IMPORTE", importe);        
    }   
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return tabla;
    }
    @Override
    public int compareTo(FacturaExtraDetalles o) {
        
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
            
                    return c.compare(obj, objO);            
                }
            }else if(obj instanceof Float){
                
                if((float)obj != (float)objO){
            
                    return (float)obj > (float)objO ? 1 : -1;
                }
            }         
            
        }
        
        return 0;
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {
        
        return orden;
    }
    
    /**
     * La clave es NUMERO
     * @return 
     */
    @Override
    public Object devuelveValorClave() {
        
        return this.get("NUMERO") + "0" + this.get("ORDEN");
    }

    public static String[] getOrden() {
        return orden;
    }

    public static String getTabla() {
        return tabla;
    }

    @Override
    public String devuelveClave() {
        
        return "NUMERO ORDEN";
    }
    
}
