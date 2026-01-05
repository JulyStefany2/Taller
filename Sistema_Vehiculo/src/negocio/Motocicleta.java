package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Motocicleta extends Vehiculo{
    private int altura;
    private String encendido;

    public Motocicleta(String marca, String modelo, int anio, Propietario propietario, int altura, String encendido) {
        super(marca, modelo, anio, propietario);
        this.altura = altura;
        this.encendido = encendido;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getEncendido() {
        return encendido;
    }

    public void setEncendido(String encendido) {
        this.encendido = encendido;
    }

    @Override
    public String toString() {
        return super.toString()+
                "altura: " + altura +
                "\nencendido: " + encendido;
    }

    @Override
    public int matricular(){
        GregorianCalendar gc=new GregorianCalendar();
        int anio= gc.get(Calendar.YEAR);
        int anioAntiguedad= anio-getAnio();
        int calculo=250-anioAntiguedad*10;
        if(calculo>10){
            return calculo;
        }
        else {
            return 10;
        }

    }
}
