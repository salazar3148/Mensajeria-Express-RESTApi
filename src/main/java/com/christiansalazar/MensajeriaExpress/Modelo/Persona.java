package com.christiansalazar.MensajeriaExpress.Modelo;

import javax.persistence.*;


@Entity
@Table(name = "PERSONAS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
    @Id
    protected Long cedula;
    @Column(name = "NOMBRE", nullable = false)
    protected String nombre;
    @Column(name = "APELLIDO1", nullable = false)
    protected String apellido1;
    @Column(name = "APELLIDO2")
    protected String apellido2;
    @Column(name = "CELULAR", nullable = false)
    protected Long celular;
    @Column(name = "EMAIL", nullable = false)
    protected String email;
    @Column(name = "CIUDAD")
    protected String ciudad;
    @Column(name = "DIRECCION")
    protected String direccion;

    public Persona() {
    }

    public Persona(Long cedula, String nombre, String apellido1, String apellido2, Long celular, String email, String ciudad, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.celular = celular;
        this.email = email;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Long getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public Long getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }
}
