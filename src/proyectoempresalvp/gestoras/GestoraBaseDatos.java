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
import proyectoempresalvp.datos.Dato;

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
    
    public static void insertarDatos(Dato d){
        String[] claves = d.devuelveOrdenDeColumnas(); 
        StringBuilder sentencia = new StringBuilder("insert into ");
        sentencia.append(d.devuelveNombreTablaDato());   
        sentencia.append("("); 
        for(String clave : claves){
        
            sentencia.append(clave).append(",");
        }
        sentencia.replace(sentencia.length() - 1, sentencia.length(), ")");
        sentencia.append(" VALUES(");
        
            
        for(String clave : claves){
            
            
            Object rec = d.get(clave);
            if(rec instanceof String){
                
                sentencia.append("'");
                sentencia.append(rec);
                sentencia.append("'");
            }else if(rec instanceof Integer){
                
                sentencia.append(rec);
            }else if(rec instanceof Float){
                
                sentencia.append(rec);
            }
            sentencia.append(" ,");            
        }
        
        sentencia.replace(sentencia.length() - 2, sentencia.length(), ");");
        
        System.out.println(sentencia.toString());
    GestoraBaseDatos.ejecutarSentencia(sentencia.toString());
    }
}
