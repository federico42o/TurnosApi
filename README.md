
# Informatorio 2022 Java-Spring 

## Trabajo práctico integrador


Crear una API rest para poder sacar turnos para cualquier evento o motivo que cualquier empresa  u organización cargue en el sistema. No es necesario estar autenticado para interactuar con la API.

 ### Organización:
Deberá poder agregarse una empresa o organización que consta con los siguientes datos, nombre, cuit, dirección donde está registrada, teléfono de contacto, email de contacto, fecha de alta (en la que se dio de alta en el sistema) y una clave de alfanumérica de 20 a 40 caracteres, dicha clave se usará cuando la organización quiera crear un evento o motivo al cual las personas podrán sacar turno o si la organización desea eliminar el evento o motivo o si desea eliminar se la organización del sistema.

### Evento:
El evento será generado por alguna organización y las personas podrán sacar un turno para asistir.
El evento tendrá nombre, ubicación, un campo que indique si está activo el evento (estará inactivo si la fecha del mismo ya pasó), la fecha en la que la creó la organización,  también se deberá indicar si es algo ocasional/ único es decir un evento que es en un momento particular como por ejemplo un recital, una convención o si será algo recurrente es decir que suceda todos los días por ejemplo ir al medico, turno para ir a un gimnasio, ir a un bar etc. 
En  caso de que sea un evento único u ocasional la persona no deberá ingresar la fecha ya que la fecha es única y ya la cargo la organización en el evento
En caso de que sea un evento recurrente del día a día deberá indicar la fecha y la hora.(No puede haber dos turnos con la misma fecha y hora) y debe haber
Una empresa no podrá tener más de 1 eventos con el mismo nombre activos

### Persona:
Una persona podrá sacar un turno para algún evento, no necesita estar registrado, deberá enviar el/los nombre/s de la persona, su apellido, su dni, el nombre del evento, el nombre de la organización, la fecha y hora en caso de que corresponda, se generará una clave para que el usuario modifique sus datos o se de baja, tendrá un campo que indique si esta activo o no.

### Turno: 
El turno tendrá la fecha y hora en caso de que corresponda por ejemplo para ir a un turno médico o ir al gimnasio o un restaurante, en caso de que no corresponda por que es un evento como un recital o convención tendrá la fecha, tendrá un código alfabético generado aleatoriamente el cual no podrá ser repetido entre dos turnos activos, un campo que indique si el turno está activo o no (indica si la fecha del turno es anterior a la fecha actual).
