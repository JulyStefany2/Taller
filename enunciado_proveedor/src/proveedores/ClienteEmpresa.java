package proveedores;
import java.util.ArrayList;
import java.util.List;

public class ClienteEmpresa {
    private String nombre;
    private List<Proveedor> proveedores;

    public ClienteEmpresa(String nombre) {
        this.nombre = nombre;
        this.proveedores = new ArrayList<>();
    }

    public void contratarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public boolean tieneProveedorTipo(String tipo) {
        for (Proveedor p : proveedores) {
            if (p.getTipoProveedor().equalsIgnoreCase(tipo)) {
                return true;
            }
        }
        return false;
    }

    public void listarContratosActivos() {
        System.out.println("Contratos activos del cliente: " + nombre);
        for (Proveedor p : proveedores) {
            for (Contrato c : p.getContratos()) {
                if (c.estaActivo()) {
                    System.out.println(p.getNombre() + " -> " + c);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ClienteEmpresa{" +
                "nombre='" + nombre + '\'' +
                ", proveedores=" + proveedores.size() +
                '}';
    }
}
