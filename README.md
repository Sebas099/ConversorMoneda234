## Conversor de monedas

Este proyecto desarrollado en Java permite consultar la tasa de cambio de una [moneda](#lista-de-monedas) a dólares estadounidenses (USD) y su operación inversa; moneda a dólar.
Se utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/). 

Proyecto realizado para el desafío del curso backend de la plataforma Alura.


## Lista de monedas disponibles

* Peso argentino (ARS)
* Real brasileño (BRL)
* Peso colombiano (COP)

## Requisitos y dependencias
* [JDK 17 o superior.](https://www.oracle.com/ae/java/technologies/downloads/#jdk24-windows)
* Conexión a internet.
* [ExchangeRate-API API Key](https://www.exchangerate-api.com/) válida (Requiere registro).

**Dependencias:**
* Librería externa [Gson](https://mvnrepository.com/artifact/com.google.code.gson/gson) formato .jar.

## Cómo ejecutar
**Windows:**
* Descargar el archivo .jar del paquete Gson y colocarlo en la carpeta "src".
* Abrir terminal de comandos ejecutando el archivo "opencosole.bat".
* Compilar el proyecto utilizando el siguiente comando en la terminal:

```bash
javac -cp "*.jar" *.java
```
* Ejecutar el programa utilizando el siguiente comando en la terminal, reemplazando "API_KEY" por nuestra [ExchangeRate-API API Key](https://app.exchangerate-api.com/keys):
```bash
java -cp "\;*.jar\" ConversorMoneda API_KEY
```

## Notas
Si ya se a compilado anteriormente el proyecto, se puede omitir este paso.
Tener en cuenta que ExchangeRate-API en su plan gratuito permite un máximo mensual de 1500 consultas.