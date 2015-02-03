/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 * @param <T>
 */
public class ArrayListDato<T extends Dato> extends ArrayList<T>{
    
    private int nSiguiente = 0;

    @Override
    public boolean add(T e) {
        
        nSiguiente = (Integer.parseInt(e.devuelveValorClave().toString()) > nSiguiente)? Integer.parseInt(e.devuelveValorClave().toString()): nSiguiente;
        nSiguiente++;
        return super.add(e); 
    }   
    
    public int devuelveYAumentaNumeroSiguiente() {
        
        return nSiguiente++;
    }
    
    public int devuelveNumeroSiguiente() {
        
        return nSiguiente;
    }
    
    public T devuelveValorPorClave(Object clave){
        
        for(T d : this){
            
            if(d.devuelveValorClave().equals(clave)){
                
                return d;
            }
        }
        
        return null;
    }
    
    public ArrayList<T> devuelveValoresPorClave(Object clave){
        
        ArrayList<T> dev = new ArrayList();
        for(T d : this){
            
            if(d.devuelveValorClave().equals(clave)){
                
                dev.add(d);
            }
        }
        
        return dev;
    }
    
    public Object[] devuelveTodasLasClaves(){
        
        Object[] dev = new Object[this.size()];
        for(int i = 0; i < dev.length; i++){
            
            dev[i] = this.get(i).devuelveValorClave();
        }
        
        return dev;
    }
    
    public ArrayList<T> devuelveValorEnFuncionCampo(String nombreCampo, Object valor){
        
        ArrayList<T> dev = new ArrayList();
        for(T d : this){
            if(d.get(nombreCampo).equals(valor)){                
                
                dev.add(d);
            }
        }
        
        return dev;
    }
}
