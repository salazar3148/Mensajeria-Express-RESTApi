package com.christiansalazar.MensajeriaExpress.Controlador;
import com.christiansalazar.MensajeriaExpress.DTO.ClienteDTO;
import com.christiansalazar.MensajeriaExpress.DTO.Responses.Mensaje;
import com.christiansalazar.MensajeriaExpress.Servicio.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@Api(value = "Controlador Clientes", tags = {"Endpoints Clientes"})
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Cliente encontrado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite obtener un cliente del sistema",
            notes = "Validaciones:\n1. El cliente debe existir\n- La cedula se envia por el url",
            response = ClienteDTO.class)
    @GetMapping("/clientes/{cedula}")
    public ResponseEntity<ClienteDTO> obtenerEmpleado(@PathVariable Long cedula){
        ClienteDTO clienteDTO = clienteService.obtenerCliente(cedula);
        return new ResponseEntity<>(clienteDTO, HttpStatus.OK);
    }

    @ApiResponses(value={
            @ApiResponse(code = 201, message = "cliente guardado correctamente"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite ingresar un nuevo cliente al sistema",
            notes = "Validaciones:\n1. Cedula no nula\n2. Nombre no nulo\n3. Primer Apellido no nulo\n4. Celular no nulo\n5. Email no nulo\n6. No debe estar previamente registrado\n- A continuacion se muestra como debe ser el cuerpo de la petición:",
            response = ClienteDTO.class)
    @PostMapping("/clientes")
    public ResponseEntity<Mensaje> anadirEmpleado(@RequestBody ClienteDTO clienteDTO){
        Long cedula = clienteService.anadirCliente(clienteDTO).getCedula();
        return new ResponseEntity<>(new Mensaje("El cliente con cedula: " + cedula + ", fue añadido con exito"), HttpStatus.CREATED);
    }

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Cliente eliminado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite eliminar un cliente del sistema",
            notes = "Validaciones:\n1. El cliente debe existir\n- La cedula se envia por el url",
            response = ClienteDTO.class)
    @DeleteMapping("/clientes/{cedula}")
    public ResponseEntity<Mensaje> eliminarEmpleado(@PathVariable Long cedula){
        clienteService.eliminarCliente(cedula);
        return new ResponseEntity<>(new Mensaje("El cliente con cedula: " + cedula + ", fue eliminado con exito"), HttpStatus.OK);
    }

    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
            @ApiResponse(code = 404, message = "Cliente no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite actualizar un cliente del sistema",
            notes = "Validaciones:\n1. El cliente debe existir\n- La cedula se envia por el url, a continuación se muestra como debe ser el cuerpo de la peticion",
            response = ClienteDTO.class)
    @PutMapping("/clientes/{cedula}")
    public ResponseEntity<Mensaje> actualizarEmpleado(@PathVariable Long cedula, @RequestBody ClienteDTO clienteDTO) {
        clienteService.actualizarCliente(cedula, clienteDTO);
        return new ResponseEntity<>(new Mensaje("El cliente con cedula: " + cedula + ", fue actualizado con exito"), HttpStatus.OK);
    }
}
