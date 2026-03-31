package com.mylabsystems.openmeteo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClimaAtual {

    @JsonProperty("temperature_2m")
    private double temperatura;

    @JsonProperty("windspeed_10m")
    private double velocidadeVento;

    @JsonProperty("weathercode")
    private int weathercode;

    // Getters
    public double getTemperatura() {
        return temperatura;
    }

    public double getVelocidadeVento() {
        return velocidadeVento;
    }

    public int getWeathercode() {
        return weathercode;
    }

    public String getDescricaoClima() {
        if (weathercode == 0) {
            return "Céu limpo";
        }
        if (weathercode >= 1 && weathercode <= 3) {
            return "Parcialmente nublado";
        }
        if (weathercode >= 45 && weathercode <= 48) {
            return "Neblina";
        }
        if (weathercode >= 61 && weathercode <= 67) {
            return "Chuva";
        }
        if (weathercode >= 71 && weathercode <= 77) {
            return "Neve";
        }
        if (weathercode >= 80 && weathercode <= 82) {
            return "Pancadas de chuva";
        }
        return "Condição desconhecida";
    }
}
