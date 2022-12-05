package app.control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import app.model.SelecaoDao;
import app.Main;
import app.model.Jogador;
import app.model.JogadorDao;
import app.model.Selecao;

public class SelecaoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView imageViewSelecao;

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
	private ComboBox<Selecao> comboBoxSelecao;

	@FXML
	private ListView<Selecao> listViewSelecao;

	@FXML
	private TextField textFiledPesquisa;

	@FXML
	private Label labelGols;

	@FXML
	private Label labelNome;

	@FXML
	private Label labelTecnico;

	@FXML
	private TableColumn<Jogador, String> tableColumnID = new TableColumn<Jogador, String>();

	@FXML
	private TableColumn<Jogador, String> tableColumnNome = new TableColumn<Jogador, String>();;

	@FXML
	private TableView<Jogador> tableViewJogadores;

	private ObservableList<Selecao> obsSelecao;
	private ObservableList<Jogador> obsJogador;
	SelecaoDao selecoes;
	JogadorDao jogadores;

	@FXML
	void actionAtt(ActionEvent event) {
		carregarListView();
	}

	@FXML
	void actionAdd(ActionEvent event) throws IOException {
		Selecao selecao = new Selecao();
		boolean confirmou = cadastrarSelecao(selecao);
		if (confirmou) {
			selecoes = Main.getSelecoes();
			selecoes.create(selecao);
			carregarListView();
		}
	}

	@FXML
	void actionDelete(ActionEvent event) {
		Selecao selecao = listViewSelecao.getSelectionModel().getSelectedItem();
		if (selecao != null) {
			selecoes = Main.getSelecoes();
			selecoes.excluir(selecao);
			carregarListView();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha uma seleção clicando na tabela! ");
			alert.show();
			carregarListView();
		}
	}

	@FXML
	void actionEdit(ActionEvent event) throws IOException {
		Selecao selecao = listViewSelecao.getSelectionModel().getSelectedItem();
		Selecao excluir = listViewSelecao.getSelectionModel().getSelectedItem();
		if (selecao != null) {
			boolean confirmou = cadastrarSelecao(selecao);
			if (confirmou) {
				selecoes = Main.getSelecoes();
				selecoes.excluir(excluir);
				selecoes.create(selecao);
				carregarListView();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha uma seleção clicando na tabela! ");
			alert.show();
		}

	}

	@FXML
	void actionVoltar(ActionEvent event) {
		Main.trocarTela("principal");
//		Stage tela = (Stage) buttonBack.getScene().getWindow(); // Obtendo a janela atual
//		tela.close(); // Fechando o Stage
	}

	@FXML
	void initialize() {
		jogadores = Main.getJogadores();
		Jogador j1 = new Jogador("Neymar", "Atacante", 10, "Brasil", 10);
		Jogador j2 = new Jogador("Richarlison", "Centro Avante", 9, "Brasil", 9);
		Jogador j3 = new Jogador("Casemiro", "Volante", 8, "Brasil", 8);
		jogadores.create(j3);
		jogadores.create(j2);
		jogadores.create(j1);

		List<Jogador> listJogadores = new ArrayList<>();
		listJogadores.add(j3);
		listJogadores.add(j2);
		listJogadores.add(j1);

		carregarListView();
		listViewSelecao.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionar(newValue));

		tableColumnID.setCellValueFactory(new PropertyValueFactory<Jogador, String>("codJog"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<Jogador, String>("nome"));

	}

	public void selecionar(Selecao selecao) {
		if (selecao == null) {
			labelNome.setText("");
			labelGols.setText("");
			labelTecnico.setText("");
		} else {
			if (selecoes.existe(selecao.getNome())) {
				try {
					String caminho = "/app/resources/imgSelecoes/" + selecao.getNome() + ".png";
					Image imgSelecao = new Image(getClass().getResourceAsStream(caminho));
					imageViewSelecao.setImage(imgSelecao);
					imageViewSelecao.setPreserveRatio(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (selecao.getNome() != null) {
				labelNome.setText(selecao.getNome());
			}
			labelGols.setText(String.valueOf(selecao.getGols()));
			labelTecnico.setText(selecao.getTecnicos());
			if (selecao.getJogadores() != null) {
				obsJogador = FXCollections.observableArrayList(selecao.getJogadores());
				tableViewJogadores.setItems(obsJogador);
			} else {
				tableViewJogadores.setItems(null);
			}
		}

	}

	public void carregarListView() {
		selecoes = Main.getSelecoes();
		obsSelecao = FXCollections.observableArrayList(selecoes.getSelecoes()).sorted();
		listViewSelecao.setItems(obsSelecao);
	}

	public boolean cadastrarSelecao(Selecao selecao) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SelecaoCadastroController.class.getResource("/app/view/SelecaoCadastro.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage telaCadastro = new Stage();
		telaCadastro.setTitle("Cadastro Selecao");
		Image iconApp = new Image(getClass().getResourceAsStream("/app/resources/Selecao300x.png"));
		telaCadastro.getIcons().add(iconApp);
		Scene scene = new Scene(page);
		telaCadastro.setScene(scene);
		SelecaoCadastroController controller = loader.getController();
		controller.setSelecaoAdd(telaCadastro);
		controller.setSelecao(selecao);
		telaCadastro.showAndWait();

		return controller.isClicou();
	}
}
