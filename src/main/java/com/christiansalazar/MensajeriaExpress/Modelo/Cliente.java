package com.christiansalazar.MensajeriaExpress.Modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Cliente extends Persona {
    public Cliente(){
    }
    public Cliente(Long cedula, String nombre, String apellido1, String apellido2, Long celular, String email, String ciudad, String direccion) {
        super(cedula, nombre, apellido1, apellido2, celular, email, ciudad, direccion);
    }
}
