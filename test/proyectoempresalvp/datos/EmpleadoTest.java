/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.sql.Date;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar
 */
public class EmpleadoTest {
    
    Empleado instance;
    
    public EmpleadoTest() {
        
        instance = new Empleado(10, 10, "", "", "", "", 10, "", 10, 10, 10, "2010-10-10"
                , "2010-10-10", 10, 10, "2010-10-10","","");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of devuelveNombreTablaDato method, of class Empleado.
     */
    @Test
    public void testDevuelveNombreTablaDato() {
        System.out.println("devuelveNombreTablaDato");
        String expResult = "EMPLEADOS";
        String result = instance.devuelveNombreTablaDato();
        assertEquals(expResult, result);
    }

    /**
     * Test of devuelveOrdenDeColumnas method, of class Empleado.
     */
    @Test
    public void testDevuelveOrdenDeColumnas() {
        System.out.println("devuelveOrdenDeColumnas");
        String[] expResult = {"NUMEMPLE", "CIF", "ANAGRAMA", "NOMBRE", "DOMICILIO", 
            "LOCALIDAD", "CP", "PROVINCIA", "TLF1", "TLF2", "IBAN", "ALTA", 
            "NACIMIENTO", "NOMINA", "SS", "BAJA"};
        String[] result = instance.devuelveOrdenDeColumnas();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Empleado.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Empleado o = new Empleado(10, 10, "", "", "", "", 10, "", 10, 10, 10, "2010-10-10"
                , "2010-10-10", 10, 10, "2010-10-10","","");
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }
    
}
