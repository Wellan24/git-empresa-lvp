/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Oscar
 */
public class Gestora {

    /**
     *
     * @param precio
     * @param iva
     * @return Un BigDecimal redondeado a 2 decimales
     */
    public static BigDecimal calculaPrecioConIva(BigDecimal precio, String iva) {

        precio = precio.multiply(new BigDecimal("1." + iva));
        precio.setScale(2, RoundingMode.HALF_EVEN);
        return precio;
    }

    /**
     *
     * @param precio
     * @param iva
     * @return Un BigDecimal redondeado a 2 decimales
     */
    public static BigDecimal calculaIva(BigDecimal precio, String iva) {

        precio = precio.multiply(new BigDecimal("0." + iva));
        precio.setScale(2, RoundingMode.HALF_EVEN);
        return precio;
    }

    /**
     *
     * @param texto
     * @return Un BigDecimal redondeado a 2 decimales
     */
    public static BigDecimal creaBigDecimal(String texto) {

        BigDecimal dev;
        if (!texto.isEmpty()) {
            
            dev = new BigDecimal(texto);
        } else {
            
            dev = new BigDecimal("0");
        }

        dev.setScale(2, RoundingMode.HALF_EVEN);
        return dev;
    }
}
