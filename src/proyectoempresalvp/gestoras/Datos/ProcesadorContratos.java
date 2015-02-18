/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras.Datos;

import proyectoempresalvp.datos.Contrato;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.gestoras.UtilidadesTareas;

/**
 *
 * @author Oscar
 */
public class ProcesadorContratos implements Procesador<Contrato> {

    Fecha fechaActual = UtilidadesTareas.getFechaActual();
    StringBuilder resul = new StringBuilder();

    @Override
    public void procesar(Dato d) {

        if((Boolean)d.get("ESTADO") != false) {
            
            Fecha fechaFin = (Fecha) d.get("FINCONTRATO");
            int dif = UtilidadesTareas.calcularDiferenciaFechas(fechaFin, fechaActual);

            if(dif <= 60) {

                resul.append("Contrato Nº: ").append(d.get("NUMCONTRATO")).append(", Cliente: ").append(d.get("DESCRIPCION")).append("\n");
            }
        }
    }

    @Override
    public void commit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getProcesado() {

        return resul;
    }

    @Override
    public boolean comprobarValido(Dato d) {

        return Contrato.class.equals(d.getClass());
    }

}
