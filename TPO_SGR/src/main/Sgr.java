package main;

import Interfaces.IOperacionGastos;
import Request.OperacionCheque;
import Request.OperacionCuentaCorriente;
import Request.OperacionCuota;
import dtos.ConsultaConsolidadaResponseDTO;
import dtos.PromedioTasaDescuentoYTotalDTO;
import documentaciones.DocumentosOperacion;
import enums.EstadoOperacionEnum;
import enums.TamañoEmpresaEnum;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.*;

import java.util.*;

public class Sgr {

    private String Nombre;
    private List<Socio> Socios;
    private static Sgr instance;
    private List<Aporte> Aportes;
    public Sgr(){
        Socios = new ArrayList<Socio>();
        Aportes = new ArrayList<Aporte>();
        GetSociosGenerales();
    }

    public List<Socio> GetSocios(){
        return this.Socios;
    }
    public List<Socio> GetSociosPorTipo(TipoDeSocio tipoDeSocio){
        List<Socio> socios = new ArrayList<Socio>();
        for(Socio socio: this.Socios){
            if (socio.getTipoDeSocio() == tipoDeSocio){
                socios.add(socio);
            }
        }
        return socios;
    }
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

    public List<Comision> comisionesEnunDia(Date fecha){
        List<Comision> comisiones =  new ArrayList<Comision>();

        for (Socio socio: Socios){
            for (Operacion operacion: socio.getOperacionList()){
                if(operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO1 &&
                        operacion.getEstadoOperacion() == EstadoOperacionEnum.MONETIZADO &&
                        operacion.getFechaMonetizado().getYear() == fecha.getYear() &&
                        operacion.getFechaMonetizado().getDay() == fecha.getDay() &&
                        operacion.getFechaMonetizado().getMonth() == fecha.getMonth())
                {
                   comisiones.add(new Comision(operacion));
                }
            }
        }
        return comisiones;
    }

    public List<Operacion> operacionesDeSocio(Socio socio, Date fechaDesde, Date fechaHasta){
        return socio.getOperacionList();/*
        List<Operacion> operacionesResultado = new ArrayList<Operacion>();
        for (Operacion operacion: socio.getOperacionList()){
            if(operacion.getEstadoOperacion() == EstadoOperacionEnum.MONETIZADO && operacion.getFechaMonetizado().after(fechaDesde) && operacion.getFechaMonetizado().before(fechaHasta)){
                operacionesResultado.add(operacion);
            }
        }
        return operacionesResultado;*/
    }

    public Integer getPorcentajeDeComision(TipoDeOperacionEnum tipoDeOperacionEnum){
        Comision comision = new Comision();
        return comision.getComisionPorTipo(tipoDeOperacionEnum);
    }

    public ConsultaConsolidadaResponseDTO consultaConsolidada(Socio socio){
        List<Operacion>  operacionesRiesgoVivo = new ArrayList<Operacion>();
        List<Operacion>  operacionesTotalUtilizado = new ArrayList<Operacion>();
        float totalRiesgoVivo = 0;
        float totalUtilizado = 0 ;
        for (Operacion operacion : socio.getOperacionList()){
            if(operacion.getFechaVencimiento().after(new Date())){
                if(operacion.getEstadoOperacion() == EstadoOperacionEnum.CON_CERTIFICADO_EMITIDO){
                    operacionesTotalUtilizado.add((operacion));
                    if(operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO3){
                        for (Cuota cuota: ((Prestamo)operacion.getDocumentosOperacion()).getCuotas()){
                            if(!cuota.isPagado() && cuota.getFechaVencimiento().before(new Date())){
                                totalUtilizado += cuota.getMonto();
                            }
                        }
                    }else {
                        totalUtilizado += operacion.getMonto();
                    }
                }
                if(operacion.getEstadoOperacion() == EstadoOperacionEnum.MONETIZADO){
                    operacionesRiesgoVivo.add(operacion);
                    if(operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO3){
                        for (Cuota cuota: ((Prestamo)operacion.getDocumentosOperacion()).getCuotas()){
                            if(!cuota.isPagado() && cuota.getFechaVencimiento().before(new Date())){
                                totalRiesgoVivo += cuota.getMonto();
                            }
                        }
                    }else {
                        totalRiesgoVivo += operacion.getMonto();
                    }
                }
            }
        }
        return new ConsultaConsolidadaResponseDTO(operacionesRiesgoVivo,operacionesTotalUtilizado, totalRiesgoVivo, totalUtilizado+totalRiesgoVivo);
    }

