/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

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

    /**
     * 
     * @param str
     * @return true si es válido y si no lo es false
     */
    public static boolean isValidIBAN(String str) {

        // \\s+ sirve para seleccionar uno o más espacios en blanco, \\s solo para uno
        str = str.replaceAll("\\s+", "");

        if (Pattern.matches("([A-Z]{2}+[0-9]{14}+)", str)) {

            String convertedStr = str.substring(4) + Character.getNumericValue(str.charAt(0))
                    + Character.getNumericValue(str.charAt(1)) + str.substring(2, 4);
            long theCheckDigits = Long.parseLong(convertedStr) % 97;
            return (theCheckDigits == 1);
        } else {

            return false;
        }
    }
}
