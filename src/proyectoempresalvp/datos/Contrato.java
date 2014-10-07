/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.util.Date;


public class Contrato extends Dato{

    public Contrato(int numContrato,int numCliente,String descripcion,
            Date inicioContrato,Date finContrato,int eurosAño,int eurosMes,
            String situacion,String formaPago,int diaCobro,int tantoIva) {
        this.put("NUMCONTRATO",numContrato);
        this.put("NUMCLIENTE",numCliente);
        this.put("DESCRIPCION",descripcion);
        this.put("INICIOCONTRATO",inicioContrato);
        this.put("FINCONTRATO",finContrato);
        this.put("EUROSAÑO",eurosAño);
        this.put("EUROSMES",eurosMes);
        this.put("SITUACION",situacion);
        this.put("FORMAPAGO",formaPago);
        this.put("DIACOBRO",diaCobro);
        this.put("TANTOIVA",tantoIva);
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
