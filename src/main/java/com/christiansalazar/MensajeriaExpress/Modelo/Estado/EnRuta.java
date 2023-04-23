package com.christiansalazar.MensajeriaExpress.Modelo.Estado;

public class EnRuta implements Estado {
    @Override
    public Estado procesar() {
        return new Entregado();
    }

    @Override
    public String toString() {
        return "EN RUTA";
    }
}
