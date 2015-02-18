/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import proyectoempresalvp.datos.Fecha;

/**
 *
 * @author Oscar
 */
public class Gestora {

    private static final char[] DIGITS_LOWER
            = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean comprobarNumero(String n) {

        return n.matches("^(\\d|-)?(\\d|,)*\\.?\\d*$");
    }

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
     * Formatea la cadena para que tenga siempre la misma, colocando el String a la derecha
     *
     * @param string
     * @param longitud
     * @return
     */
    public static String stringLongitudFijaDrch(String string, int longitud) {
        return String.format("%1$" + longitud + "s", string);
    }

    /**
     * Formatea la cadena para que, pad rellena la cadena dada Apple + "00000000" devuelve
     * "000Apple"
     *
     * @param string
     * @param pad
     * @return
     */
    public static String stringLongitudFijaIzq(String string, String pad) {

        return (pad + string).substring(string.length());
    }

    public static String completarConEspaciosBlancosIzq(String pString, int length) {
        if(pString.length() > length) {

            return pString.substring(0, length);
        }
        length = length - pString.length();
        for(int i = 0;i < length;i++) {
            pString = pString + " ";
        }
        return pString;
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
        if(!texto.isEmpty()) {

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

        if(IBAN.length() == 24) {

            String stringConvertido = IBAN.substring(4) + Character.getNumericValue(IBAN.charAt(0))
                    + Character.getNumericValue(IBAN.charAt(1)) + IBAN.substring(2, 4);

            long total = 0;
            for(int i = 0;i < stringConvertido.length();i++) {
                int charValue = Character.getNumericValue(stringConvertido.charAt(i));
                total = (charValue > 9 ? total * 100 : total * 10) + charValue;
                if(String.valueOf(total).length() > 9) {
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
     * Cuenta es un parametro en formato CCC: 4 dígitos para el banco, 4 para la sucursal, 2 dígitos
     * de control y 10 para el número de cuenta en la entidad y oficina.
     *
     * @param cuenta
     * @return Un IBAN válido para españa ESXX + cuenta, donde XX son los dígitos de control.
     */
    public static String calcularIbanEspaña(String cuenta) {

        cuenta = cuenta.replaceAll("\\s+", "");

        if(Pattern.matches("([0-9]{20})", cuenta)) {

            String aux = cuenta + "142800";

            long total = 0;
            for(int i = 0;i < aux.length();i++) {
                int charValue = Character.getNumericValue(aux.charAt(i));
                total = (charValue > 9 ? total * 100 : total * 10) + charValue;
                if(String.valueOf(total).length() > 9) {
                    total = (total % 97);
                }
            }

            int digitosControl = 98 - (int) (total % 97);
            return "ES" + digitosControl + cuenta;

        } else {

            return null;
        }
    }

    /**
     * El formato es dd/mm/aaaa
     *
     * @param fecha
     * @return true si la fecha es correcta, si no false
     */
    public static boolean comprobarFormatoFechaCorrecto(String fecha) {

        String[] f = fecha.split("/");

        int año;
        int mes;
        int dia;
        try {
            dia = Integer.parseInt(f[0]);
            mes = Integer.parseInt(f[1]);
            año = Integer.parseInt(f[2]);

        } catch(Exception numberFormatException) {

            return false;
        }
        if(año < 0 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return false;
        }

        switch(mes) {
            case 2:

                if(dia > 29) {
                    return false;
                }

                if(!(((año % 4 == 0) && (año % 100 != 0)) || (año % 400 == 0)) && dia == 29) {
                    return false;
                }

                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(dia > 30) {
                    return false;
                }

                break;
        }
        return true;

    }

    public static int numeroPeriodoPorNombre(String nombre) {

        String mes = nombre.substring(0, 3);
        String año = nombre.substring(3);

        switch(mes) {

            case "ENE":
                mes = "01";
                break;
            case "FEB":
                mes = "02";
                break;
            case "MAR":
                mes = "03";
                break;
            case "ABR":
                mes = "04";
                break;
            case "MAY":
                mes = "05";
                break;
            case "JUN":
                mes = "06";
                break;
            case "JUL":
                mes = "07";
                break;
            case "AGO":
                mes = "08";
                break;
            case "SEP":
                mes = "09";
                break;
            case "OCT":
                mes = "10";
                break;
            case "NOV":
                mes = "11";
                break;
            case "DIC":
                mes = "12";
                break;
        }

        return Integer.parseInt(año + mes);
    }

    public static Fecha fechaPeriodoPorNombre(String nombre) {

        String mes = nombre.substring(0, 3);
        String año = nombre.substring(3);

        switch(mes) {

            case "ENE":
                mes = "01";
                break;
            case "FEB":
                mes = "02";
                break;
            case "MAR":
                mes = "03";
                break;
            case "ABR":
                mes = "04";
                break;
            case "MAY":
                mes = "05";
                break;
            case "JUN":
                mes = "06";
                break;
            case "JUL":
                mes = "07";
                break;
            case "AGO":
                mes = "08";
                break;
            case "SEP":
                mes = "09";
                break;
            case "OCT":
                mes = "10";
                break;
            case "NOV":
                mes = "11";
                break;
            case "DIC":
                mes = "12";
                break;
        }

        return new Fecha("01/" + mes + "/" + año);
    }

    public static byte[] getHash(String password) {
        try {

            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.reset();
            byte[] input = digest.digest(password.getBytes("UTF-8"));

            return input;

        } catch(NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Gestora.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }
    
    public static String devuelveHash(String contraseña){
        
        return String.valueOf(encodeHex(getHash(contraseña), DIGITS_LOWER));
    }

}
