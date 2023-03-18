# inventory-vaccinated
reto de programación de kruger

# Desarrollo

Para el desarrolo back-end de siguio una serie de pasos:
- Creacion de la base de datos
- Creacion del proyecto utilizando https://start.spring.io con la utilizacion de:
  * java 17
  * String en la version 3.0.4
  * Maven
  * Jar
- Implementacion de dependencias necesarias para el desarrollo
  * Spring Web
  * devtools
  * JPA
  * Lombok
  * PostgreSQL
  * De manera externa la dependencia de Swagger (OpenAPI)
- Utlizacion del entorno de desarrollo intelliJ para el desarrollo de cada entidad de manera progresiva siguiendo el mismo patron :
  * Creacion de las entidades y pojos en base a la base de datos previamente desarrollada
  * Creacion de los repositorios de las entidades
  * Creacion de los servicios e implementacion de los mismos
  * Creacion de los controladores e implementacion de los mismos
    * Para la creacion de los servicios y controladores, de realizo el desarrollo de los respecctivos CRUDs para finalmente implementar las historias de usuario solicitadas 
  * Comprovacion de funcionamiento mediande peticiones en Postman
  * Resolucion de confictos encontrados 
- La direccion de la creacion de las entidades fue: Rol, Vaccine(Vacunas), User(Usuarios), Vaccination(Vacunaciones) y Config(configuracion para seguridad) 
- Una vez termano el desarrollo de las entidades con sus respectivos end-points se implemento la respectiva documentacion swagger

# Desarrollo faltante

Dentro del desarrollo back-end, se llegue a cubrir gran parte de los requerimientos, no obstante, no se llego a realizar la culminacion del todo, faltando asi los siguientes puntos:
- Implementacion de seguridad: Debido al desconocimiento de utilizacion de OAuth 2.0 por parte de mi persona, no se llego a implementar la misma (aunque dado el caso que se se conoce la implementacion de seguridad mediante la utilizacion de jwt, y debido a la especificacion realizada, este punto fue preparado para su posible implemntacion posterior)
- Creacion e implementacion de permisos: Esto en base a la falta de culminacion del punto anterior
- Filtrado por fechas: Se tiene el servicio requerido y la consulta en BD, faltando la implemetacion en el respectivo controller.

# Requerimientos para ejecucion

Para la ejecucion de la apliacion en un entorno nuevo es necesario contar con los siguientes requerimientos:
  * Java (version 17, la misma se puede obtener de https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
  * IntelliJ IDEA, descargable desde https://www.jetbrains.com/idea/download/ (ya sea en su version de pago o comunity, tambien se puede realizar mediante el entorno de desarrollo de preferencia, pero tomando en cuenta las configuraciones necesarias para el correcto funcionamiento)
  * maven (se puede obtener de la direccion https://maven.apache.org/download.cgi)
  Postgres (utilizacion del desarrollo en su version 14) con su respectivo manejador (PgAdmin en la version que trae con la instalacion del postgres) obtenido en https://www.postgresql.org/download/
  * Git (con cuenta en https://github.com/).
  * Postman (este requisito es opcional, ya que se cuenta con la documentacion swagger, el mismo se puede obtener en https://www.postman.com/downloads/?utm_source=postman-home).
  * Un navegador de su eleccion.

# Ejecucion

- Para la ejecucion es necesario que el entorno cuente con los requerimientos previamente descritos ya configurados dentro de entorno, una vez se cuente con los mismos :
  * Copiar el poyecto al ordenador con con el siguiente comando dentro de una consola:
    * git clone https://github.com/dpa7641/inventory-vaccinated.git.
  * Ingresar en el proyecto (dentro de la cacrpeta back-end) y ejecutar dentro del mismo el IntelliJ.
  * Dar los permisos necesarios (en caso de requerirlos).
  * Cargar el archivo .sql que se encuentra dentro la carpera "Archivos auxiliares" en la BD postgres.
  * Dirigirse a la ubicacion del archivo: src/main/java/com/challenge/inventoryvaccinated/InventoryVaccinated.java y ejecutarlo.
- Con las anteriores instrucciones el proyecto se estara ejecutando, por lo que puede llegar a visualizar los end-points desarrollados desde el navegador diriguiendo a la direccion: http://localhost:9090/swagger-ui/index.html

# Notas

- La apliacion back end se ejecuta mediante el puerto "9090", en caso de que el puerto este siendo utilizado, reemplazar por el puerto de su preferencia en: src/main/resources/application.properties, en la linea 9: por server.port= {Puerto por el cual se desee ejecutar}.
  * Al cambiar el puerto tambien es requerido cambiar el puerto en todas las direcciones como ser la de swagger dentro del navegador.
- Al momento de cargar la base de datos dentro del nuevo entorno, se puede llegar a dar el caso que las credenciales llegen a ser diferentes. por lo que es necesario cambian las mismas por las que se encuentrar en su entorno, este cambio se realiza en src/main/resources/application.properties, en las lineas.
  * Linea 1: spring.datasource.url=jdbc:postgresql://localhost:{Puerto del postgres}/{Nombre de la base de datos}
  * Linea 2: spring.datasource.username= {nombre de usuario de postgres}
  * Linea 3: spring.datasource.password= {contraseña de usuario de postgres}
- Si se llega a contar con postman como medio de ejecucion cargar el archivo de postman que se encuentra en Archivos auxiliares/kruger.postman_collection.json dentro del programa, y ejecutar los endpoints conforme a las pruebas a realizar.
