package interfaz;

import negocio.Propietario;
import negocio.Vehiculo;
import util.Utilitario;

import java.util.List;
import java.util.Scanner;

public class MainVehiculo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Utilitario u=new Utilitario();
        String cedula;
        String nombre;
        String telefono;
        String marca;
        String modelo;
        int anio;

        int opcion;

        do {
            System.out.println("******** Sistema Vehicular ********");
            System.out.println("1. Ingresar propietario");
            System.out.println("2. Ingresar automóvil");
            System.out.println("3. Ingresar motocicleta");
            System.out.println("4. Mostrar propietarios");
            System.out.println("5. Mostrar vehículos");
            System.out.println("6. Buscar vehículos por marca");
            System.out.println("7.Mostrar automoviles");
            System.out.println("8.Mostrar motos");
            System.out.println("9.Mostrar Traccion vehiculos por marca");
            System.out.println("10.Matricular");
            System.out.println("11.Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {

                case 1:
                    System.out.print("Ingrese cédula: ");
                    cedula = sc.nextLine();
                    Propietario pr=u.buscarPropietario(cedula);
                    if (pr==null) {
                        System.out.print("Ingrese nombre: ");
                        nombre = sc.nextLine();
                        System.out.print("Ingrese teléfono: ");
                        telefono = sc.nextLine();
                        u.agregarPropietario(cedula, nombre, telefono);
                        System.out.println("Propietario registrado con éxito.");
                    }
                    else {
                        System.out.println("Propietario ya existe");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese cédula del propietario: ");
                    cedula = sc.nextLine();
                    Propietario p1 = u.buscarPropietario(cedula);

                    if (p1 == null) {
                        System.out.println("Propietario NO encontrado.");
                        break;
                    }
                    System.out.print("Ingrese marca: ");
                    marca = sc.nextLine();
                    System.out.print("Ingrese modelo: ");
                    modelo = sc.nextLine();
                    System.out.print("Ingrese año: ");
                    anio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese tipo de auto: ");
                    String tipoAuto = sc.nextLine();
                    System.out.print("Ingrese tipo de tracción: ");
                    String traccion = sc.nextLine();
                    u.agregarAutomovil(marca, modelo, anio, p1, tipoAuto, traccion);
                    System.out.println("Automóvil registrado con éxito.");
                    break;

                case 3:
                    System.out.print("Ingrese cédula del propietario: ");
                    cedula = sc.nextLine();
                    Propietario p2 = u.buscarPropietario(cedula);

                    if (p2 == null) {
                        System.out.println("Propietario NO encontrado.");
                        break;
                    }
                    System.out.print("Ingrese marca: ");
                    marca = sc.nextLine();
                    System.out.print("Ingrese modelo: ");
                    modelo = sc.nextLine();
                    System.out.print("Ingrese año: ");
                    anio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese altura en cm: ");
                    int altura = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese tipo de encendido: ");
                    String encendido = sc.nextLine();
                    u.agregarMoto(marca, modelo, anio, p2, altura, encendido);
                    System.out.println("Motocicleta registrada con éxito.");

                    break;

                case 4:
                    System.out.println("\n--- Lista de Propietarios ---");
                    System.out.println(u.listarPropietarios());
                    break;

                case 5:
                    System.out.println("\n--- Lista de Vehículos ---");
                    System.out.println(u.listarVehiculos());
                    break;

                case 6:
                    System.out.print("Ingrese la marca a buscar: ");
                    marca = sc.nextLine();
                    List<Vehiculo> listaMarca = u.buscarVehiculoMarca(marca);
                    if (listaMarca.isEmpty()) {
                        System.out.println("No se encontraron vehículos con esa marca.");
                    } else {
                        System.out.println("\n--- Vehículos encontrados ---");
                        for (Vehiculo v : listaMarca) {
                            System.out.println(v);
                            System.out.println("---------------------");
                        }
                    }
                    break;

                case 7:
                    System.out.println("\n--- Automóviles ---");
                    System.out.println(u.listarAutomoviles());
                    break;

                case 8:
                    System.out.println("\n--- Automóviles ---");
                    System.out.println(u.listarMotocicletas());
                    break;

                case 9:
                    System.out.println("Marca: ");
                    String marc=sc.nextLine();
                    System.out.println(u.mostrarAutomovilesMarca(marc));
                    break;

                case 10:
                    System.out.println("Matricular: ");
                    System.out.println("\nIngrese cedula: ");
                    cedula= sc.nextLine();
                    System.out.println("\nIngrese marca dedl vehiculo: ");
                    marca= sc.nextLine();
                    System.out.println("\nIngrese el anio: ");
                    anio=Integer.parseInt(sc.nextLine());
                    int valor= u.matricular(cedula, marca, anio);
                    if (valor!=-1){
                        System.out.println("\nEl valor a pagar es: "+valor);
                    }
                    else {
                        System.out.println("\nNo fue posible realizar la matricula...");
                    }
                    break;

                case 11:
                    System.out.println("Saliendo chan chan chan...");
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 11);

        sc.close();
    }
}
