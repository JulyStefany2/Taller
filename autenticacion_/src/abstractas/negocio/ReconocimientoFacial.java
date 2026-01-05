package abstractas.negocio;

public class ReconocimientoFacial extends MetodoAutenticacion{
    String patronRostro;

    public ReconocimientoFacial(int nivelDeSeguridad, String patronRostro) {
        super(nivelDeSeguridad, "Reconocimiento Facial");
        this.patronRostro = patronRostro;
    }

    public String getPatronRostro() {
        return patronRostro;
    }

    public void setPatronRostro(String patronRostro) {
        this.patronRostro = patronRostro;
    }

    @Override
    public String toString(){
        return super.toString()+"\nReconocimiento facial: "+patronRostro;
    }

    @Override
    public boolean autentcar(String patron){
        if (patronRostro.contains(patron))
            return true;
        return false;
    }
}
