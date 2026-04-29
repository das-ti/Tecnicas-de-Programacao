package com.mylabsystems.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mylabsystems.jpa.model.Aluno;
import com.mylabsystems.jpa.repository.AlunoRepository;

@SpringBootApplication
public class JPAApplication implements CommandLineRunner {

    @Autowired
    private AlunoRepository rep;

    public static void main(String[] args) {
        SpringApplication.run(JPAApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // System.out.println("DSM");

        // Aluno a1 = new Aluno("LAI", "22345678917","7","lan@gmail.com");
        // Aluno a2 = new Aluno("TIN", "32345678918","8","ton@gmail.com");
        // Aluno a3 = new Aluno("BIA", "32345678919","9","bir@gmail.com");
        // rep.save(a1);
        // rep.save(a2);
        // rep.save(a3);

        List<Aluno> alunos = rep.findAll();
        alunos.forEach(System.out::println);
        alunos.forEach(a -> System.out.println("# Nome: " + a.getNome() + "  | E-mail: " + a.getEmail() + " #"));

		      // AQUI você usa findById e deleteById:
        rep.findById(1L).ifPresent(aluno
                -> System.out.println("Encontrado: " + aluno.getNome())
        );

        rep.deleteById(2L);

        // Buscar por nome usando o método customizado
        List<Aluno> alunos1 = rep.buscarPorNome("BIA");
        alunos1.forEach(a -> System.out.println("Nome: " + a.getNome()));

        // Listar todos
        List<Aluno> todos = rep.findAll();
        todos.forEach(a -> System.out.println("Aluno: " + a.getNome()));
	}
}
