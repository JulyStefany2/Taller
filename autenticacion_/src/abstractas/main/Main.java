package abstractas.main;

import abstractas.utilitario.Util;

public class Main {
    public static void main(String[] args) {

        Util util = new Util();

        util.agregarEmpleados("0101", "Ana");
        util.agregarAutenticacionHuella("0101", 5, "1234");

        boolean acceso = util.autenticarEmpleado(
                "0101", "Huella digital", "1234"
        );

        System.out.println("Acceso: " + acceso);
    }
}
