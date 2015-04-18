/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

/**
 *
 * @author Oscar
 */
public class Banco extends Dato{
    
    private static final String[] orden = {"NUMERO", "NOMBRE"};
    private static final String tabla = "BANCOS";

    public Banco(int numero, String nombre) {
        super(2);
        put("NUMERO", numero);
        put("NOMBRE", nombre);
    }
    
    private Banco(Dato d) {
        super(d);
    }

    @Override
    public String devuelveNombreTablaDato() {

        return tabla;
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {

        return orden;
    }

    @Override
    public Object devuelveValorClave() {

        return this.get("NUMERO");
    }

    @Override
    public String devuelveClave() {
        
        return "NUMERO";
    }

    @Override
    public Dato copia() {
        
        return new Banco(this);
    }

    @Override
    public int compareTo(Dato o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
