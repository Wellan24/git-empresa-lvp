/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.AbstractListModel;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.FacturaExtraDetalles;

/**
 *
 * @author Oscar
 */
    public class ListModel extends AbstractListModel{

    private final ArrayList<Dato> lista;

    public ListModel() {
        lista = new ArrayList<>();
    }       
    public ListModel(ArrayList<Dato> lista ) {
        this.lista = lista;
    }     
    @Override
    public int getSize() {
        return lista.size();
    }
    @Override
    public Object getElementAt(int index) {
        return lista.get(index).toString();
    }
    public void addDato(Dato f){
        lista.add(f);
        Collections.sort(lista);
        this.fireIntervalAdded(this, getSize(), getSize()+1);
    }
    public Dato eliminarDato(int index0){
        Dato d = lista.remove(index0);
        Collections.sort(lista);
        this.fireIntervalRemoved(index0, getSize(), getSize()+1);
        return d;
    }
    public Dato getDato(int index){
        return lista.get(index);
    }
    public ArrayList<Dato> getLista() {
        return lista;
    }  
}

