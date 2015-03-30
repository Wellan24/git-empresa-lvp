/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proyectoempresalvp.datos.Cliente;
import proyectoempresalvp.datos.Contrato;
import proyectoempresalvp.datos.Empleado;
import proyectoempresalvp.datos.Fecha;
import proyectoempresalvp.gestoras.Gestora;
import proyectoempresalvp.gestoras.GestoraBaseDatos;
import proyectoempresalvp.gestoras.GestoraConfiguracion;

/**
 *
 * @author Oscar
 */
public class ImportarDataBase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        GestoraBaseDatos.conectarBaseDatos();
        GestoraConfiguracion.recuperaConfiguracion();
        Connection conDos = DriverManager.getConnection("jdbc:ucanaccess://../BaseDatosAntigua/Antigua.accdb");     
        recuperarClientes(conDos);
        recuperarEmpleados(conDos);
        recuperarContratos(conDos);
    }
    
    public static void recuperarClientes(Connection c) throws SQLException{
        
        Statement s = c.createStatement();        
        ResultSet rs = s.executeQuery("Select * from Clientes");
        GestoraBaseDatos.ejecutarSentenciaUpdate("Delete from Clientes");
        int num = 1;
        while(rs.next()){
            String cuenta = rs.getString(14) + rs.getString(15) + rs.getString(16) + rs.getString(17);
            String iban =   cuenta.isEmpty() ? "VACIO":Gestora.calcularIbanEspaña(cuenta);
            GestoraBaseDatos.insertarDato(new Cliente(num++, 
                    rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
                    Integer.parseInt(rs.getString(7).isEmpty()? "0" : rs.getString(7)), rs.getString(8), rs.getString(9), 
                    Integer.parseInt(rs.getString(10).isEmpty()? "0" : rs.getString(10)), 
                    Integer.parseInt(rs.getString(11).isEmpty()? "0" : rs.getString(11)), rs.getString(13), 0, iban, 0));
        }
    }
    
    public static void recuperarEmpleados(Connection c) throws SQLException{
        
        Statement s = c.createStatement();        
        ResultSet rs = s.executeQuery("Select * from Empleados");
        GestoraBaseDatos.ejecutarSentenciaUpdate("Delete from Empleados");
        int num = 1;
        while(rs.next()){            
            
            GestoraBaseDatos.insertarDato(new Empleado(num++, rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), Integer.parseInt(rs.getString(7).isEmpty()? "0" : rs.getString(7)), rs.getString(8), 
                    Integer.parseInt(rs.getString(9).isEmpty()? "0" : rs.getString(9)), 
                    Integer.parseInt(rs.getString(10).isEmpty()? "0" : rs.getString(10)), "", 
                    new Fecha(rs.getString(15).replace("-", "/")), new Fecha(rs.getString(15).replace("-", "/")), 
                    Integer.parseInt(rs.getString(17).isEmpty()? "0" : rs.getString(17)), 
                    rs.getString(18), "", ""));
        }
    }
    
    public static void recuperarContratos(Connection c) throws SQLException{
        
        Statement s = c.createStatement();        
        ResultSet rs = s.executeQuery("Select * from Contratos");
        GestoraBaseDatos.ejecutarSentenciaUpdate("Delete from Contratos");
        int num = 1;
        while(rs.next()){
            GestoraBaseDatos.insertarDato(new Contrato(num++, rs.getInt(2), rs.getString(3),
                    Gestora.importarFecha(rs.getString(4)), Gestora.importarFecha(rs.getString(5)),
                    rs.getString(12), rs.getString(14),  rs.getString(16), 
                    Integer.parseInt(rs.getString(17).isEmpty()? "0" : rs.getString(17)),
                    Integer.parseInt(rs.getString(18).isEmpty()? "0" : rs.getString(18)), 
                    rs.getString(15).equals("ACTIVO")));
        }
    }
    
}
