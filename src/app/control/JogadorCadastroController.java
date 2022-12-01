package app.control;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Jogador;
import app.model.JogadorDao;
import app.model.Selecao;
import app.model.SelecaoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class JogadorCadastroController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ChoiceBox<String> choiceBoxPosicao;

	@FXML
	private ComboBox<Selecao> comboBoxSelecao;

	@FXML
	TextField textFieldCartaoAmarelo;

	@FXML
	TextField textFieldGols;

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldNumero;

	@FXML
	TextField textFieldVermelho;

	@FXML
	private Button buttonCancelar;

	@FXML
	private Button buttonConfirmar;

	private boolean clicou = false;
	private Jogador jogador;
	private Stage jogadorAdd;
	SelecaoDao selecoes;

	public JogadorCadastroController() {
		jogadorAdd = new Stage();
	}

	public Stage getJogadorAdd() {
		return jogadorAdd;
	}

	public void setJogadorAdd(Stage jogadorAdd) {
		this.jogadorAdd = jogadorAdd;
	}

	public boolean isClicou() {
		return clicou;
	}

	public void setClicou(boolean clicou) {
		this.clicou = clicou;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
		if (jogador != null) {
			this.textFieldCartaoAmarelo.setText(String.valueOf(jogador.getCartaoAmarelo()));
			this.textFieldVermelho.setText(String.valueOf(jogador.getCartaoVermelho()));
			this.textFieldNome.setText(jogador.getNome());
			this.textFieldNumero.setText(String.valueOf(jogador.getNumero()));
			this.textFieldGols.setText(String.valueOf(jogador.getgols()));
			SelecaoDao selecoes = Main.getSelecoes();
			String selecao = jogador.getSelecao();
			this.comboBoxSelecao.setValue(selecoes.buscaNome(selecao));
			this.choiceBoxPosicao.setValue(jogador.getPosicao());
		}
	}

	@FXML
	void ActionConfirmar(ActionEvent event) {
		JogadorDao jogadores = Main.getJogadores();
		if (validacao()) {
			jogador.setNome(textFieldNome.getText());
			jogador.setPosicao(choiceBoxPosicao.getValue());
			jogador.setCartaoAmarelo(0);
			jogador.setCartaoVermelho(0);
			jogador.setGols(0);
			jogador.setSelecao(comboBoxSelecao.getEditor().getText());
			jogador.setNumero(Integer.valueOf(textFieldNumero.getText()));
			jogador.setCodJog(jogadores.getId());
			clicou = true;
			this.jogadorAdd.close();
		}
	}

	@FXML
	void actionCancelar(ActionEvent event) {
		this.jogadorAdd.close();
	}

	@FXML
	void initialize() {
		choiceBoxPosicao.getItems().addAll("Zagueiro", "Lateral direito", "Lateral esquerdo", "Libero", "Ala direito",
				"Ala esquerdo", "Meia-armador", "Meia-de-ligacao", "Apoiador", "Medio", "Medio-centro", "Meio-campista",
				"Lateral direito", "Meio-campista", "Lateral esquerdo", "Meia-atacante", "Meia Ofensivo",
				"Medio ofensivo", "Ponta", "Segundo atacante", "Centroavante", "Avancado-centro");
		SelecaoDao selecoes = Main.getSelecoes();
		comboBoxSelecao.getItems().addAll(selecoes.getSelecoes());
	}

	private boolean validacao() {
		String mensagens = "";
		if (textFieldNome.getText() == null || textFieldNome.getText().isEmpty()) {
			mensagens += "Campo nome está vazio, por favor preencha. \n";
		}

		if (textFieldNumero.getText() == null || textFieldNumero.getText().isEmpty()) {
			mensagens += "Campo numero está vazio, por favor preencha. \n";
		} else if (!isNumero(textFieldNumero.getText())) {
			mensagens += "Campo numero está não contém um numero, por favor corrija. \n";
		}

		if (comboBoxSelecao.getValue() == null) {
			mensagens += "Campo selecao está vazio, por favor preencha. \n";
		}

		if (choiceBoxPosicao.getValue() == null || choiceBoxPosicao.getValue().isEmpty()) {
			mensagens += "Campo posicao está vazio, por favor preencha. \n";
		}

		if (mensagens.isEmpty()) {
			return true;
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(mensagens);
			alert.show();
			return false;
		}
	}

	private boolean isNumero(String texto) {
		return texto != null && texto.matches("[0-9]*");
	}
}
