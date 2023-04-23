package com.christiansalazar.MensajeriaExpress.Servicio;

import com.christiansalazar.MensajeriaExpress.DTO.EmpleadoDTO;
import com.christiansalazar.MensajeriaExpress.Excepciones.ApiRequestException;
import com.christiansalazar.MensajeriaExpress.Modelo.Empleado;
import com.christiansalazar.MensajeriaExpress.Repositorio.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public EmpleadoDTO anadirEmpleado(EmpleadoDTO empleadoDTO) {
        Optional<Empleado> existente = empleadoRepository.findById(empleadoDTO.getCedula());

        if(existente.isPresent()) throw new ApiRequestException("Ya está registrado");
        if(empleadoDTO.getCedula() == null) throw new ApiRequestException("identificación necesaria");
        if(empleadoDTO.getNombre() == null) throw new ApiRequestException("nombre necesario");
        if(empleadoDTO.getApellido1() == null) throw new ApiRequestException("primer apellido necesaria");
        if(empleadoDTO.getCelular() == null) throw new ApiRequestException("celular necesario");
        if(empleadoDTO.getEmail()== null) throw new ApiRequestException("email necesario");
        if(empleadoDTO.getAntiguedad()== null) throw new ApiRequestException("antiguedad necesaria");
        if(empleadoDTO.getRh()== null) throw new ApiRequestException("tipo de sangre necesario");
        if(empleadoDTO.getTipoEmpleado() == null) throw new ApiRequestException("tipo de empleado necesario");

        Empleado empleado = new Empleado(
                empleadoDTO.getCedula(),
                empleadoDTO.getNombre(),
                empleadoDTO.getApellido1(),
                empleadoDTO.getApellido2(),
                empleadoDTO.getCelular(),
                empleadoDTO.getEmail(),
                empleadoDTO.getCiudad(),
                empleadoDTO.getDireccion(),
                empleadoDTO.getAntiguedad(),
                empleadoDTO.getRh(),
                empleadoDTO.getTipoEmpleado()
        );

        empleadoRepository.save(empleado);
        return empleadoDTO;
    }

    public void actualizarEmpleado(Long cedula, EmpleadoDTO empleadoDTO) {
        Optional<Empleado> buscar = empleadoRepository.findById(cedula);
        if(buscar.isEmpty()) throw new ApiRequestException("Empleado no existente");

        Empleado empleado = new Empleado(
                cedula,
                empleadoDTO.getNombre(),
                empleadoDTO.getApellido1(),
                empleadoDTO.getApellido2(),
                empleadoDTO.getCelular(),
                empleadoDTO.getEmail(),
                empleadoDTO.getCiudad(),
                empleadoDTO.getDireccion(),
                empleadoDTO.getAntiguedad(),
                empleadoDTO.getRh(),
                empleadoDTO.getTipoEmpleado()
        );
        empleadoRepository.save(empleado);
    }

    public EmpleadoDTO obtenerEmpleado(Long cedula) {
        Optional<Empleado> empleado = empleadoRepository.findById(cedula);
        if(empleado.isEmpty()) throw new ApiRequestException("Empleado no registrado");

        return new EmpleadoDTO(
                empleado.get().getCedula(),
                empleado.get().getNombre(),
                empleado.get().getApellido1(),
                empleado.get().getApellido2(),
                empleado.get().getCelular(),
                empleado.get().getEmail(),
                empleado.get().getCiudad(),
                empleado.get().getDireccion(),
                empleado.get().getAntiguedad(),
                empleado.get().getRh(),
                empleado.get().getTipoEmpleado()
        );
    }

    public void eliminarEmpleado(Long cedula) {
        Optional<Empleado> empleado = empleadoRepository.findById(cedula);
        if(empleado.isEmpty()) throw new ApiRequestException("Usuario no registrado");
        empleadoRepository.deleteById(cedula);
    }
}
