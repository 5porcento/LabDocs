package com.example.labdocs.controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HelloController {
    @FXML
    private TextField nomeAluno, emailAluno,nomeOrientador ,telefoneAluno,horaColeta, nomeProjeto, localColeta, numeroAmostras,responsavelColeta,metais,descricaoPontos;
    @FXML
    private DatePicker dataColeta;
    @FXML
    private CheckBox tcc,mestrado,doutorado,iniciacaoCientifica,saa,
            rio,lago,igarape,outro,sai,sac,fonte,
            microbiologicas,quimica,fisioQuimica,
            torneira,torneiraDeFiltro,torneiraDeBebedouro,caixaDAgua,cisterena,outroPonto,
            turbidez,cor,ph,condutividade,od,std,nitrato,nitrito,fosfaro,colifTotal,colifTermo,eColi;


    @FXML
    private void gerarPdf() {
        String caminho = "Relatorio_Coleta.pdf";

        // Obter os valores dos CheckBox com o novo método
        String nivelFormacao = getSelectedCheckboxes(
                Arrays.asList(tcc,mestrado,doutorado,iniciacaoCientifica)
        );
        String origemColeta = getSelectedCheckboxes(
                Arrays.asList(saa,rio,lago,igarape,outro,sai,sac,fonte)
        );
        String analisesSolicitadas = getSelectedCheckboxes(
                Arrays.asList(microbiologicas,quimica,fisioQuimica)
        );
        String pontoColeta = getSelectedCheckboxes(
                Arrays.asList(torneira,torneiraDeFiltro,torneiraDeBebedouro,caixaDAgua,cisterena,outroPonto)
        );
        String parametroColeta = getSelectedCheckboxes(
                Arrays.asList(turbidez,cor,ph,condutividade,od,std,nitrato,nitrito,fosfaro,colifTotal,colifTermo,eColi)
        );


        //TODO adicionar os demais checkBoxs

        try {
            PdfWriter writer = new PdfWriter(caminho);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Relatório de Coleta").setBold().setFontSize(18));
            document.add(new Paragraph("Nome do aluno: " + nomeAluno.getText()));
            document.add(new Paragraph("Email: " + emailAluno.getText()));
            document.add(new Paragraph("Nome do Orientador: " + nomeOrientador.getText()));
            document.add(new Paragraph("Telefone: " + telefoneAluno.getText()));
            document.add(new Paragraph("Nome do projeto: " + nomeProjeto.getText()));
            document.add(new Paragraph("Local da coleta: " + localColeta.getText()));
            document.add(new Paragraph("Data da coleta: " + dataColeta.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            document.add(new Paragraph("Hora: " + horaColeta.getText()));
            document.add(new Paragraph("Número de amostras: " + numeroAmostras.getText()));
            document.add(new Paragraph("Nivel Academico: " + nivelFormacao));
            document.add(new Paragraph("Origem da Amostra: " + origemColeta));
            document.add(new Paragraph("Responsavel pela Coleta: " + responsavelColeta.getText()));
            document.add(new Paragraph("Analises Solicitadas: " + analisesSolicitadas));
            document.add(new Paragraph("Pontos de Coleta: " + pontoColeta));
            document.add(new Paragraph("Parâmetros definidos: " + parametroColeta));
            document.add(new Paragraph("Descrição dos Pontos : " + descricaoPontos.getText()));
            document.add(new Paragraph("Elementos Traços(Metais) : " + metais.getText()));

            document.close();
            PdfController.exibirAlerta("Sucesso", "PDF gerado com sucesso: " + caminho);
        } catch (FileNotFoundException e) {
            PdfController.exibirAlerta("Erro", "Não foi possível criar o PDF.");
        }
    }

    // Método para obter os valores dos CheckBox marcados
    private String getSelectedCheckboxes(List<CheckBox> checkBoxes) {
        return checkBoxes.stream()
                .filter(CheckBox::isSelected).map(CheckBox::getText)
                .collect(Collectors
                        .joining(", "));
    }

}
