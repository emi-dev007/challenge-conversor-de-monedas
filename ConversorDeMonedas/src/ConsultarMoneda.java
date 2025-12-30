
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

    public class ConsultarMoneda {

        public Moneda buscarMoneda(String monedaBase, String monedaTarget, double cantidad) {


            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e577e974256268d160047710/pair/" +
                    monedaBase + "/" + monedaTarget + "/" + cantidad);


            HttpClient client = HttpClient.newHttpClient();


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            try {

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());


                return new Gson().fromJson(response.body(), Moneda.class);

            } catch (Exception e) {
                throw new RuntimeException("No encontré esa moneda.");
            }
        }
    }

