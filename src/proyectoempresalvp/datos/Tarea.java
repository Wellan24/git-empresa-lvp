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
public class Tarea extends Dato {

    private static final String[] orden = {"NTAREA", "CONCEPTO", "FECHA", "PERIODO", "CLIENTE"};
    private static final String tabla = "TAREAS";

    /**
     * Fecha en formato dd/mm/aa y periodo en meses
     *
     * @param ntarea
     * @param concepto
     * @param fecha
     * @param periodo
     * @param cliente
     */
    public Tarea(int ntarea, String concepto, Fecha fecha, int periodo, String cliente) {

        this.put("NTAREA", ntarea);
        this.put("CONCEPTO", concepto);
        this.put("FECHA", fecha);
        this.put("PERIODO", periodo);
        this.put("CLIENTE", cliente);
    }

    public static String[] getOrden() {
        return orden;
    }

    @Override
    public String devuelveNombreTablaDato() {

        return tabla;
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {

        return orden;
    }

    public void calcularNuevaFecha() {

        Fecha f = (Fecha)this.get("FECHA");
        int dia = f.getDia();
        int mes = f.getMes();
        int año = f.getAño();

        if (mes + (int) this.get("PERIODO") > 12) {

            mes = mes + (int) this.get("PERIODO") - 12;
            año++;
        } else {
            mes = mes + (int) this.get("PERIODO");
        }

        this.put("FECHA", dia + "/" + mes + "/" + año);

    }

    /**
     * La clave es NTAREA
     *
     * @return
     */
    @Override
    public String devuelveValorClave() {

        return "" + this.get("NTAREA");
    }

    public static String getTabla() {
        return tabla;
    }    
    
}
