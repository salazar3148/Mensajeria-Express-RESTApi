package com.christiansalazar.MensajeriaExpress.DTO.Responses;

public class EstadoResponse {

    private String numeroGuia;
    private String ultimoEstado;

    public EstadoResponse(String numeroGuia, String ultimoEstado) {
        this.numeroGuia = numeroGuia;
        this.ultimoEstado = ultimoEstado;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public String getUltimoEstado() {
        return ultimoEstado;
    }
}
