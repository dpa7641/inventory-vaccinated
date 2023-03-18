# inventory-vaccinated
reto de programación de kruger


# Desarrollo
Para el desarrolo back-end de siguio una serie de pasos:
- Creacion de la base de datos
- Creacion del proyecto utilizando https://start.spring.io
- Utlizacion del entorno de desarrollo intelliJ para el desarrollo de cada entidad de manera progresiva siguiendo el mismo patron :
  * Creacion de las entidades y pojos en base a la base de datos previamente desarrolla
  * Creacion de los repositorios de las entidades
  * Creacion de los servicios e implementacion de los mismos
  * Creacion de los controladores
  * Comprovacion de funcionamiento mediande peticiones en Postman
  * Resolucion de confictos encontrados 
-

# requerimientos para ejecucion
Para la ejecucion de la apliacion en un entorno nuevo es necesario contar con los siguientes requerimientos:
  * Java en su version 17
  * IntelliJ IDEA (ya sea en su version de pago o comunity, tambien se puede realizar mediante el entorno de desarrollo de su preferencia, pero tomando en cuenta las configuraciones necesarias para el correcto funcionamiento)
  * maven
  Postgres (utilizacion del desarrollo en su version 14) con su respectivo manejador (PgAdmin en la version que trae con la instalacion del postgres)
  * Git
  * Un navegador de su eleccion

# ejecucion

- Para la ejecucion:
  * Copiar el poyecto al ordenador con:
    * git clone 
  * Ingresar en el proyecto i ejecutar dentro del mismo el IntelliJ 
  * Dar los permisos necesarios (en caso de requerirlos)
  * Dirigirse a la ubicacion del archivo: src/main/java/com/challenge/inventoryvaccinated/InventoryVaccinated.java 
- Con las anteriores instrucciones el proyecto se estara ejecutando, por lo que puede llegar a visualizar los end-points desarrollados desde el navegador diriguiendo a la direccion: 
