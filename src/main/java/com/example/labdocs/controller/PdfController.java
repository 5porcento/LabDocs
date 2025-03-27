package com.example.labdocs.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;

import java.util.List;
import java.util.stream.Collectors;

public class PdfController {


    // Exibir alerta ao concluir Pdf
    public static void exibirAlerta(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    // Método para obter os valores dos CheckBox marcados
    public static String getSelectedCheckboxes(List<CheckBox> checkBoxes) {
        return checkBoxes.stream()
                .filter(CheckBox::isSelected).map(CheckBox::getText)
                .collect(Collectors
                        .joining(", "));
    }

}
