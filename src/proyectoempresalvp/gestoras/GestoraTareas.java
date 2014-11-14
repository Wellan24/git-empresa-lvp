/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.Tarea;

/**
 * @author Oscar
 * @date 11-nov-2014
 * @time 21:22:39
 */
public class GestoraTareas extends Thread {

    public static ArrayList<Tarea> tareas;
    public static String tareasARealizar;
    public static ObservadorTareas observador;

    public GestoraTareas(ObservadorTareas observador) {

        GestoraTareas.observador = observador;
    }

    @Override
    public void run() {

        Calendar c = Calendar.getInstance();
        String fecha = c.get(Calendar.DATE) + "/" + c.get(Calendar.DATE) + "/" + c.get(Calendar.DATE);
        ResultSet tareasComprobar = GestoraBaseDatos.ejecutarSentenciaQuery("Select CONCEPTO, FECHA, PERIODO, CLIENTE from TAREAS");

        if (tareas == null) {
            tareas = new ArrayList();
        } else {
            tareas.clear();
        }

        StringBuilder string = new StringBuilder();
        Tarea tareaActual;

        try {
            while (tareasComprobar.next()) {

                tareaActual = new Tarea(tareasComprobar.getString(1), tareasComprobar.getString(2), tareasComprobar.getInt(3), tareasComprobar.getString(4));
                tareas.add(tareaActual);

                if (tareaActual.comprobarTareaEnProximosQuinceDias(fecha))
                    string.append("El día ").append(tareaActual.get("FECHA")).append(" hay ").append(tareaActual.get("CONCEPTO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        tareasARealizar = string.toString();
        GestoraTareas.observador.avisar();
    }

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

        return Math.abs(Integer.parseInt(primera[0]) - Integer.parseInt(segunda[0]))
                + Math.abs(Integer.parseInt(primera[1]) - Integer.parseInt(segunda[1])) * 30
                + Math.abs(Integer.parseInt(primera[2]) - Integer.parseInt(segunda[2])) * 365;
    }

    public static boolean comprobarFormatoFechaCorrecto(String fecha) {

        String[] f = fecha.split("/");

        int año;
        int mes;
        int dia;
        try {
            dia = Integer.parseInt(f[0]);
            mes = Integer.parseInt(f[1]);
            año = Integer.parseInt(f[2]);

        } catch (NumberFormatException numberFormatException) {

            return false;
        }
        if (año < 0 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return false;
        }

        switch (mes) {
            case 2:

                if (dia > 29) {
                    return false;
                }

                if (!(((año % 4 == 0) && (año % 100 != 0)) || (año % 400 == 0)) && dia == 29) {
                    return false;
                }

                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia > 30) {
                    return false;
                }

                break;
        }
        return true;

    }

    public static synchronized ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public static synchronized String getTareasARealizar() {
        return tareasARealizar;
    }
}
