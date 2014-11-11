/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author Oscar
 */
@RunWith(value=Parameterized.class)
public class GestoraTareasTest {

    String fecha;
    boolean correcto;
    static int i= 0;
    
    public GestoraTareasTest(String fecha, boolean correcto) {
        
        this.fecha = fecha;
        this.correcto = correcto;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of comprobarFormatoFechaCorrecto method, of class GestoraTareas.
     */
    @Test
    public void testComprobarFormatoFechaCorrecto() {
        
        boolean expResult = correcto;
        boolean result = GestoraTareas.comprobarFormatoFechaCorrecto(fecha);
        System.out.println(i++ + " " + fecha + " " + correcto);
        assertEquals(expResult, result);
    }

    @Parameters
    public static Collection<Object[]> ValidDateProvider() {
       
        return Arrays.asList(new Object[][]{
            new Object[]{"1/1/2010", true}, new Object[]{"01/01/2020", true},
            new Object[]{"31/1/2010", true}, new Object[]{"31/01/2020", true},
            new Object[]{"29/2/2008", true}, new Object[]{"29/02/2008", true},
            new Object[]{"28/2/2009", true}, new Object[]{"28/02/2009", true},
            new Object[]{"31/3/2010", true}, new Object[]{"31/03/2010", true},
            new Object[]{"30/4/2010", true}, new Object[]{"30/04/2010", true},
            new Object[]{"31/5/2010", true}, new Object[]{"31/05/2010", true},
            new Object[]{"30/6/2010", true}, new Object[]{"30/06/2010", true},
            new Object[]{"31/7/2010", true}, new Object[]{"31/07/2010", true},
            new Object[]{"31/8/2010", true}, new Object[]{"31/08/2010", true},
            new Object[]{"30/9/2010", true}, new Object[]{"30/09/2010", true},
            new Object[]{"31/10/2010", true}, new Object[]{"31/10/2010", true},
            new Object[]{"30/11/2010", true}, new Object[]{"30/11/2010", true},
            new Object[]{"31/12/2010", true}, new Object[]{"31/12/2010", true},
            
            new Object[]{"32/1/2010", false}, new Object[]{"32/01/2020", false},
            new Object[]{"1/13/2010", false}, new Object[]{"01/01/1820", true},
            new Object[]{"29/2/2007", false}, new Object[]{"29/02/2007", false},
            new Object[]{"30/2/2008", false}, new Object[]{"31/02/2008", false},
            new Object[]{"29/a/2008", false}, new Object[]{"a/02/2008", false},
            new Object[]{"333/2/2008", false}, new Object[]{"29/02/200a", false},
            new Object[]{"31/4/2010", false}, new Object[]{"31/04/2010", false},
            new Object[]{"31/6/2010", false}, new Object[]{"31/06/2010", false},
            new Object[]{"31/9/2010", false}, new Object[]{"31/09/2010", false},
            new Object[]{"31/11/2010", false}
                });
    }

}
