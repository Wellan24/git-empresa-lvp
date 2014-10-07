/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.util.HashMap;

/**
 *
 * @author Administrador
 */
abstract class Dato extends HashMap<String, Object> implements Comparable{
    
    public abstract String devuelveNombreTablaDato();
}
