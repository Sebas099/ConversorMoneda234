import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;



public final class Request {
    public static String adress = "https://v6.exchangerate-api.com/v6/";
    private static final String key = "API_KEY";
    private static String[] currency = {"USD/ARS/", "ARS/USD/", "USD/BRL/", "BRL/USD/", "USD/COP/", "COP/USD/"};
    
    private Request(){}
    public static void makeRequest(String endpoint, String amount) throws IOException, InterruptedException {

        var url = adress + key + endpoint + amount;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

    private static void saveToJson(String response) throws IOException {
        JsonElement jsonElement = JsonParser.parseString(response);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter file = new FileWriter("response.json");
        file.write(gson.toJson(jsonElement));
        file.close();
    }

    public static String resource(int i) {
        return "/pair/" + currency[i];
    }
}
