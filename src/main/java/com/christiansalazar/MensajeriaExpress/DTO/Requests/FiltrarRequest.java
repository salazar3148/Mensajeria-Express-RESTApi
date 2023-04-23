package com.christiansalazar.MensajeriaExpress.DTO.Requests;

public class FiltrarRequest {
    private String estadoEnvio;
    private Long cedulaCliente;

    public FiltrarRequest(String estadoEnvio, Long cedulaCliente) {
        this.estadoEnvio = estadoEnvio;
        this.cedulaCliente = cedulaCliente;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public Long getCedulaCliente() {
        return cedulaCliente;
    }
}
