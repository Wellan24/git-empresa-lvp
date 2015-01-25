/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrador
 */
public abstract class Dato extends HashMap<String, Object>{    
    
    public abstract String devuelveNombreTablaDato();
    public abstract String[] devuelveOrdenDeColumnas();
    public abstract Object devuelveValorClave();
    public abstract String devuelveClave();
    public Class[] devuelveClases() {
        
        Class[] classes = new Class[this.size()];
        ArrayList<Object> objetos = new ArrayList(this.values());
        
        for(int i = 0; i < classes.length; i++){            
            
                classes[i] = objetos.getClass();            
        }
        return classes;        
    }   
    
}
