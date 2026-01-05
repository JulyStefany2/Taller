package proveedores;

public class ProveedorPasarelaPago extends Proveedor{
    public ProveedorPasarelaPago(String nombre, String pais) {
        super(nombre, pais);
    }

    @Override
    public String getTipoProveedor() {
        return "Pasarela de Pago";
    }
}
