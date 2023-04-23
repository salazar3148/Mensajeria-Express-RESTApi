# $${\color{lightblue}RESTApi \space\space-\space\space MensajeriaExpress}$$

Este es un proyecto de API REST para gestionar todo el sistema de paqueteria de Mensajeria-Express.<br> La API permite a los clientes registrarse para así quedar habilitados en el despacho de sus paquetes.<br> Los empleados tambien se pueden registrar y pueden cambiar el estado del envio (En bodega, En Ruta o Entregado).<br> La API tiene cuatro entidades principales: Cliente, Empleado, Envio y Paquete.
<br>
<br>

## ${\color{lightgreen}Tecnologias \space usadas}$

- Spring boot
- Spring Security
- Base de datos relacional (H2)
- JPA
- Pruebas unitarias con JUNIT4 & Mockito
- DAO & DTO
- Swagger
- CI (Github Actions)
<br>

<div>
<img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="40" height="40"/> 
<img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/> 
<img src="https://dbdb.io/media/logos/h2-logo.svg" alt="h2" width="40" height="40"/> 
<img src="https://avatars.githubusercontent.com/u/874086?s=200&v=4" alt="spring" width="40" height="40"/> 
<img src="https://raw.githubusercontent.com/mockito/mockito/main/src/javadoc/org/mockito/logo.png" alt="mockiyo" width="80" height="40"/> 
<img src="https://i.imgur.com/Wtd4d97.png" alt="spring" width="35" height="40"/> </a>
<img src="https://cavedweller92.files.wordpress.com/2019/07/swagger-logo-horizontal.png" alt="spring" width="105" height="40"/>
</div>

<br>

## ${\color{lightgreen}Probar \space la \space aplicacion}$

> Swagger-UI es una herramienta que ayuda a probar y visualizar APIs REST de forma más sencilla y comprensible para aquellos que no tienen experiencia en tecnología. 
> Es como un "menú" para las API, que informa y muestra todas las opciones disponibles (Mediante los endpoints) para interactuar con ellas de una manera clara y ordenada

<br>

> Prueba los endpoints con este URL ->  http://localhost:8080/swagger-ui/

## ${\color{lightgreen}Reglas\space de \space negocio \space principales}$

- Todo cliente debe estar registrado para enviar un paquete
- Solo los empleados que sean coordinadores o conductores pueden cambiar el estado del paquete

- El paquete será de un tipo o otro según su peso en Kg: 
  - liviano: menor a 2Kg
  - Mediano: mayor o igual a 2Kg y Menor o igual a 5Kg
  - Grande: mayor a 5kg

- El valor del envio se calcula en base el tipo del paquete:
  - Liviano: 30000
  - Mediano: 40000
  - Grande: 50000

- El estado inicial de todo envio será, En Bodega
- El numero de guia se generará aleatoriamente
<br>

## ${\color{lightgreen}Entidades}$
### Habitación
Una habitación está definida por:

- Número
- Tipo de habitación (estándar o premium)
- Precio base

### Cliente
Un cliente está definido por:

- Cedula
- Nombre
- Apellido 1
- Apellido 2
- Celular
- Email
- Ciudad
- Direccion

### Empleado
Una reserva está definida por:

- Cedula
- Nombre
- Apellido 1
- Apellido 2
- Celular
- Email
- Ciudad
- Direccion
- Antiguedad
- Tipo de sangre
- Tipo de empleado

### Envio
Un cliente está definido por:

- Numero de Guia
- Cliente
- Ciudad Origen
- Ciudad Destino
- Direccion
- Destinatario
- Celular Destinatario
- Hora de entrega
- Estado
- Valor
- Paquete

### Cliente
Un cliente está definido por:

- ID
- Tipo de paquete
- Peso
- Valor Declarado
 
<br>
<br>

## ${\color{lightgreen}Endpoints}$
La API tiene varios endpoints para manejar las operaciones necesarias.

### Registro de cliente

Este endpoint permite registrar un nuevo cliente en el sistema
```java
URL: api/v1/clientes 
```
Ejemplo de peticion: 

```http
POST api/v1/clientes
Content-Type: application/json`
```

> **Validaciones:** <br>
> <li> Cedula no nula
> <li> Nombre no nulo
> <li> Primer Apellido no nulo
> <li> Celular no nulo
> <li> Email no nulo
> <li> No debe estar previamente registrado

```json
{
  "apellido1": "string",
  "apellido2": "string",
  "cedula": 0,
  "celular": 0,
  "ciudad": "string",
  "direccion": "string",
  "email": "string",
  "nombre": "string"
}
```
Ejemplo de respuesta:

```json
{
  "mensaje": "El cliente con cedula: 1001645612, fue añadido con exito"
}
```

<br>

### Obtener un cliente

Este endpoint permite obtener un cliente ya registrado, enviando por la URL su cedula

```java
URL: api/v1/clientes/{cedula}
```
Ejemplo de peticion: 



```http
GET api/v1/clientes/
URL: api/v1/clientes/88
```

> **Validaciones:** <br>
> <li> El cliente debe existir

Ejemplo de respuesta

```json
{
  "cedula": 88,
  "nombre": "Sofia",
  "apellido1": "Lopez",
  "apellido2": "Garcia",
  "celular": 3207770123,
  "email": "lopez@gmail.com",
  "ciudad": "Manizales",
  "direccion": "Calle 23 # 56 - 78"
}
```
<br>

### Actualizar un cliente

Este endpoint permite editar un cliente registrado en el sistema, debe enviar por URL la cedula,
y enviar por JSON los nuevos datos

```java
URL: api/v1/clientes
```
Ejemplo de peticion: 

```http
PUT api/v1/clientes/
Content-Type: application/json`
URL: api/v1/clientes/88
```

