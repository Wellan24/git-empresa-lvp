/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.ArrayListDato;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.ObservadorGestoraDatos;

/**
 *
 * @author Oscar
 */
public class GestoraDatos extends HashMap<String, ArrayListDato<Dato>>{
    
    public static final int ACTUALIZAR_TODO = 0;
    public static final int ACTUALIZAR_EMPLEADOS = 1;
    public static final int ACTUALIZAR_CONTRATOS = 2;
    public static final int ACTUALIZAR_CLIENTES = 3;
    public static final int ACTUALIZAR_FACTURASMENSUALES = 4;
    public static final int ACTUALIZAR_FACTURASMENSUALES_AÑO = 5;
    public static final int ACTUALIZAR_FACTURASEXTRA = 6;
    public static final int ACTUALIZAR_HISTORICOCONTRATOS = 7;
    
    private static GestoraDatos g;

    private GestoraDatos() {
    }
    
    public static void actualizaDatos(int datoActualizar){
        
        try {
            new Thread(new HiloActualizarDatos(datoActualizar, null)).start();
        } catch(Exception ex) {
            Logger.getLogger(GestoraDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void actualizaDatos(int datoActualizar, Procesador p){
        
        try {
            new Thread(new HiloActualizarDatos(datoActualizar, p)).start();
        } catch(Exception ex) {
            Logger.getLogger(GestoraDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void actualizaDatos(int datoActualizar, Procesador p, int numPeriodo){        
        
            new Thread(new HiloActualizarDatos(datoActualizar, p, " where NUMPERIODO = " + numPeriodo)).start();
    }
    
    public static void actualizaDatos(int datoActualizar, Procesador p, String where){        
        
            new Thread(new HiloActualizarDatos(datoActualizar, p, where)).start();
    }

    public static GestoraDatos dameGestora(){
        
        if(g == null)
            g = new GestoraDatos();
        
        return g;
    }
    
    public static void setObservador(ObservadorGestoraDatos observador) {
        HiloActualizarDatos.setObservador(observador);
    }

    @Override
    public ArrayListDato<Dato> get(Object key) {
        return super.get(key); 
    }
    
    public static ArrayListDato<Dato> recuperarConDummy(Dato d, Procesador procesador, String where) {

        ArrayListDato<Dato> datos = new ArrayListDato();
        String[] claves = d.devuelveOrdenDeColumnas();
        
        String select;
        if(where != null)
            select = GestoraBaseDatos.construyeSentenciaSelect(claves, d.devuelveNombreTablaDato(), where);
        else
            select = GestoraBaseDatos.construyeSentenciaSelect(claves, d.devuelveNombreTablaDato());
        
        ResultSet datosSelect = GestoraBaseDatos.ejecutarSentenciaQuery(select);

        try {
            while(datosSelect.next()) {

                for(int i = 0;i < claves.length;i++) {

                    String clave = claves[i];
                    Object obj = d.get(clave);
                    if(obj instanceof Integer) {

                        d.put(clave, datosSelect.getInt(i + 1));
                    } else if(obj instanceof String) {

                        d.put(clave, datosSelect.getString(i + 1));
                    } else if(obj instanceof Fecha) {

                        d.put(clave, new Fecha(datosSelect.getString(i + 1)));
                    } else if(obj instanceof Boolean) {

                        d.put(clave, datosSelect.getBoolean(i + 1));
                    }
                }
                
                if(procesador != null && procesador.comprobarValido(d)){
                    if(procesador.procesar(d))
                        datos.add((Dato) d.copia());
                }else
                    datos.add((Dato) d.copia());
                
            }
        } catch(SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datos;
    }
    
}
