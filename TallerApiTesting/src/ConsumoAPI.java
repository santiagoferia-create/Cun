import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando petición HTTP GET...");

            // 1. Crear el cliente
            HttpClient client = HttpClient.newHttpClient();

            // 2. Crear la solicitud (Endpoint)
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://jsonplaceholder.typicode.com/users/1"))
                    .GET()
                    .build();

            // 3. Enviar la solicitud y recibir la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Verificar código de estado (200 = OK)
            if (response.statusCode() == 200) {
                System.out.println("Respuesta recibida con éxito.");
                String jsonRecibido = response.body();
                System.out.println("JSON Crudo: " + jsonRecibido);

                // 5. Deserializar el JSON a un objeto Java
                Gson gson = new Gson();
                Usuario usuario = gson.fromJson(jsonRecibido, Usuario.class);
                System.out.println("Objeto Java (Deserializado): " + usuario);

                // INTEGRACIÓN: Usando el escudo para validar los datos de la API
                ValidadorUsuario validador = new ValidadorUsuario();
                if (validador.esEmailValido(usuario.getEmail())) {
                    System.out.println("✅ El email recibido de la API es seguro y válido.");
                } else {
                    System.err.println("❌ ALERTA: La API devolvió un email corrupto: " + usuario.getEmail());
                }

                // Pregunta de reflexión:
                // ¿Qué pasaría si consumimos la API de un banco, descargamos un usuario y el email viene nulo,
                // y no usamos el Validador antes de guardarlo en nuestra base de datos?
                // Respuesta: Podríamos insertar datos inválidos o nulos en la BD, causando errores posteriores
                // (NullPointerException, violaciones de integridad, datos corruptos, fallos en lógica de negocio).
                // El validador actúa como escudo para proteger la integridad del sistema.

            } else {
                System.out.println("Error en la petición. Código: " + response.statusCode());
            }
        } catch (Exception e) {
            System.err.println("Falla del puente (Error de red): " + e.getMessage());
            e.printStackTrace();
        }
    }
}
