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
import proyectoempresalvp.datos.Fecha;
import static proyectoempresalvp.gestoras.GestoraDatos.*;

/**
 *
 * @author Oscar
 */
public class HiloActualizarDatos implements Runnable {

    private static ObservadorGestoraDatos observador;
    private final int datoActualizar;

    public HiloActualizarDatos(int datoActualizar) {

        this.datoActualizar = datoActualizar;
    }

    @Override
    public void run() {

        if (datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_EMPLEADOS) 
            actualizarEmpleados();
        if (datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_CLIENTES) 
            actualizarClientes();
        if (datoActualizar == ACTUALIZAR_TODO|| datoActualizar == ACTUALIZAR_CONTRATOS) 
            actualizarContratos();

        observador.avisar(datoActualizar);
    }

    private void actualizarClientes() {

        ArrayListDato<Dato> clientes = null;
        ResultSet clientesComp = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(Cliente.getOrden(), Cliente.getTabla()));
        if (clientes == null) {
            clientes = new ArrayListDato();
        } else {
            clientes.clear();
        }

        Cliente cliente;

        try {
            while (clientesComp.next()) {

                cliente = new Cliente(clientesComp.getInt(1), clientesComp.getInt(2), clientesComp.getString(3),
                        clientesComp.getString(4), clientesComp.getString(5), clientesComp.getString(6), clientesComp.getInt(7),
                        clientesComp.getString(8), clientesComp.getString(9), clientesComp.getInt(10), clientesComp.getInt(11),
                        clientesComp.getString(12), clientesComp.getInt(13), clientesComp.getInt(14), clientesComp.getInt(15));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put("CLIENTES", clientes);
    }
    
    private void actualizarContratos() {

        ArrayListDato<Dato> contratos = null;
        ResultSet clientesComp = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(Cliente.getOrden(), Cliente.getTabla()));
        if (contratos == null) {
            contratos = new ArrayListDato();
        } else {
            contratos.clear();
        }

        Contrato contrato;

        try {
            while (clientesComp.next()) {

                contrato = new Contrato(clientesComp.getInt(1), clientesComp.getInt(2), clientesComp.getString(3),
                        new Fecha(clientesComp.getString(4)), new Fecha(clientesComp.getString(5)), clientesComp.getInt(6), clientesComp.getInt(7),
                        clientesComp.getString(8), clientesComp.getString(9), clientesComp.getInt(10), clientesComp.getInt(11));
                contratos.add(contrato);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put("CLIENTES", contratos);
    }

    private void actualizarEmpleados() {

        ArrayListDato<Dato> empleados = null;
        ResultSet empleadosComprobar = GestoraBaseDatos.ejecutarSentenciaQuery(GestoraBaseDatos.construyeSentenciaSelect(Empleado.getOrden(), Empleado.getTabla()));
        if (empleados == null) {
            empleados = new ArrayListDato();
        } else {
            empleados.clear();
        }

        Empleado empleadoActual;

        try {
            while (empleadosComprobar.next()) {

                empleadoActual = new Empleado(empleadosComprobar.getInt(1), empleadosComprobar.getInt(2), empleadosComprobar.getString(3),
                        empleadosComprobar.getString(4), empleadosComprobar.getString(5), empleadosComprobar.getString(6), empleadosComprobar.getInt(7),
                        empleadosComprobar.getString(8), empleadosComprobar.getInt(9), empleadosComprobar.getInt(10), empleadosComprobar.getString(11),
                        new Fecha(empleadosComprobar.getString(12)), new Fecha(empleadosComprobar.getString(13)), empleadosComprobar.getInt(14), empleadosComprobar.getInt(15), "", "");
                empleados.add(empleadoActual);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }

        GestoraDatos.dameGestora().put("EMPLEADOS", empleados);
    }

    public static void setObservador(ObservadorGestoraDatos observador) {
        HiloActualizarDatos.observador = observador;
    }

}
