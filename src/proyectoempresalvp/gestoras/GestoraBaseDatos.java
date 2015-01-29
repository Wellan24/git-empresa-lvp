/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.Fecha;

/**
 *
 * @author Oscar
 */
public class GestoraBaseDatos {

    private static Connection conexion;
    private static Statement sentencia;

    public static boolean conectarBaseDatos() {

        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

            if(GestoraBaseDatos.conexion == null) {
                GestoraBaseDatos.conexion = DriverManager.getConnection("jdbc:ucanaccess://../DataBase/BaseDeDatosLVP.accdb");
            }

            if(sentencia == null) {
                sentencia = GestoraBaseDatos.conexion.createStatement();
            }

        } catch(ClassNotFoundException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch(SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }

    public static boolean ejecutarSentenciaUpdate(String textoSentencia) {

        try {
            if(sentencia == null) {
                sentencia = GestoraBaseDatos.conexion.createStatement();
            }
System.out.println(textoSentencia);
            int result = sentencia.executeUpdate(textoSentencia);
            
            return result == 1;
        } catch(SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * @param textoSentencia
     * @return Devuelve un ResultSet con los datos de la consulta o null si hay una excepción
     */
    public static ResultSet ejecutarSentenciaQuery(String textoSentencia) {

        Statement sentenciaLocal;
        ResultSet dev = null;
        try {

            sentenciaLocal = GestoraBaseDatos.conexion.createStatement();
            dev = sentenciaLocal.executeQuery(textoSentencia);
        } catch(SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dev;
    }

    public static void cerrarConexion() {

        try {

            GestoraBaseDatos.sentencia.close();
            GestoraBaseDatos.conexion.commit();
            GestoraBaseDatos.conexion.close();
        } catch(SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean insertarDato(Dato d) {

        String[] claves = d.devuelveOrdenDeColumnas();

        if(!comprobarExiste(d)) {

            StringBuilder textoSentencia = construyeSentenciaInsert(d, claves);

            System.out.println(textoSentencia.toString());
            GestoraBaseDatos.ejecutarSentenciaUpdate(textoSentencia.toString());
            return comprobarExiste(d);
        }
        return false;
    }

    public static boolean comprobarExiste(Dato d) {
        String primaryKey = d.devuelveClave();
        try {
            if(!primaryKey.contains(" ")) {

                ResultSet rs = sentencia.executeQuery("Select " + primaryKey + " from " + d.devuelveNombreTablaDato()
                        + " where " + primaryKey + " = "
                        + ((d.get(primaryKey) instanceof String) ? "'" + d.get(primaryKey) + "'" : d.get(primaryKey)));

                return rs.next();

            } else {
                String[] key = primaryKey.split(" ");
                ResultSet rs = sentencia.executeQuery("Select " + key[0] + ", " + key[1] + " from " + d.devuelveNombreTablaDato()
                        + " where " + key[0] + " = "
                        + ((d.get(key[0]) instanceof String) ? "'" + d.get(key[0]) + "'" : d.get(key[0]))
                        + " AND " + key[1] + " = "
                        + ((d.get(key[1]) instanceof String) ? "'" + d.get(key[1]) + "'" : d.get(key[1]))
                );

                return rs.next();
            }
        } catch(SQLException ex) {
            Logger.getLogger(GestoraBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static StringBuilder construyeSentenciaInsert(Dato d, String[] claves) {

        StringBuilder textoSentencia = new StringBuilder("insert into ");
        textoSentencia.append(d.devuelveNombreTablaDato());
        textoSentencia.append("(");
        for(String clave :claves) {

            textoSentencia.append(clave).append(",");
        }
        textoSentencia.replace(textoSentencia.length() - 1, textoSentencia.length(), ")");
        textoSentencia.append(" VALUES(");
        for(String clave :claves) {

            Object rec = d.get(clave);
            if(rec instanceof String || rec instanceof Fecha) {

                textoSentencia.append("'");
                textoSentencia.append(rec.toString());
                textoSentencia.append("'");
            } else if(rec instanceof Integer) {

                textoSentencia.append(rec);
            } else if(rec instanceof Float) {

                textoSentencia.append(rec);
            } else {

                textoSentencia.append(rec);
            }
            textoSentencia.append(" ,");
        }
        textoSentencia.replace(textoSentencia.length() - 2, textoSentencia.length(), ");");

        return textoSentencia;
    }

    public static boolean updateDato(Dato d) {

        if(comprobarExiste(d)) {

            return ejecutarSentenciaUpdate(construyeSentenciaUpdate(d).toString());
        }

        return false;
    }

    public static StringBuilder construyeSentenciaUpdate(Dato d) {

        String[] claves = d.devuelveOrdenDeColumnas();
        StringBuilder textoSentencia = new StringBuilder("update ");
        textoSentencia.append(d.devuelveNombreTablaDato());
        textoSentencia.append(" set ");
        for(int i = 1; i < claves.length; i++) {

            Object rec = d.get(claves[i]);
            textoSentencia.append(claves[i]).append("=");

            if(rec instanceof String || rec instanceof Fecha) {

                textoSentencia.append("'");
                textoSentencia.append(rec.toString());
                textoSentencia.append("'");
            } else if(rec instanceof Integer) {

                textoSentencia.append(rec);
            } else if(rec instanceof Float) {

                textoSentencia.append(rec);
            } else {

                textoSentencia.append(rec);
            }
            textoSentencia.append(" ,");
        }

        textoSentencia.replace(textoSentencia.length() - 2, textoSentencia.length(), " where ");
        textoSentencia.append(claves[0]).append(" = ").append(d.get(claves[0]));
        return textoSentencia;
    }

    public static String construyeSentenciaSelect(String[] claves, String nombreTabla) {

        StringBuilder dev = new StringBuilder("Select ");

        for(String clave :claves) {

            dev.append(clave).append(",");
        }

        dev.replace(dev.length() - 1, dev.length(), " from " + nombreTabla);
        return dev.toString();
    }
}
