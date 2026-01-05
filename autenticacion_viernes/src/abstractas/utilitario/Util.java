package abstractas.utilitario;

import abstractas.negocio.Empleado;
import abstractas.negocio.HuellaDigital;

import java.util.ArrayList;
import java.util.List;

//En esta clase se crean todos los listados y todos los requerimientos necesarios

public class Util {
    private List<Empleado> empleados;

    public Util(){
        empleados=new ArrayList<>();
    }

    public void agregarEmpleados(String cedula, String nombre){
        int indice=buscarEmpleado(cedula);
        if (indice==-1)
            empleados.add(new Empleado(cedula, nombre));
        else
            System.out.println("l empleado ya existe");
    }

    public int buscarEmpleado(String cedula){
        for (int i=0; i<empleados.size(); i++){
            if (empleados.get(i).getCedula().equals(cedula))
                return i;
        }
        return -1;
    }

    public void agregarAutenticacionHuella(String cedula, int nivelSeguridad, String patron){
        int indice=buscarEmpleado(cedula);
        if (indice !=-1){
            empleados.get(indice).agregarAutenticacion(new HuellaDigital(nivelSeguridad, patron));
        }
        else {
            System.out.println("Empleado no existe");
        }
    }

    public int cantidadAutenticcionHuella(String cedula){
        int indice=buscarEmpleado(cedula);
        if (indice !=-1){
            return empleados.get(indice).cantidadAutenticacionesHuella();
        }
        else {
            System.out.println("Empleado no existe");
            return -1;
        }
    }

    public String autenticacionesUmbralMayor(String cedula, int umbral){
        int indice=buscarEmpleado(cedula);
        if (indice !=-1){
            return empleados.get(indice).autenticaionesMayorUmbral(umbral);
        }
        else {
            return "Empleado no existe";
        }
    }

    //se puede elejir cualquiera de los dos
    public Boolean autenticarEmpleado(String cedula, String tipo, String patron){
        int indice=buscarEmpleado(cedula);
        if (indice !=-1){
            return empleados.get(indice).autenticar(tipo, patron);
        }
        else {
            return false;
        }
    }
    //public String autenticarEmpleado(String cedula, String tipo, String patron){}
}
