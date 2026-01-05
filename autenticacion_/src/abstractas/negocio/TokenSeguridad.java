package abstractas.negocio;

public class TokenSeguridad extends MetodoAutenticacion{
    private String token;

    public TokenSeguridad(int nivelDeSeguridad, String token) {
        super(nivelDeSeguridad, "Token de seguridad");
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean autentcar(String patron){
        if (token.equals(patron))
            return true;
        return false;
    }
}
