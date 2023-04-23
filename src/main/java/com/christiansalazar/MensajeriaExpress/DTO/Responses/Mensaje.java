package com.christiansalazar.MensajeriaExpress.DTO.Responses;

public class Mensaje {
    String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
