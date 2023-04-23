package com.christiansalazar.MensajeriaExpress;

import com.christiansalazar.MensajeriaExpress.DTO.ClienteDTO;
import com.christiansalazar.MensajeriaExpress.Excepciones.ApiRequestException;
import com.christiansalazar.MensajeriaExpress.Modelo.Cliente;
import com.christiansalazar.MensajeriaExpress.Repositorio.ClienteRepository;
import com.christiansalazar.MensajeriaExpress.Servicio.ClienteService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class ClienteServiceTest {
    ClienteService clienteService;
    ClienteRepository clienteRepository;

    @Before
    public void setUp(){
        this.clienteRepository = mock(ClienteRepository.class);
        clienteService = new ClienteService(clienteRepository);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirClienteConCedulaNula(){
        //Arrange

        Long cedula = null;
        String nombre = "Jorge";
        String apellido = "Bedoya";
        Long celular = 3101234598L;
        String email = "jbedoya@mail.com";

        //Act
        ClienteDTO cliente = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        clienteService.anadirCliente(cliente);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirClienteConNombreNulo(){
        //Arrange

        Long cedula = 10014561024L;
        String nombre = null;
        String apellido = "Bedoya";
        Long celular = 3101234598L;
        String email = "jbedoya@mail.com";

        //Act
        ClienteDTO cliente = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        clienteService.anadirCliente(cliente);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirClienteConPrimerApellidoNulo(){
        //Arrange

        Long cedula = 10014561024L;
        String nombre = "Jorge";
        String apellido = null;
        Long celular = 3101234598L;
        String email = "jbedoya@mail.com";

        //Act
        ClienteDTO cliente = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        clienteService.anadirCliente(cliente);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirClienteConCelularNulo(){
        //Arrange

        Long cedula = 10014561024L;
        String nombre = "Jorge";
        String apellido = "Bedoya";
        Long celular = null;
        String email = "jbedoya@mail.com";

        //Act
        ClienteDTO cliente = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        clienteService.anadirCliente(cliente);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirClienteConEmailNulo(){
        //Arrange

        Long cedula = 10014561024L;
        String nombre = "Jorge";
        String apellido = "Bedoya";
        Long celular = 3101234598L;
        String email = null;

        //Act
        ClienteDTO cliente = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        clienteService.anadirCliente(cliente);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirClienteYaRegistrado(){
        //Arrange

        Long cedula = 10014561024L;
        String nombre = "Jorge";
        String apellido = "Bedoya";
        Long celular = 3101234598L;
        String email = "jbedoya@mail.com";
        when(clienteRepository.findById(10014561024L)).thenReturn(Optional.of(new Cliente(cedula, null, null, null, null, null,null, null)));

        //Act
        ClienteDTO cliente = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        clienteService.anadirCliente(cliente);
    }

    @Test
    public void anadirClienteCorrectamente(){
        //Arrange

        Long cedula = 10014561024L;
        String nombre = "Jorge";
        String apellido = "Bedoya";
        Long celular = 3101234598L;
        String email = "jbedoya@mail.com";

        //Act
        ClienteDTO cliente = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        clienteService.anadirCliente(cliente);

        //Assert
        verify(clienteRepository, times(1)).save(any());
    }

    @Test(expected = ApiRequestException.class)
    public void obtenerClienteConCedulaInvalida(){
        //Arrange
        when(clienteRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        clienteService.obtenerCliente(123L);
    }

    @Test
    public void obtenerClienteConTodoCorrecto(){
        //Arrange
        Long cedula = 10014561024L;
        String nombre = "Jorge";
        String apellido = "Bedoya";
        Long celular = 3101234598L;
        String email = "jbedoya@mail.com";

        Cliente cliente = new Cliente(cedula, nombre, apellido, null, celular, email, null, null);

        when(clienteRepository.findById(10014561024L)).thenReturn(Optional.of(cliente));

        //Act
        ClienteDTO cliente2 = clienteService.obtenerCliente(10014561024L);

        //Assert
        assertEquals(cliente.getCedula(), cliente2.getCedula());
    }

    @Test(expected = ApiRequestException.class)
    public void eliminarClienteQueNoExiste(){
        //Arrange
        when(clienteRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        clienteService.eliminarCliente(123L);
    }

    @Test
    public void eliminarClienteConTodoCorrecto(){

        //Arrange
        Cliente cliente = new Cliente();
        when(clienteRepository.findById(123L)).thenReturn(Optional.of(cliente));

        //Act
        clienteService.eliminarCliente(123L);

        //Assert
        verify(clienteRepository, times(1)).deleteById(any());
    }

    @Test(expected = ApiRequestException.class)
    public void actualizarClienteQueNoExiste(){
        //Arrange
        when(clienteRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        clienteService.actualizarCliente(123L, new ClienteDTO());
    }

    @Test
    public void actualizarClienteConTodoCorrecto(){
        //Arrange
        Long cedula = 10014561024L;
        String nombre = "Jorge";
        String apellido = "Bedoya";
        Long celular = 3101234598L;
        String email = "jbedoya@mail.com";

        //Act
        ClienteDTO clienteDTO = new ClienteDTO(cedula, nombre, apellido, null, celular, email, null, null);
        when(clienteRepository.findById(any())).thenReturn(Optional.of(new Cliente()));

        //Act
        clienteService.actualizarCliente(any(), clienteDTO);

        //Assert
        verify(clienteRepository, times(1)).save(any());
    }



}
