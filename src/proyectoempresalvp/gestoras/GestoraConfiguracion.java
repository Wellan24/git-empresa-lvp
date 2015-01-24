/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.gestoras;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempresalvp.datos.Configuracion;

/**
 *
 * @author Oscar
 */
public class GestoraConfiguracion {

    private static Configuracion config;
    private static final String ruta = "../DataBase/config.xml";

    public static void guardaConfiguracion() {
        
        if(config == null) {
            config = new Configuracion();
        }
        try(XMLEncoder out = new XMLEncoder(new FileOutputStream(ruta))) {

            HashMap<String,Object> hash = new HashMap(config);
            out.writeObject(hash);

        } catch(FileNotFoundException ex) {
            Logger.getLogger(GestoraConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void recuperaConfiguracion() {

        try(XMLDecoder out = new XMLDecoder(new FileInputStream(ruta))) {

            config = new Configuracion((HashMap<String,Object>)out.readObject());

        } catch(FileNotFoundException ex) {
            Logger.getLogger(GestoraConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void put(String clave, Object value) {

        config.put(clave, value);
    }

    public static Object get(String clave) {

        return config.get(clave);
    }
}
