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
public class ContratoTest {
    
    Contrato instance;
    public ContratoTest() {
        
        instance = new Contrato( 10, 10, "", new Fecha("2010/10/10"), new Fecha("2010/10/10"), 10, 10, "", "", 10, 10);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of devuelveNombreTablaDato method, of class Contrato.
     */
    @Test
    public void testDevuelveNombreTablaDato() {
        System.out.println("devuelveNombreTablaDato");
        String expResult = "CONTRATOS";
        String result = instance.devuelveNombreTablaDato();
        assertEquals(expResult, result);
    }

    /**
     * Test of devuelveOrdenDeColumnas method, of class Contrato.
     */
    @Test
    public void testDevuelveOrdenDeColumnas() {
        System.out.println("devuelveOrdenDeColumnas");
        String[] expResult = {"NUMCONTRATO", "NUMCLIENTE", "DESCRIPCION","INICIOCONTRATO","FINCONTRATO", "EUROSAÑO", "EUROSMES", 
            "SITUACION", "FORMAPAGO", "DIACOBRO", "TANTOIVA"};
        String[] result = instance.devuelveOrdenDeColumnas();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Contrato.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Contrato o = new Contrato( 11, 10, "", new Fecha("2010/10/10"), new Fecha("2010/10/10"), 10, 10, "", "", 10, 10);
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
