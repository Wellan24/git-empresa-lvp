/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras.Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.ArrayListDato;
import proyectoempresalvp.datos.Cliente;
import proyectoempresalvp.datos.Contrato;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.Empleado;
import proyectoempresalvp.datos.FacturaExtra;
import proyectoempresalvp.datos.FacturaExtraDetalles;
import proyectoempresalvp.datos.FacturaMensual;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.ObservadorGestoraDatos;
import static proyectoempresalvp.gestoras.Datos.GestoraDatos.*;

/**
 *
 * @author Oscar
 */
public class HiloActualizarDatos implements Runnable {

    private static ObservadorGestoraDatos observador;
    private final int datoActualizar;
    private int numPeriodo;
    private String where;
    private Procesador procesador;

    public HiloActualizarDatos(int datoActualizar, Procesador p, int numPeriodo) {
        
        this.datoActualizar = datoActualizar;
        this.numPeriodo = numPeriodo;
        this.procesador = p;
    }
    
    public HiloActualizarDatos(int datoActualizar, Procesador p, String where) {
        
        this.datoActualizar = datoActualizar;
        this.where = where;
        this.procesador = p;
    }

    public HiloActualizarDatos(int datoActualizar, Procesador p) throws Exception {

        if(datoActualizar == ACTUALIZAR_FACTURASMENSUALES || datoActualizar == ACTUALIZAR_FACTURASMENSUALES_AÑO)
            throw new Exception("No se pueden actualizar facturas mensuales así");

        this.datoActualizar = datoActualizar;
        this.procesador = p;
    }

    @Override
    public void run() {

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_EMPLEADOS)
            recuperarConDummy(new Empleado());

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_CLIENTES)
            recuperarConDummy(new Cliente());

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_CONTRATOS)
            recuperarConDummy(new Contrato());

        if(datoActualizar == ACTUALIZAR_FACTURASMENSUALES)
            actualizarFacturasMes();
        
        if(datoActualizar == ACTUALIZAR_FACTURASMENSUALES_AÑO)
            actualizarFacturasMesAño();

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_FACTURASEXTRA) {
            recuperarConDummy(new FacturaExtra());
            recuperarConDummy(new FacturaExtraDetalles());
        }

        observador.avisar(datoActualizar, procesador);
    }

    private void actualizarFacturasMes() {

        recuperarConDummy(new FacturaMensual(), " where NUMPERIODO = " + numPeriodo);
    }
    
    private void actualizarFacturasMesAño() {

        recuperarConDummy(new FacturaMensual(), where, "FACTURASMENSUALESAÑO");
    }

    public static void setObservador(ObservadorGestoraDatos observador) {
        HiloActualizarDatos.observador = observador;
    }

    private void recuperarConDummy(Dato d) {

        ArrayListDato<Dato> facturas = new ArrayListDato();
        String[] claves = d.devuelveOrdenDeColumnas();
        ResultSet facturasComprobar = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(claves, d.devuelveNombreTablaDato()));

        try {
            while(facturasComprobar.next()) {

                for(int i = 0;i < claves.length;i++) {

                    String clave = claves[i];
                    Object obj = d.get(clave);
                    if(obj instanceof Integer) {

                        d.put(clave, facturasComprobar.getInt(i + 1));
                    } else if(obj instanceof String) {

                        d.put(clave, facturasComprobar.getString(i + 1));
                    } else if(obj instanceof Fecha) {

                        d.put(clave, new Fecha(facturasComprobar.getString(i + 1)));
                    } else if(obj instanceof Boolean) {

                        d.put(clave, facturasComprobar.getBoolean(i + 1));
                    }
                }
                
                if(procesador != null && procesador.comprobarValido(d))
                    procesador.procesar(d);
                
                facturas.add((Dato) d.clone());
            }
        } catch(SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put(d.devuelveNombreTablaDato(), facturas);
    }

    private void recuperarConDummy(Dato d, String where) {

        ArrayListDato<Dato> facturas = new ArrayListDato();
        String[] claves = d.devuelveOrdenDeColumnas();
        ResultSet facturasComprobar = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(claves, d.devuelveNombreTablaDato(), where));

        try {
            while(facturasComprobar.next()) {

                for(int i = 0;i < claves.length;i++) {

                    String clave = claves[i];
                    Object obj = d.get(clave);
                    if(obj instanceof Integer) {

                        d.put(clave, facturasComprobar.getInt(i + 1));
                    } else if(obj instanceof String) {

                        d.put(clave, facturasComprobar.getString(i + 1));
                    } else if(obj instanceof Fecha) {

                        d.put(clave, new Fecha(facturasComprobar.getString(i + 1)));
                    } else if(obj instanceof Boolean) {

                        d.put(clave, facturasComprobar.getBoolean(i + 1));
                    }
                }
                facturas.add((Dato) d.clone());
            }
        } catch(SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put(d.devuelveNombreTablaDato(), facturas);
    }
    
    private void recuperarConDummy(Dato d, String where, String key) {

        ArrayListDato<Dato> facturas = new ArrayListDato();
        String[] claves = d.devuelveOrdenDeColumnas();
        ResultSet facturasComprobar = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(claves, d.devuelveNombreTablaDato(), where));

        try {
            while(facturasComprobar.next()) {

                for(int i = 0;i < claves.length;i++) {

                    String clave = claves[i];
                    Object obj = d.get(clave);
                    if(obj instanceof Integer) {

                        d.put(clave, facturasComprobar.getInt(i + 1));
                    } else if(obj instanceof String) {

                        d.put(clave, facturasComprobar.getString(i + 1));
                    } else if(obj instanceof Fecha) {

                        d.put(clave, new Fecha(facturasComprobar.getString(i + 1)));
                    } else if(obj instanceof Boolean) {

                        d.put(clave, facturasComprobar.getBoolean(i + 1));
                    }
                }
                facturas.add((Dato) d.clone());
            }
        } catch(SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put(key, facturas);
    }

}
