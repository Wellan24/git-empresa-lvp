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
public class Empleados extends HashMap<String, Object> implements Dato{

    
    
    @Override
    public HashMap<String, Object> devuelveTodosCampos() {
        
        return this;
    }

    @Override
    public String devuelveNombreTablaDato() {
        
        return "empleados";
    }
    
}
