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
public class FacturaExtraDetallesTest {
    
    FacturaExtraDetalles instance;
    
    public FacturaExtraDetallesTest() {
        
        instance = new FacturaExtraDetalles(10, 20, "Hola", 20.0f);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Este test comprueba que el nombre de insertado de la tabla
     * es correcto y se puede hacer copia y pega en los demás
     */
    @Test
    public void testDevuelveNombreTablaDato() {
        System.out.println("devuelveNombreTablaDato");
        String expResult = "FACTURAEXTRADETALLES";
        String result = instance.devuelveNombreTablaDato();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Este test comprueba que podemos meter y recuperar todos los datos de los 
     * HashMap correctamente y se puede hacer copia y pega en los demás
     */
    @Test
    public void comprobarDatos(){
        
        boolean comp = (int)instance.get("ORDEN") == 10;
        comp = (comp)?(int)instance.get("NUMERO") == 20 : false;
        comp = (comp)?"Hola".equals((String)instance.get("CONCEPTO")) : false;
        comp = (comp)?(float)instance.get("IMPORTE") == 20.0f : false;
        
        assertTrue(comp);
    }

    /**
     * Este test comprueba que el compareTo es correcto
     */
    
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        FacturaExtraDetalles o = new FacturaExtraDetalles(10, 20, "Hola", 20.0f);
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of devuelveOrdenDeColumnas method, of class FacturaExtraDetalles.
     */
    @Test
    public void testDevuelveOrdenDeColumnas() {
        System.out.println("devuelveOrdenDeColumnas");
        String[] expResult = {"NUMERO","ORDEN", "CONCEPTO", "IMPORTE"};
        String[] result = instance.devuelveOrdenDeColumnas();
        assertArrayEquals(expResult, result);
    }
    
}
