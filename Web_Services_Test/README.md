# Web Services Test

## Requerimiento

Se tiene el siguiente requerimiento para una aplicación Web.
* Tomando como referencia lo documentado en este swagger: https://petstore.swagger.io/ .
* Agregar una mascota realizando un POST al path /v2/pet.
* Realizar un GET /v2/pet/{petId} para obtener una mascota existente.
* Modificar una mascota existente mediante PUT al path /v2/pet.

En todos los casos validar:
- Status code esperado.
- Schema del response.

## Descripción

Se realizan 3 escenarios uno por cada punto del requerimiento 
- Escenario para agregar una mascota.
- Escenario para obtener una mascota existente.
- Escenario para modificar una mascota existente.

## Instrucciones de ejeución

Descargar el proyecto desde:

https://github.com/CR105/bf-squaly-automation-exercise.git

Ingresar al directorio:
>bf-squaly-automation-exercise/Web_Services_Test

Dentro del siguiente directorio, se encontra el archivo data.json en el cual se puede cambiar los datos de la ejecución 

>src/test/java/examples/pets

Primero ejecutamos el siguiente comando para descargar las dependencias:
> mvn clean install

Posteriomente para ejecutar el escenrario de prueba se puede usar el siguiente comando:
> mvn test