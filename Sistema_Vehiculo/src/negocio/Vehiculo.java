package negocio;

public abstract class Vehiculo {
    private String marca, modelo;
    private int anio;

    private Propietario propietario;

    public Vehiculo(String marca, String modelo, int anio, Propietario propietario) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.propietario = propietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return
                "marca: " + marca +
                "\nmodelo: " + modelo +
                "\nanio: " + anio +
                "\npropietario: " + propietario;
    }

    public abstract int matricular();
}
