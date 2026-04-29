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

        // Aluno a1 = new Aluno("Marcos", "22345674917");
        // Aluno a2 = new Aluno("Pedro", "32345678418");
        // Aluno a3 = new Aluno("Felipe", "32345678419");
        Aluno a4 = new Aluno("Sonia", "22345674917","4","sonia@gmail.com");
        Aluno a5 = new Aluno("Dina", "32345678418","5","dina@gmail.com");
        Aluno a6 = new Aluno("Mara", "32345678419","6","mara@gmail.com");
        // // rep.save(a1);
        // // rep.save(a2);
        // // rep.save(a3);
        rep.save(a4);
        rep.save(a5);
        rep.save(a6);
        List<Aluno> alunos = rep.findAll();
        alunos.forEach(System.out::println);
        alunos.forEach(a -> System.out.println("# Nome: " + a.getNome() + "  | E-mail: " + a.getEmail() + " #"));

     
        rep.findById(1L).ifPresent(aluno
                -> System.out.println("Encontrado: " + aluno.getNome())
        );

        rep.deleteById(2L);

        List<Aluno> alunos1 = rep.buscarPorNome("Sonia");
        alunos1.forEach(a -> System.out.println("Nome: " + a.getNome()));

        List<Aluno> todos = rep.findAll();
        todos.forEach(a -> System.out.println("Aluno: " + a.getNome()));
    }
}
