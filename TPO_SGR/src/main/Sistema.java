package main;

import Responses.ConsultaConsolidadaResponse;
import Responses.PromedioTasaDescuentoYTotal;
import documentaciones.DocumentosOperacion;
import dtos.OperacionesDTO;
import enums.EstadoDocumentacion;
import enums.TamañoEmpresaEnum;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Comision;

import java.util.Date;
import java.util.List;

public class Sistema {

    private Sgr sgr;
    private List<Solicitante> solicitanteList;
    private static Sistema instance;

    public Sgr getSgr() {
        return sgr;
    }

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

    public List<Comision> comisionesEnUnDia(Date fecha){
        return sgr.getInstance().comisionesEnunDia(fecha);
    }

    public List<Operacion> operacionesDeSocio(Socio socio, Date fechaDesde, Date fechaHasta){
        return sgr.getInstance().operacionesDeSocio(socio, fechaDesde, fechaHasta);
    }

    public Integer getPorcentajeDeComisiones(TipoDeOperacionEnum tipoDeOperacionEnum){
        return sgr.getInstance().getPorcentajeDeComision(tipoDeOperacionEnum);
    }

    public ConsultaConsolidadaResponse consultaConsolidada(Socio socio){
        return sgr.getInstance().consultaConsolidada(socio);
    }

    public PromedioTasaDescuentoYTotal promedioTasaDescuentoYTotalOperado(TamañoEmpresaEnum tamañoEmpresaEnum, Date fechaDesde, Date fechaHasta){
        return sgr.getInstance().promedioTasaDescuentoYTotalOperado(tamañoEmpresaEnum, fechaDesde, fechaHasta);
    }

    public OperacionesDTO solicitarGarantiaOperacion(Socio socio, Operacion operacion, DocumentosOperacion documentosOperacion){
        return socio.solicitarGarantia(documentosOperacion, operacion);
    }

//Singleton sistema

    public static Sistema getInstance(){
        if(instance == null){
            instance = new Sistema();
        }

        return instance;
    }



}
