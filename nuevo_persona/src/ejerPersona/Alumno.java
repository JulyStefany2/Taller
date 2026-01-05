package ejerPersona;

public class Alumno extends Persona{
    private String uiversidad;

    public Alumno(String cedula, String nombre, String uiversidad) {
        super(cedula, nombre);
        this.uiversidad = uiversidad;
    }

    public String getUiversidad() {
        return uiversidad;
    }

    public void setUiversidad(String uiversidad) {
        this.uiversidad = uiversidad;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\nuiversidad='" + uiversidad;
    }
}
