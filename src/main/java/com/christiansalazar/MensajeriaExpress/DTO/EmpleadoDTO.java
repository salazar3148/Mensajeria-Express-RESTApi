package com.christiansalazar.MensajeriaExpress.DTO;

import com.christiansalazar.MensajeriaExpress.Modelo.RH;
import com.christiansalazar.MensajeriaExpress.Modelo.TipoEmpleado;

public class EmpleadoDTO {
    private Long cedula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Long celular;
    private String email;
    private String ciudad;
    private String direccion;
    private Integer antiguedad;
    private RH rh;
    private TipoEmpleado tipoEmpleado;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(Long cedula, String nombre, String apellido1, String apellido2, Long celular, String email, String ciudad, String direccion, Integer antiguedad, RH rh, TipoEmpleado tipoEmpleado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.celular = celular;
        this.email = email;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.antiguedad = antiguedad;
        this.rh = rh;
        this.tipoEmpleado = tipoEmpleado;
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

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public RH getRh() {
        return rh;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }
}
