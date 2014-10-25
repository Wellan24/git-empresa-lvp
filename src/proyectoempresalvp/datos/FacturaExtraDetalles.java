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
public class FacturaExtraDetalles extends Dato{

    
    public static String[] orden = {"NUMERO","ORDEN", "CONCEPTO", "IMPORTE"};
    /**
     *  Las claves son: ORDEN, NUMERO, CONCEPTO, IMPORTE
     * 
     * @param orden
     * @param numero
     * @param concepto
     * @param importe 
     */
    public FacturaExtraDetalles(int orden, int numero, String concepto, float importe) {
        
        this.put("ORDEN", orden);
        this.put("NUMERO", numero);
        this.put("CONCEPTO", concepto);
        this.put("IMPORTE", importe);        
    }   
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "FACTURAEXTRADETALLES";
    }
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
            
                    return c.compare((String)obj, objO);            
                }
            }else if(obj instanceof Float){
                
                if((float)obj != (float)objO){
            
                    return (float)obj > (float)objO ? 1 : -1;
                }
            }
            
            
        }
        
        if((int)this.get("ORDEN") != (int)o.get("ORDEN")){
            
            return (int)this.get("ORDEN") > (int)o.get("ORDEN") ? 1 : -1;
            
        }else if((int)this.get("NUMERO") != (int)o.get("NUMERO")){
            
            return (int)this.get("NUMERO") > (int)o.get("NUMERO") ? 1 : -1;
            
        }else if(c.compare((String)this.get("CONCEPTO"), (String)o.get("CONCEPTO")) != 0){
            
            return c.compare((String)this.get("CONCEPTO"), (String)o.get("CONCEPTO"));
            
        }else if((float)this.get("IMPORTE") != (float)o.get("IMPORTE")){
            
            return (float)this.get("IMPORTE") > (float)o.get("IMPORTE") ? 1 : -1;
        }
        
        return 0;
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {
        
        return orden;
    }
    
}
