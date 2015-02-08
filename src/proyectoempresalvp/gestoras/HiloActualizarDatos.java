/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

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
import static proyectoempresalvp.gestoras.GestoraDatos.*;

/**
 *
 * @author Oscar
 */
public class HiloActualizarDatos implements Runnable {

    private static ObservadorGestoraDatos observador;
    private final int datoActualizar;
    private int numPeriodo;

    public HiloActualizarDatos(int datoActualizar, int numPeriodo) {

        this.datoActualizar = datoActualizar;
        this.numPeriodo = numPeriodo;
    }

    public HiloActualizarDatos(int datoActualizar) throws Exception {
        if(datoActualizar == ACTUALIZAR_CONTRATOS)
            throw new Exception("No se pueden actualziar contratos así");

        this.datoActualizar = datoActualizar;
    }

    @Override
    public void run() {

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_EMPLEADOS)
            recuperarConDummy(new Empleado());

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_CLIENTES)
            recuperarConDummy(new Cliente());

        if(datoActualizar == ACTUALIZAR_CONTRATOS)
            recuperarConDummy(new Contrato());

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_FACTURASMENSUALES)
            actualizarFacturasMes();

        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_FACTURASEXTRA) {
            recuperarConDummy(new FacturaExtra());
            recuperarConDummy(new FacturaExtraDetalles());
        }

        observador.avisar(datoActualizar);
    }

    private void actualizarFacturasMes() {

        ArrayListDato<Dato> facturas = null;
        ResultSet facturasComprobar = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(FacturaMensual.getOrden(), FacturaMensual.getTabla()));
        if(facturas == null) {
            facturas = new ArrayListDato();
        } else {
            facturas.clear();
        }

        FacturaMensual facturaActual;

        try {
            while(facturasComprobar.next()) {

                facturaActual = new FacturaMensual(facturasComprobar.getInt(1), new Fecha(facturasComprobar.getString(2)), facturasComprobar.getInt(3),
                        facturasComprobar.getString(4), facturasComprobar.getInt(5), facturasComprobar.getInt(6), facturasComprobar.getString(7),
                        facturasComprobar.getString(8), facturasComprobar.getString(9), facturasComprobar.getInt(10), facturasComprobar.getInt(11),
                        facturasComprobar.getInt(12), facturasComprobar.getString(13), facturasComprobar.getInt(14), facturasComprobar.getString(15),
                        facturasComprobar.getString(16), facturasComprobar.getInt(17), facturasComprobar.getInt(18), facturasComprobar.getInt(19),
                        facturasComprobar.getInt(20), facturasComprobar.getString(21));
                facturas.add(facturaActual);
            }
        } catch(SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put("FACTURASMENSUALES", facturas);
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
                facturas.add((Dato) d.clone());
            }
        } catch(SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put(d.devuelveNombreTablaDato(), facturas);
    }

    private void recuperarConDummy(Dato d, String comparacion, String nombreCampo, Object valor) {

        ArrayListDato<Dato> facturas = new ArrayListDato();
        String[] claves = d.devuelveOrdenDeColumnas();
        ResultSet facturasComprobar = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(claves, d.devuelveNombreTablaDato(), comparacion, nombreCampo, valor));

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

}
