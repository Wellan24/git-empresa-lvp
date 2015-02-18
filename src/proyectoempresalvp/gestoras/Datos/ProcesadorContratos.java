/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras.Datos;

import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.gestoras.UtilidadesTareas;

/**
 *
 * @author Oscar
 */
public class ProcesadorContratos implements Procesador{
    
    Fecha fechaActual = UtilidadesTareas.getFechaActual();
    StringBuilder resul = new StringBuilder();
    
    @Override
    public void procesar(Dato d) {
        
        Fecha fechaFin = new Fecha(d.get("FINCONTRATO").toString());
        int dif = UtilidadesTareas.calcularDiferenciaFechas(fechaFin, fechaActual);
        
        if(dif <= 60){
            
            resul.append("Contrato Nº: ").append(d.get("NUMCONTRATO")).append(", Cliente: ").append(d.get("DESCRIPCION"));
        }
        
    }

    @Override
    public void commit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
