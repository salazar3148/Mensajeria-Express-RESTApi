package com.christiansalazar.MensajeriaExpress.Modelo.Estado;

import com.christiansalazar.MensajeriaExpress.Modelo.Envio;

import java.util.Objects;

public interface Estado {
    Estado procesar();
    boolean equals(Object obj);
    int hashCode();
}
