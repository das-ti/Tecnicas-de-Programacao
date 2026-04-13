package com.mylabsystems.cadastroproduto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mylabsystems.cadastroproduto.model.Produto;

import jakarta.validation.Valid;

@Controller
public class ProdutoController {

    private static final List<Produto> produtos = new ArrayList<>();

    @GetMapping("/")
    public String index() {
        return "redirect:/cadastrar";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("produto", new Produto());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarProduto(@Valid @ModelAttribute ("produto") Produto produto, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "cadastrar";
        }
        produtos.add(produto);
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String exibirLista(Model model) {
        model.addAttribute("produtos", produtos);
        return "lista";
    }
}
