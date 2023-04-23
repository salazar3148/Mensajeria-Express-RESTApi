package com.christiansalazar.MensajeriaExpress.DTO.Responses;

public class EnvioResponse {
    private String numeroGuia;
    private String estado;

    public EnvioResponse(String numeroGuia, String estado) {
        this.numeroGuia = numeroGuia;
        this.estado = estado;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public String getEstado() {
        return estado;
    }
}
