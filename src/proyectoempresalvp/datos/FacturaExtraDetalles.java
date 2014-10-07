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
public class FacturaExtraDetalles extends Dato{

    /**
     *  Las claves son: ORDEN, NUMERO, CONCEPTO, IMPORTE
     * 
     * @param orden
     * @param numero
     * @param concepto
     * @param importe 
     */
    public FacturaExtraDetalles(int orden, int numero, String concepto, float importe) {
        
        this.put("ORDEN", orden);
        this.put("NUMERO", numero);
        this.put("CONCEPTO", concepto);
        this.put("IMPORTE", importe);
    }

    @Override
    public String devuelveNombreTablaDato() {
        
        return "FACTURAEXTRADETALLES";
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
