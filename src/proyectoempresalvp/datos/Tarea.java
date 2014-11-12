/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import proyectoempresalvp.gestoras.GestoraTareas;

/**
 * @author Oscar
 * @date 10-nov-2014
 * @time 22:02:22
 */
public class Tarea extends Dato {

    private static final String[] orden = {"CONCEPTO", "FECHA", "PERIODO"};

    /**
     * Fecha en formato dd/mm/aa y periodo en meses
     *
     * @param concepto
     * @param fecha
     * @param periodo
     * @param cliente
     */
    public Tarea(String concepto, String fecha, int periodo, String cliente) {

        this.put("CONCEPTO", concepto);
        this.put("FECHA", fecha);
        this.put("PERIODO", periodo);
        this.put("CLIENTE", cliente);
    }

    /**
     * Comprueba si la fecha tiene que realizarse en los próximos 15 días
     *
     * @param fechaActual
     * @return Un boolean indicando si ha de hacerse en los próximos 15 días
     */
    public boolean comprobarTareaEnProximosQuinceDias(String fechaActual) {

        return GestoraTareas.calcularDiferenciaFechas((String) this.get("FECHA"), fechaActual) <= 15;

    }

    @Override
    public String devuelveNombreTablaDato() {

        return "TAREAS";
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {

        return orden;
    }
}
