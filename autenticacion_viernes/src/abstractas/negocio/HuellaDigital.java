package abstractas.negocio;

public class HuellaDigital extends MetodoAutenticacion{
    private String patronHuella;

    public HuellaDigital(int nivelDeSeguridad, String patronHuella) {
        super(nivelDeSeguridad,  "Huella digital");
        this.patronHuella = patronHuella;
    }

    public String getPatronHuella() {
        return patronHuella;
    }

    public void setPatronHuella(String patronHuella) {
        this.patronHuella = patronHuella;
    }

    @Override
    public String toString(){
        return super.toString()+"\nPatron Huella: "+patronHuella;
    }

    @Override
    public boolean autentcar(String patron){
        if (patronHuella.contains(patron))
            return true;
        return false;
    }
}
