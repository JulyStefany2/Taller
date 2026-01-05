package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Automovil extends Vehiculo{
    private String tipodeauto;
    private  String traccion;

    public Automovil(String marca, String modelo, int anio, Propietario propietario, String tipodeauto, String traccion) {
        super(marca, modelo, anio, propietario);
        this.tipodeauto = tipodeauto;
        this.traccion = traccion;
    }

    public String getTipodeauto() {
        return tipodeauto;
    }

    public void setTipodeauto(String tipodeauto) {
        this.tipodeauto = tipodeauto;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return super.toString()+
                "tipo:" + tipodeauto+
                "\ntraccion='" + traccion;
    }

    @Override
    public int matricular(){
        GregorianCalendar gc=new GregorianCalendar();
        int anio= gc.get(Calendar.YEAR);
        int anioAntiguedad= anio-getAnio();
        int calculo=400-anioAntiguedad*20;
        if(calculo>20){
            return calculo;
        }
        else {
            return 20;
        }

    }
}