> **Validaciones:** <br>
> <li> El cliente debe existir
> <li> Las mismas en la inserción

```json
{
  "apellido1": "string",
  "apellido2": "string",
  "cedula": 0,
  "celular": 0,
  "ciudad": "string",
  "direccion": "string",
  "email": "string",
  "nombre": "string"
}
```
Ejemplo de respuesta:

```json
{
    "mensaje": "El cliente con cedula: 88, fue actualizado con exito"
}
```

<br>

### Eliminar un cliente

Este endpoint permite eliminar un cliente ya registrado, enviando por la URL su cedula

```java
URL: api/v1/clientes/{cedula}
```
Ejemplo de peticion: 



```http
DELETE api/v1/clientes/
URL: api/v1/clientes/88
```

> **Validaciones:** <br>
> <li> El cliente debe existir

Ejemplo de respuesta

```json
{
    "mensaje": "El cliente con cedula: 88, fue eliminado con exito"
}
```

### Registro de empleados

Este endpoint permite registrar un nuevo empleado al sistema
```java
URL: api/v1/empleados 
```
Ejemplo de peticion: 

```http
POST api/v1/empleados
Content-Type: application/json`
```

> **Validaciones:** <br>
> <li> Cedula no nula
> <li> Nombre no nulo
> <li> Primer Apellido no nulo
> <li> Celular no nulo
> <li> Email no nulo
> <li> Antiguedad no nulo
> <li> Tipo de sangre no nulo
> <li> Tipo de empleado no nulo
> <li> No debe estar previamente registrado

```json
{
  "antiguedad": 0,
  "apellido1": "string",
  "apellido2": "string",
  "cedula": 0,
  "celular": 0,
  "ciudad": "string",
  "direccion": "string",
  "email": "string",
  "nombre": "string",
  "rh": "AB_NEGATIVO",
  "tipoEmpleado": "CONDUCTOR"
}
```
Ejemplo de respuesta:

```json
{
  "mensaje": "El empleado con cedula: 1001645612, fue añadido con exito"
}
```

<br>

### Obtener un empleado

Este endpoint permite buscar un empleado que está en la base de datos, enviando por la URL su cedula

```java
URL: api/v1/empleados/{cedula}
```
Ejemplo de peticion: 



```http
GET api/v1/empleados/
URL: api/v1/empleados/11
```

> **Validaciones:** <br>
> <li> El empleado debe existir

Ejemplo de respuesta

```json
{
  "cedula": 11,
  "nombre": "Juan",
  "apellido1": "Gonzalez",
  "apellido2": "Perez",
  "celular": 3115551234,
  "email": "gonzalez@gmail.com",
  "ciudad": "Bogota",
  "direccion": "Calle 123 # 45 - 67",
  "antiguedad": 2,
  "rh": "A_POSITIVO",
  "tipoEmpleado": "CONDUCTOR"
}
```
<br>

### Actualizar un empleado

Este endpoint permite modificar un empeleado registrado, debe enviar por URL la cedula,
y enviar por el cuerpo de la petición los nuevos datos

```java
URL: api/v1/empleados
```
Ejemplo de peticion: 

```http
PUT api/v1/empleados/
Content-Type: application/json`
URL: api/v1/empleados/11
```

> **Validaciones:** <br>
> <li> El empleado debe existir
> <li> Las mismas en la inserción

```json
{
  "antiguedad": 0,
  "apellido1": "string",
  "apellido2": "string",
  "cedula": 0,
  "celular": 0,
  "ciudad": "string",
  "direccion": "string",
  "email": "string",
  "nombre": "string",
  "rh": "AB_NEGATIVO",
  "tipoEmpleado": "CONDUCTOR"
}
```
Ejemplo de respuesta:

```json
{
    "mensaje": "El Empleado con cedula: 11, fue actualizado con exito"
}
```

<br>

### Eliminar un Empleado

Este endpoint permite eliminar un empleado, enviando por la URL su cedula

```java
URL: api/v1/empleados/{cedula}
```
Ejemplo de peticion: 



```http
DELETE api/v1/empleados/
URL: api/v1/empleados/11
```

> **Validaciones:** <br>
> <li> El Empleado debe existir

Ejemplo de respuesta

```json
{
    "mensaje": "El empleado con cedula: 11, fue eliminado con exito"
}
```

## ${\color{lightgreen}Diagramas}$

- Modelo Relacional
![MR](https://user-images.githubusercontent.com/105958626/233867288-aa039b38-4ef9-4e8c-9f24-1d5194235cb0.png)

- Diagrama UML
![UML](https://user-images.githubusercontent.com/105958626/233867301-c506985a-2b37-4bb2-917b-303059c81f15.png)