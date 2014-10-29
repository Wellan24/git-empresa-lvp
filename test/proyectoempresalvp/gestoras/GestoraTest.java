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
        String precio = "45";
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
        String precio = "45";
        String iva = "16";
        BigDecimal expResult = new BigDecimal("7.20");
        BigDecimal result = Gestora.calculaIva(precio, iva);
        assertEquals(expResult, result);
    }
    
}
