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
import proyectoempresalvp.datos.FacturaMensual;
import proyectoempresalvp.gestoras.Gestora;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.GestoraConfiguracion;
import proyectoempresalvp.gestoras.UtilidadesTareas;

/**
 *
 * @author Oscar
 */
public class GestoraFacturas {

    public static void generarFacturas(String mes, String año) {

        String periodo = mes + año;
        int numperiodo = Gestora.numeroPeriodoPorNombre(periodo);
        ArrayListDato<Dato> contratos = GestoraDatos.dameGestora().get(Contrato.getTabla());

        GestoraBaseDatos.ejecutarSentenciaUpdate("Delete from FACTURAMENSUAL where NUMPERIODO = " + numperiodo);
        ResultSet num = GestoraBaseDatos.ejecutarSentenciaQuery("Select max(NUMFACTURA) from FACTURAMENSUAL");

        int proximaFactura = 0;
        try {
            num.next();
            proximaFactura = num.getInt(1);
            System.out.println(proximaFactura);

        } catch(SQLException ex) {
            Logger.getLogger(GestoraFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacturaMensual facturaActual;
        if(proximaFactura != 0) {

            for(Dato c :contratos) {
                proximaFactura++;
                facturaActual = new FacturaMensual(proximaFactura, UtilidadesTareas.getFechaActual(),
                        (int) c.get("NUMCLIENTE"), c.get("DESCRIPCION").toString(), (int) c.get("NUMCONTRATO"),
                        0, null, null, null, 0, (int) c.get("EUROSMES"), (int) GestoraConfiguracion.get("IVA"), null,
                        (int) c.get("DIACOBRO"), c.get("FORMAPAGO").toString(), periodo, numperiodo, 0, 0, 0, null);
                GestoraBaseDatos.insertarDato(facturaActual);
            }
        }

    }
}
