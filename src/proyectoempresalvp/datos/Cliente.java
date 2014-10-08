/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;




public class Cliente extends Dato implements Comparable<Cliente>{
    
    /**
     *   Las claves son: NUMEROCONTACTO, CIF, DESCRIPCION, NOMBRE, DOMICILIO,
     *          LOCALIDAD, CP, PROVINCIA, PERSONACONTACTO, TLFCLIENTE,
     *          TLFCONTACTO, NOTAS, ENTIDAD, SUCURSAL, DC, CUENTA, REFBANCO,
     *          IBAN, BANCOCOBRO
     * 
     * @param numeroContacto
     * @param cif
     * @param descripcion
     * @param nombre
     * @param domicilio
     * @param localidad
     * @param cp
     * @param provincia
     * @param personaContacto
     * @param tlfCliente
     * @param tlfContacto
     * @param notas
     * @param entidad
     * @param sucursal
     * @param dc
     * @param cuenta
     * @param refBanco
     * @param iban
     * @param bancoCobro 
     */
   public Cliente( int numeroContacto, int cif, String descripcion,
    String nombre,String domicilio,String localidad,int cp,
    String provincia,String personaContacto,int tlfCliente,int tlfContacto,
    String notas,int entidad,int sucursal,int dc, int cuenta,int refBanco,
    int iban,int bancoCobro) {
        this.put("NUMEROCONTACTO", numeroContacto);
        this.put("CIF",cif);
        this.put("DESCRIPCION",descripcion);
        this.put("NOMBRE",nombre);
        this.put("DOMICILIO",domicilio);
        this.put("LOCALIDAD",localidad);
        this.put("CP",cp);
        this.put("PROVINCIA",provincia);
        this.put("PERSONACONTACTO",personaContacto);
        this.put("TLFCLIENTE",tlfCliente);
        this.put("TLFCONTACTO",tlfContacto);
        this.put("NOTAS",notas);
        this.put("ENTIDAD",entidad);
        this.put("SUCURSAL",sucursal);
        this.put("DC",dc);
        this.put("CUENTA",cuenta);
        this.put("REFBANCO",refBanco);
        this.put("IBAN",iban);
        this.put("BANCOCOBRO",bancoCobro);
    }

    @Override
    public String devuelveNombreTablaDato() {
        return "CLIENTES";
    }

    @Override
    public int compareTo(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
