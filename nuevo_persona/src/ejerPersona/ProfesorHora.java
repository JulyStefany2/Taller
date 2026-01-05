package ejerPersona;

public class ProfesorHora extends Profesor{
    private int hora;

    public ProfesorHora(String cedula, String nombre, String especialidad, int hora) {
        super(cedula, nombre, especialidad);
        this.hora = hora;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nhora=" + hora;
    }
}
