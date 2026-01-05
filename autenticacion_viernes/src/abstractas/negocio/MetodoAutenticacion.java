package abstractas.negocio;

public abstract class MetodoAutenticacion {
    private int nivelDeSeguridad;
    private String tipo;

    public MetodoAutenticacion(int nivelDeSeguridad, String tipo) {
        this.nivelDeSeguridad = nivelDeSeguridad;
        this.tipo = tipo;
    }

    public int getNivelDeSeguridad() {
        return nivelDeSeguridad;
    }

    public void setNivelDeSeguridad(int nivelDeSeguridad) {
        this.nivelDeSeguridad = nivelDeSeguridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipo: "+tipo+"\nNivel de seguridad: "+nivelDeSeguridad;
    }

    public abstract boolean autentcar(String patron);
}
