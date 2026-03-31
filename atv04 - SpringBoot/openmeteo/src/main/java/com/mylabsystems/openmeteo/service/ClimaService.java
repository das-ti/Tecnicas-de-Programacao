package com.mylabsystems.openmeteo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylabsystems.openmeteo.model.ClimaDados;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public ClimaDados buscarClima(String latitude, String longitude) {
        String url = "https://api.open-meteo.com/v1/forecast"
                + "?latitude=" + latitude
                + "&longitude=" + longitude
                + "&current=temperature_2m,windspeed_10m,weathercode"
                + "&timezone=America/Sao_Paulo";

        String json = restTemplate.getForObject(url, String.class);

        try {
            return mapper.readValue(json, ClimaDados.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar dados do clima", e);
        }
    }
}
