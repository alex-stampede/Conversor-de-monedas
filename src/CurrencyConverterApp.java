import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CurrencyConverterApp {

    private static final String API_KEY = "031dee57434fa088c57a70d2";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        // Bucle del menú
        while (option != 9) {
            System.out.println("\n==============================");
            System.out.println(" Conversor de Monedas");
            System.out.println("==============================");
            System.out.println("1. Realizar conversión de moneda");
            System.out.println("9. Salir de la aplicación");
            System.out.print("Elija una opción: ");

            option = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer del scanner

            switch (option) {
                case 1:
                    // Pedir moneda base
                    System.out.println("\n==============================");
                    System.out.print("Ingrese el código de la moneda base (ej. USD, MXN, JPY): ");
                    String baseCurrency = scanner.nextLine().toUpperCase();

                    // Pedir moneda objetivo
                    System.out.println("\n==============================");
                    System.out.print("Ingrese el código de la moneda a la que desea convertir (ej. EUR, CAD, GBP): ");
                    String targetCurrency = scanner.nextLine().toUpperCase();

                    // Pedir cantidad a convertir
                    System.out.println("\n==============================");
                    System.out.print("Ingrese la cantidad a convertir: ");
                    double amount = scanner.nextDouble();

                    // Obtener tasa de conversión y mostrar resultado
                    System.out.println("\n==============================");
                    double conversionRate = getConversionRate(baseCurrency, targetCurrency);
                    if (conversionRate != 0) {
                        double convertedAmount = convertCurrency(amount, conversionRate);
                        System.out.println(amount + " " + baseCurrency + " es igual a " + convertedAmount + " " + targetCurrency);
                    } else {
                        System.out.println("No se pudo obtener la tasa de cambio para " + targetCurrency);
                    }
                    break;

                case 9:
                    System.out.println("Saliendo de la aplicación... ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija 1 o 9.");
                    break;
            }
        }

        scanner.close();
    }

    // Metodo para obtener la tasa de conversión de la API
    public static double getConversionRate(String baseCurrency, String targetCurrency) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String url = BASE_URL + baseCurrency;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonResponse = parseJson(response.body());

        if (jsonResponse.get("result").getAsString().equals("success")) {
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
            return rates.get(targetCurrency).getAsDouble();
        } else {
            System.out.println("Error al obtener los datos de la API.");
            return 0;
        }
    }

    // Metodo para convertir la cantidad utilizando la tasa de conversión
    public static double convertCurrency(double amount, double rate) {
        return amount * rate;
    }

    // Metodo para parsear JSON usando Gson
    public static JsonObject parseJson(String responseBody) {
        Gson gson = new Gson();
        return gson.fromJson(responseBody, JsonObject.class);
    }
}
