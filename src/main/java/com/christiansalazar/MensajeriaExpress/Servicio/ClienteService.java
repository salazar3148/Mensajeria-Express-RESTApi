package com.christiansalazar.MensajeriaExpress.Servicio;

import com.christiansalazar.MensajeriaExpress.DTO.ClienteDTO;
import com.christiansalazar.MensajeriaExpress.Excepciones.ApiRequestException;
import com.christiansalazar.MensajeriaExpress.Modelo.Cliente;
import com.christiansalazar.MensajeriaExpress.Repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO obtenerCliente(Long cedula) {
        Optional<Cliente> cliente = clienteRepository.findById(cedula);
        if(cliente.isEmpty()) throw new ApiRequestException("cliente no registrado");

        return new ClienteDTO(
                cliente.get().getCedula(),
                cliente.get().getNombre(),
                cliente.get().getApellido1(),
                cliente.get().getApellido2(),
                cliente.get().getCelular(),
                cliente.get().getEmail(),
                cliente.get().getCiudad(),
                cliente.get().getDireccion()
        );
    }

    public ClienteDTO anadirCliente(ClienteDTO clienteDTO) {
        Optional<Cliente> existente = clienteRepository.findById(clienteDTO.getCedula());

        if(existente.isPresent()) throw new ApiRequestException("ya está registrado");
        if(clienteDTO.getCedula() == null) throw new ApiRequestException("identificación necesaria");
        if(clienteDTO.getNombre() == null) throw new ApiRequestException("nombre necesario");
        if(clienteDTO.getApellido1() == null) throw new ApiRequestException("primer apellido necesario");
        if(clienteDTO.getCelular() == null) throw new ApiRequestException("celular necesario");
        if(clienteDTO.getEmail()== null) throw new ApiRequestException("email necesario");

        Cliente cliente = new Cliente(
                clienteDTO.getCedula(),
                clienteDTO.getNombre(),
                clienteDTO.getApellido1(),
                clienteDTO.getApellido2(),
                clienteDTO.getCelular(),
                clienteDTO.getEmail(),
                clienteDTO.getCiudad(),
                clienteDTO.getDireccion()
        );

        clienteRepository.save(cliente);
        return clienteDTO;
    }

    public void eliminarCliente(Long cedula) {
        Optional<Cliente> cliente = clienteRepository.findById(cedula);
        if(cliente.isEmpty()) throw new ApiRequestException("cliente no registrado");
        clienteRepository.deleteById(cedula);
    }

    public void actualizarCliente(Long cedula, ClienteDTO clienteDTO) {
        Optional<Cliente> buscar = clienteRepository.findById(cedula);
        if(buscar.isEmpty()) throw new ApiRequestException("cliente no existente");

        Cliente cliente = new Cliente(
                cedula,
                clienteDTO.getNombre(),
                clienteDTO.getApellido1(),
                clienteDTO.getApellido2(),
                clienteDTO.getCelular(),
                clienteDTO.getEmail(),
                clienteDTO.getCiudad(),
                clienteDTO.getDireccion()
        );
        clienteRepository.save(cliente);
    }
}
