/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Oscar
 */
public class Gestora {
    
    /**
     * 
     * @param precio
     * @param iva
     * @return Un BigDecimal redondeado a 2 decimales
     */
    public static BigDecimal calculaPrecioConIva(String precio, String iva){
        
        BigDecimal dev = new BigDecimal(precio);
        dev = dev.multiply(new BigDecimal("1."+iva));
        dev.setScale(2, RoundingMode.HALF_EVEN);
        return dev;
    }
    
    /**
     * 
     * @param precio
     * @param iva
     * @return Un BigDecimal redondeado a 2 decimales
     */
    public static BigDecimal calculaIva(String precio, String iva){
        
        BigDecimal dev = new BigDecimal(precio);
        dev = dev.multiply(new BigDecimal("0."+iva));
        dev.setScale(2, RoundingMode.HALF_EVEN);
        return dev;
    }
}
