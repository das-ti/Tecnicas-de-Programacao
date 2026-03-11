package br.edu.fatecpg.apijdbc.view;

import br.edu.fatecpg.apijdbc.service;
import br.edu.fatecpg.apijdbc.db.DB;
import br.edu.fatecpg.apijdbc.model.Empresa;
import br.edu.fatecpg.apijdbc.service.ConsomeApi;

import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.System.*;

public class Main {
    public static void main(Strings[] ars) {
        Scanner entrada = new Scanner(in);
        Gson gson = new Gson();

        try {
            String retorno = ConsomeApi.buscaCnpj();
            System.out.println(retorno);
            Empresa end = gson.fromJson(retorno, Empresa.class);
            System.out.println(end);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

         try (var connection =  DB.connect()){
            System.out.println("Connected to the PostgreSQL database.");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
