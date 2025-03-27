package com.example.labdocs;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private void abrirCadastroAluno() throws IOException {
        abrirNovaTela("CadastroAluno.fxml", "Cadastro de Alunos");
    }

    @FXML
    private void abrirRelatorioAmostras() throws IOException {
        abrirNovaTela("hello-view.fxml", "Ficha de Controle  de Analise de aluno");
    }

    @FXML
    private void abrirResumoColeta() throws IOException {
        abrirNovaTela("resumoColeta.fxml", "Ficha de Controle  de Recebimento de amostras");
    }

    private void abrirNovaTela(String  fxmlFile, String titulo) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(titulo);
        stage.setScene(new Scene(root)); // Definir largura e altura padrão


        stage.setMaximized(true); // Permite redimensionamento

        stage.show();
    }
}

