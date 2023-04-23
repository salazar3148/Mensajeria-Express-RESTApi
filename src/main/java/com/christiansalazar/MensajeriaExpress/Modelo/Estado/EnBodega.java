package com.christiansalazar.MensajeriaExpress.Modelo.Estado;

import com.christiansalazar.MensajeriaExpress.Modelo.Envio;

import java.util.Objects;

public class EnBodega implements Estado {

    @Override
    public Estado procesar() {
        return new EnRuta();
    }

    @Override
    public String toString() {
        return "EN BODEGA";
    }

}
