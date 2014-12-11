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
import proyectoempresalvp.datos.Empleado;

/**
 *
 * @author Oscar
 */
public class GestoraDatos extends Thread{
    
    private static ArrayListDato<Empleado> empleados;
    private static ArrayListDato<Contrato> contratos;
    private static ArrayListDato<Cliente> clientes;
    
    public static final int ACTUALIZAR_TODO = 0;
    public static final int ACTUALIZAR_EMPLEADOS = 1;
    public static final int ACTUALIZAR_CONTRATOS = 2;
    public static final int ACTUALIZAR_CLIENTES = 3;
    
    public static ObservadorGestoraDatos observador;
    
    private final int datoActualizar;

    public GestoraDatos(int datoActualizar) {
        
        this.datoActualizar = datoActualizar;
    }

    @Override
    public void run() {
        
        if(datoActualizar == ACTUALIZAR_TODO || datoActualizar == ACTUALIZAR_EMPLEADOS)
            actualizarEmpleados();
    }

    private void actualizarEmpleados() {
       
         ResultSet empleadosComprobar = GestoraBaseDatos.ejecutarSentenciaQuery("Select NUMEMPLE, CIF, ANAGRAMA, NOMBRE, DOMICILIO, LOCALIDAD, CP, PROVINCIA"
                 + ", TLF1, TLF2, IBAN, ALTA, NACIMIENTO, NOMINA, SS, BAJA from EMPLEADOS");
        if (empleados == null) {
            empleados = new ArrayListDato();
        } else {
            empleados.clear();
        }
        
        Empleado empleadoActual;

        try {
            while (empleadosComprobar.next()) {

                empleadoActual = new Empleado(empleadosComprobar.getInt(1), empleadosComprobar.getInt(2), empleadosComprobar.getString(3), 
                        empleadosComprobar.getString(4),empleadosComprobar.getString(5),empleadosComprobar.getString(6),empleadosComprobar.getInt(7),
                        empleadosComprobar.getString(8),empleadosComprobar.getInt(9),empleadosComprobar.getInt(10),empleadosComprobar.getInt(11),
                        empleadosComprobar.getString(12),empleadosComprobar.getString(13),empleadosComprobar.getInt(14),empleadosComprobar.getInt(15),
                        empleadosComprobar.getString(16),"","");
                empleados.add(empleadoActual);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GestoraTareas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        observador.avisar(datoActualizar);
    }

    public static void setObservador(ObservadorGestoraDatos observador) {
        GestoraDatos.observador = observador;
    }
    
    

    public static ArrayListDato<Empleado> getEmpleados() {
        return empleados;
    }

    public static ArrayListDato<Contrato> getContratos() {
        return contratos;
    }

    public static ArrayListDato<Cliente> getClientes() {
        return clientes;
    }
    
}
