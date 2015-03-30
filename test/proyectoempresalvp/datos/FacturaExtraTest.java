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

        instance = new FacturaExtra(10, new Fecha("2010/10/10"), "10", "", "", "", "", "10", 10, "20", 0);
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
        String expResult = "FACTURAEXTRA";
        String result = instance.devuelveNombreTablaDato();
        assertEquals(expResult, result);
    }

    /**
     * Test of devuelveOrdenDeColumnas method, of class FacturaExtra.
     */
    @Test
    public void testDevuelveOrdenDeColumnas() {
        System.out.println("devuelveOrdenDeColumnas");
        String[] expResult = {"NUMEROFACTURA", "FECHA", "CIF", "NOMBRE", "DOMICILIO", "LOCALIDAD",
            "PROVINCIA", "CP", "TANTOIVA", "EUROSNETO", "CLIENTE"};
        String[] result = instance.devuelveOrdenDeColumnas();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class FacturaExtra.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        FacturaExtra o = new FacturaExtra(10, new Fecha("2010/10/10"), "10", "", "", "", "", "10", 10, "20", 0);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

}
