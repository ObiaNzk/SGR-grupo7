package main;

import enums.TamañoEmpresaEnum;

import java.util.Date;
import java.util.List;

public class Empresa {

    private String cuit;
    private String razonSocial;
    private Date fechaDeInicio;
    private TamañoEmpresaEnum tamañoEmpresaEnum;
    private String actividadPrincipal;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private List<Accionista> accionistaList;

    public TamañoEmpresaEnum getTamañoEmpresaEnum() {
        return tamañoEmpresaEnum;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setTamañoEmpresaEnum(TamañoEmpresaEnum tamañoEmpresaEnum) {
        this.tamañoEmpresaEnum = tamañoEmpresaEnum;
    }

    public String getActividadPrincipal() {
        return actividadPrincipal;
    }

    public void setActividadPrincipal(String actividadPrincipal) {
        this.actividadPrincipal = actividadPrincipal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Accionista> getAccionistaList() {
        return accionistaList;
    }

    public void setAccionistaList(List<Accionista> accionistaList) {
        this.accionistaList = accionistaList;
    }
}
