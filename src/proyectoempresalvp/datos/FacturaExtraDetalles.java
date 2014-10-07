/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;


public class FacturaExtraDetalles extends Dato{

    public FacturaExtraDetalles(int orden,int numeroFactura,String concepto,
            Float importe) {
        this.put("ORDEN",orden);
        this.put("NUMEROFACTURA",numeroFactura);
        this.put("CONCEPTO",concepto);
        this.put("IMPORTE",importe);
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
