/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Oscar
 */
public class Configuracion extends HashMap<String, Object> implements Serializable {

    public Configuracion() {
        super(1);
        put("IVA", 21);
    }

    public Configuracion(int initialCapacity) {
        super(initialCapacity);
    }

    public Configuracion(Map<? extends String, ? extends Object> m) {
        super(m);
    }
}
