package com.christiansalazar.MensajeriaExpress.DTO;

public class ClienteDTO {
    private Long cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Long celular;
    private String email;
    private String ciudad;
    private String direccion;

    public ClienteDTO() {
    }

    public ClienteDTO(Long cedula, String nombre, String apellido1, String apellido2, Long celular, String email, String ciudad, String direccion) {
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
