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
import proyectoempresalvp.datos.Contrato;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.gestoras.Gestora;
import proyectoempresalvp.gestoras.GestoraBaseDatos;

/**
 *
 * @author Oscar
 */
public class GestoraFacturas {

    public static void generarFacturas(String mes, String año) {

        String periodo = mes + año;
        int numperiodo = Gestora.numeroPeriodoPorNombre(periodo);
        ArrayListDato<Dato> contratos = GestoraDatos.dameGestora().get(Contrato.getTabla());
        ResultSet num = GestoraBaseDatos.ejecutarSentenciaQuery("Select max(NUMFACTURA) from FACTURAMENSUAL");
        
        int proximaFactura;        
        try {
            num.next();
            proximaFactura = num.getInt(1);            
            System.out.println(proximaFactura);
            
        } catch(SQLException ex) {
            Logger.getLogger(GestoraFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}

class HiloGenerar extends Thread {

}
