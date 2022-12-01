package app.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
	void ActionButtonPartida(ActionEvent event) {
		Main.trocarTela("partida");
	}

	@FXML
	void ActionButtonPquisa(ActionEvent event) {
		Main.trocarTela("pesquisa");
	}

	@FXML
	void ActionButtonSelecao(ActionEvent event) {
		Main.trocarTela("selecao");
	}

	@FXML
	void ActionButtonTecnico(ActionEvent event) {
		Main.trocarTela("tecnico");
	}

	@FXML
	void initialize() {

	}

}
