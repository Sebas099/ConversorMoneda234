import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;


public final class Request {
    public static String adress = "https://v6.exchangerate-api.com/v6/";
    private static String[] currency = {"USD/ARS/", "ARS/USD/", "USD/BRL/", "BRL/USD/", "USD/COP/", "COP/USD/"};
    private static String convertAmount;
    
    private Request(){}

    public static void makeRequest(String endpoint, String amount, String key) throws IOException, InterruptedException {
        convertAmount = amount;
        String url = adress + key + endpoint + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        
        if (response.statusCode() == 404){
            System.out.println("Error en la consulta. Corrobore su API_KEY");
            System.exit(1);
        }
        System.out.println(jsonConverter(response.body()));
    }

    private static responseObject jsonConverter(String response) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.fromJson(response, responseObject.class);
    }

    public static String resource(int i) {
        return "/pair/" + currency[i];
    }
    private class  responseObject {
        @SerializedName("conversion_result")
        private String conversionResult;
        @SerializedName("base_code")
        private String currencyOne;
        @SerializedName("target_code")
        private String currencyTwo;
        @SerializedName("result")
        private String result;

        @Override
        public String toString() {
            if (result.equals("error"))
            {
                System.out.println("Error en la consulta. Corrobore su API_KEY");
                System.exit(1);
            }
            return convertAmount + " " + currencyOne + " equivalen a " + conversionResult + " " + currencyTwo;
        }
    }
}
