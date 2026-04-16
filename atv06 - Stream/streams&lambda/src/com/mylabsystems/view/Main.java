package com.mylabsystems.view;

import com.mylabsystems.model.Funcionario;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Ana", "Contabilidade", 3500., 15));
        funcionarios.add(new Funcionario("Carla", "Contabilidade", 3000., 6));
        funcionarios.add(new Funcionario("Maicon", "Contabilidade", 2500., 4));
        funcionarios.add(new Funcionario("Silvio", "RH", 3000., 13));
        funcionarios.add(new Funcionario("Marisa", "RH", 3600., 11));
        funcionarios.add(new Funcionario("João", "RH", 2000., 3));
        funcionarios.add(new Funcionario("Antonio", "Administração", 8000., 18));
        funcionarios.add(new Funcionario("José", "Administração", 4500., 6));
        funcionarios.add(new Funcionario("Beatriz", "TI", 9500., 8));
        funcionarios.add(new Funcionario("Ricardo", "TI", 7200., 12));
        funcionarios.add(new Funcionario("Fernanda", "Marketing", 4200., 5));
        funcionarios.add(new Funcionario("Roberto", "Marketing", 3800., 2));
        funcionarios.add(new Funcionario("Cláudia", "Logística", 2900., 14));
        funcionarios.add(new Funcionario("Eduardo", "Vendas", 3100., 7));
        funcionarios.add(new Funcionario("Patrícia", "Vendas", 5400., 16));
        funcionarios.add(new Funcionario("Mônica", "Diretoria Executiva", 28000., 22));
        funcionarios.add(new Funcionario("Carlos Alberto", "Presidência", 45000., 30));
        funcionarios.add(new Funcionario("Sandro", "Vice-Presidência", 32000., 25));


        System.out.println("\n### Funcionários com Salário acima de R$3.000 ###");

        final double salarioBase = 3000;
        List<Funcionario> salarioSuperior = funcionarios.stream()
                .filter(f -> f.getSalario() > salarioBase)
                .collect(Collectors.toList());
        salarioSuperior.forEach(System.out::println);

        System.out.println("\n### Funcionários com mais de 10 anos receberam 5% de aumento no salário. ###");
        System.out.printf("%-16s | %-15s",
                "Funcionário", "Salário Atualizado\n");
        System.out.println("-".repeat(38));

        funcionarios.stream()
                .filter(f -> f.getAnosDeServico() > 10)
                .forEach(f -> {
                    f.setSalario(f.getSalario() * 1.05);
                    System.out.printf("%-16s | R$ %,-15.2f%n",
                            f.getNome(), f.getSalario());
                });

        System.out.println("\n### Lista de Funcionários em Ordem Alfabética ###");
        List<Funcionario> ordemAlfabetica = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        ordemAlfabetica.forEach(System.out::println);

        double totalSalarios = funcionarios.stream()
                .mapToDouble(Funcionario::getSalario)
                .reduce(0.0, Double::sum);

                System.out.println("\n### Total da Folha Salarial da Empresa ###");
        System.out.printf("Total da folha salarial: R$ %,.2f%n", totalSalarios);

        System.out.println("\n### Média Salarial por Departamento ###");
        System.out.printf("%-20s | %-15s",
                "Departamento", "Média Salarial\n");
        System.out.println("-".repeat(38));
        Map<String, Double> mediaSalarialPorDepto = funcionarios.stream()
                .collect(Collectors.groupingBy(
                        Funcionario::getDepartamento,
                        Collectors.averagingDouble(Funcionario::getSalario)
                ));
        mediaSalarialPorDepto.forEach((depto, media)
                -> System.out.printf("%-20s | R$ %,-15.2f%n", depto, media)
        );

        System.out.println("\n### Funcionario com Mais Anos de Serviço ###");
        funcionarios.stream()
                .max(Comparator.comparingInt(Funcionario::getAnosDeServico))
                .ifPresent(f -> System.out.printf(
                "Funcionário: %s - Departamento: %s - Anos de Serviço: %s\n",
                f.getNome(), f.getDepartamento(), f.getAnosDeServico()
        ));

        System.out.println("\n### Lista de Funcionários da Empresa ###");
        System.out.printf("%-15s | %-20s | %-12s | %-15s%n",
                "Funcionário", "Departamento", "Salário", "Anos de Serviço");
        System.out.println("-".repeat(64));
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(f -> System.out.printf(
                "%-15s | %-20s | R$ %,-10.2f | %-15d%n",
                f.getNome(), f.getDepartamento(), f.getSalario(), f.getAnosDeServico()
        ));
    }
}
