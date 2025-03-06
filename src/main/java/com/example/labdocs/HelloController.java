package com.example.labdocs;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private TextArea textArea;

    @FXML
    private void onButtonClick() {
        String nome = textArea.getText();

        if (nome.isEmpty()) {
            exibirAlerta("Erro", "Por favor, digite algo antes de clicar no botão!");
        } else {
            exibirAlerta("Sucesso", "Olá, " + nome + "!");
        }
    }

    private void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
