package dtos;

import main.Operacion;

import java.util.ArrayList;
import java.util.List;

public class ConsultaConsolidadaResponseDTO {
    private List<Operacion> operacionesRiesgoVivo;
    private List<Operacion>  operacionesTotalUtilizado;
    private Integer totalRiesgoVivo ;
    private Integer totalUtilizado ;

    public ConsultaConsolidadaResponseDTO(List<Operacion> operacionesRiesgoVivo, List<Operacion> operacionesTotalUtilizado, Integer totalRiesgoVivo, Integer totalUtilizado ){
        this.operacionesRiesgoVivo = operacionesRiesgoVivo;
        this.operacionesTotalUtilizado = operacionesTotalUtilizado;
        this.totalRiesgoVivo = totalRiesgoVivo;
        this.totalUtilizado = totalUtilizado;

    }
    public List<Operacion> getOperacionesRiesgoVivo() {
        return operacionesRiesgoVivo;
    }

    public void setOperacionesRiesgoVivo(List<Operacion> operacionesRiesgoVivo) {
        this.operacionesRiesgoVivo = operacionesRiesgoVivo;
    }

    public List<Operacion> getOperacionesTotalUtilizado() {
        return operacionesTotalUtilizado;
    }

    public void setOperacionesTotalUtilizado(List<Operacion> operacionesTotalUtilizado) {
        this.operacionesTotalUtilizado = operacionesTotalUtilizado;
    }

    public Integer getTotalRiesgoVivo() {
        return totalRiesgoVivo;
    }

    public void setTotalRiesgoVivo(Integer totalRiesgoVivo) {
        this.totalRiesgoVivo = totalRiesgoVivo;
    }

    public Integer getTotalUtilizado() {
        return totalUtilizado;
    }

    public void setTotalUtilizado(Integer totalUtilizado) {
        this.totalUtilizado = totalUtilizado;
    }
}
