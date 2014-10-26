/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.sql.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar
 */
public class FacturaExtraTest {
    
    FacturaExtra instance;
    
    public FacturaExtraTest() {
        
        instance = new FacturaExtra(10, 10, "", 10, Date.valueOf("2010-10-10"), 10, "", "", "", "", 10, 10, 10, "");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of devuelveNombreTablaDato method, of class FacturaExtra.
     */
    @Test
    public void testDevuelveNombreTablaDato() {
        System.out.println("devuelveNombreTablaDato");
        FacturaExtra instance = null;
        String expResult = "";
        String result = instance.devuelveNombreTablaDato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devuelveOrdenDeColumnas method, of class FacturaExtra.
     */
    @Test
    public void testDevuelveOrdenDeColumnas() {
        System.out.println("devuelveOrdenDeColumnas");
        String[] expResult = null;
        String[] result = instance.devuelveOrdenDeColumnas();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class FacturaExtra.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        FacturaExtra o = new FacturaExtra(10, 10, "", 10, Date.valueOf("2010-10-10"), 10, "", "", "", "", 10, 10, 10, "");
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
