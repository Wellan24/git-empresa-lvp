/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

/**
 *
 * @author Administrador
 */
public class Empleados extends Dato{
    
    //Hi
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "empleados";
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
