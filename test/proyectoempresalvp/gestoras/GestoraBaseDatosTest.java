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
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.FacturaExtraDetalles;

/**
 *
 * @author Oscar
 */
public class GestoraBaseDatosTest {
    
    private static Dato prueba;
    
    public GestoraBaseDatosTest() {
        
        prueba = new FacturaExtraDetalles(10, 10, "Hola", 20);
        GestoraBaseDatos.conectarBaseDatos();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of conectarBaseDatos method, of class GestoraBaseDatos.
     */
    @Test
    public void testConectarBaseDatos() {
        System.out.println("conectarBaseDatos");
        boolean expResult = true;
        boolean result = GestoraBaseDatos.conectarBaseDatos();
        assertEquals(expResult, result);
    }

    /**
     * Test of ejecutarSentencia method, of class GestoraBaseDatos.
     */
    @Test
    public void testEjecutarSentencia() {
        System.out.println("ejecutarSentencia");
        String textoSentencia = "Insert into prueba values (1)";
        GestoraBaseDatos.ejecutarSentencia(textoSentencia);  
    }
    

    /**
     * Test of insertarDatos method, of class GestoraBaseDatos.
     */
//    @Test
//    public void testInsertarDatos() {
//        System.out.println("insertarDatos");
//        boolean expResult = true;
//        boolean result = GestoraBaseDatos.insertarDatos(prueba);
//        assertEquals(expResult, result);
//    }

    /**
     * Test of comprobarExiste method, of class GestoraBaseDatos.
     */
//    @Test
//    public void testComprobarExiste() {
//        System.out.println("comprobarExiste");
//        String primaryKey = prueba.devuelveOrdenDeColumnas()[0];
//        boolean expResult = true;
//        boolean result = GestoraBaseDatos.comprobarExiste(prueba, primaryKey);
//        assertEquals(expResult, result);
//    }
    
    /**
     * Test of cerrarConexion method, of class GestoraBaseDatos.
     */
//    @Test
//    public void testCerrarConexion() {
//        System.out.println("cerrarConexion");
//        GestoraBaseDatos.cerrarConexion();
//    }
    
}
