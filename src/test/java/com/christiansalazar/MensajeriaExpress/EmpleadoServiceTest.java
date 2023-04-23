package com.christiansalazar.MensajeriaExpress;
import com.christiansalazar.MensajeriaExpress.DTO.EmpleadoDTO;
import com.christiansalazar.MensajeriaExpress.Excepciones.ApiRequestException;
import com.christiansalazar.MensajeriaExpress.Modelo.Empleado;
import com.christiansalazar.MensajeriaExpress.Modelo.RH;
import com.christiansalazar.MensajeriaExpress.Modelo.TipoEmpleado;
import com.christiansalazar.MensajeriaExpress.Repositorio.EmpleadoRepository;
import com.christiansalazar.MensajeriaExpress.Servicio.EmpleadoService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EmpleadoServiceTest {

    EmpleadoService empleadoService;
    EmpleadoRepository empleadoRepository;

    @Before
    public void setUp(){
        this.empleadoRepository = mock(EmpleadoRepository.class);
        this.empleadoService = new EmpleadoService(empleadoRepository);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConCedulaNula(){
        //Arrange

        Long cedula = null;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConNombreNulo(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = null;
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConPrimerApellidoNulo(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = null;
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConCelularNulo(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = null;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConEmailNulo(){
        //Arrange

        Long cedula = null;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = null;
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConAntiguedadNula(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = null;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConTipoDeSangreNulo(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = null;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoConTipoDeEmpleadoNulo(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = null;

        //Act
        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);
        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test(expected = ApiRequestException.class)
    public void anadirEmpleadoYaRegistrado(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);

        when(empleadoRepository.findById(10372659483L)).thenReturn(Optional.of(new Empleado(cedula, null, null, null, null, null,null, null, null, null, null)));

        //Act

        empleadoService.anadirEmpleado(empleadoDTO);
    }

    @Test
    public void anadirEmpleadoConTodoCorrecto(){
        //Arrange

        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;

        EmpleadoDTO empleadoDTO = new EmpleadoDTO(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);

        when(empleadoRepository.findById(10372659483L)).thenReturn(Optional.empty());

        //Act

        empleadoService.anadirEmpleado(empleadoDTO);

        //Assert

        verify(empleadoRepository, times(1)).save(any());
    }

    @Test(expected = ApiRequestException.class)
    public void actualizarEmpleadoQueNoExiste(){
        //Arrange
        when(empleadoRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        empleadoService.actualizarEmpleado(anyLong(), new EmpleadoDTO());
    }

    @Test
    public void actualizarEmpleadoConTodoCorrecto(){
        //Arrange

        when(empleadoRepository.findById(any())).thenReturn(Optional.of(new Empleado()));

        //Act
        empleadoService.actualizarEmpleado(any(), new EmpleadoDTO());

        //Assert
        verify(empleadoRepository, times(1)).save(any());
    }

    @Test(expected = ApiRequestException.class)
    public void obtenerClienteConCedulaInvalida(){
        //Arrange
        when(empleadoRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        empleadoService.obtenerEmpleado(anyLong());
    }

    @Test
    public void obtenerClienteConTodoCorrecto(){
        //Arrange
        Long cedula = 10372659483L;
        String nombre = "Mauricio";
        String apellido = "Martinez";
        Long celular = 3021334598L;
        String email = "mmartinez@mail.com";
        Integer antiguedad = 2;
        RH rh = RH.A_POSITIVO;
        TipoEmpleado tipoEmpleado = TipoEmpleado.CONDUCTOR;
        Empleado empleado = new Empleado(cedula, nombre, apellido, null, celular, email, null, null, antiguedad, rh, tipoEmpleado);

        when(empleadoRepository.findById(10014561024L)).thenReturn(Optional.of(empleado));

        //Act
        EmpleadoDTO empleadoDTO = empleadoService.obtenerEmpleado(10014561024L);

        //Assert
        assertEquals(empleado.getCedula(), empleadoDTO.getCedula());
    }
    @Test(expected = ApiRequestException.class)
    public void eliminarClienteQueNoExiste(){
        //Arrange
        when(empleadoRepository.findById(any())).thenReturn(Optional.empty());

        //Act
        empleadoService.eliminarEmpleado(anyLong());
    }

    @Test
    public void eliminarClienteConTodoCorrecto(){
        //Arrange
        when(empleadoRepository.findById(any())).thenReturn(Optional.of(new Empleado()));

        //Act
        empleadoService.eliminarEmpleado(anyLong());

        //Assert
        verify(empleadoRepository, times(1)).deleteById(any());
    }
}
