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
    Dato d;
    
    public ModeloTabla(Dato[] datos) {
        
        this.datos = datos;
        filas = datos.length;    
        
        if(datos.length != 0){
            
            for(Dato d : datos){
                
                if(d != null){
                    clases = d.devuelveClases();
                    columnas = d.keySet().toArray(new String[d.keySet().size()]);
                    break;
                }
            }
        }
    }
    
   @Override
    public int getRowCount() {
        
        return filas;
    }

    @Override
    public int getColumnCount() {
        
        return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {        
        
        return columnas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        
        return clases[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(datos.length > 0){
            
            if(columnIndex == 0){
            d = datos[rowIndex];
            }
            if(d != null){
                return d.get(columnas[columnIndex]);
            }
        }
        
        return null;        
    }
    
    
}
