package com.christiansalazar.MensajeriaExpress.Repositorio;
import com.christiansalazar.MensajeriaExpress.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
