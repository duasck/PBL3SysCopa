package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PartidaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonDel;

    @FXML
    private Button buttonEdit;

    @FXML
    private Label codigo;

    @FXML
    private Label codigoFix;

    @FXML
    private Label data;

    @FXML
    private Label dataFix;

    @FXML
    private Label golsSelecao1;

    @FXML
    private Label golsSelecao1Fix;

    @FXML
    private Label golsSelecao2;

    @FXML
    private Label golsSelecao2Fix;

    @FXML
    private Label hora;

    @FXML
    private Label horaFix;

    @FXML
    private Label local;

    @FXML
    private Label localFix;

    @FXML
    private Label selecao1;

    @FXML
    private Label selecao2;

    @FXML
    private Label selecaoFix1;

    @FXML
    private Label selecaoFix2;

    @FXML
    private TableColumn<?, ?> tableColumnCodigo;

    @FXML
    private TableColumn<?, ?> tableColumnSelecao1;

    @FXML
    private TableColumn<?, ?> tableColumnSelecao2;

    @FXML
    private TableView<?> tableViewPartida;

    @FXML
    private TextField textFiledPesquisa;

    @FXML
    void ActionAdd(ActionEvent event) {

    }

    @FXML
    void actionDelete(ActionEvent event) {

    }

    @FXML
    void actionEdit(ActionEvent event) {

    }

    @FXML
    void actionVoltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert buttonDel != null : "fx:id=\"buttonDel\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert buttonEdit != null : "fx:id=\"buttonEdit\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert codigo != null : "fx:id=\"codigo\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert codigoFix != null : "fx:id=\"codigoFix\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert dataFix != null : "fx:id=\"dataFix\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert golsSelecao1 != null : "fx:id=\"golsSelecao1\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert golsSelecao1Fix != null : "fx:id=\"golsSelecao1Fix\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert golsSelecao2 != null : "fx:id=\"golsSelecao2\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert golsSelecao2Fix != null : "fx:id=\"golsSelecao2Fix\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert hora != null : "fx:id=\"hora\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert horaFix != null : "fx:id=\"horaFix\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert local != null : "fx:id=\"local\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert localFix != null : "fx:id=\"localFix\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert selecao1 != null : "fx:id=\"selecao1\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert selecao2 != null : "fx:id=\"selecao2\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert selecaoFix1 != null : "fx:id=\"selecaoFix1\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert selecaoFix2 != null : "fx:id=\"selecaoFix2\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert tableColumnCodigo != null : "fx:id=\"tableColumnCodigo\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert tableColumnSelecao1 != null : "fx:id=\"tableColumnSelecao1\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert tableColumnSelecao2 != null : "fx:id=\"tableColumnSelecao2\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert tableViewPartida != null : "fx:id=\"tableViewPartida\" was not injected: check your FXML file 'PartidaView.fxml'.";
        assert textFiledPesquisa != null : "fx:id=\"textFiledPesquisa\" was not injected: check your FXML file 'PartidaView.fxml'.";

    }

}
