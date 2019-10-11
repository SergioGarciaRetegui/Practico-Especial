# Trabajo Practico Especial 

## Análisis de trabajo preexistente de Metodología de desarrollo de software

En Trabajo realizado para la cursada de metodología se enfoco principalmente en la ejercitación de métodos ágiles para el desarrollo de software, por este motivo inicialmente se realizo una captura general de requerimientos, a lo cual siguió la definición de las User Story.
Una vez definidas las US, la cátedra fue asignando en cada spring una para cada grupo, por lo que en ningún momento se desarrollo el trabajo en forma entera por cada grupo, es decir cada grupo desarrollo el sistema en fragmentos, por lo cual nunca pudimos establecer un diseño completo de las tablas en las cuales persistir los datos.
Solo se implementaron las tablas y clases de las User Story asignadas al Sprint que se asignaba.

## Rediseño del sistema para cátedra Arquitecturas Web


En virtud de la narrativa entregada por la cátedra se decidió establecer el siguiente grupo de clases:

**Usuario:** Clase que persiste los datos de un usuario del sistema (vecinos que acopian residuos).  
**Punto Limpio:** Clase que representa los lugares de acopio los cuales son dinámicos, es decir su locación cambia, para esto persiste su ubicación así como también datos como el nombre del punto limpio y su capacidad de acopiar residuos.  
**Ong:** Este clase representa a las organizaciones que reciben los residuos clasificados de los puntos limpios.  
**Camión:** Esta clase modela los camiones recolectores los cuales recorren según un itinerario los puntos limpios Itinerantes para recolectar los residuos, esta clase permite persistir su ubicación a fin de que se pueda seguir en tiempo real su ubicación.  
**Residuo:**Representan los residuos que se acopiaran clasificados en los puntos limpios y serán entregados a las ONGs.  
**Acopio:** Representa la acción de deposito de residuos por parte de un usuario en un Punto limpio, para esto se deben completar datos como punto limpio en donde se realiza la deposición, el residuo depositado, la cantidad y la fecha de deposito.  
**Donación:**Representa la entrega de residuos clasificados por parte de los puntos limpios a las Ong.  
**Recolección:**Representa los recorridos que realizan los camiones, básicamente son instancias de puntos con fecha y hora de recolección.  
