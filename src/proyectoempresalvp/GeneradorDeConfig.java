/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.Configuracion;
import proyectoempresalvp.gestoras.Gestora;
import proyectoempresalvp.gestoras.GestoraConfiguracion;

/**
 *
 * @author Oscar
 */
public class GeneradorDeConfig {

    public static void main(String... args) {

        String ruta = "../config.xml";
        Configuracion config = new Configuracion();
        
        config.put("IVA", 21);
        String contra = Gestora.devuelveHash("PASS");
        config.put("CONTRA", contra);
        config.put("RUTA", "D:/Clientes");
        config.put("NUMPROXIMAFACTURA", 0);
        try(XMLEncoder out = new XMLEncoder(new FileOutputStream(ruta))) {

            HashMap<String, Object> hash = new HashMap(config);
            out.writeObject(hash);

        } catch(FileNotFoundException ex) {
            Logger.getLogger(GestoraConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
