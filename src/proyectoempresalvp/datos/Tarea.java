/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectoempresalvp.datos;

/**
 * @author Oscar
 * @date 10-nov-2014
 * @time 22:02:22
 */
public class Tarea extends Dato{

    private static final String[] orden = {"CONCEPTO", "FECHA", "PERIODO"};
    
    /**
     *  Fecha en formato dd/mm/aa y periodo en meses
     * @param concepto
     * @param fecha
     * @param periodo 
     */
    public Tarea(String concepto, String fecha, int periodo){

        this.put("CONCEPTO", concepto);
        this.put("FECHA", fecha);
        this.put("PERIODO", periodo);
    }
    
    /**
     * Comprueba si la fecha tiene que realizarse en los próximos 15 días
     * @param fechaActual 
     */
    public void comprobarTareaEnProximosQuinceDias(String fechaActual){
        
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
