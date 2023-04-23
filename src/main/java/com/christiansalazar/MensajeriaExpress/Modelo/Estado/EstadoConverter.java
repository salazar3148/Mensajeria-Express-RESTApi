package com.christiansalazar.MensajeriaExpress.Modelo.Estado;
import javax.persistence.AttributeConverter;

public class EstadoConverter implements AttributeConverter<Estado, String> {
    @Override
    public String convertToDatabaseColumn(Estado estado) {
        return estado.toString();
    }

    @Override
    public Estado convertToEntityAttribute(String estado) {
        switch (estado){
            case "EN BODEGA":
                return new EnBodega();
            case "EN RUTA":
                return new EnRuta();
            case "ENTREGADO":
                return new Entregado();
            default:
                throw new IllegalArgumentException("Estado no valido");
        }
    }
}