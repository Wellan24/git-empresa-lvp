/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar
 */
public class GestoraBaseDatos {
    
    private static Connection conexion;
    
    public static boolean conectarBaseDatos(){
        
        try {
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            GestoraBaseDatos.conexion = DriverManager.getConnection("jdbc:ucanaccess://../DataBase/BaseDeDatosLVP.accdb"); 
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    public static void ejecutarSentencia(String sentencia){
        
        try {
            Statement s = GestoraBaseDatos.conexion.createStatement();
            
            s.executeUpdate(sentencia);
        } catch (SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cerrarConexion(){
        
        try {
            
            GestoraBaseDatos.conexion.commit();
            GestoraBaseDatos.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
