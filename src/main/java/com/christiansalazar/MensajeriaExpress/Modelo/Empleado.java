package com.christiansalazar.MensajeriaExpress.Modelo;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "CEDULA")
@Table(name="EMPLEADOS")
public class Empleado extends Persona{
    @Column(name = "ANTIGUEDAD", nullable = false)
    private Integer antiguedad;
    @Enumerated(EnumType.STRING)
    @Column(name = "RH", nullable = false)
    private RH rh;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false)
    private TipoEmpleado tipoEmpleado;
    public Empleado(){
    }

    public Empleado(Long cedula, String nombre, String apellido1, String apellido2, Long celular, String email, String ciudad, String direccion, Integer antiguedad, RH rh, TipoEmpleado tipoEmpleado) {
        super(cedula, nombre, apellido1, apellido2, celular, email, ciudad, direccion);
        this.antiguedad = antiguedad;
        this.rh = rh;
        this.tipoEmpleado = tipoEmpleado;
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
