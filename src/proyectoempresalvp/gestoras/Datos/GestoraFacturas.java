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

        FacturaMensual facturaActual;

        for(Dato c :contratos) {
            Dato cliente = GestoraDatos.recuperarConDummy(new Cliente(), null, " where NUMEROCLIENTE = " + c.get("NUMCLIENTE")).get(0);
            facturaActual = new FacturaMensual(numeroProximaFactura(), UtilidadesTareas.getFechaActual(),
                    (int) c.get("NUMCLIENTE"), c.get("DESCRIPCION").toString(), (int) c.get("NUMCONTRATO"),
                    cliente.get("CIF").toString(), cliente.get("NOMBRE").toString(), cliente.get("DOMICILIO").toString(),
                    cliente.get("LOCALIDAD").toString(), cliente.get("CP").toString(), c.get("EUROSMES").toString(), (int) GestoraConfiguracion.get("IVA"), "",
                    (int) c.get("DIACOBRO"), c.get("FORMAPAGO").toString(), periodo, numperiodo, cliente.get("IBAN").toString(), 0,
                    (int) cliente.get("BANCOCOBRO"), "");
            GestoraBaseDatos.insertarDato(facturaActual);
            aumentarNumeroProximaFactura();
        }
    }

    public static int numeroProximaFactura() {

        return (int) GestoraConfiguracion.get("NUMPROXIMAFACTURA");
    }

    public static void aumentarNumeroProximaFactura() {

        GestoraConfiguracion.put("NUMPROXIMAFACTURA", (int) GestoraConfiguracion.get("NUMPROXIMAFACTURA") + 1);
    }
}
