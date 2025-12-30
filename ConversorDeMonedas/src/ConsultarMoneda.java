
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

    public class ConsultarMoneda {

        public Moneda buscarMoneda(String monedaBase, String monedaTarget, double cantidad) {

            // 1. Preparamos la URL
            // OJO: Puse tu Key aquí basándome en tu imagen, pero recuerda regenerarla después por seguridad.
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e577e974256268d160047710/pair/" +
                    monedaBase + "/" + monedaTarget + "/" + cantidad);

            // 2. Instanciamos al Cliente (El repartidor)
            HttpClient client = HttpClient.newHttpClient();

            // 3. Armamos la Solicitud (El paquete)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            try {
                // 4. Enviamos y esperamos la Respuesta
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                // 5. Convertimos el JSON (String) a nuestro objeto Moneda (Clase)
                return new Gson().fromJson(response.body(), Moneda.class);

            } catch (Exception e) {
                throw new RuntimeException("No encontré esa moneda.");
            }
        }
    }

