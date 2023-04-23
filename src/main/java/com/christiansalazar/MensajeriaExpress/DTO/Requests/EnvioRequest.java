package com.christiansalazar.MensajeriaExpress.DTO.Requests;

public class EnvioRequest {
    String numeroGuia;

    public EnvioRequest(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }
}
