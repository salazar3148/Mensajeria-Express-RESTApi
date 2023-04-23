package com.christiansalazar.MensajeriaExpress.Repositorio;

import com.christiansalazar.MensajeriaExpress.Modelo.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, String> {
}
