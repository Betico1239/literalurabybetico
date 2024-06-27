
<h1 align="center"> Literalura By Betico</h1>

<img src="https://github.com/Betico1239/currencies_exchanger/assets/132612578/d50e3294-742f-4474-9b01-7e19783d2ef1" width = 50>

<img src="https://github.com/Betico1239/literalurabybetico/assets/132612578/fe65684a-ff4d-455b-82bc-dace8ac5469a" width = 50>


![Badge en Desarollo](https://img.shields.io/badge/STATUS-EN%20DESAROLLO-purple)
![GitHub Org's stars](https://img.shields.io/github/stars/Betico1239?style=social)


## Descripción
En este proyecto, te mostraré cómo construir una aplicación en Java que consume la API de Gutendex, procesa esta información y la almacena en una base de datos relacional (PostgreSQL), para luego mostrar resultados importantes al usuario a través de la consola.

La aplicación Java se encargará de realizar peticiones a la API de Gutendex para obtener datos como títulos de libros, autores, y otra información relevante. Estos datos serán procesados y almacenados en una base de datos PostgreSQL, donde se gestionará la persistencia de los libros y autores.

Además de la gestión de la base de datos, la aplicación incluirá funcionalidades para filtrar y presentar resultados significativos al usuario a través de la interfaz de línea de comandos (consola). Por ejemplo, podrías implementar funcionalidades como la búsqueda por título o autor, la recuperación de detalles específicos de un libro, y la generación de informes sobre la biblioteca virtual consultada.

El objetivo es proporcionar una herramienta eficaz y útil para gestionar y consultar datos de libros de manera estructurada y accesible directamente desde la consola, utilizando tecnologías modernas como Java y PostgreSQL para garantizar la robustez y escalabilidad del sistema.

## Instalación
1. Clonar el repositorio:
   ```sh
   git clone <URL_del_repositorio>
2. Abrir el proyecto en un IDE que soporte archivos .java (recomendado IntelliJ IDEA).
3. Ejecutar la clase Principal para iniciar el programa.

## :hammer:Funcionalidades del proyecto
- `Funcionalidad 1`: Es de aclarar que deberás configurar tu base de datos POSTGRE SQL para que funcione con mi proyecto, recordando que está de forma local
- `Funcionalidad 2`: Luego de configurar tus varibles de entorno y verificar la version 22 de java, podrás ejecutar el programa desde "LiteraluraProjectApplication.java".
- `Funcionalidad 3`: Luego encontrarás un menú amplio para que puedas interacturar con la información que desees.
- `Funcionalidad 4`: Primeramente, podrás buscar títulos de libros que se encuentren en la API de gutendex, los cuáles serán almacenados directemente en la base de datos de postgres que hayas registrado.
- `Funcionalidad 5`: Luego de alimentar tu base de datos podrás utilizar las demás opciones, donde puedes consultar los libros registrados, los autores y cada uno de sus libros anexados, una lista de autores que hayan estados vivos a partir de un año que deseees, y finalmente filtrar los libros por el idioma que desees.
- `Funcionalidad 6`: Finalmente el usuario podrá salir del programa especificando el número y se mostrará el historial correspondiente y el programa habrá finalizado.

## Autores
| <img src="https://github.com/Betico1239/currencies_exchanger/assets/132612578/1e475b43-8bf7-4579-9624-757f2080c86e" width=115><br><sub>Cristian Alberto Bravo Granados</sub>|
| :---: |


## Tecnologías
| Tecnologías usadas  | Descripción |
| ------------- | ------------- |
| Java (Spring boot) | Utilizado para la lógica del programa |
| Postgres SQL | Utilizado para almacenar la información de la API |
| Derived Queries  y JPQL | Para manejar las consultas a la base de datos |
|  IntelliJ IDEA IDE | Utilizado para el desarrollo  |
| API de Gutendex  | Para obtener los libros deseados en fromato JSON.  |
| Dependecia Jackson | Para manejar y adaptar el formato JSON a la clase deseada.  |
|  Excepciones personalizadas | Para manejar errores y proporcionar información útil al usuario.  |

## Licencia
Gratuita de uso libre.
