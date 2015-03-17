/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar
 */
public class ClienteTest {
    
    Cliente instance;
    
    public ClienteTest() {
        instance = new Cliente(1, "10", "", "", "", "", 10, "", "", 10, 10, "", 10, "10", 10);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of devuelveNombreTablaDato method, of class Cliente.
     */
    @Test
    public void testDevuelveNombreTablaDato() {
        System.out.println("devuelveNombreTablaDato");
        String expResult = "CLIENTES";
        String result = instance.devuelveNombreTablaDato();
        assertEquals(expResult, result);
    }

    /**
     * Test of devuelveOrdenDeColumnas method, of class Cliente.
     */
    @Test
    public void testDevuelveOrdenDeColumnas() {
        System.out.println("devuelveOrdenDeColumnas");
        String[] expResult = {"NUMEROCLIENTE", "CIF", "DESCRIPCION", "NOMBRE", "DOMICILIO","LOCALIDAD", "CP", "PROVINCIA", "PERSONACONTACTO", "TLFCLIENTE","TLFCONTACTO", "NOTAS", 
                                    "REFBANCO","IBAN", "BANCOCOBRO"};
        String[] result = instance.devuelveOrdenDeColumnas();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Cliente.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Cliente o = new Cliente(10, "10", "", "", "", "", 10, "", "", 10, 10, "", 10, "10", 10);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
