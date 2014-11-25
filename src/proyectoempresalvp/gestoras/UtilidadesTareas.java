/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.util.Calendar;

/**
 * @author Oscar
 * @date 19-nov-2014
 * @time 18:12:53
 */
public class UtilidadesTareas {

    private static String fechaActual;
    public static int ESENQUINCE = 0;
    public static int ESHOY = 1;
    public static int NOESENQUINCE = 2;
    public static int HAPASADO = 3;

    /**
     * Devuelve los <u>días</u> de diferencia entre dos fechas
     *
     * @param fechaUno
     * @param fechaDos
     * @return
     */
    public static int calcularDiferenciaFechas(String fechaUno, String fechaDos) {

        String[] primera = fechaUno.split("/");
        String[] segunda = fechaDos.split("/");

        return (Integer.parseInt(primera[0]) - Integer.parseInt(segunda[0]))
                + (Integer.parseInt(primera[1]) - Integer.parseInt(segunda[1])) * 30
                + (Integer.parseInt(primera[2]) - Integer.parseInt(segunda[2])) * 365;
    }

    /**
     * Comprueba si la fecha tiene que realizarse en los próximos 15 días
     *
     * @param fechaTarea
     * @return Un boolean indicando si ha de hacerse en los próximos 15 días
     */
    public static int comprobarTareaEnProximosQuinceDias(String fechaTarea) {

        if (fechaActual == null) {

            Calendar c = Calendar.getInstance();
            fechaActual = c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
        }

        int diferencia = UtilidadesTareas.calcularDiferenciaFechas(fechaTarea, fechaActual);

        if (diferencia > 15) {
            return UtilidadesTareas.NOESENQUINCE;
        }
        if (diferencia <= 15 && diferencia > 0) {
            return UtilidadesTareas.ESENQUINCE;
        }
        if (diferencia == 0) {
            return UtilidadesTareas.ESHOY;
        }
        return UtilidadesTareas.HAPASADO;

    }
}