    public PromedioTasaDescuentoYTotalDTO promedioTasaDescuentoYTotalOperado(TamañoEmpresaEnum tamañoEmpresaEnum, Date fechaDesde, Date fechaHasta){
        List<Integer> tasaDescuentos = new ArrayList<Integer>();
        List<Integer> montos = new ArrayList<Integer>();
        Integer tasaTotal = 0;
        double promedioTasa;
        double promedioMonto;
        Integer montoTotal = 0;
        for (Socio socio: this.GetSociosPorTipo(TipoDeSocio.PARTICIPE)){
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

        if(montos.size() == 0 || tasaDescuentos.size() == 0){
            return new PromedioTasaDescuentoYTotalDTO(0,0);
        }
        for (Integer tasa: tasaDescuentos){
            tasaTotal += tasa;
        }
        for (Integer monto: montos){
            montoTotal += monto;
        }
        promedioTasa = tasaTotal/tasaDescuentos.size();
        promedioMonto = montoTotal/montos.size();
        return new PromedioTasaDescuentoYTotalDTO(promedioTasa,promedioMonto);
    }

    public void RealizarOperacion(Socio socio,Operacion operacion, IOperacionGastos gasto) {

        if (operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO1){
            OperacionCheque gastoCheque = (OperacionCheque) gasto;
            operacion.setMontoUtilizado(operacion.getMonto());
            operacion.setTasaDeDescuento(gastoCheque.getTasaDescuento());
            operacion.setFechaMonetizado(new Date());
            operacion.setEstadoOperacion(EstadoOperacionEnum.MONETIZADO);
            Comision comision = new Comision(operacion);
            socio.AgregarComision(comision);
            return;
        }
        if (operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO2){
            OperacionCuentaCorriente gastoCuentaCorriente = (OperacionCuentaCorriente)gasto;
            operacion.setMontoUtilizado(gastoCuentaCorriente.getMontoUtilizado());
            return;
        }
        if (operacion.getTipoDeOperacion() == TipoDeOperacionEnum.TIPO3){
            OperacionCuota gastoCuota = (OperacionCuota)gasto;
            gastoCuota.getCuota().setPagado(true);
            return;
        }
    }

    public void VentaDeAcciones(Socio socioQueVende, Socio socioQueCompra, Integer cantidadDeAcciones) {
        socioQueCompra.ComprarAcciones(socioQueVende.VenderAcciones(cantidadDeAcciones));
    }

    public static Sgr getInstance() {
        if(instance == null){
            instance = new Sgr();
        }
        return instance;
    }

    public List<Aporte> getAportes() {
        return Aportes;
    }

    public List<Aporte> getAportes(boolean sinVencer ){
        List<Aporte> resultado = new ArrayList<Aporte>();
        for (Aporte aporte: this.Aportes){
            if(sinVencer) {
                if (aporte.getFechaVencimiento().after(Calendar.getInstance().getTime())) {
                    resultado.add(aporte);
                }
            }else{
                if (aporte.getFechaVencimiento().before(Calendar.getInstance().getTime())) {
                    resultado.add(aporte);
                }
            }
        }
        return resultado;
    }



    public void AgregarAporte(Aporte aporte) {
        this.Aportes.add(aporte);
    }

    public void GetSociosGenerales(){
        List<Socio> sociosGenerales = new ArrayList<Socio>();
        Socio socioPrincipalParticipe = new Socio();
        Empresa empresa = new Empresa();
        empresa.setTamañoEmpresaEnum(TamañoEmpresaEnum.MEDIANA);
        socioPrincipalParticipe.setTipoDeSocio(TipoDeSocio.PARTICIPE);
        socioPrincipalParticipe.setAccionesSgrA(new ArrayList<String>(Collections.nCopies(100,"accion A")));
        socioPrincipalParticipe.setNombre("Socio General Participe");
        socioPrincipalParticipe.setTipoDeOperacionEnum(TipoDeOperacionEnum.TIPO1);
        socioPrincipalParticipe.setEmpresa(empresa);
        //operaciones para probar el consolidado
        Operacion operacion = new Operacion();
        operacion.setTipoDeOperacion(TipoDeOperacionEnum.TIPO1);
        operacion.setEstadoOperacion(EstadoOperacionEnum.MONETIZADO);
        operacion.setTasaDeDescuento(18);
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.JANUARY, 9); //Year, month and day of month
        Date date = cal.getTime();
        socioPrincipalParticipe.setLineaDeCredito(new LineaDeCredito(1000, date, true));
        operacion.setFechaVencimiento(date);
        operacion.setFechaMonetizado(date);
        operacion.setMonto(100);
        operacion.setMontoUtilizado(100);
        socioPrincipalParticipe.AgregarOperacion(operacion);

        Operacion operacion2 = new Operacion();
        operacion2.setTipoDeOperacion(TipoDeOperacionEnum.TIPO2);
        operacion2.setEstadoOperacion(EstadoOperacionEnum.CON_CERTIFICADO_EMITIDO);
        operacion2.setFechaMonetizado(new Date());
        operacion2.setFechaVencimiento(date);
        operacion2.setFechaMonetizado(date);
        operacion2.setMonto(250);
        operacion2.setMontoUtilizado(150);
        socioPrincipalParticipe.AgregarOperacion(operacion2);


        Operacion operacion3 = new Operacion();
        Aporte aporte = new Aporte(100000, cal.getTime());
        operacion3.setTipoDeOperacion(TipoDeOperacionEnum.APORTE);
        operacion3.setEstadoOperacion(EstadoOperacionEnum.MONETIZADO);
        operacion3.setFechaMonetizado(new Date());
        operacion3.setFechaVencimiento(cal.getTime());
        operacion3.setFechaMonetizado(date);
        operacion3.setMonto(100000);
        operacion3.setMontoUtilizado(100000);
        operacion3.setDocumentosOperacion(aporte);

        Socio socioPrincipalProtector = new Socio();

        socioPrincipalProtector.setTipoDeSocio(TipoDeSocio.PROTECTORES);
        socioPrincipalProtector.setAccionesSgrB(new ArrayList<String>(Collections.nCopies(100,"accion B")));
        socioPrincipalProtector.setNombre("Socio General Protector");
        socioPrincipalProtector.setTipoDeOperacionEnum(TipoDeOperacionEnum.TIPO1);
        socioPrincipalProtector.setEmpresa(empresa);
        socioPrincipalProtector.AgregarOperacion(operacion3);

        this.Socios.add(socioPrincipalParticipe);
        this.Socios.add(socioPrincipalProtector);
        this.Aportes.add(aporte);
    }
}
