package com.christiansalazar.MensajeriaExpress.Modelo;

import javax.persistence.*;

@Entity
@Table(name = "PAQUETES")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false)
    private TipoPaquete tipo;

    @Column(name = "PESO", nullable = false)
    private Double peso;

    @Column(name = "VALOR_DECLARADO", nullable = false)
    private Integer valorDeclarado;

    public Paquete() {
    }

    public Paquete(TipoPaquete tipo, Double peso, Integer valorDeclarado) {
        this.tipo = tipo;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }

    public Integer getID() {
        return ID;
    }

    public TipoPaquete getTipo() {
        return tipo;
    }

    public Double getPeso() {
        return peso;
    }

    public Integer getValorDeclarado() {
        return valorDeclarado;
    }
}
