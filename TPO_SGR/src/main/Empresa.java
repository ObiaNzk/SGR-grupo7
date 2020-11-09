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
    private int telefono;
    private String correoElectronico;
    private List<Accionista> accionistaList;

    public TamañoEmpresaEnum getTamañoEmpresaEnum() {
        return tamañoEmpresaEnum;
    }
}
