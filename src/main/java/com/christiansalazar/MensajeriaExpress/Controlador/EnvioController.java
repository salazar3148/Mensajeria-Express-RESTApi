package com.christiansalazar.MensajeriaExpress.Controlador;

import com.christiansalazar.MensajeriaExpress.DTO.ClienteDTO;
import com.christiansalazar.MensajeriaExpress.DTO.EmpleadoDTO;
import com.christiansalazar.MensajeriaExpress.DTO.EnvioDTO;
import com.christiansalazar.MensajeriaExpress.Modelo.Envio;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.ActualizarEnvioRequest;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.EnvioRequest;
import com.christiansalazar.MensajeriaExpress.DTO.Requests.FiltrarRequest;
import com.christiansalazar.MensajeriaExpress.DTO.Responses.EnvioResponse;
import com.christiansalazar.MensajeriaExpress.DTO.Responses.EstadoResponse;
import com.christiansalazar.MensajeriaExpress.Servicio.EnvioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1")
@Api(value = "Endpoints Envios", tags = {"Endpoints Envios"})
public class EnvioController {

    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Envio encontrado correctamente"),
            @ApiResponse(code = 404, message = "Envio no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite obtener un Envio por su numero de guia",
            notes = "Validaciones:\n1. La guia debe existir\n- A continuacion, se muestra como debe ser el cuerpo de la petición",
            response = EmpleadoDTO.class)
    @GetMapping("/envios")
    public ResponseEntity<EnvioDTO> consultarGuia(@RequestBody EnvioRequest envioRequest) {
        EnvioDTO envioDTO = envioService.consultarGuia(envioRequest);
        return new ResponseEntity<>(envioDTO, HttpStatus.OK);
    }

    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Envio encontrado correctamente"),
            @ApiResponse(code = 404, message = "Envio no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite obtener un Envio por su numero de guia y estado de entrega",
            notes = "Validaciones:\n1. El empleado\n2. El estado debe ser: (En bodega, En ruta, Entregado)\n- A continuacion, se muestra como debe ser el cuerpo de la petición",
            response = EnvioDTO.class)
    @GetMapping("/enviosfiltrado")
    public ResponseEntity<List<EnvioDTO>> filtrarPorEstado(@RequestBody FiltrarRequest filtrarRequest){
        List<EnvioDTO> enviosDTO = envioService.filtrarPorEstado(filtrarRequest);
        return new ResponseEntity<>(enviosDTO, HttpStatus.OK);
    }

    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Envio despachado correctamente"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite despachar un nuevo paquete",
            notes = "Validaciones:\n1. Cedula cliente no nula\n2. Ciudad Origen no nulo\n3. Ciudad destino no nulo\n4. Direccion destino no nulo\n5. Nombre recibe no nulo\n6. Celular no nulo\n7. Valor declarado paquete no nulo\n8. Peso no nulo\n9. El cliente no debe estar previamente registrado\n- A continuacion se muestra como debe ser el cuerpo de la petición:",
            response = EmpleadoDTO.class)
    @PostMapping("/envios")
    public ResponseEntity<EnvioResponse> despacharEnvio(@RequestBody EnvioDTO envioDTO){
        Envio envio = envioService.despacharEnvio(envioDTO);
        return new ResponseEntity<>(
                new EnvioResponse(envio.getNumeroGuia(), envio.getEstado().toString()),
                HttpStatus.CREATED
        );
    }

    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Cambio en el estado del paquete realizado correctamente"),
            @ApiResponse(code = 404, message = "Paquete no encontrado"),
            @ApiResponse(code = 400, message = "Parametros invalidos"),
            @ApiResponse(code = 500, message = "Ocurrió un error en el servidor")
    })
    @ApiOperation(value = "Este endpoint permite actualizar un empleado del sistema",
            notes = "Validaciones:\n1. El empleado debe existir\n2. El empleado tiene que ser Repartidor o Coordinador\n3. El Paquete tiene que existir con el numero de guia\n- A continuación se muestra como debe ser el cuerpo de la peticion",
            response = ClienteDTO.class)
    @PutMapping("/envios")
    public ResponseEntity<EstadoResponse> actualizarEstado(@RequestBody ActualizarEnvioRequest actualizarEnvioRequest) {
        Envio envio = envioService.actualizarEstado(actualizarEnvioRequest);
        return new ResponseEntity<>(
                new EstadoResponse(envio.getNumeroGuia(), envio.getEstado().toString()),
                HttpStatus.OK
        );
    }
}
