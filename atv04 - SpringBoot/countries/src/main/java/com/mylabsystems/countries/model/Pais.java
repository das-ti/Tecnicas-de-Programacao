package com.mylabsystems.countries.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pais {

    @JsonProperty("name")
    private Name name;

    @JsonProperty("capital")
    private String[] capital;

    @JsonProperty("region")
    private String regiao;

    @JsonProperty("subregion")
    private String subregiao;

    @JsonProperty("population")
    private long populacao;

    @JsonProperty("area")
    private double area;

    @JsonProperty("flags")
    private Flags flags;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Name {

        @JsonProperty("common")
        private String nomeComum;

        @JsonProperty("official")
        private String nomeOficial;

        public String getNomeComum() {
            return nomeComum;
        }

        public String getNomeOficial() {
            return nomeOficial;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Flags {

        @JsonProperty("png")
        private String png;

        public String getPng() {
            return png;
        }
    }

    public String getNomeComum() {
        return name != null ? name.getNomeComum() : "";
    }

    public String getNomeOficial() {
        return name != null ? name.getNomeOficial() : "";
    }

    public String getCapital() {
        return (capital != null && capital.length > 0) ? capital[0] : "N/A";
    }

    public String getRegiao() {
        return regiao;
    }

    public String getSubregiao() {
        return subregiao;
    }

    public long getPopulacao() {
        return populacao;
    }

    public double getArea() {
        return area;
    }

    public String getUrlBandeira() {
        return flags != null ? flags.getPng() : "";
    }
}
