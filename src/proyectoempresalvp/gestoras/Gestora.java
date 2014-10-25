/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.text.DecimalFormat;

/**
 *
 * @author Oscar
 */
public class Gestora {
    
    public static float calculaPrecioConIva(float precio, float iva){
        
        return precio * (1 + iva / 100);
    }
    
    public static float calculaIva(float precio, float iva){
        
        return precio * iva / 100;
    }
    
    public static String redondeaFloat(float n, int decimales){
        
        DecimalFormat d = new DecimalFormat("###.##");       
        return d.format(n);
    }
}
