/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp;

import proyectoempresalvp.datos.ArrayListDato;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.GestoraDatos;
import proyectoempresalvp.gestoras.ObservadorGestoraDatos;


/**
 *
 * @author Administrador
 */
public class ProyectoEmpresaLVP implements ObservadorGestoraDatos{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        GestoraBaseDatos.conectarBaseDatos();   
        GestoraDatos.setObservador(new ProyectoEmpresaLVP());
        GestoraDatos.actualizaDatos(GestoraDatos.ACTUALIZAR_FACTURASEXTRA);
        GestoraBaseDatos.cerrarConexion();
    }

    @Override
    public void avisar(int datoActualizado) {
        
        ArrayListDato<Dato> ds = GestoraDatos.dameGestora().get("FACTURASEXTRADETALLES");
        
        for(Dato d: ds)
            System.out.println(d);
    }
}
