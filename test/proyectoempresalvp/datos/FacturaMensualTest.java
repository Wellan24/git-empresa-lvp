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
public class FacturaMensualTest {
    
    FacturaMensual instance;
    
    public FacturaMensualTest() {
        
        instance = new FacturaMensual(11,new Fecha("2010/10/10"), 10, "", 10, "10", "", "", "", "10", "10", 10, "", 10, "", "", 10, "10", 10, 10, "");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of devuelveNombreTablaDato method, of class FacturaMensual.
     */
    @Test
    public void testDevuelveNombreTablaDato() {
        System.out.println("devuelveNombreTablaDato");
        String expResult = "FACTURAMENSUAL";
        String result = instance.devuelveNombreTablaDato();
        assertEquals(expResult, result);
    }

    /**
     * Test of devuelveOrdenDeColumnas method, of class FacturaMensual.
     */
    @Test
    public void testDevuelveOrdenDeColumnas() {
        System.out.println("devuelveOrdenDeColumnas");
        String[] expResult = {"NUMFACTURA", "FECHA","NUMCLIENTE", "DESCRIPCION","NUMCONTACTO", "CIF","NOMBRE", "DOMICILIO",
        "LOCALIDAD", "PROVINCIA", "EUROSMES", "TANTOIVA","REFMONEDA","DIACOBRO", "FORMAPAGO", "PERIODO", "NUMPERIODO",
        "NUMCUENTA","REFBANCO","BANCOCOBRO","NUMBREBANCO"};
        String[] result = instance.devuelveOrdenDeColumnas();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class FacturaMensual.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        FacturaMensual o = new FacturaMensual(11,new Fecha("2010/10/10"), 10, "", 10, "10", "", "", "", "10", "10", 10, "", 10, "", "", 10, "10", 10, 10, "");
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
