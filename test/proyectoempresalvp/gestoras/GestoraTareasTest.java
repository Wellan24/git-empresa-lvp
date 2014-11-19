/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;


import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Oscar
 */
public class GestoraTareasTest implements ObservadorTareas {

    StringBuilder tareas = new StringBuilder();

    public GestoraTareasTest() {

        GestoraBaseDatos.conectarBaseDatos();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of run method, of class GestoraTareas.
     */
    @Test
    public void testHilo() {

        GestoraTareas t = new GestoraTareas(this);
        t.start();
        
        while(t.isAlive()){
            
        }
        assertEquals("El día 21/11/2014 hay GARAJE para PEPA", tareas.toString());
        GestoraBaseDatos.cerrarConexion();
    }

    @Override
    public void avisar() {
        
        tareas = GestoraTareas.getTareasARealizar();
    }
    
    

}
