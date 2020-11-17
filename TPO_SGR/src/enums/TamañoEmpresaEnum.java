package enums;

public enum TamañoEmpresaEnum {
    PEQUEÑA("Pequeña"),
    MEDIANA("Mediana"),
    GRANDE("Grande");

    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    TamañoEmpresaEnum(String codigo) {
        this.codigo = codigo;
    }


}
