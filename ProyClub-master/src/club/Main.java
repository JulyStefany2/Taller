package club;

import java.util.ArrayList;
import java.util.Scanner;
import club.Socio.Tipo;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int op;
        Club c = new Club();

        do{
            System.out.println("1. Afiliar un socio al club.");
            System.out.println("2. Registrar una persona autorizada por un socio.");
            System.out.println("3. Pagar una factura.");
            System.out.println("4. Registrar un consumo en la cuenta de un socio");
            System.out.println("5. Aumentar fondos de la cuenta de un socio");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            op = Integer.parseInt(sc.next());
            switch (op){
                case 1:{
                    System.out.print("Cedula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    System.out.print("Tipo (1. VIP, 2. REGULAR): ");
                    int t = Integer.parseInt(sc.nextLine());
                    Tipo tipoSocio = (t == 1) ? Tipo.VIP : Tipo.REGULAR;

                    c.afiliarSocio(ced, nom, tipoSocio);
                    System.out.println("Socio afiliado.");
                }break;

                case 2:{
                    System.out.print("Cedula del socio: ");
                    String cedulaSocio = sc.nextLine();
                    System.out.print("Nombre del autorizado: ");
                    String nombreAut = sc.nextLine();

                    c.agregarAutorizadoSocio(cedulaSocio, nombreAut);
                    System.out.println("Autorizado registrado.");
                }break;

                case 3:{
                    System.out.print("Cedula del socio: ");
                    String cedulaSocio = sc.nextLine();
                    ArrayList<Factura> facturas = c.darFacturasSocio(cedulaSocio);

                    for (int i = 0; i < facturas.size(); i++) {
                        System.out.println(i + ". " + facturas.get(i).toString());
                    }
                    System.out.print("Ingrese el indice de la factura a pagar: ");
                    int indice = Integer.parseInt(sc.nextLine());
                    c.pagarFacturaSocio(cedulaSocio, indice);
                    System.out.println("Factura pagada.");
                }break;

                case 4:{
                    System.out.print("Cedula del socio: ");
                    String cedulaSocio = sc.nextLine();
                    System.out.print("Nombre cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Concepto: ");
                    String concepto = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = Double.parseDouble(sc.nextLine());

                    c.registrarConsumo(cedulaSocio, cliente, concepto, valor);
                    System.out.println("Consumo registrado.");
                }break;
                case 5:{
                    System.out.print("Cedula del socio: ");
                    String cedulaSocio = sc.nextLine();
                    System.out.print("Monto a aumentar: ");
                    double monto = Double.parseDouble(sc.nextLine());

                    c.aumentarFondosSocio(cedulaSocio, monto);
                    System.out.println("Fondos actualizados.");
                }break;

                case 6:{
                    System.out.println("Gracias!");
                }break;

                default:
                    System.out.println("opcion invalida");
            }

        }while(op!=6);
    }
}