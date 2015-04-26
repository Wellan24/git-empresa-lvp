/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras.Datos;

import proyectoempresalvp.datos.Dato;

/**
 *
 * @author Oscar
 * @param <T>
 */
public interface Procesador<T extends Dato> {
    
    public boolean procesar(Dato d);
    public void commit();
    public Object getProcesado();
    public boolean comprobarValido(Dato d);
}
