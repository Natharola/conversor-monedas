import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaConversionMoneda {
    public String buscaConversion(String monedaBase, String monedaObjetivo, double cantidad) {
        try {
            String apiKey = "ca73efd0fbf1e3440811e579";
            String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/"
                    + monedaBase + "/" + monedaObjetivo + "/" + cantidad;

            URI direccion = URI.create(urlStr);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            String status = jsonObject.get("result").getAsString();

            if (!status.equals("success")) {
                String errorType = jsonObject.has("error-type") ? jsonObject.get("error-type").getAsString() : "desconocido";

                switch (errorType) {
                    case "unsupported-code":
                        throw new RuntimeException("Error: Código de moneda no soportado.");
                    case "malformed-request":
                        throw new RuntimeException("Error: La solicitud está mal formada.");
                    case "invalid-key":
                        throw new RuntimeException("Error: Clave de API inválida.");
                    case "inactive-account":
                        throw new RuntimeException("Error: Cuenta de API inactiva.");
                    case "quota-reached":
                        throw new RuntimeException("Error: Se ha alcanzado el límite de peticiones.");
                    default:
                        throw new RuntimeException("Error desconocido de la API: " + errorType);
                }
            }

            double resultado = jsonObject.get("conversion_result").getAsDouble();
            return String.valueOf(resultado);

        } catch (NumberFormatException e) {
            throw new RuntimeException("Error de formato numérico: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error de entrada/salida: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // buena práctica en interrupciones
            throw new RuntimeException("La operación fue interrumpida.");
        }
    }
}