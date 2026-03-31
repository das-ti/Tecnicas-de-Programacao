package com.mylabsystems.openmeteo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mylabsystems.openmeteo.model.ClimaDados;
import com.mylabsystems.openmeteo.service.ClimaService;

@Controller
public class ClimaController {

    private final ClimaService climaService;

    public ClimaController(ClimaService climaService) {
        this.climaService = climaService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/buscar")
    public String buscar(@RequestParam String latitude,
            @RequestParam String longitude,
            Model model) {
        try {
            ClimaDados dados = climaService.buscarClima(latitude, longitude);
            model.addAttribute("dados", dados);
            return "resultado";
        } catch (Exception e) {
            model.addAttribute("erro", "Não foi possível obter o clima. Verifique as coordenadas.");
            return "index";
        }
    }
}
