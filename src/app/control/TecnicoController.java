package app.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import app.Main;
import app.model.Tecnico;
import app.model.TecnicoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TecnicoController {

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
	private Label labelNacionalidade;

	@FXML
	private Label labelNome;

	@FXML
	private Label labelSelecao;

	@FXML
	private ListView<Tecnico> listViewTecnico;

	@FXML
	private TextField textFieldPesquisa;

	private ObservableList<Tecnico> obsTecnicos;

	TecnicoDao tecnicos;

	@FXML
	void actionAtt(ActionEvent event) {
		carregarListView();
	}
	
	@FXML
	void actionAdd(ActionEvent event) throws IOException {
		Tecnico tecnico = new Tecnico();
		boolean confirmou = cadastrarTecnico(tecnico);
		if (confirmou) {
			tecnicos = Main.getTecnicos();
			tecnicos.create(tecnico);
			carregarListView();
		}
	}

	@FXML
	void actionDelete(ActionEvent event) {
		Tecnico tecnico = listViewTecnico.getSelectionModel().getSelectedItem();
		if (tecnico != null) {
			tecnicos = Main.getTecnicos();
			tecnicos.excluir(listViewTecnico.getSelectionModel().getSelectedItem());
			carregarListView();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um técnico clicando na tabela! ");
			alert.show();
			carregarListView();
		}
	}

	@FXML
	void actionEdit(ActionEvent event) throws IOException {
		Tecnico tecnico = listViewTecnico.getSelectionModel().getSelectedItem();
		Tecnico excluir = listViewTecnico.getSelectionModel().getSelectedItem();

		if (tecnico != null) {
			boolean confirmou = cadastrarTecnico(tecnico);
			if (confirmou) {
				tecnicos = Main.getTecnicos();
				tecnicos.excluir(excluir);
				tecnicos.create(tecnico);
				carregarListView();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um técnico clicando na tabela! ");
			alert.show();
		}
	}

	@FXML
	void actionVoltar(ActionEvent event) {
		Main.trocarTela("principal");
	}

	@FXML
	void initialize() {
		carregarListView();
		listViewTecnico.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionar(newValue));

	}

	public void selecionar(Tecnico tecnico) {
		if (tecnico == null) {
			labelNome.setText("");
			labelNacionalidade.setText("");
		} else {
			if (tecnico.getNome() != null) {
				labelNome.setText(tecnico.getNome());
				labelNacionalidade.setText(tecnico.getNacionalidade());
				labelSelecao.setText(tecnico.getSelecao());
			}
		}
	}

	public void carregarListView() {
		tecnicos = Main.getTecnicos();
		obsTecnicos = FXCollections.observableArrayList(tecnicos.getTecnicos()).sorted();
		listViewTecnico.setItems(obsTecnicos);
	}

	public boolean cadastrarTecnico(Tecnico tecnico) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(TecnicoCadastroController.class.getResource("/app/view/TecnicoCadastro.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage telaCadastro = new Stage();
		telaCadastro.setTitle("Cadastro Técnico");
		Image iconApp = new Image(getClass().getResourceAsStream("/app/resources/Tecnico300x.png"));
		telaCadastro.getIcons().add(iconApp);
		Scene scene = new Scene(page);
		telaCadastro.setScene(scene);
		TecnicoCadastroController controller = loader.getController();
		controller.setTecnicoAdd(telaCadastro);
		controller.setTecnico(tecnico);
		telaCadastro.showAndWait();

		return controller.isClicou();
	}
}
