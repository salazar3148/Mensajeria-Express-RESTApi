package com.christiansalazar.MensajeriaExpress.Controlador;
import com.christiansalazar.MensajeriaExpress.DTO.ClienteDTO;
import com.christiansalazar.MensajeriaExpress.DTO.EmpleadoDTO;
import com.christiansalazar.MensajeriaExpress.DTO.Responses.Mensaje;
import com.christiansalazar.MensajeriaExpress.Servicio.EmpleadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1")
@RestController
@Api(value = "Endpoints Empleados", tags = {"Endpoints Empleados"})
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Empleado encontrado correctamente"),
            @ApiResponse(code = 404, message = "Empleado no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite obtener un Empleado del sistema",
            notes = "Validaciones:\n1. El empleado debe existir\n- La cedula se envia por el url",
            response = EmpleadoDTO.class)
    @GetMapping("/empleados/{cedula}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleado(@PathVariable Long cedula){
        EmpleadoDTO empleadoDTO = empleadoService.obtenerEmpleado(cedula);
        return new ResponseEntity<>(empleadoDTO, HttpStatus.OK);
    }

    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Empleado guardado correctamente"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite ingresar un nuevo empleado al sistema",
            notes = "Validaciones:\n1. Cedula no nula\n2. Nombre no nulo\n3. Primer Apellido no nulo\n4. Celular no nulo\n5. Email no nulo\n6. Antiguedad no nulo\n7. Tipo de sangre no nulo\n8. Tipo de empleado no nulo\n9. No debe estar previamente registrado\n- A continuacion se muestra como debe ser el cuerpo de la petición:",
            response = EmpleadoDTO.class)
    @PostMapping("/empleados")
    public ResponseEntity<Mensaje> anadirEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        Long cedula = empleadoService.anadirEmpleado(empleadoDTO).getCedula();
        return new ResponseEntity<>(new Mensaje("El empleado con cedula: " + cedula + ", fue añadido con exito"), HttpStatus.CREATED);
    }

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Empleado eliminado correctamente"),
            @ApiResponse(code = 404, message = "Empleado no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite eliminar un empleado del sistema",
            notes = "Validaciones:\n1. El empleado debe existir\n- La cedula se envia por el url",
            response = EmpleadoDTO.class)
    @DeleteMapping("/empleados/{cedula}")
    public ResponseEntity<Mensaje> eliminarEmpleado(@PathVariable Long cedula){
        empleadoService.eliminarEmpleado(cedula);
        return new ResponseEntity<>(new Mensaje("El empleado con cedula: " + cedula + ", fue eliminado con exito"), HttpStatus.OK);
    }

    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Empleado actualizado correctamente"),
            @ApiResponse(code = 404, message = "Empleado no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite actualizar un empleado del sistema",
            notes = "Validaciones:\n1. El empleado debe existir\n- La cedula se envia por el url, a continuación se muestra como debe ser el cuerpo de la peticion",
            response = ClienteDTO.class)
    @PutMapping("/empleados/{cedula}")
    public ResponseEntity<Mensaje> actualizarEmpleado(@PathVariable Long cedula, @RequestBody EmpleadoDTO empleadoDTO) {
        empleadoService.actualizarEmpleado(cedula, empleadoDTO);
        return new ResponseEntity<>(new Mensaje("El empleado con cedula: " + cedula + ", fue actualizado con exito"), HttpStatus.OK);
    }
}
