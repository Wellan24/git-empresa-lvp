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

    private static final int BBAN_INDEX = 4;
    private static final long CHECK_DIGITS_MAX = 999999999;
    private static final long CHECK_DIGITS_MODULUS = 97;

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
     * @param IBAN
     * @return true si es válido y si no lo es false
     */
    public static boolean esValidoIBAN(String IBAN) {

        // \\s+ sirve para seleccionar uno o más espacios en blanco, \\s solo para uno
        IBAN = IBAN.replaceAll("\\s+", "");

        if (IBAN.length() == 24) {

            String stringConvertido = IBAN.substring(4) + Character.getNumericValue(IBAN.charAt(0))
                    + Character.getNumericValue(IBAN.charAt(1)) + IBAN.substring(2, 4);

            long total = 0;
            for (int i = 0; i < stringConvertido.length(); i++) {
                int charValue = Character.getNumericValue(stringConvertido.charAt(i));
                total = (charValue > 9 ? total * 100 : total * 10) + charValue;
                if (String.valueOf(total).length() > 9) {
                    total = (total % 97);
                }
            }

            long digitosControl = total % 97;

            return (digitosControl == 1);
        } else {

            return false;
        }
    }

    /**
     * Cuenta es un parametro en formato CCC: 4 dígitos para el banco, 4 para la sucursal, 2 dígitos de control y 10
     * para el número de cuenta en la entidad y oficina.
     *
     * @param cuenta
     * @return Un IBAN válido para españa ESXX + cuenta, donde XX son los dígitos de control.
     */
    public static String calcularIbanEspaña(String cuenta) {

        cuenta = cuenta.replaceAll("\\s+", "");

        if (Pattern.matches("([0-9]{20})", cuenta)) {

            String aux = cuenta + "142800";

            long total = 0;
            for (int i = 0; i < aux.length(); i++) {
                int charValue = Character.getNumericValue(aux.charAt(i));
                total = (charValue > 9 ? total * 100 : total * 10) + charValue;
                if (String.valueOf(total).length() > 9) {
                    total = (total % 97);
                }
            }

            int digitosControl = 98 - (int) (total % 97);
            return "ES" + digitosControl + cuenta;

        } else {

            return null;
        }
    }
}
