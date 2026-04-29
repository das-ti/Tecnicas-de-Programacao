package com.mylabsystems.jpa;

import java.math.BigDecimal;

import com.mylabsystems.jpa.model.Receita;
import com.mylabsystems.jpa.repository.ReceitaRepository;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JPAApplication implements CommandLineRunner {

    @Autowired
    private ReceitaRepository rep;

    public static void main(String[] args) {
        SpringApplication.run(JPAApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Minhas Receitas Favoritas");

        Receita r1 = new Receita(
                "Cuzcuz Paulista",
                "Salgados",
                new BigDecimal("25.90"),
                true
        );

        Receita r2 = new Receita(
                "Moqueca de Peixe",
                "Prato Principal",
                new BigDecimal("52.00"),
                false
        );

        Receita r3 = new Receita(
                "Pão de Queijo Mineiro",
                "Salgados",
                new BigDecimal("15.50"),
                true
        );

        Receita r4 = new Receita(
                "Brigadeiro Gourmet",
                "Sobremesa",
                new BigDecimal("8.90"),
                false
        );

        Receita r5 = new Receita(
                "Açaí na Tigela",
                "Sobremesa",
                new BigDecimal("22.50"),
                true
        );
    
        rep.saveAll(List.of(r1, r2, r3, r4, r5));

        System.out.println("5 receitas cadastradas com sucesso!\n");

        // Buscando receitas em promoção
        System.out.println("RECEITAS EM PROMOÇÃO:\n");
        List<Receita> receitasEmPromocao = rep.buscarPorEmPromocao();

        receitasEmPromocao.forEach(receita -> {
            System.out.println(receita.getNome()
                    + " - R$ " + receita.getPreco()
                    + " (" + receita.getCategoria() + ")");
        });

        System.out.println("\nTotal em promoção: " + receitasEmPromocao.size());
    }
}
