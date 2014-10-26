/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

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
        float precio = 45F;
        float iva = 16F;
        float expResult = 52.2F;
        float result = Gestora.calculaPrecioConIva(precio, iva);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of calculaIva method, of class Gestora.
     */
    @Test
    public void testCalculaIva() {
        System.out.println("calculaIva");
        float precio = 45F;
        float iva = 16F;
        float expResult = 7.2F;
        float result = Gestora.calculaIva(precio, iva);
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of redondeaFloat method, of class Gestora.
     */
    @Test
    public void testRedondeaFloat() {
        System.out.println("redondeaFloat");
        float n = 1456.234567F;
        int decimales = 2;
        String expResult = "1456,23";
        String result = Gestora.redondeaFloat(n, decimales);
        assertEquals(expResult, result);
    }
    
}
