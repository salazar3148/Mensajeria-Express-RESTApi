package com.christiansalazar.MensajeriaExpress.Repositorio;

import com.christiansalazar.MensajeriaExpress.Modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
