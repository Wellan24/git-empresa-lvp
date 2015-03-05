/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp;

import java.sql.SQLException;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.Datos.GestoraDatos;
import proyectoempresalvp.gestoras.Datos.GestoraFacturas;
import proyectoempresalvp.gestoras.Datos.Procesador;
import proyectoempresalvp.gestoras.GestoraConfiguracion;
import proyectoempresalvp.gestoras.ObservadorGestoraDatos;
import proyectoempresalvp.gestoras.pdf.GestoraArchivos;

/**
 *
 * @author Administrador
 */
public class ProyectoEmpresaLVP implements ObservadorGestoraDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, InterruptedException {

//        GestoraBaseDatos.conectarBaseDatos();
//        GestoraConfiguracion.recuperaConfiguracion();
//        GestoraDatos.setObservador(new ProyectoEmpresaLVP());
//        GestoraDatos.actualizaDatos(GestoraDatos.ACTUALIZAR_CONTRATOS);
        
        new GestoraArchivos().start();
    }

    @Override
    public void avisar(int datoActualizado, Procesador procesador) {

        GestoraFacturas.generarFacturas("AGO", "2014");
        GestoraBaseDatos.cerrarConexion();
    }
}
