package ejerPersona;

public class AlumnoMagister extends Alumno{
    private String tesis;

    public AlumnoMagister(String cedula, String nombre, String uiversidad, String tesis) {
        super(cedula, nombre, uiversidad);
        this.tesis = tesis;
    }

    public String getTesis() {
        return tesis;
    }

    public void setTesis(String tesis) {
        this.tesis = tesis;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\ntesis='" + tesis;
    }
}
