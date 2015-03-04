/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.ArrayListDato;
import proyectoempresalvp.datos.Cliente;
import proyectoempresalvp.datos.Dato;
import proyectoempresalvp.datos.DocumentoPDF;
import proyectoempresalvp.gestoras.Datos.GestoraDatos;

/**
 *
 * @author Oscar
 */
public class GestoraArchivos extends Thread {

    
    
    @Override
    public void run() {

        comprobarArchivos();
    }

    public void comprobarArchivos() {

        ArrayListDato<Dato> clientes = GestoraDatos.dameGestora().get(Cliente.getTabla());
        String raiz = GestoraConfiguracion.get("RUTA").toString() + "/";
        if(clientes != null) {

            for(Dato c :clientes) {

                comprobarArchivo(c, raiz);
            }
        }

    }

    private void comprobarArchivo(Dato c, String raiz) {
        File f;
        try {
            f = new File(raiz + c.get("NUMEROCLIENTE").toString() + "_" + c.get("DESCRIPCION").toString().replace(" ", "_"));
            if(!f.exists()) {
                f.createNewFile();
            }
        } catch(IOException ex) {
            Logger.getLogger(GestoraArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void guardarPDF(DocumentoPDF d){
        
        
    }
}
