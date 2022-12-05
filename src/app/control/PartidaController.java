package app.control;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    Stage tela;
	public Stage getTela() {
		return tela;
	}

	public void setTela(Stage tela) {
		this.tela = tela;
	}
	
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
    	Main.trocarTela("principal");
    }

    @FXML
    void initialize() {

    }

}
