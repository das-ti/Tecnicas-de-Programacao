package com.mylabsystems.countries.service;

import com.mylabsystems.countries.model.Pais;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

@Service
public class PaisService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public Pais buscarPais(String nome) {
        String url = "https://restcountries.com/v3.1/name/" + nome;

        String json = restTemplate.getForObject(url, String.class);

        try {
            Pais[] paises = mapper.readValue(json, Pais[].class);
            return paises[0];
        } catch (JacksonException e) {
            throw new RuntimeException("País não encontrado ou erro na API", e);
        }
    }
}
