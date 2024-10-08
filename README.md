# Conversor-de-monedas

Conversor de Monedas - Java

Descripción

Este proyecto es una aplicación de consola en Java que permite convertir montos entre diferentes monedas utilizando tasas de cambio en tiempo real. La aplicación se conecta a una API externa para obtener las tasas de cambio actuales y realiza los cálculos de conversión según las monedas seleccionadas por el usuario.

Características

Conversión de monedas en tiempo real utilizando una API externa.
Menú interactivo que permite al usuario realizar múltiples conversiones.
Opción de salir de la aplicación cuando lo desee.
La API utilizada es ExchangeRate-API, que proporciona tasas de cambio actualizadas.


Requisitos

Java 11 o superior.
Conexión a Internet para realizar las solicitudes a la API.


Instalación

Clona el repositorio o descarga el código fuente.

git clone [https://github.com/tu_usuario/conversor-monedas-java.git](https://github.com/alex-stampede/Conversor-de-monedas)
Abre el proyecto en IntelliJ IDEA o cualquier otro IDE compatible con Java.
Asegúrate de tener la dependencia de Gson para manejar la respuesta en formato JSON. Puedes agregar esta dependencia al archivo pom.xml si usas Maven:

<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.8.9</version>
</dependency>

Obtén una API key de ExchangeRate-API, si aún no tienes una.
Reemplaza la variable API_KEY en el código con tu clave de API.


private static final String API_KEY = "TU-API-KEY";


Uso

Al ejecutar la aplicación, se mostrará un menú con las siguientes opciones:

==============================
 Conversor de Monedas
==============================
1. Realizar conversión de moneda
9. Salir de la aplicación
Elige la opción 1 para realizar una conversión de moneda. Se te solicitará lo siguiente:
Código de la moneda base (por ejemplo, USD para dólares estadounidenses).
Código de la moneda a la que deseas convertir (por ejemplo, EUR para euros).
Cantidad que deseas convertir.
La aplicación consultará las tasas de cambio y mostrará el resultado de la conversión. Después de la conversión, el menú principal se mostrará nuevamente, permitiendo realizar más conversiones o salir del programa.
Para salir de la aplicación, presiona 9 en el menú principal.
Ejemplo de Ejecución


==============================
 Conversor de Monedas
==============================
1. Realizar conversión de moneda
9. Salir de la aplicación
Elija una opción: 1
Ingrese el código de la moneda base (ej. USD): USD
Ingrese el código de la moneda a la que desea convertir (ej. EUR): EUR
Ingrese la cantidad a convertir: 100
100.0 USD es igual a 90.13 EUR

==============================
 Conversor de Monedas
==============================
1. Realizar conversión de moneda
9. Salir de la aplicación
Elija una opción: 9
Saliendo de la aplicación... ¡Adiós!


API Utilizada

Este proyecto utiliza la API de ExchangeRate-API para obtener tasas de cambio actualizadas.

Documentación API: ExchangeRate API Docs

Autor

Nombre: Alex-Stampede
Contacto: contacto@marketingorion.com

Este proyecto está bajo la licencia MIT. Puedes ver más detalles en el archivo LICENSE.
