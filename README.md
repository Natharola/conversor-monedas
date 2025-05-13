conversor-monedas
programa que permite a través de una API conversión de monedas

🚀 Funcionalidad
Conversión entre dos monedas mediante una solicitud HTTP.
Manejo de errores comunes (moneda inválida, clave API inválida, límites superados).
Devuelve el resultado como una cadena con el valor convertido.
🛠 Requisitos
Java 11 o superior
Biblioteca Gson para procesar JSON
Clave de API de ExchangeRate (gratuita o de pago)
📦 Instalación
Clona el repositorio:
git clone https://github.com/tuusuario/conversor-moneda-java.git
cd conversor-moneda-java
Asegúrate de tener la biblioteca Gson en tu proyecto. Puedes agregarla manualmente o mediante Maven/Gradle.

Si usas Maven:
xml
Copiar
Editar
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
🔑 Configuración
Reemplaza "ca73efd0fbf1e3440811e579" en el código con tu propia clave de API de ExchangeRate.

Puedes obtener una aquí: https://www.exchangerate-api.com/

💡 Ejemplo de uso
java
Copiar
Editar
ConsultaConversionMoneda consulta = new ConsultaConversionMoneda();
String resultado = consulta.buscaConversion("USD", "CLP", 100);
System.out.println("Resultado: " + resultado);
⚠️ Manejo de errores
El programa maneja errores como:

Código de moneda inválido

Clave de API incorrecta o inactiva

Límite de peticiones alcanzado

Problemas de red o interrupciones
