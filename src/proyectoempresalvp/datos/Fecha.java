/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

/**
 *
 * @author Oscar
 */
public class Fecha {
    
    int dia;
    int mes;
    int año;

    public Fecha(String fecha) {
        
        String[] f = fecha.split("/");
        this.dia = Integer.parseInt(f[0]);
        this.mes = Integer.parseInt(f[1]);
        this.año = Integer.parseInt(f[2]);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        
        return ((dia < 10)?"0"+dia: dia) + "/" + ((mes < 10)?"0"+mes: mes)  + "/" + año; 
    } 
    
    
}
