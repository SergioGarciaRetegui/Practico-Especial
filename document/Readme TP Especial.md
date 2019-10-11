# Trabajo Practico Especial 

## Pautas de Instalación y ejecución de Test 

+ Clonar el repositorio en carpeta Workspace o descargar .zip y descomprimir en la misma carpeta.    
+ Desde Eclipse importar el proyecto.  
+ Al importar el proyecto se instalaran las dependencias que no esten insatladas en la maquina.  
+ Editar el archivo persistence.xml ubicado en: _**Java Resources/src/META-INF**_  
+ Verificar la linea _<property name="hibernate.hbm2ddl.auto" value=**"create"**/>_ que el valor value sea create.  
+ Guarda los cambios.  
+ Correr como JunitTest la clase **TestInitDataBase.java**  
+ Editar nuevamente el archivo persistence.xml ubicado en: _**Java Resources/src/META-INF  **_  
+ Modificar en la linea _<property name="hibernate.hbm2ddl.auto" value=**"create"**/>_ el valor **value** a _**update**_.  
+ Guarda los cambios.  
+ Correr como JunitTest la clase **TestUsuario.java**  
+ Correr como JunitTest la clase **testConsultaVarias.java**  
+ Correr como JunitTest la clase **TestBorrarBaseDeDatos.java**  
+ Correr como JunitTest la clase **TestListadoBaseDeDatos.java** 
