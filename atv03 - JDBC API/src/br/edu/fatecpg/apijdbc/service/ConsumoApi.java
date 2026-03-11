package br.edu.fatecpg.apijdbc.service;

import br.edu.fatecpg.apijdbc.model*;

public class ConsumoApi {
    import java.io.IOException;
    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;

    public class ConsomeApi {

        public static String buscaCnpj(String cnpj) throws IOException, InterruptedException {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://brasilapi.com.br/api/cnpj/v1/" + cnpj + "/json/")).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200 || response.body().contains("\"Número de CNPJ incorreto!\"")) {
                return null;
            }
            return response.body();
        }
    }
