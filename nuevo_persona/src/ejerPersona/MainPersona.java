package ejerPersona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPersona {
    public static void main(String[] args) {
        List<Persona>listado=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        String nombre;
        String cedula;
        String universidad;
        String tesis;
        String carrera;
        String especialidad;
        int horas;
        int opc;
        do {
            menu();
            switch (opc){
                case 1:
                    System.out.println("Ingrese la cedula: ");
                    cedula= sc.nextLine();
                    System.out.println("Ingrese el nombre: ");
                    nombre= sc.nextLine();
                    System.out.println("Ingrese la carrea: ");
                    carrera= sc.nextLine();
                    System.out.println("Ingrese la universidad: ");
                    universidad= sc.nextLine();

                    listado.add(new AlumnoPregrado(cedula, nombre, carrera, universidad));
                    break;

                case 2:
                    System.out.println("Ingrese la cedula: ");
                    cedula = sc.nextLine();

                    System.out.println("Ingrese el nombre: ");
                    nombre = sc.nextLine();

                    System.out.println("Ingrese la universidad: ");
                    universidad = sc.nextLine();

                    System.out.println("Ingrese la tesis: ");
                    tesis = sc.nextLine();

                    listado.add(new AlumnoMagister(cedula, nombre, universidad, tesis));
                    break;

                case 3:
                    System.out.println("Ingrese la cedula: ");
                    cedula = sc.nextLine();

                    System.out.println("Ingrese el nombre: ");
                    nombre = sc.nextLine();

                    System.out.println("Ingrese la especialidad: ");
                    especialidad = sc.nextLine();

                    System.out.println("Ingrese las horas: ");
                    horas = sc.nextInt();
                    sc.nextLine();

                    listado.add(new ProfesorHora(cedula, nombre, especialidad, horas));
                    break;

                case 4:
                    for (Persona p : listado) {
                        System.out.println("-------------------");
                        System.out.println(p);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;
            }
        }while(opc != 5);
    }

    public static void menu(){
        System.out.println("1.Ingresar aumno pregrado");
        System.out.println("2.Ingresar aumno magister");
        System.out.println("3.Ingresar profesor hora");
        System.out.println("4.Mostrar listado");
        System.out.println("5.Salir");
        System.out.println("Ingrese una opcion: ");
    }
}
