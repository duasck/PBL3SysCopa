package app.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import app.Dados;
import app.Main;
import app.MockarValores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class TelaPrincipalController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button ButtonArbitro;

	@FXML
	private Button ButtonGrupos;

	@FXML
	private Button ButtonJogador;

	@FXML
	private Button ButtonPartida;

	@FXML
	private Button ButtonPesquisa;

	@FXML
	private Button ButtonSelecao;

	@FXML
	private Button ButtonTecnico;

	@FXML
	private Button ButtonPreencher;

	@FXML
    private Button ButtonMataMata;
	
	@FXML
	void ActionButtonArbitro(ActionEvent event) {
		Main.trocarTela("arbitro");
	}

	@FXML
	void ActionButtonGrupo(ActionEvent event) {
		Main.trocarTela("grupo");
	}

	@FXML
	void ActionButtonJogador(ActionEvent event) throws IOException {
		Main.trocarTela("jogador");
	}

	@FXML
	void ActionButtonPartida(ActionEvent event) throws IOException {
		Main.trocarTela("partida");
	}

	@FXML
	void ActionButtonPquisa(ActionEvent event) throws IOException {
		Main.trocarTela("pesquisa");
	}

	@FXML
	void ActionButtonSelecao(ActionEvent event) throws IOException {
		Main.trocarTela("selecao");
	}

	@FXML
	void ActionButtonTecnico(ActionEvent event) throws IOException {
		Main.trocarTela("tecnico");
	}

	@FXML
	void ActionButtonPreencher(ActionEvent event) {
		Dados d = new Dados();
		d.selecoes();
		MockarValores.MockJogadores();
		d.tecnicos();
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setContentText("Os dados foram inseridos! \nAperte o botão de atualizar");
		alert.show();
	}

	@FXML
	void actionButtonMataMata(ActionEvent event) {

	}

	@FXML
	void initialize() {

	}

}
