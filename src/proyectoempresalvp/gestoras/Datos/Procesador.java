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
 */
public interface Procesador {
    
    public void procesar(Dato d);
    public void commit();
}
