
import java.util.ArrayList;
import java.util.List;
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
        funcionarios.add(new Funcionario("Antonio", "Administração", 8000., 15));
        funcionarios.add(new Funcionario("José", "Administração", 4500., 6));

        System.out.println("### Funcionários com Salários acima de R$3.000,00 ###");
        
        final double salarioBase = 3000;
        List<Funcionario> salarioSuperior = funcionarios.stream()
                .filter(f -> f.getSalario() > salarioBase)
                .collect(Collectors.toList());
        salarioSuperior.forEach(System.out::println);
        
        System.out.println("\n### Funcionários com mais de 10 anos receberam 5% de aumento no salário. ###");
        // funcionarios.stream()
        //     .filter(f -> f.getAnosDeServico() > 10) 
        //     .map(f -> new Funcionario(
        //                     f.getNome(),
        //                     f.getDepartamento(),
        //                     f.getSalario() * 1.05,
        //                     f.getAnosDeServico()
        //             ))
        //     .collect(Collectors.toList())
        //     .forEach(System.out::println);

        // List<Funcionario> comAumento = funcionarios.stream()
        //         .map(f -> {
        //             if (f.getAnosDeServico() > 10) {
        //                 return new Funcionario(
        //                         f.getNome(),
        //                         f.getDepartamento(),
        //                         f.getSalario() * 1.05,
        //                         f.getAnosDeServico()
        //                 );
        //             }
        //             return f; 
        //         })
        //         .collect(Collectors.toList());

        // comAumento.forEach(System.out::println);

        // final double tempoNaEmpresa = 10;
        // List<Double> novoSalario = funcionarios.stream()
        //         .filter(f -> f.getAnosDeServico() > tempoNaEmpresa)
        //         .map(f -> f.getSalario()*1.05)
        //         .collect(Collectors.toList());
                
        // novoSalario.forEach(s -> System.out.printf("R$ %.2f%n", s));

        

    }
}
