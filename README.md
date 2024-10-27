# Api-Jugadores.n-m


## Descripción

Api-Jugadores.n-m es una API REST diseñada para gestionar información sobre jugadores y trofeos. Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) tanto para jugadores como para trofeos, y facilita la relación muchos-a-muchos entre ellos.

## Características

- **Consulta de Jugadores:** Obtener todos los jugadores y sus respectivos trofeos.
- **Consulta Individual de Jugadores:** Acceder a un jugador específico junto con sus trofeos.
- **Consulta de Trofeos:** Listar todos los trofeos disponibles en el sistema.
- **Creación de Jugadores:** Añadir nuevos jugadores al sistema, inicializando su colección de trofeos a vacía.
- **Creación de Trofeos:** Insertar nuevos trofeos, comenzando con una colección de jugadores vacía.
- **Asignación de Trofeos a Jugadores:** Otorgar un trofeo a un jugador existente.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework para crear aplicaciones Java.
- **Hibernate**: ORM para la gestión de la base de datos.
- **MySQL**: Base de datos relacional utilizada para almacenar la información.

## Endpoints

### Jugadores

- **GET** `/api/v1/jugador`: Obtiene todos los jugadores.
- **GET** `/api/v1/jugador/name/{username}`: Obtiene un jugador por nombre.
- **POST** `/api/v1/jugador/insert`: Crea un nuevo jugador.
- **POST** `/api/v1/jugador/{jugadorId}/trofeos/{trofeoId}`: Otorga un trofeo a un jugador.
- **PUT** `/api/v1/jugador/edit/{id}`: Actualiza la información de un jugador.
- **DELETE** `/api/v1/jugador/delete/{id}`: Elimina un jugador.

### Trofeos

- **GET** `/api/v1/trofeo`: Obtiene todos los trofeos.
- **GET** `/api/v1/trofeo/title/{titulo}`: Obtiene un trofeo por título.
- **POST** `/api/v1/trofeo/insert`: Crea un nuevo trofeo.
- **PUT** `/api/v1/trofeo/edit/{id}`: Actualiza la información de un trofeo.
- **DELETE** `/api/v1/trofeo/delete/{id}`: Elimina un trofeo.

## Ejemplo de Solicitudes

### Crear Jugador

```json
{
  "jugadorId": 0,
  "name": "Alicia",
  "trofeosGanados": []
}

### Crear Trofeos

```json
{
  "trofeoId": 0,
  "titulo": "Mejor Jugador",
  "descrip": "Otorgado al mejor jugador del torneo"
}
