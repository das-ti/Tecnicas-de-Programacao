package client;

import com.google.gson.Gson;
import model.Empresa;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BrasilApiClient {

    private static final String BASE_URL = "https://brasilapi.com.br/api/cnpj/v1/";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public Empresa buscarEmpresa(String cnpjNumerico) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + cnpjNumerico))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        switch (response.statusCode()) {
            case 200:
                return gson.fromJson(response.body(), Empresa.class);
            case 404:
                throw new IllegalArgumentException("CNPJ nao encontrado na BrasilAPI.");
            default:
                throw new RuntimeException("Erro na API. Status: " + response.statusCode());
        }
    }
}
