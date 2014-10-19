/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import javax.swing.table.DefaultTableModel;
import proyectoempresalvp.datos.Dato;

/**
 *
 * @author Oscar
 */
public class ModeloTabla extends DefaultTableModel{

    int filas;
    Dato[] datos;
    String[] columnas = {"ID", "NOMBRE"};
    Class[] clases = {Integer.class, String.class};
    
    public ModeloTabla(Dato[] datos) {
        
        this.datos = datos;
        filas = datos.length;    
        
        if(datos.length != 0){
            
            for(Dato d : datos){
                
                if(d != null){
                    clases = devuelveClases(d.devuelveValoresCampos());
                    columnas = d.devuelveNombreCampos();
                    break;
                }
            }
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        return super.getValueAt(row, column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return super.getColumnCount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
