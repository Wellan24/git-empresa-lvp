/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import proyectoempresalvp.gestoras.Datos.Procesador;

/**
 *
 * @author Oscar
 */
public interface ObservadorGestoraDatos {
    
    public void avisar(int datoActualizado, Procesador procesador);
}
