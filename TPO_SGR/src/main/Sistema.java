package main;

import enums.EstadoDocumentacion;
import enums.TamañoEmpresaEnum;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Comisiones;

import java.util.Date;
import java.util.List;

public class Sistema {

    private Sgr sgr;
    private List<Solicitante> solicitanteList;

    public Solicitante solicitud(Empresa empresa, TipoDeSocio tipoDeSocio){
        return null;
    }

    public void presentarDocumentacion(Solicitante solicitante, String estatuto, String balanceCertificado1, String balanceCertificado2,
                                       String balanceCertificado3, String bienesSocios){
    }

    public EstadoDocumentacion revisarDocumentacion(Solicitante solicitante){
        return null;
    }

    public Socio crearSocios(){
        return null;
    }

    public List<Comisiones> comisionesEnUnDia(Date fecha){
        return null;
    }

    public List<Operacion> operacionesDeSocio(String nombre, Date fechaDesde, Date fechaHasta){
        return null;
    }

    public Integer getPorcentajeDeComisiones(TipoDeOperacionEnum tipoDeOperacionEnum){
        return null;
    }

    public void consultaConsolidada(String nombre){

    }

    public double promedioTasaDescuentoYTotalOperado(TamañoEmpresaEnum tamañoEmpresaEnum, Date fechaDesde, Date fechaHasta){
        return 123;
    }

}
