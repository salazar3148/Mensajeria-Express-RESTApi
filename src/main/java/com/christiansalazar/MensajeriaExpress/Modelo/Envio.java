package com.christiansalazar.MensajeriaExpress.Modelo;


import com.christiansalazar.MensajeriaExpress.Modelo.Estado.Estado;
import com.christiansalazar.MensajeriaExpress.Modelo.Estado.EstadoConverter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "ENVIOS")
public class Envio {

    @Id
    @Column(name = "NUMERO_GUIA")
    private String numeroGuia;

    @ManyToOne
    @JoinColumn(name = "CEDULA_CLIENTE")
    private Cliente cliente;

    @Column(name = "CIUDAD_ORIGEN", nullable = false)
    private String ciudadOrigen;

    @Column(name = "CIUDAD_DESTINO", nullable = false)
    private String ciudadDestino;

    @Column(name = "DIRECCION", nullable = false)
    private String direccion;

    @Column(name = "DESTINATARIO", nullable = false)
    private String destinatario;

    @Column(name = "CELULAR_DESTINATARIO", nullable = false)
    private Long celularDestinatario;

    @Column(name = "HORA_ENTREGA")
    private LocalTime horaEntrega;

    @Column(name = "ESTADO", nullable = false)
    @Convert(converter = EstadoConverter.class)
    private Estado estado;
    @Column(name = "VALOR", nullable = false)
    private Integer valor;
    @OneToOne
    @JoinColumn(name="PAQUETE")
    private Paquete paquete;

    public Envio() {
    }

    public Envio(Cliente cliente, String ciudadOrigen, String ciudadDestino, String direccion, String destinatario, Long celularDestinatario, LocalTime horaEntrega, Estado estado, Integer valor, Paquete paquete) {
        this.numeroGuia = UUID.randomUUID().toString().substring(0, 8);
        this.cliente = cliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.direccion = direccion;
        this.destinatario = destinatario;
        this.celularDestinatario = celularDestinatario;
        this.horaEntrega = horaEntrega;
        this.estado = estado;
        this.valor = valor;
        this.paquete = paquete;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public Long getCelularDestinatario() {
        return celularDestinatario;
    }

    public LocalTime getHoraEntrega() {
        return horaEntrega;
    }

    public Estado getEstado() {
        return estado;
    }

    public Integer getValor() {
        return valor;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setEstado(){
        this.estado = this.estado.procesar();
    }
}
