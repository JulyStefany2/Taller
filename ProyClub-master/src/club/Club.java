
package club;
import java.util.ArrayList;
import club.Socio.Tipo;

public class Club
{
    public final static int MAXIMO_VIP = 3;
    private ArrayList<Socio> socios;

    public Club( )
    {
        socios = new ArrayList<Socio>( );
    }

    public ArrayList<Socio> darSocios( )
    {
        return socios;
    }

    public void afiliarSocio(String pCedula, String pNombre, Tipo pTipo) throws Exception {
        if (buscarSocio(pCedula) != null) {
            throw new Exception("El socio ya existe");
        }
        if (pTipo == Tipo.VIP && contarSociosVIP() == MAXIMO_VIP) {
            throw new Exception("El club en el momento no acepta más socios VIP");
        }
        socios.add(new Socio(pCedula, pNombre, pTipo));
    }


    public Socio buscarSocio(String pCedulaSocio) {
        for (Socio s : socios) {
            if (s.darCedula().equals(pCedulaSocio)) return s;
        }
        return null;
    }

    public int contarSociosVIP() {
        int conteo = 0;
        for (Socio s : socios) {
            if (s.darTipo() == Tipo.VIP) conteo++;
        }
        return conteo;
    }

    public ArrayList<String> darAutorizadosSocio( String pCedulaSocio )
    {
        Socio s = buscarSocio( pCedulaSocio );
        ArrayList<String> autorizados = new ArrayList<String>( );

        autorizados.add( s.darNombre( ) );
        autorizados.addAll( s.darAutorizados( ) );

        return autorizados;
    }

    public void agregarAutorizadoSocio(String pCedulaSocio, String pNombreAutorizado) throws Exception {
        Socio s = buscarSocio(pCedulaSocio);
        if (s != null) {
            s.agregarAutorizado(pNombreAutorizado);
        }
    }

    public void eliminarAutorizadoSocio(String pCedulaSocio, String pNombreAutorizado) throws Exception {
        Socio s = buscarSocio(pCedulaSocio);
        if (s != null) {
            s.eliminarAutorizado(pNombreAutorizado);
        }
    }


    public void registrarConsumo(String pCedulaSocio, String pNombreCliente, String pConcepto, double pValor) throws Exception {
        Socio s = buscarSocio(pCedulaSocio);
        if (s != null) {
            s.registrarConsumo(pNombreCliente, pConcepto, pValor);
        }
    }

    public ArrayList<Factura> darFacturasSocio(String pCedulaSocio) {
        Socio s = buscarSocio(pCedulaSocio);
        return (s != null) ? s.darFacturas() : new ArrayList<Factura>();
    }

    public void pagarFacturaSocio(String pCedulaSocio, int pFacturaIndice) throws Exception {
        Socio s = buscarSocio(pCedulaSocio);
        if (s != null) {
            s.pagarFactura(pFacturaIndice);
        }
    }


    public void aumentarFondosSocio(String pCedulaSocio, double pValor) throws Exception {
        Socio s = buscarSocio(pCedulaSocio);
        if (s != null) {
            s.aumentarFondos(pValor);
        }
    }

    public double calcularTotalConsumos(String pCedula) throws Exception {
        Socio s = buscarSocio(pCedula);
        if (s == null) throw new Exception("No existe socio");
        double total = 0;
        for (Factura f : s.darFacturas()) {
            total += f.darValor();
        }
        return total;
    }

    public String sePuedeEliminarSocio(String pCedula) {
        Socio s = buscarSocio(pCedula);
        if (s == null)
            return "No existe un socio con la cédula recibida como parámetro.";
        if (s.darTipo() == Tipo.VIP)
            return "Que el socio sea de tipo VIP. No se pueden eliminar.";
        if (!s.darFacturas().isEmpty())
            return "Que el socio tenga facturas pendientes de pago. No se pueden eliminar.";
        if (s.darAutorizados().size() > 1)
            return "Que el socio tenga más de un autorizado. No se puede eliminar.";
        return "El socio puede ser eliminado.";
    }

    // -----------------------------------------------------------------
    // M�todos de Extensi�n
    // -----------------------------------------------------------------


    public String metodo1( )
    {
        return "respuesta1";
    }

    public String metodo2( )
    {
        return "respuesta2";
    }
}