/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;
import java.util.Date;

public class Contrato extends Dato implements Comparable<Contrato> {

    public static String[] orden = {"NUMCONTRATO", "NUMCLIENTE", "DESCRIPCION", "INICIOCONTRATO", "FINCONTRATO", "EUROSAÑO", "EUROSMES",
        "SITUACION", "FORMAPAGO", "DIACOBRO", "TANTOIVA"};

    /**
     * Las claves son: NUMCONTRATO, NUMCLIENTE, DESCRIPCION,INICIOCONTRATO,
     * FINCONTRATO, EUROSAÑO, EUROSMES, SITUACION, FORMAPAGO, DIACOBRO, TANTOIVA
     *
     * @param numContrato
     * @param numCliente
     * @param descripcion
     * @param inicioContrato
     * @param finContrato
     * @param eurosAño
     * @param eurosMes
     * @param situacion
     * @param formaPago
     * @param diaCobro
     * @param tantoIva
     */
    public Contrato(int numContrato, int numCliente, String descripcion,
            Date inicioContrato, Date finContrato, int eurosAño, int eurosMes,
            String situacion, String formaPago, int diaCobro, int tantoIva) {
        this.put("NUMCONTRATO", numContrato);
        this.put("NUMCLIENTE", numCliente);
        this.put("DESCRIPCION", descripcion);
        this.put("INICIOCONTRATO", inicioContrato);
        this.put("FINCONTRATO", finContrato);
        this.put("EUROSAÑO", eurosAño);
        this.put("EUROSMES", eurosMes);
        this.put("SITUACION", situacion);
        this.put("FORMAPAGO", formaPago);
        this.put("DIACOBRO", diaCobro);
        this.put("TANTOIVA", tantoIva);
    }

    @Override
    public String devuelveNombreTablaDato() {

        return "CONTRATOS";
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {

        return orden;
    }

    @Override
    public int compareTo(Contrato o) {

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

                    return c.compare((String) obj, objO);
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
    public String devuelveClave() {

        return "" + this.get("NUMCONTRATO");
    }
}
