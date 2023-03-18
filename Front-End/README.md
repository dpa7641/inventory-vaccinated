# inventory-vaccinated
reto de programación de kruger

# Desarrollo

Para el desarrolo front-end se siguio una serie de pasos:
- ccreacion del protecto mediante la utilizacion de Vite (npm create vite@latest) 
- Instalaccion de los modulos de node (npm install)
- Implementacion de las respectivas dependencias 
  * axios
  * material ui (con los paquetes de styled, icons y font)
  * reacct-route-dom
- Utlizacion del entorno de desarrollo Visual Studio Code para el desarrollo de cada entidad
  * Limpieza de los archivos con los cuales se crea el proyecto
  * implementacion de rutas dentro del archivo Main
  * Creacion de estructura de carpetas dentro del proyecto
  * Creacion de archivos dentro de las carpetas (esto en base a las entidades del back-end)
  * Coneccion con el back-end previamente desarrollado (mediante la utilizacion de axios)
  * Implementacion de Login y Dashboard
  * Respectivas implementaccion de los archivos previamente creados
    * Implemetacion de CRUDs de cada respectiva entidad:  Rol, Vaccine(Vacunas),User(Usuarios),  Vaccination(Vacunaciones) y Config(configuracion para seguridad) 
  * Correccion de errores del back-end para la utilizacion de front-end

  # Desarrollo faltante

Dentro del desarrollo front-end, debido al tiempo implementado en el desarrollo del back-end, no se llego a cubrir el desarrollo tanto como se esperaba, faltando asi:
- Implementacion de seguridad: Esto debido a que con la preparacion de la posible implementacion de seguridad del back-end, y al no conocimiento de la uliticacion de OAuth 2.0, no se llego a implementar
Login: Aunque se llego a implementar la interface, no se tiene un desarrollo de control dentro del mismo
- Creacion e implementacion de permisos: Separacion de datos con respecto a cada usuario mediante la utilizacion de permisos
- Control de datos en los formularios.
- Edicion de usuarios: dentro del CRUD de usuarios se tiene la visualizacion, creacion y eliminacion de usuarios, faltando el desarrollo de la edicion de los mismos.
- Filtrados.

# Requerimientos para ejecucion

Para la ejecucion de la apliacion en un entorno nuevo es necesario contar con los siguientes requerimientos:
  * Node (se puede descargar desde https://nodejs.org/en)
  * npm (en mismo se cuede enontrar en https://www.npmjs.com/)
  * Visual Studio Code (tambien se puede realizar mediante el entorno de desarrollo de su preferencia, pero tomando en cuenta las configuraciones necesarias para el correcto funcionamiento)
  * Git (con cuenta en https://github.com/).
  * Un navegador de su eleccion

# Ejecucion

- Para la ejecucion:
  * Copiar el poyecto al ordenador con:
    * git clone https://github.com/dpa7641/inventory-vaccinated.git
  * Ingresar en el proyecto (dentro de la cacrpeta front-end) y ejecutar dentro del mismo el Visual Studio Code 
  * Dar los permisos necesarios (en caso de requerirlos)
  * En una consola dentro del proyecto ejecutar el comando: npm install
  * Ejecutar el proyeto con el comando: npm run dev
- Con las anteriores instrucciones el proyecto se estara ejecutando, por lo que puede llegar a visualizarlo desde el navegador diriguiendo a la direccion: http://localhost:5173
- Las entidades desarrolladas se pueden llegar a visualizar desde la direccion http://localhost:5173/dashboard/

