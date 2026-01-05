package ejerPersona;

public class AlumnoPregrado extends Alumno{
    private String carrea;

    public AlumnoPregrado(String cedula, String nombre, String uiversidad, String carrea) {
        super(cedula, nombre, uiversidad);
        this.carrea = carrea;
    }

    public String getCarrea() {
        return carrea;
    }

    public void setCarrea(String carrea) {
        this.carrea = carrea;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ncarrea='" + carrea;
    }
}
