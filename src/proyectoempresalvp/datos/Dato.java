/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashMap;
import static proyectoempresalvp.datos.FacturaExtraDetalles.orden;

/**
 *
 * @author Administrador
 */
public abstract class Dato extends HashMap<String, Object> implements Comparable<Dato>{    
    
    public abstract String devuelveNombreTablaDato();
    public abstract String[] devuelveOrdenDeColumnas();
    public Class[] devuelveClases() {
        
        Class[] classes = new Class[this.size()];
        ArrayList<Object> objetos = new ArrayList(this.values());
        
        for(int i = 0; i < classes.length; i++){            
            
                classes[i] = objetos.getClass();            
        }
        return classes;        
    }

    @Override
    public int compareTo(Dato o) {
        
        if(o.getClass() ==  this.getClass()){
            
            return -2;
        }
        
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
        return 0;
    }
}
