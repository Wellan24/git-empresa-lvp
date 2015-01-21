/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.util.HashMap;
import proyectoempresalvp.datos.ArrayListDato;
import proyectoempresalvp.datos.Dato;

/**
 *
 * @author Oscar
 */
public class GestoraDatos extends HashMap<String, ArrayListDato<Dato>>{
    
    public static final int ACTUALIZAR_TODO = 0;
    public static final int ACTUALIZAR_EMPLEADOS = 1;
    public static final int ACTUALIZAR_CONTRATOS = 2;
    public static final int ACTUALIZAR_CLIENTES = 3;
    public static final int ACTUALIZAR_FACTURASMENSUALES = 4;
    public static final int ACTUALIZAR_FACTURASEXTRA = 5;
    
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
