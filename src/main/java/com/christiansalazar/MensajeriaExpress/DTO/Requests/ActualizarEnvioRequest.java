package com.christiansalazar.MensajeriaExpress.DTO.Requests;

public class ActualizarEnvioRequest {
    private String numeroGuia;
    private Long cedulaEmpleado;

    public ActualizarEnvioRequest() {
    }

    public ActualizarEnvioRequest(String numeroGuia, Long cedulaEmpleado) {
        this.numeroGuia = numeroGuia;
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public Long getCedulaEmpleado() {
        return cedulaEmpleado;
    }
}
