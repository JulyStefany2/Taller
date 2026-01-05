package util;
import negocio.Automovil;
import negocio.Motocicleta;
import negocio.Propietario;
import negocio.Vehiculo;

import java.util.ArrayList;
import java.util.List;
public class Utilitario {
    private List<Propietario>propietarios;
    private List<Vehiculo>vehiculos;

    public Utilitario(){
        propietarios=new ArrayList<>();
        vehiculos=new ArrayList<>();
    }
    public void agregarAutomovil(String marca, String modelo, int anio, Propietario propietario, String tipodeauto, String traccion){
        vehiculos.add(new Automovil(marca, modelo, anio, propietario, tipodeauto, traccion));
    }
    public void agregarPropietario(String cedula, String nombre, String telefono){
        propietarios.add(new Propietario(cedula,nombre, telefono));
    }
    public void agregarMoto(String marca, String modelo, int anio, Propietario propietario, int altura, String encendido){
        vehiculos.add(new Motocicleta(marca, modelo, anio, propietario, altura, encendido));
    }

    //for de colecciones
    public Propietario buscarPropietario(String cedula){
        for (Propietario p: propietarios){
            if (p.getCedula().equals(cedula)){
                return p;
            }
        }
        return null;
    }

    //Retorno de la lista completa
    public List<Vehiculo> buscarVehiculoMarca(String marca){
        List<Vehiculo> lista=new ArrayList<>();
        for (Vehiculo v: vehiculos){
            if (v.getMarca().equalsIgnoreCase(marca)){
                lista.add(v);
            }
        }
        return lista;
    }

    public String listarPropietarios(){
        String mensaje=" ";
        for (Propietario p: propietarios){
            mensaje+=p;
            mensaje+="\n";
        }
        return mensaje;
    }

    public String listarVehiculos(){
        StringBuilder sb= new StringBuilder();
        for (Vehiculo v: vehiculos){
            sb.append(v);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String listarAutomoviles(){
        StringBuilder sb= new StringBuilder();
        for (Vehiculo v: vehiculos){
            if (v instanceof  Automovil) {
                sb.append(v);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String listarMotocicletas(){
        StringBuilder sb= new StringBuilder();
        for (Vehiculo v: vehiculos){
            if (v instanceof  Motocicleta) {
                sb.append(v);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String mostrarAutomovilesMarca(String marca){
        StringBuilder sb= new StringBuilder();
        for (Vehiculo v: vehiculos){
            if (v instanceof  Automovil) {
                if (v.getMarca().equalsIgnoreCase(marca)) {
                    Automovil a=(Automovil)v ;
                sb.append("Anio: "+a.getAnio());
                sb.append("Propietario: "+a.getPropietario().getNombre());
                sb.append("Traccion: "+a.getTraccion());
                sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    public void menu(){
        System.out.println("********Sistema Vehicular*******");
        System.out.println("1.Ingresar propietario");
        System.out.println("2.Ingresar automivil");
        System.out.println("3.Ingresar moto");
        System.out.println("4.Mostrar propietarios");
        System.out.println("5.Mostrar vehiculos");
        System.out.println("6.Mostrar vehiculos por marca");
        System.out.println("7.Mostrar automoviles");
        System.out.println("8.Mostrar motos");
        System.out.println("9.Mostrar Traccion vehiculos por marca");
        System.out.println("10.Matricular");
        System.out.println("11.Salir");
    }

    public int matricular(String  cedula, String marca, int anio){
        for (Vehiculo v: vehiculos){
            if (v.getMarca().equalsIgnoreCase(marca)){
                if (v.getAnio()==anio){
                    if (v.getPropietario().getCedula().equals(cedula)){
                        return v.matricular();
                    }
                }
            }
        }
        return -1;
    }
}

