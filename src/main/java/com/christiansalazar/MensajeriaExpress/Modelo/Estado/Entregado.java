package com.christiansalazar.MensajeriaExpress.Modelo.Estado;

import com.christiansalazar.MensajeriaExpress.Modelo.Envio;

import java.util.Objects;

public class Entregado implements Estado {
    @Override
    public Estado procesar() {
        return new Entregado();
    }

    @Override
    public String toString() {
        return "ENTREGADO";
    }
}
