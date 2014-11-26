/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public static StringBuilder tareasARealizar;
    public static ObservadorTareas observador;
    public static int nProximaTarea;

    public GestoraTareas(ObservadorTareas observador) {

        GestoraTareas.observador = observador;
    }

    @Override
    public void run() {
        
        ResultSet tareasComprobar = GestoraBaseDatos.ejecutarSentenciaQuery("Select NTAREA,CONCEPTO, FECHA, PERIODO, CLIENTE from TAREAS");
        if (tareas == null) {
            tareas = new ArrayList();
        } else {
            tareas.clear();
        }

        StringBuilder string = new StringBuilder();
        nProximaTarea = 0;
        Tarea tareaActual;

        try {
            while (tareasComprobar.next()) {

                tareaActual = new Tarea(tareasComprobar.getInt(1), tareasComprobar.getString(2), tareasComprobar.getString(3), tareasComprobar.getInt(4),tareasComprobar.getString(5));
                tareas.add(tareaActual);
                
                nProximaTarea = ((int)tareaActual.get("NTAREA") > nProximaTarea)? (int)tareaActual.get("NTAREA"): nProximaTarea;
                
                int comprobar = UtilidadesTareas.comprobarTareaEnProximosQuinceDias((String)tareaActual.get("FECHA"));
                if(comprobar == UtilidadesTareas.ESHOY){
                    string.append("El día ").append(tareaActual.get("FECHA")).append(" hay ").append(tareaActual.get("CONCEPTO")).append(" para ").append(tareaActual.get("CLIENTE")).append("\n");
                    tareaActual.calcularNuevaFecha();
                }
                else if (comprobar == UtilidadesTareas.ESENQUINCE){
                    string.append("El día ").append(tareaActual.get("FECHA")).append(" hay ").append(tareaActual.get("CONCEPTO")).append(" para ").append(tareaActual.get("CLIENTE")).append("\n");
                }else if(comprobar == UtilidadesTareas.HAPASADO){
                    
                    tareaActual.calcularNuevaFecha();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        tareasARealizar = string;
        nProximaTarea++;
        GestoraTareas.observador.avisar();
    }

    public static synchronized ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public static synchronized StringBuilder getTareasARealizar() {
        return tareasARealizar;
    }
}
