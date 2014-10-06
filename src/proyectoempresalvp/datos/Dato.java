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
interface Dato {
    
    HashMap<String, Object> devuelveTodosCampos();
    String devuelveNombreTablaDato();
}
