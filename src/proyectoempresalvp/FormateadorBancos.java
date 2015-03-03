/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import proyectoempresalvp.datos.Banco;
import proyectoempresalvp.gestoras.GestoraBaseDatos;

/**
 *
 * @author Oscar
 */
public class FormateadorBancos {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        GestoraBaseDatos.conectarBaseDatos();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("../bancos.txt")));

        Banco bActual;
        while(in.ready()) {

            String temp = in.readLine();
            if(!temp.endsWith("DUMMY")) {

                String[] banco = temp.split("\t");
                System.out.println(banco[0] + " | " + banco[1]);
                bActual = new Banco(Integer.parseInt(banco[0]), banco[1]);
                GestoraBaseDatos.insertarDato(bActual);
            }
        }

        GestoraBaseDatos.cerrarConexion();
    }

}
