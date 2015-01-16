/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.ArrayListDato;
import proyectoempresalvp.datos.Cliente;
import proyectoempresalvp.datos.Contrato;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.Empleado;
import proyectoempresalvp.datos.FacturaExtra;
import proyectoempresalvp.datos.FacturaMensual;

/**
 *
 * @author Oscar
 */
public class GestoraDatos extends HashMap<String, ArrayListDato<Dato>>{
    
//    private static ArrayListDato<Empleado> empleados;
    private static ArrayListDato<Contrato> contratos;
    private static ArrayListDato<Cliente> clientes;
    private static ArrayListDato<FacturaExtra> facturasExtra;
    private static ArrayListDato<FacturaMensual> facturasMensuales;
    
    public static final int ACTUALIZAR_TODO = 0;
    public static final int ACTUALIZAR_EMPLEADOS = 1;
    public static final int ACTUALIZAR_CONTRATOS = 2;
    public static final int ACTUALIZAR_CLIENTES = 3;
    
    private static GestoraDatos g;

    private GestoraDatos() {
    }
    
    public static void actualizaDatos(int datoActualizar){
        
        new Thread(new HiloActualizarDatos(datoActualizar)).start();
    }

    public static GestoraDatos dameGestora(){
        
        if(g == null)
            g = new GestoraDatos();
        
        return g;
    }
    
    public static void setObservador(ObservadorGestoraDatos observador) {
        HiloActualizarDatos.setObservador(observador);
    }

    @Override
    public ArrayListDato<Dato> get(Object key) {
        return super.get(key); 
    }
    
}
