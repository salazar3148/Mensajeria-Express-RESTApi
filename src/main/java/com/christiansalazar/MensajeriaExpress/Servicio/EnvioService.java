package com.christiansalazar.MensajeriaExpress.Servicio;

import com.christiansalazar.MensajeriaExpress.DTO.EnvioDTO;
import com.christiansalazar.MensajeriaExpress.Excepciones.ApiRequestException;
import com.christiansalazar.MensajeriaExpress.Modelo.*;
import com.christiansalazar.MensajeriaExpress.Modelo.Estado.EnBodega;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.ActualizarEnvioRequest;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.EnvioRequest;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.FiltrarRequest;
import com.christiansalazar.MensajeriaExpress.Modelo.Estado.Estado;
import com.christiansalazar.MensajeriaExpress.Repositorio.ClienteRepository;
import com.christiansalazar.MensajeriaExpress.Repositorio.EmpleadoRepository;
import com.christiansalazar.MensajeriaExpress.Repositorio.EnvioRepository;
import com.christiansalazar.MensajeriaExpress.Repositorio.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;
    private final ClienteRepository clienteRepository;
    private final PaqueteRepository paqueteRepository;
    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository, ClienteRepository clienteRepository, PaqueteRepository paqueteRepository, EmpleadoRepository empleadoRepository) {
        this.envioRepository = envioRepository;
        this.clienteRepository = clienteRepository;
        this.paqueteRepository = paqueteRepository;
        this.empleadoRepository = empleadoRepository;
    }

    public Envio despacharEnvio(EnvioDTO envioDTO) {

        if (envioDTO.getCedulaCliente() == null) throw new ApiRequestException("Cedula cliente necesaria");

        Optional<Cliente> cliente = clienteRepository.findById(envioDTO.getCedulaCliente());
        if (cliente.isEmpty()) throw new ApiRequestException("El cliente no está debidamente registrado");

        if (envioDTO.getCiudadOrigen() == null) throw new ApiRequestException("ciudad origen necesario");
        if (envioDTO.getCiudadDestino() == null) throw new ApiRequestException("ciudad destino necesario");
        if (envioDTO.getDireccionDestino() == null) throw new ApiRequestException("direccion destino necesario");
        if (envioDTO.getNombreRecibe() == null) throw new ApiRequestException("nombre recibe necesario");
        if (envioDTO.getCelular() == null) throw new ApiRequestException("celular  necesario");
        if (envioDTO.getValorDeclaradoPaquete() == null) throw new ApiRequestException("valor declarado paquete necesario");
        if (envioDTO.getPeso() == null) throw new ApiRequestException("peso necesario");

        TipoPaquete tipoPaquete;
        int valor;

        if (envioDTO.getPeso() < 2) {
            tipoPaquete = TipoPaquete.LIVIANO;
            valor = 30000;
        } else if (envioDTO.getPeso() >= 2 && envioDTO.getPeso() <= 5) {
            tipoPaquete = TipoPaquete.MEDIANO;
            valor = 40000;
        } else {
            tipoPaquete = TipoPaquete.GRANDE;
            valor = 50000;
        }

        Paquete paquete = new Paquete(tipoPaquete, envioDTO.getPeso(), envioDTO.getValorDeclaradoPaquete());
        paqueteRepository.save(paquete);

        Envio envio = new Envio(
                cliente.get(),
                envioDTO.getCiudadOrigen(),
                envioDTO.getCiudadDestino(),
                envioDTO.getDireccionDestino(),
                envioDTO.getNombreRecibe(),
                envioDTO.getCelular(),
                null,
                new EnBodega(),
                valor,
                paquete);

        envioRepository.save(envio);
        return envio;
    }

    public EnvioDTO consultarGuia(EnvioRequest envioRequest) {
        Optional<Envio> envio = envioRepository.findById(envioRequest.getNumeroGuia());
        if (envio.isEmpty()) throw new ApiRequestException("envio no registrado");
        return new EnvioDTO(
                envio.get().getCliente().getCedula(),
                envio.get().getCiudadOrigen(),
                envio.get().getCiudadDestino(),
                envio.get().getDireccion(),
                envio.get().getDestinatario(),
                envio.get().getCelularDestinatario(),
                envio.get().getPaquete().getValorDeclarado(),
                envio.get().getPaquete().getPeso(),
                envio.get().getEstado().toString()
        );
    }

    public Envio actualizarEstado(ActualizarEnvioRequest actualizarEnvioRequest) {
        Optional<Empleado> empleado = empleadoRepository.findById(actualizarEnvioRequest.getCedulaEmpleado());

        if (empleado.isEmpty()) throw new ApiRequestException("El empleado no está registrado");

        if (empleado.get().getTipoEmpleado() != TipoEmpleado.REPARTIDOR && empleado.get().getTipoEmpleado() != TipoEmpleado.COORDINADOR)
            throw new ApiRequestException("No cuenta con los permisos para actualizar el envio");

        Optional<Envio> envio = envioRepository.findById(actualizarEnvioRequest.getNumeroGuia());
        if (envio.isEmpty()) throw new ApiRequestException("El paquete no existe");

        envio.get().setEstado();

        envioRepository.save(envio.get());
        return envio.get();
    }

    public List<EnvioDTO> filtrarPorEstado(FiltrarRequest filtrarRequest) {
        Long cedula = filtrarRequest.getCedulaCliente();

        Optional<Cliente> cliente = clienteRepository.findById(cedula);
        if (cliente.isEmpty()) throw new ApiRequestException("El cliente con " + cedula + ", no existe en nuestra compañia");

        return envioRepository.findAll().stream()
                .filter(envio -> envio.getEstado().toString().toLowerCase().equals(filtrarRequest.getEstadoEnvio().toLowerCase()) && envio.getCliente().getCedula().equals(cedula))
                .map(envio -> new EnvioDTO(
                        envio.getCliente().getCedula(),
                        envio.getCiudadOrigen(),
                        envio.getCiudadDestino(),
                        envio.getDireccion(),
                        envio.getDestinatario(),
                        envio.getCelularDestinatario(),
                        envio.getPaquete().getValorDeclarado(),
                        envio.getPaquete().getPeso(),
                        envio.getEstado().toString()
                )).collect(Collectors.toList());
    }
}
