package abstractas.negocio;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String cedula;
    private String nombre;
    private List<MetodoAutenticacion>autenticaciones;

    public Empleado(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        autenticaciones=new ArrayList<>();
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public List<MetodoAutenticacion> getAutenticaciones() {
        return autenticaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAutenticacion(MetodoAutenticacion me){
        autenticaciones.add(me);
    }

    public int cantidadAutenticacionesHuella(){
        int cont=0;
        for (MetodoAutenticacion me: autenticaciones){
            if (me instanceof HuellaDigital)
                cont++;
        }
        return cont;
    }
    //terminar el resto de metodos de auenticacion

    public String autenticaionesMayorUmbral(int umbral){
        String autenticacion= "";
        for (MetodoAutenticacion me: autenticaciones){
            if (me.getNivelDeSeguridad()>umbral){
                autenticacion += me.getTipo();
                //que quiere mostrar

            }
        }
        return autenticacion;
    }

    public boolean autenticar(String tipo, String patron){
        for (MetodoAutenticacion me: autenticaciones){
            if (me.getTipo().equalsIgnoreCase(tipo)){
                if (me.autentcar(patron))
                    return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return "Cedula: "+cedula+"\nNombre: "+nombre+"\nAutenticaciones: \n"+autenticaciones;
    }
}
