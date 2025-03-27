package com.example.labdocs.controller;


import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

public class ResumoColetaController {

    @FXML
    private TextField nomeSolicitante,cpf_cnpj,telefoneSolicitante,endereco,bairro,email,
            municipio,nomeInteressado,localColeta,horaColeta,responsalvelColeta,identificacao,tipoAmostra,
            responsavelRecebimento,campoEspecificar;

    @FXML
    private CheckBox torneira,torneiraDeFiltro,torneiraDeBebedouro,caixaDAgua,cisterena,outroPonto,
            saa,rio,lago,igarape,sac,sai,fonte,outro,tratada,naoTratada,consumoHumano,balneabilidade,Recreacao,
            microbiologicas,quimica,fisioQuimica,checkOutros;
    @FXML
    private DatePicker dataColeta,data;
    @FXML
    private TextArea obs,especificarAnalise;


    //TODO: adicionar Logica de gereção dos pfds


}
