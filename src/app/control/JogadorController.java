package app.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import app.Main;
import app.model.Jogador;
import app.model.JogadorDao;
import app.model.Selecao;
import app.model.SelecaoDao;

public class JogadorController {

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
	private Button buttonAtt;

	@FXML
	private Label cartaoAmarelo;

	@FXML
	private Label cartaoAmareloFix;

	@FXML
	private Label cartaoVermelho;

	@FXML
	private Label cartaoVermelhoFix;

	@FXML
	private Label codigo;

	@FXML
	private Label codigoFix;

	@FXML
	private Label gols;

	@FXML
	private Label golsFix;

	@FXML
	private Label nome;

	@FXML
	private Label nomeFix;

	@FXML
	private Label numero;

	@FXML
	private Label numeroFix;

	@FXML
	private Label posicao;

	@FXML
	private Label posicaoFix;

	@FXML
	private Label selecao;

	@FXML
	private Label selecaoFix;

	@FXML
	private TextField textFiledPesquisa;

	@FXML
	private TableColumn<Jogador, String> tableColumnCodigo;

	@FXML
	private TableColumn<Jogador, String> tableColumnNome;

	@FXML
	private TableView<Jogador> tableViewJogador;

	private ObservableList<Jogador> obsJogadores;

	JogadorDao jogadores;
	SelecaoDao selecoes;

	@FXML
	void actionAtt(ActionEvent event) {
		carregarTabela();
	}

	@FXML
	void ActionAdd(ActionEvent event) throws IOException {
		Jogador jogador = new Jogador();
		boolean confirmou = cadastrarJogador(jogador);
		if (confirmou) {
			jogadores = Main.getJogadores();
			selecoes = Main.getSelecoes();
			if (selecoes.existe(jogador.getSelecao())) {
				Selecao editar = selecoes.buscaNome(jogador.getSelecao());
				selecoes.excluir(editar);
				editar.getJogadores().add(jogador);
				selecoes.create(editar);
			}
			jogadores.create(jogador);
			carregarTabela();
		}
	}

	@FXML
	void actionDelete(ActionEvent event) {
		Jogador jogador = tableViewJogador.getSelectionModel().getSelectedItem();
		if (jogador != null) {
			jogadores = Main.getJogadores();
			jogadores.excluir(tableViewJogador.getSelectionModel().getSelectedItem());
			selecoes = Main.getSelecoes();
			if (selecoes.existe(jogador.getSelecao())) {
				selecoes.apagarJogador(jogador);
			}
			carregarTabela();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um jogador clicando na tabela! ");
			alert.show();
			carregarTabela();
		}
	}

	@FXML
	void actionEdit(ActionEvent event) throws IOException {
		Jogador jogador = tableViewJogador.getSelectionModel().getSelectedItem();
		Jogador excluir = tableViewJogador.getSelectionModel().getSelectedItem();
		if (jogador != null) {
			boolean confirmou = editarJogador(jogador);
			if (confirmou) {
				jogadores = Main.getJogadores();
				selecoes = Main.getSelecoes();
				jogadores.excluir(excluir);
				jogadores.create(jogador);
				if (selecoes.existe(jogador.getSelecao())) {
					selecoes.apagarJogador(excluir);
					selecoes.addJogador(jogador);
				}
				carregarTabela();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um jogador clicando na tabela! ");
			alert.show();
		}

	}

	@FXML
	void actionVoltar(ActionEvent event) {
		Main.trocarTela("principal");
	}

	@FXML
	void initialize() {
		carregarTabela();
		tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<Jogador, String>("codJog"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<Jogador, String>("nome"));
		tableViewJogador.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionar(newValue));
	}

	public void carregarTabela() {
		jogadores = Main.getJogadores();
		obsJogadores = FXCollections.observableArrayList(jogadores.getJogadores());
		tableViewJogador.setItems(obsJogadores);
	}

	public void selecionar(Jogador jogador) {
		if (jogador == null) {
			codigo.setText("");
			nome.setText("");
			numero.setText("");
			posicao.setText("");
			selecao.setText("");
			gols.setText("");
			cartaoAmarelo.setText("");
			cartaoVermelho.setText("");
		} else {
			codigo.setText(String.valueOf(jogador.getCodJog()));
			nome.setText(jogador.getNome());
			numero.setText(String.valueOf(jogador.getNumero()));
			posicao.setText(jogador.getPosicao());
			selecao.setText(jogador.getSelecao());
			gols.setText(String.valueOf(jogador.getgols()));
			cartaoAmarelo.setText(String.valueOf(jogador.getCartaoAmarelo()));
			cartaoVermelho.setText(String.valueOf(jogador.getCartaoVermelho()));
		}

	}

	public boolean cadastrarJogador(Jogador jogador) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(JogadorCadastroController.class.getResource("/app/view/JogadorCadastro.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage telaCadastro = new Stage();
		telaCadastro.setTitle("Cadastro Jogador");
		Image iconApp = new Image(getClass().getResourceAsStream("/app/resources/Jogador300x.png"));
		telaCadastro.getIcons().add(iconApp);
		Scene scene = new Scene(page);
		telaCadastro.setScene(scene);
		JogadorCadastroController controller = loader.getController();
		controller.setJogadorAdd(telaCadastro);
		controller.setJogador(jogador);
		telaCadastro.showAndWait();
		return controller.isClicou();
	}

	public boolean editarJogador(Jogador jogador) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(JogadorCadastroController.class.getResource("/app/view/JogadorCadastro.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage telaCadastro = new Stage();
		telaCadastro.setTitle("Cadastro Jogador");
		Image iconApp = new Image(getClass().getResourceAsStream("/app/resources/Jogador300x.png"));
		telaCadastro.getIcons().add(iconApp);
		Scene scene = new Scene(page);
		telaCadastro.setScene(scene);
		JogadorCadastroController controller = loader.getController();
		controller.setJogadorAdd(telaCadastro);
		controller.setJogador(jogador);
		controller.textFieldCartaoAmarelo.setDisable(false);
		controller.textFieldVermelho.setDisable(false);
		controller.textFieldGols.setDisable(false);
		telaCadastro.showAndWait();
		return controller.isClicou();
	}

}
