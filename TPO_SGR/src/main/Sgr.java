package main;

import Responses.ConsultaConsolidadaResponse;
import Responses.PromedioTasaDescuentoYTotal;
import documentaciones.DocumentosOperacion;
import enums.EstadoOperacionEnum;
import enums.TamañoEmpresaEnum;
import enums.TipoDeOperacionEnum;
import operaciones.Comision;
import operaciones.ContraGarantia;
import operaciones.Cuota;
import operaciones.Prestamo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sgr {

    private String nombre;
    private List<Socio> sociosProtectores;
    private List<Socio> sociosParticipes;
    private static Sgr instance;



    public void agregarSocio(Socio socio){

    }

    public void asignarLineaCredito(Socio socio){

    }

    public void setContragarantia(Socio socio, ContraGarantia contraGarantia){

    }

    public Operacion solicitarOperacion(Socio socio, DocumentosOperacion documentosOperacion){
        return null;
    }

    public void monetizarOperacion(Operacion operacion){

    }

    public Comision calcularComision(Operacion operacion, Socio socio){
        return null;
    }

    public void emitirFactura(Socio socio){

    }

    public void getLineaCredito(Socio socio){

    }

    public void crearDesembolso(Socio socio, int monto){

    }

    //REVISAR EN DIAGRAMA
    public void venderAcciones(){

    }

    public List<Socio> getSociosProtectores() {
        return sociosProtectores;
    }

    public List<Socio> getSociosParticipes() {
        return sociosParticipes;
    }

    public List<Comision> comisionesEnunDia(Date fecha){
        List<Comision> comisiones =  new ArrayList<Comision>();
        for (Socio socio: sociosParticipes){
            for (Operacion operacion: socio.getOperacionList()){
                if(operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO1 && operacion.getEstadoOperacion() == EstadoOperacionEnum.MONETIZADO && operacion.getFechaMonetizado() == fecha){
                   comisiones.add(new Comision(operacion));
                }
            }
        }
        return comisiones;
    }

    public List<Operacion> operacionesDeSocio(Socio socio, Date fechaDesde, Date fechaHasta){
        List<Operacion> operacionesResultado = new ArrayList<Operacion>();
        for (Operacion operacion: socio.getOperacionList()){
            if(operacion.getEstadoOperacion() == EstadoOperacionEnum.MONETIZADO && operacion.getFechaMonetizado().after(fechaDesde) && operacion.getFechaMonetizado().before(fechaHasta)){
                operacionesResultado.add(operacion);
            }
        }
        return operacionesResultado;
    }

    public Integer getPorcentajeDeComision(TipoDeOperacionEnum tipoDeOperacionEnum){
        Comision comision = new Comision();
        return comision.getComisionPorTipo(tipoDeOperacionEnum);
    }

    public ConsultaConsolidadaResponse consultaConsolidada(Socio socio){
        List<Operacion>  operacionesRiesgoVivo = new ArrayList<Operacion>();
        List<Operacion>  operacionesTotalUtilizado = new ArrayList<Operacion>();
        Integer totalRiesgoVivo = 0;
        Integer totalUtilizado = 0 ;
        for (Operacion operacion : socio.getOperacionList()){
            if(operacion.getFechaVencimiento().after(new Date())){
                if(operacion.getEstadoOperacion() == EstadoOperacionEnum.CON_CERTIFICADO_EMITIDO){
                    operacionesTotalUtilizado.add((operacion));
                    if(operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO3){
                        for (Cuota cuota: operacion.getDocumentosOperacion().getPrestamo().getCuotas()){
                            if(!cuota.isPagado() && cuota.getFechaVencimiento().before(new Date())){
                                totalUtilizado += cuota.getMonto();
                            }
                        }
                    }
                    totalUtilizado += operacion.getMontoUtilizado();
                }
                if(operacion.getEstadoOperacion() == EstadoOperacionEnum.MONETIZADO){
                    operacionesRiesgoVivo.add(operacion);
                    if(operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO3){
                        for (Cuota cuota: operacion.getDocumentosOperacion().getPrestamo().getCuotas()){
                            if(!cuota.isPagado() && cuota.getFechaVencimiento().before(new Date())){
                                totalRiesgoVivo += cuota.getMonto();
                            }
                        }
                    }
                    totalRiesgoVivo += operacion.getMontoUtilizado();
                }
            }
        }
        return new ConsultaConsolidadaResponse(operacionesRiesgoVivo,operacionesTotalUtilizado, totalRiesgoVivo, totalUtilizado);
    }

    public PromedioTasaDescuentoYTotal promedioTasaDescuentoYTotalOperado(TamañoEmpresaEnum tamañoEmpresaEnum, Date fechaDesde, Date fechaHasta){
        List<Integer> tasaDescuentos = new ArrayList<Integer>();
        List<Integer> montos = new ArrayList<Integer>();
        Integer tasaTotal = 0;
        double promedioTasa;
        double promedioMonto;
        Integer montoTotal = 0;
        for (Socio socio: sociosParticipes){
            if(socio.getEmpresa().getTamañoEmpresaEnum() == tamañoEmpresaEnum){
                for(Operacion operacion: socio.getOperacionList()){
                    if(operacion.getEstadoOperacion() == EstadoOperacionEnum.MONETIZADO &&
                    operacion.getFechaMonetizado().after(fechaDesde) &&
                    operacion.getFechaMonetizado().before((fechaHasta)) &&
                    operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO1){
                        montos.add(operacion.getMonto());
                        tasaDescuentos.add((operacion.getTasaDeDescuento()));
                    }
                }
            }
        }
        for (Integer tasa: tasaDescuentos){
            tasaTotal += tasa;
        }
        for (Integer monto: montos){
            montoTotal += monto;
        }
        promedioTasa = tasaTotal/tasaDescuentos.size();
        promedioMonto = montoTotal/montos.size();
        return new PromedioTasaDescuentoYTotal(promedioTasa,promedioMonto);
    }

    public static Sgr getInstance() {
        if(instance == null){
            instance = new Sgr();
        }
        return instance;
    }

}
