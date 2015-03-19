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
public class Fecha implements Comparable<Fecha>{
    
    int dia;
    int mes;
    int año;
    
    /**
     * Crea un objeto que representa una fecha
     * @param fecha La fecha en formato dd/mm/aaaa
     */
    public Fecha(String fecha) {
        
        String[] f = fecha.split("/");
        this.dia = Integer.parseInt(f[0]);
        this.mes = Integer.parseInt(f[1]);
        this.año = Integer.parseInt(f[2]);
    }
    
    private Fecha(Fecha fecha) {
        
        this.dia = fecha.getDia();
        this.mes = fecha.getMes();
        this.año = fecha.getAño();
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

    @Override
    public int compareTo(Fecha o) {
        
        if(año != o.año)
            return año > o.año ? 1 : -1;
        if(mes != o.mes)
            return mes > o.mes ? 1 : -1;
        if(dia != o.dia)
            return dia > o.dia ? 1 : -1;
        
        return 0;
    }
    
    
    public Fecha clonar(){
        
        return new Fecha(this);
    }
    
}
