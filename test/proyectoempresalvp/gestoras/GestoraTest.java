/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.math.BigDecimal;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar
 */
public class GestoraTest {
    
    public GestoraTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calculaPrecioConIva method, of class Gestora.
     */
    @Test
    public void testCalculaPrecioConIva() {
        System.out.println("calculaPrecioConIva");
        BigDecimal precio = Gestora.creaBigDecimal("45");
        String iva = "16";
        BigDecimal expResult = new BigDecimal("52.20");
        BigDecimal result = Gestora.calculaPrecioConIva(precio, iva);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculaIva method, of class Gestora.
     */
    @Test
    public void testCalculaIva() {
        System.out.println("calculaIva");
        BigDecimal precio = Gestora.creaBigDecimal("45");
        String iva = "16";
        BigDecimal expResult = new BigDecimal("7.20");
        BigDecimal result = Gestora.calculaIva(precio, iva);
        assertEquals(expResult, result);
    }

    /**
     * Test of creaBigDecimal method, of class Gestora.
     */
    @Test
    public void testCreaBigDecimal() {
        System.out.println("creaBigDecimal");
        String texto = "";
        BigDecimal expResult = new BigDecimal("0");
        BigDecimal result = Gestora.creaBigDecimal(texto);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidIBAN method, of class Gestora.
     */
    @Test
    public void testIsValidIBAN() {
        System.out.println("isValidIBAN");
        String str = "ES80 2310 0001 1800 0001 2345";
        boolean expResult = false;
        boolean result = Gestora.isValidIBAN(str);
        assertEquals(expResult, result);
    }
    
}
