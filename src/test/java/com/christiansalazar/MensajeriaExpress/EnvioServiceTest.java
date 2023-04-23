package com.christiansalazar.MensajeriaExpress;

import com.christiansalazar.MensajeriaExpress.DTO.EnvioDTO;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.ActualizarEnvioRequest;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.EnvioRequest;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.FiltrarRequest;
import com.christiansalazar.MensajeriaExpress.Excepciones.ApiRequestException;
import com.christiansalazar.MensajeriaExpress.Modelo.*;
import com.christiansalazar.MensajeriaExpress.Modelo.Estado.EnBodega;
import com.christiansalazar.MensajeriaExpress.Modelo.Estado.EnRuta;
import com.christiansalazar.MensajeriaExpress.Modelo.Estado.Entregado;
import com.christiansalazar.MensajeriaExpress.Repositorio.ClienteRepository;
import com.christiansalazar.MensajeriaExpress.Repositorio.EmpleadoRepository;
import com.christiansalazar.MensajeriaExpress.Repositorio.EnvioRepository;
import com.christiansalazar.MensajeriaExpress.Repositorio.PaqueteRepository;
import com.christiansalazar.MensajeriaExpress.Servicio.EnvioService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class EnvioServiceTest {
    EmpleadoRepository empleadoRepository;
    ClienteRepository clienteRepository;
    EnvioRepository envioRepository;

    PaqueteRepository paqueteRepository;

    EnvioService envioService;

    @Before
    public void setUp(){
        this.empleadoRepository = mock(EmpleadoRepository.class);
        this.clienteRepository = mock(ClienteRepository.class);
        this.envioRepository = mock(EnvioRepository.class);
        this.paqueteRepository = mock(PaqueteRepository.class);
        this.envioService = new EnvioService(envioRepository, clienteRepository, paqueteRepository, empleadoRepository);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConCedulaCLienteNula() {
        //Arrange
        Long cedulaCliente = null;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 3.15D;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConCiudadOrigenNulo() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = null;
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 3.15D;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConCiudadDestinoNulo() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = null;
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 3.15D;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConDireccionDestinoNula() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = null;
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 3.15D;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConNombreRecibeNulo() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = null;
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 3.15D;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConCelularNulo() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = null;
        Integer valorDeclarado = 150000;
        Double peso = 3.15D;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConValorDeclaradoNulo() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = null;
        Double peso = 3.15D;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void despacharEnvioConPesoNulo() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = null;

        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);

        //Act

        envioService.despacharEnvio(envioDTO);
    }

    @Test
    public void despacharEnvioConTodoCorrecto() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 1.5D;

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        //Act

        envioService.despacharEnvio(envioDTO);

        //Assert

        verify(envioRepository, times(1)).save(any());
    }



    @Test
    public void evaluarPaqueteLiviano() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 1.5D;

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        //Act

        Envio envio = envioService.despacharEnvio(envioDTO);

        //Assert
        assertEquals(envio.getPaquete().getTipo(), TipoPaquete.LIVIANO);
    }

    @Test
    public void evaluarPaqueteMediano() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 4.5D;

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        //Act

        Envio envio = envioService.despacharEnvio(envioDTO);

        //Assert
        assertEquals(envio.getPaquete().getTipo(), TipoPaquete.MEDIANO);
    }

    @Test
    public void evaluarPaqueteGrande() {
        //Arrange
        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 8D;

        EnvioDTO envioDTO = new EnvioDTO(cedulaCliente, ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular, valorDeclarado, peso, null);
        when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(new Cliente()));

        //Act

        Envio envio = envioService.despacharEnvio(envioDTO);

        //Assert
        assertEquals(envio.getPaquete().getTipo(), TipoPaquete.GRANDE);
    }

    @Test(expected = ApiRequestException.class)
    public void consultarGuiaQueNoExiste() {

        //Arrange
        when(envioRepository.findById(any())).thenReturn(Optional.empty());

        //Act

        envioService.consultarGuia(new EnvioRequest("123ABC"));
    }

    @Test
    public void consultarGuiaExistente() {
        //Arrange

        Long cedulaCliente = 10018431392L;
        String ciudadOrigen = "Medellin";
        String ciudadDestino = "Bogota";
        String direccionDestino = "Calle 33B #15-64";
        String nombreRecibe = "Sebastian soto";
        Long celular = 3014562366L;
        Integer valorDeclarado = 150000;
        Double peso = 8D;

        Envio envio = new Envio(new Cliente(123L, null, null, null, null, null, null, null), ciudadOrigen, ciudadDestino, direccionDestino, nombreRecibe, celular,null, new EnBodega(),  valorDeclarado, new Paquete());
        when(envioRepository.findById(any())).thenReturn(Optional.of(envio));

        //Act
        envioService.consultarGuia(new EnvioRequest("123ABC"));
    }

    @Test(expected = ApiRequestException.class)
    public void actualizarEstadoConEmpleadoNoRegistrado() {
        //Arrange
        when(empleadoRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        envioService.actualizarEstado(new ActualizarEnvioRequest("ABC123", 123L));
    }

    @Test(expected = ApiRequestException.class)
    public void actualizarEstadoConEmpleadoFierenteARepartidorOCoordinador() {
        //Arrange
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;
        when(empleadoRepository.findById(any())).thenReturn(Optional.of(new Empleado(null, null, null,null, null, null, null,null,null,null,tipoEmpleado)));

        //Act
        envioService.actualizarEstado(new ActualizarEnvioRequest("ABC123", 123L));
    }

    @Test(expected = ApiRequestException.class)
    public void actualizarEstadoConPaqueteInexistente() {
        //Arrange
        TipoEmpleado tipoEmpleado = TipoEmpleado.REPARTIDOR;
        when(empleadoRepository.findById(any())).thenReturn(Optional.of(new Empleado(null, null, null,null, null, null, null,null,null,null,tipoEmpleado)));
        when(envioRepository.findById(anyString())).thenReturn(Optional.empty());

        //Act

        envioService.actualizarEstado(new ActualizarEnvioRequest("ABC123", 123L));
    }

    @Test
    public void actualizarEstadoConTodoCorrecto() {
        //Arrange
        TipoEmpleado tipoEmpleado = TipoEmpleado.REPARTIDOR;
        when(empleadoRepository.findById(any())).thenReturn(Optional.of(new Empleado(null, null, null,null, null, null, null,null,null,null,tipoEmpleado)));
        when(envioRepository.findById(anyString())).thenReturn(Optional.of(new Envio(null, null,null,null,null,null,null,new EnBodega(), null, null)));

        //Act

        envioService.actualizarEstado(new ActualizarEnvioRequest("ABC123", 123L));

        //Assert
        verify(envioRepository, times(1)).save(any());
    }

    @Test(expected = ApiRequestException.class)
    public void filtrarPorEstadoConClienteInexistente() {
        //Arrange
        when(clienteRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        envioService.filtrarPorEstado(new FiltrarRequest("En Ruta", 123L));
    }

    @Test
    public void filtrarPorEstadoConTodoCorrecto() {
        //Arrange
        when(clienteRepository.findById(any())).thenReturn(Optional.of(new Cliente()));
        Envio envio = new Envio(new Cliente(123L, null, null, null, null, null, null, null), "Medellin", "Bogota", "Calle 13", "Mauricio", 3100549461L,null, new EnBodega(),  15000, new Paquete());
        Envio envio2 = new Envio(new Cliente(123L, null, null, null, null, null, null, null), "Medellin", "Bogota", "Calle 13", "Mauricio", 3100549461L,null, new EnRuta(),  15000, new Paquete());
        Envio envio3 = new Envio(new Cliente(123L, null, null, null, null, null, null, null), "Medellin", "Bogota", "Calle 13", "Mauricio", 3100549461L,null, new EnBodega(),  15000, new Paquete());
        Envio envio4 = new Envio(new Cliente(123L, null, null, null, null, null, null, null), "Medellin", "Bogota", "Calle 13", "Mauricio", 3100549461L,null, new Entregado(),  15000, new Paquete());
        List enviosAux = Arrays.asList(envio, envio2, envio3, envio4);
        when(envioRepository.findAll()).thenReturn(enviosAux);
        //Act

        List<EnvioDTO> envios = envioService.filtrarPorEstado(new FiltrarRequest("En Ruta", 123L));
        List<EnvioDTO> envios2 = envioService.filtrarPorEstado(new FiltrarRequest("En Bodega", 123L));
        List<EnvioDTO> envios3 = envioService.filtrarPorEstado(new FiltrarRequest("Entregado", 123L));

        //Assert
        assertEquals(envios.size(), 1);
        assertEquals(envios2.size(), 2);
        assertEquals(envios3.size(), 1);
    }
}
