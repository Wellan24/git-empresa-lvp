/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.util.ArrayList;
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
    Dato datoActual;
    int filaActual = -1;
    
    public ModeloTabla(Dato[] datos) {
        
        this.datos = datos;
        filas = datos.length;    
        
        if(datos.length != 0){
            
            for(Dato d : datos){
                
                if(d != null){
                    clases = d.devuelveClases();
                    columnas = d.devuelveOrdenDeColumnas();
                    break;
                }
            }
        }
    }
    
    public ModeloTabla(ArrayList<Dato> datos) {
        
        this.datos = datos.toArray(new Dato[datos.size()]);
        filas = datos.size();    
        
        if(!datos.isEmpty()){
            
            for(Dato d : datos){
                
                if(d != null){
                    clases = d.devuelveClases();
                    columnas = d.devuelveOrdenDeColumnas();
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
            
            if(filaActual != rowIndex){
                datoActual = datos[rowIndex];
                filaActual = rowIndex;    
            }
            if(datoActual != null){
                return datoActual.get(columnas[columnIndex]);
            }
        }
        
        return null;        
    }
    
    
}
