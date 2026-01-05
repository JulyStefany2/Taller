package proveedores;

public class MainProveedores {
    public static void main(String[] args) {
        Proveedor cloud = new ProveedorCloud("AWS", "USA");
        Proveedor saas = new ProveedorSaaS("Google Workspace", "USA");
        Proveedor pago = new ProveedorPasarelaPago("PayPal", "USA");

        // Crear contratos
        Contrato c1 = new Contrato(300.0, 12);
        Contrato c2 = new Contrato(150.0, 0);
        Contrato c3 = new Contrato(500.0, 24);

        cloud.agregarContrato(c1);
        saas.agregarContrato(c2);
        pago.agregarContrato(c3);

        // Crear cliente
        ClienteEmpresa cliente = new ClienteEmpresa("Tech Solutions");

        // Asociar proveedores
        cliente.contratarProveedor(cloud);
        cliente.contratarProveedor(saas);
        cliente.contratarProveedor(pago);

        // Verificar tipo
        System.out.println("¿Tiene proveedor Cloud?: " +
                cliente.tieneProveedorTipo("Cloud"));

        // Listar contratos activos
        cliente.listarContratosActivos();
    }
}
