package view;

import client.BrasilApiClient;
import dao.EmpresaDAO;
import dao.SocioDAO;
import java.util.Scanner;
import model.Empresa;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CNPJ: ");
        String entrada = scanner.nextLine();

        String cnpjLimpo = entrada.replaceAll("[.\\-/]", "");

        BrasilApiClient apiClient = new BrasilApiClient();
        EmpresaDAO empresaDAO     = new EmpresaDAO();
        SocioDAO   socioDAO       = new SocioDAO();

        try {
            System.out.println("Localizando dados da empresa...");
            Empresa empresa = apiClient.buscarEmpresa(cnpjLimpo);

            System.out.println("Salvando no banco...");
            empresaDAO.salvar(empresa);
            socioDAO.salvarTodos(empresa.getCnpj(), empresa.getQsa());

            System.out.println("Cadastro concluido com sucesso!");

        } catch (IllegalArgumentException e) {
            System.err.println("CNPJ invalido: " + e.getMessage());
        } catch (java.sql.SQLException e) {
            System.err.println("Erro no banco de dados: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}
