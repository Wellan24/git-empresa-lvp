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

        if((Boolean) d.get("ESTADO") != false) {

            Fecha fechaFin = (Fecha) d.get("FINCONTRATO");
            int dif = UtilidadesTareas.calcularDiferenciaFechas(fechaFin, fechaActual);

            if(dif <= 60) {

                resul.append("Contrato Nº: ").append(d.get("NUMCONTRATO")).append(", Cliente: ").append(d.get("DESCRIPCION"));

                if(dif < 0){
                    d.put("ESTADO", false);
                    resul.append(" CADUCADO");
                }

                resul.append("\n");
            }
        }
    }

    @Override
    public void commit() {
        
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
