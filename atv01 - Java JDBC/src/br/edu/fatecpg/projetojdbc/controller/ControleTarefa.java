package br.edu.fatecpg.projetojdbc.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.fatecpg.projetojdbc.db.*;
import br.edu.fatecpg.projetojdbc.model.*;

public class ControleTarefa {
    static Scanner entrada = new Scanner(System.in);

    public void iniciarMenu() {

        while (true) {
            System.out.println("\nGESTÃO DE TAREFAS");
            System.out.println("1 - Criar Tarefa");
            System.out.println("2 - Editar Tarefa");
            System.out.println("3 - Listar Todas");
            System.out.println("4 - Listar por Categoria");
            System.out.println("5 - Marcar como Concluída");
            System.out.println("6 - Excluir Tarefa");
            System.out.println("7 - Sair");

            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1 -> criarTarefa();
                case 2 -> editarTarefa();
                case 3 -> listarTodas();
                case 4 -> listarPorCategoria();
                case 5 -> concluirTarefa();
                case 6 -> excluirTarefa();
                case 7 -> System.exit(0);
            }
        }
    }

    private static void criarTarefa() {
        try (var conn = DB.connection()) {

            System.out.print("Título: ");
            String titulo = entrada.nextLine();

            System.out.print("Descrição: ");
            String descricao = entrada.nextLine();

            System.out.print("Categoria: ");
            String categoria = entrada.nextLine();

            System.out.print("Prioridade: ");
            String prioridade = entrada.nextLine();

            System.out.print("Status: ");
            String status = entrada.nextLine();

            String sql = "INSERT INTO tb_tarefas(titulo, descricao, categoria, prioridade, status) VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, descricao);
            stmt.setString(3, categoria);
            stmt.setString(4, prioridade);
            stmt.setString(5, status);
            stmt.execute();

            System.out.println("Tarefa criada com sucesso!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void editarTarefa() {
        try (var conn = DB.connection()) {

            while (true) {
                System.out.println("\nEditar Tarefas");
                System.out.println("1 - Titulo");
                System.out.println("2 - Descrição");
                System.out.println("3 - Categoria");
                System.out.println("4 - Prioridade");
                System.out.println("5 - Status");

                int opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Novo titulo: ");
                        String titulo = entrada.nextLine();
                        String sql = "UPDATE tb_tarefas SET titulo = ? WHERE id = ?";
                        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                            ps.setString(1, titulo);
                            ps.executeUpdate();
                            System.out.println("Titulo atualizado!");
                            break;
                        }
                    }
                    case 2 -> {
                        System.out.print("Nova descricao: ");
                        String descricao = entrada.nextLine();
                        String sql = "UPDATE tb_tarefas SET descricao = ? WHERE id = ?";
                        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                            ps.setString(2, descricao);
                            ps.executeUpdate();
                            System.out.println("Descricao atualizada!");
                            break;
                        }
                    }
                    case 3 -> {
                        System.out.print("Nova categoria: ");
                        String categoria = entrada.nextLine();
                        String sql = "UPDATE tb_tarefas SET categoria = ? WHERE id = ?";
                        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                            ps.setString(3, categoria);
                            ps.executeUpdate();
                            System.out.println("Categoria atualizada!");
                            break;
                        }
                    }
                    case 4 -> {
                        System.out.print("Nova prioridade (BAIXA/MEDIA/ALTA): ");
                        String prioridade = entrada.nextLine();
                        String sql = "UPDATE tb_tarefas SET prioridade = ? WHERE id = ?";
                        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                            ps.setString(4, prioridade);
                            ps.executeUpdate();
                            System.out.println("Prioridade atualizada!");
                            break;
                        }
                    }
                    case 5 -> {
                        System.out.print("Novo status (PENDENTE/EM_ANDAMENTO/CONCLUIDA/CANCELADA): ");
                        String status = entrada.nextLine();
                        String sql = "UPDATE tb_tarefas SET status = ? WHERE id = ?";
                        try (PreparedStatement ps = conn.prepareStatement(sql)) {
                            ps.setString(5, status);
                            ps.executeUpdate();
                            System.out.println("Status atualizado!");
                            break;
                        }

                    }

                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void listarTodas() {
        try (var conn = DB.connection()) {

            String sql = "SELECT * FROM tb_tarefas";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            List<Tarefa> tarefas = new ArrayList<>();

            while (rs.next()) {
                tarefas.add(new Tarefa(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("descricao"),
                        rs.getString("categoria"),
                        rs.getString("prioridade"),
                        rs.getString("status"),
                        rs.getTimestamp("data_criacao").toLocalDateTime()
                    )
                );
            }

            tarefas.forEach(System.out::println);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void listarPorCategoria() {
        try (var conn = DB.connection()) {

            System.out.print("Digite a categoria: ");
            String categoria = entrada.nextLine();

            String sql = "SELECT * FROM tb_tarefas WHERE categoria = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, categoria);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - "
                                + rs.getString("titulo") + " - "
                                + rs.getString("status")
                );
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void concluirTarefa() {
        try (var conn = DB.connection()) {

            System.out.print("ID da tarefa: ");
            int id = entrada.nextInt();

            String sql = "UPDATE tb_tarefas SET status = 'CONCLUIDA' WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

            System.out.println("Tarefa concluída!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void excluirTarefa() {
        try (var conn = DB.connection()) {

            System.out.print("ID da tarefa para excluir: ");
            int id = entrada.nextInt();

            String sql = "DELETE FROM tb_tarefas WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();

            System.out.println("Tarefa excluída!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
