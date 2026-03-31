package com.mylabsystems.countries.controller;

import com.mylabsystems.countries.model.Pais;
import com.mylabsystems.countries.service.PaisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/buscar")
    public String buscar(@RequestParam String nome, Model model) {
        try {
            Pais pais = paisService.buscarPais(nome);
            model.addAttribute("pais", pais);
            return "resultado";
        } catch (Exception e) {
            model.addAttribute("erro", "País não encontrado. Digite o nome em inglês.");
            return "index";
        }
    }
}
