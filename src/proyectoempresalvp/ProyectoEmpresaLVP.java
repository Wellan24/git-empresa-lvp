/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.FacturaExtra;
import proyectoempresalvp.datos.FacturaExtraDetalles;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.Datos.GestoraDatos;
import proyectoempresalvp.gestoras.Datos.Procesador;
import proyectoempresalvp.gestoras.GestoraConfiguracion;
import proyectoempresalvp.gestoras.ObservadorGestoraDatos;
import proyectoempresalvp.gestoras.pdf.GestoraPDF;

/**
 *
 * @author Administrador
 */
public class ProyectoEmpresaLVP implements ObservadorGestoraDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, InterruptedException {

        GestoraBaseDatos.conectarBaseDatos();
        GestoraConfiguracion.recuperaConfiguracion();
        GestoraDatos.setObservador(new ProyectoEmpresaLVP());
        GestoraDatos.actualizaDatos(GestoraDatos.ACTUALIZAR_TODO);       
        
    }

    @Override
    public void avisar(int datoActualizado, Procesador procesador) {

        Dato factura = GestoraDatos.dameGestora().get(FacturaExtra.getTabla()).get(0);
        ArrayList<Dato> extras = GestoraDatos.dameGestora().get(FacturaExtraDetalles.getTabla()).devuelveValorEnFuncionCampo("NUMERO", factura.get("NUMEROFACTURA"));
        GestoraPDF.generarPDFExtra(new ArrayList<>(extras), factura);
    }
}
