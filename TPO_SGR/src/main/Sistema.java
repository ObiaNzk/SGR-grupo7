package main;

import Interfaces.IOperacionGastos;
import dtos.ConsultaConsolidadaResponseDTO;
import dtos.PromedioTasaDescuentoYTotalDTO;
import documentaciones.DocumentosOperacion;
import dtos.OperacionesDTO;
import enums.*;
import operaciones.Comision;

import java.util.Date;
import java.util.List;

public class Sistema {

    private Sgr sgr;
    private List<Solicitante> solicitanteList;
    private static Sistema instance;

    public Solicitante solicitud(Empresa empresa, TipoDeSocio tipoDeSocio) {
        return null;
    }

    public void presentarDocumentacion(Solicitante solicitante, String estatuto, String balanceCertificado1, String balanceCertificado2,
                                       String balanceCertificado3, String bienesSocios) {
    }

    public EstadoDocumentacion revisarDocumentacion(Solicitante solicitante) {
        return null;
    }

    public Socio crearSocios() {
        return null;
    }

    public List<Comision> comisionesEnUnDia(Date fecha) {
        return sgr.comisionesEnunDia(fecha);
    }

    public List<Operacion> operacionesDeSocio(Socio socio, Date fechaDesde, Date fechaHasta) {
        return sgr.getInstance().operacionesDeSocio(socio, fechaDesde, fechaHasta);
    }

    public Integer getPorcentajeDeComisiones(TipoDeOperacionEnum tipoDeOperacionEnum) {
        return sgr.getInstance().getPorcentajeDeComision(tipoDeOperacionEnum);
    }

    public void RealizarOperacion(Socio socio,Operacion operacion, IOperacionGastos gasto){
        sgr.getInstance().RealizarOperacion(socio, operacion, gasto);
    }

    public ConsultaConsolidadaResponseDTO consultaConsolidada(Socio socio){
        return sgr.consultaConsolidada(socio);
    }

    public PromedioTasaDescuentoYTotalDTO promedioTasaDescuentoYTotalOperado(TamañoEmpresaEnum tamañoEmpresaEnum, Date fechaDesde, Date fechaHasta){
        return sgr.getInstance().promedioTasaDescuentoYTotalOperado(tamañoEmpresaEnum, fechaDesde, fechaHasta);
    }

    public OperacionesDTO solicitarGarantiaOperacion(Socio socio, Operacion operacion, DocumentosOperacion documentosOperacion){
        return socio.solicitarGarantia(documentosOperacion, operacion);
    }

    public void MonetizarOperacion(Socio socio, Operacion operacion){
        operacion.setEstadoOperacion(EstadoOperacionEnum.MONETIZADO);
        operacion.setFechaMonetizado(new Date());
        socio.AgregarComision(new Comision(operacion));
    }
    public void VentaDeAcciones(Socio socioQueVende, Socio socioQueCompra, Integer cantidadDeAcciones){
        sgr.getInstance().VentaDeAcciones(socioQueVende, socioQueCompra, cantidadDeAcciones);
    }

//Singleton sistema

    public static Sistema getInstance(){
        if(instance == null){
            instance = new Sistema();
        }

        return instance;
    }

}
