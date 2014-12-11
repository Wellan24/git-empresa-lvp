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
    
    private int nSiguiente;

    @Override
    public boolean add(T e) {
        
        nSiguiente = (Integer.parseInt(e.devuelveValorClave()) > nSiguiente)? Integer.parseInt(e.devuelveValorClave()): nSiguiente;
        return super.add(e); 
    }   
    
    public int devuelvYAumentaNumeroSiguiente() {
        
        return nSiguiente++;
    }
}
