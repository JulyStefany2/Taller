package proveedores;

import java.util.ArrayList;
import java.util.List;

public abstract class Proveedor {
    private String nombre;
    private String pais;
    private List<Contrato> contratos;

    public Proveedor(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.contratos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public abstract String getTipoProveedor();

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", tipo='" + getTipoProveedor() + '\'' +
                '}';
    }
}
