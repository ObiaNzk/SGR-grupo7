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
import operaciones.Comision;
import operaciones.ContraGarantia;
import operaciones.Cuota;
import operaciones.LineaDeCredito;

import java.util.*;

public class Sgr {

    private String nombre;
    private List<Socio> socios;
    private static Sgr instance;

    public Sgr(){
        socios = new ArrayList<Socio>();
        Socio socioPrincipalParticipe = new Socio();
        Empresa empresa = new Empresa();
        empresa.setTamañoEmpresaEnum(TamañoEmpresaEnum.MEDIANA);
        socioPrincipalParticipe.setTipoDeSocio(TipoDeSocio.PARTICIPE);
        socioPrincipalParticipe.setAccionesSgrA(new ArrayList<String>(Collections.nCopies(100,"accion A")));
        socioPrincipalParticipe.setNombre("Socio General Participe");
        socioPrincipalParticipe.setLineaDeCredito(new LineaDeCredito(100000, new Date(2022, Calendar.JANUARY, 11), true));
        socioPrincipalParticipe.setTipoDeOperacionEnum(TipoDeOperacionEnum.TIPO1);
        socioPrincipalParticipe.setFdr(999999999);
        socioPrincipalParticipe.setEmpresa(empresa);

        //operaciones para probar el consolidado
        Operacion operacion = new Operacion();
        operacion.setTipoDeOperacion(TipoDeOperacionEnum.TIPO1);
        operacion.setEstadoOperacion(EstadoOperacionEnum.MONETIZADO);
        operacion.setFechaMonetizado(new Date());
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.JANUARY, 9); //Year, month and day of month
        Date date = cal.getTime();
        operacion.setFechaVencimiento(date);
        operacion.setMonto(100);
        operacion.setMontoUtilizado(100);
        socioPrincipalParticipe.AgregarOperacion(operacion);

        Operacion operacion2 = new Operacion();
        operacion2.setTipoDeOperacion(TipoDeOperacionEnum.TIPO2);
        operacion2.setEstadoOperacion(EstadoOperacionEnum.CON_CERTIFICADO_EMITIDO);
        operacion2.setFechaMonetizado(new Date());
        operacion2.setFechaVencimiento(date);
        operacion2.setMonto(100000);
        operacion2.setMontoUtilizado(1000);
        socioPrincipalParticipe.AgregarOperacion(operacion2);


        Socio socioPrincipalProtector = new Socio();
        socioPrincipalProtector.setTipoDeSocio(TipoDeSocio.PROTECTORES);
        socioPrincipalProtector.setAccionesSgrB(new ArrayList<String>(Collections.nCopies(100,"accion B")));
        socioPrincipalProtector.setNombre("Socio General Protector");
        socioPrincipalProtector.setTipoDeOperacionEnum(TipoDeOperacionEnum.TIPO1);
        socioPrincipalProtector.setFdr(999999999);
        socioPrincipalProtector.setEmpresa(empresa);

        this.socios.add(socioPrincipalParticipe);
        this.socios.add(socioPrincipalProtector);
    }

    public List<Socio> GetSocios(){
        return this.socios;
    }
    public List<Socio> GetSociosPorTipo(TipoDeSocio tipoDeSocio){
        List<Socio> socios = new ArrayList<Socio>();
        for(Socio socio: this.socios){
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
        for (Socio socio: socios){
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

    public ConsultaConsolidadaResponseDTO consultaConsolidada(Socio socio){
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
        return new ConsultaConsolidadaResponseDTO(operacionesRiesgoVivo,operacionesTotalUtilizado, totalRiesgoVivo, totalUtilizado+totalRiesgoVivo);
    }

    public PromedioTasaDescuentoYTotalDTO promedioTasaDescuentoYTotalOperado(TamañoEmpresaEnum tamañoEmpresaEnum, Date fechaDesde, Date fechaHasta){
        List<Integer> tasaDescuentos = new ArrayList<Integer>();
        List<Integer> montos = new ArrayList<Integer>();
        Integer tasaTotal = 0;
        double promedioTasa;
        double promedioMonto;
        Integer montoTotal = 0;
        for (Socio socio: socios){
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

}
