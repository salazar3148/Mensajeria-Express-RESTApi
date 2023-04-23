package com.christiansalazar.MensajeriaExpress.DTO;

public class EnvioDTO {
    private Long cedulaCliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String direccionDestino;
    private String nombreRecibe;
    private Long celular;
    private Integer valorDeclaradoPaquete;
    private Double peso;
    private String estado;

    public EnvioDTO() {
    }

    public EnvioDTO(Long cedulaCliente, String ciudadOrigen, String ciudadDestino, String direccionDestino, String nombreRecibe, Long celular, Integer valorDeclaradoPaquete, Double peso, String estado) {
        this.cedulaCliente = cedulaCliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccionDestino = direccionDestino;
        this.nombreRecibe = nombreRecibe;
        this.celular = celular;
        this.valorDeclaradoPaquete = valorDeclaradoPaquete;
        this.peso = peso;
        this.estado = estado;
    }

    public Long getCedulaCliente() {
        return cedulaCliente;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public String getNombreRecibe() {
        return nombreRecibe;
    }

    public Long getCelular() {
        return celular;
    }

    public Integer getValorDeclaradoPaquete() {
        return valorDeclaradoPaquete;
    }

    public Double getPeso() {
        return peso;
    }

    public String getEstado(){
        return estado;
    }
}

