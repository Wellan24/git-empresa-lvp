/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.util.Date;


public class Empleado extends Dato{

    public Empleado(int numEmple,int cif,String nomRapido,String nombre,
            String domicilio,String localidad,int cp,String provincia,int tlf1,
            int tlf2,int entidad,int sucursal,int dc,int cuenta,Date alta,
            Date nacimiento,int nomina,int ss,Date baja,String centro0,
            String horas0) {
        this.put("NUMEEMPLE", numEmple);
        this.put("CIF",cif);
        this.put("NOMRAPIDO",nomRapido);
        this.put("NOMBRE",nombre);
        this.put("DOMICILIO",domicilio);
        this.put("LOCALIDAD",localidad);
        this.put("CP",cp);
        this.put("PROVINCIA",provincia);
        this.put("TLF1",tlf1);
        this.put("TLF2",tlf2);
        this.put("ENTIDAD",entidad);
        this.put("SUCURSAL",sucursal);
        this.put("DC",dc);
        this.put("CUENTA",cuenta);
        this.put("ALTA",alta);
        this.put("NACIMIENTO",nacimiento);
        this.put("NOMINA",nomina);
        this.put("SS",ss);
        this.put("BAJA",baja);
        this.put("CENTRO0",centro0);//???
        this.put("HORAS0",horas0);//???
        
    }
    
    
    
    @Override
    public String devuelveNombreTablaDato() {
        
        return "empleados";
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
