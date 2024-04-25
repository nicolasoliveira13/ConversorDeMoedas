package br.com.alura.conversor.consultas;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCambio {
    public String buscaCambio(String cambio) {
        URI link = URI.create("https://v6.exchangerate-api.com/v6/7cf8bc3ac4357f545b6f797e/latest/" + cambio);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(link)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível determinar a moeda para câmbio.");
        }
    }
}