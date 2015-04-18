/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;
import java.util.Date;

public class Contrato extends Dato {

    private static final String[] orden = {"NUMCONTRATO", "NUMCLIENTE", "DESCRIPCION", "INICIOCONTRATO", "FINCONTRATO", "EUROSAÑO", "EUROSMES", 
        "FORMAPAGO", "DIACOBRO", "TANTOIVA", "ESTADO"};
    private static final String tabla = "CONTRATOS";

    /**
     * Las claves son: NUMCONTRATO, NUMCLIENTE, DESCRIPCION,INICIOCONTRATO,
     * FINCONTRATO, EUROSAÑO, EUROSMES, FORMAPAGO, DIACOBRO, TANTOIVA, ESTADO
     *
     * @param numContrato
     * @param numCliente
     * @param descripcion
     * @param inicioContrato
     * @param finContrato
     * @param eurosAño
     * @param eurosMes
     * @param formaPago
     * @param diaCobro
     * @param tantoIva
     */
    public Contrato(int numContrato, int numCliente, String descripcion,
            Fecha inicioContrato, Fecha finContrato, String eurosAño, String eurosMes,
            String formaPago, int diaCobro, int tantoIva) {
        super(12);
        this.put("NUMCONTRATO", numContrato);
        this.put("NUMCLIENTE", numCliente);
        this.put("DESCRIPCION", descripcion);
        this.put("INICIOCONTRATO", inicioContrato);
        this.put("FINCONTRATO", finContrato);
        this.put("EUROSAÑO", eurosAño);
        this.put("EUROSMES", eurosMes);
        this.put("FORMAPAGO", formaPago);
        this.put("DIACOBRO", diaCobro);
        this.put("TANTOIVA", tantoIva);
        this.put("ESTADO", false);
    }
    
    public Contrato(int numContrato, int numCliente, String descripcion,
            Fecha inicioContrato, Fecha finContrato, String eurosAño, String eurosMes,
            String formaPago, int diaCobro, int tantoIva, boolean estado) {
        super(12);
        this.put("NUMCONTRATO", numContrato);
        this.put("NUMCLIENTE", numCliente);
        this.put("DESCRIPCION", descripcion);
        this.put("INICIOCONTRATO", inicioContrato);
        this.put("FINCONTRATO", finContrato);
        this.put("EUROSAÑO", eurosAño);
        this.put("EUROSMES", eurosMes);
        this.put("FORMAPAGO", formaPago);
        this.put("DIACOBRO", diaCobro);
        this.put("TANTOIVA", tantoIva);
        this.put("ESTADO", estado);
    }
    
     public Contrato() {
        super(12);
        this.put("NUMCONTRATO", 0);
        this.put("NUMCLIENTE", 0);
        this.put("DESCRIPCION", "");
        this.put("INICIOCONTRATO", new Fecha("1/1/2015"));
        this.put("FINCONTRATO", new Fecha("1/1/2015"));
        this.put("EUROSAÑO", "");
        this.put("EUROSMES", "");
        this.put("FORMAPAGO", "");
        this.put("DIACOBRO", 0);
        this.put("TANTOIVA", 0);
        this.put("ESTADO", false);
    }
    
    private Contrato(Dato d) {
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
    public int compareTo(Dato o) {

        Collator c = Collator.getInstance();
        c.setStrength(Collator.PRIMARY);

        Object obj;
        Object objO;

        for (String clave : orden) {

            obj = this.get(clave);
            objO = o.get(clave);
            if (obj instanceof Integer) {

                if ((int) obj != (int) objO) {

                    return (int) obj > (int) objO ? 1 : -1;
                }
            } else if (obj instanceof String) {
                if (c.compare((String) obj, (String) objO) != 0) {

                    return c.compare(obj, objO);
                }
            } else if (obj instanceof Float) {

                if ((float) obj != (float) objO) {

                    return (float) obj > (float) objO ? 1 : -1;
                }
            } else if (obj instanceof Date) {

                if (((Date) obj).compareTo((Date) objO) != 0) {

                    return ((Date) obj).compareTo((Date) objO);
                }
            }

        }

        return 0;
    }

    /**
     * La clave es NUMCONTRATO
     *
     * @return
     */
    @Override
    public Object devuelveValorClave() {

        return "" + this.get("NUMCONTRATO");
    }

    public static String[] getOrden() {
        return orden;
    }

    public static String getTabla() {
        return tabla;
    }

    @Override
    public String devuelveClave() {
        
        return "NUMCONTRATO";
    }

    @Override
    public Dato copia() {
        
        return new Contrato(this);
    }
}
