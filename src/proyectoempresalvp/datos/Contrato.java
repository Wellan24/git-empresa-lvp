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
public class Contrato extends Dato{

    public Contrato() {
    }    
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "CONTRATOS";
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
