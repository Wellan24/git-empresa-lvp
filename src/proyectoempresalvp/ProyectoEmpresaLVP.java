/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp;

import java.sql.SQLException;
import proyectoempresalvp.datos.FacturaExtra;
import proyectoempresalvp.datos.FacturaMensual;
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

        int sum = 0;
        for (int i = 1; i < 10; i++) {
            
        System.out.println(1);
            sum += i;
        }
        
        System.out.println(sum);
//        GestoraBaseDatos.conectarBaseDatos();
//        GestoraConfiguracion.recuperaConfiguracion();
//        GestoraDatos.setObservador(new ProyectoEmpresaLVP());
//        GestoraDatos.actualizaDatos(GestoraDatos.ACTUALIZAR_TODO);
//        int numPeriodo = Gestora.numeroPeriodoPorNombre("ENE2015");
//        GestoraDatos.actualizaDatos(GestoraDatos.ACTUALIZAR_FACTURASMENSUALES, null, numPeriodo);

    }

    @Override
    public void avisar(int datoActualizado, Procesador procesador) {

//        if(datoActualizado == GestoraDatos.ACTUALIZAR_FACTURASMENSUALES) {
            FacturaExtra factura = (FacturaExtra) GestoraDatos.dameGestora().get(FacturaExtra.getTabla()).get(0);
            GestoraPDF.generarPDFExtra(factura);
//        }
    }
}
