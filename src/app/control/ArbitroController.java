package app.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Arbitro;
import app.model.ArbitroDao;
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

public class ArbitroController {

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
	private Label labelNacionalidade;

	@FXML
	private Label labelNome;

	@FXML
	private ListView<Arbitro> listViewArbitro;

	@FXML
	private TextField textFieldPesquisa;

	private ObservableList<Arbitro> obsArbitros;
	
	ArbitroDao arbitros;

	@FXML
	void actionAdd(ActionEvent event) throws IOException {
		Arbitro arbitro = new Arbitro();
		boolean confirmou = cadastrarArbitro(arbitro);
		if (confirmou) {
			arbitros = Main.getArbitros();
			arbitros.create(arbitro);
			carregarListView();
		}
	}

	@FXML
	void actionDelete(ActionEvent event) {
		Arbitro arbitro = listViewArbitro.getSelectionModel().getSelectedItem();
		if (arbitro != null) {
			arbitros = Main.getArbitros();
			arbitros.excluir(arbitro);
			carregarListView();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um árbitro clicando na tabela! ");
			alert.show();
			carregarListView();
		}
	}

	@FXML
	void actionEdit(ActionEvent event) throws IOException {
		Arbitro arbitro = listViewArbitro.getSelectionModel().getSelectedItem();
		Arbitro excluir = listViewArbitro.getSelectionModel().getSelectedItem();
		if (arbitro != null) {
			boolean confirmou = cadastrarArbitro(arbitro);
			if (confirmou) {
				arbitros = Main.getArbitros();
				arbitros.excluir(excluir);
				arbitros.create(arbitro);
				carregarListView();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um árbitro clicando na tabela! ");
			alert.show();
		}
	}

	@FXML
	void actionVoltar(ActionEvent event) {
		Main.trocarTela("principal");
	}

	@FXML
	void initialize() {
		Arbitro a1 = new Arbitro("Wilton", "Brasileiro");
		arbitros = Main.getArbitros();
		arbitros.create(a1);
		carregarListView();
		listViewArbitro.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionar(newValue));

	}

	public void selecionar(Arbitro arbitro) {
		if (arbitro == null) {
			labelNome.setText("");
			labelNacionalidade.setText("");
		} else {
			if (arbitro.getNome() != null) {
				labelNome.setText(arbitro.getNome());
				labelNacionalidade.setText(arbitro.getNacionalidade());
			}
		}
	}

	public void carregarListView() {
		arbitros = Main.getArbitros();
		obsArbitros = FXCollections.observableArrayList(arbitros.getArbitros());
		listViewArbitro.setItems(obsArbitros);
	}

	public boolean cadastrarArbitro(Arbitro arbitro) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ArbitroCadastroController.class.getResource("/app/view/ArbitroCadastro.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage telaCadastro = new Stage();
		telaCadastro.setTitle("Cadastro Arbitro");
		Image iconApp = new Image(getClass().getResourceAsStream("/app/resources/Arbitro300x.png"));
		telaCadastro.getIcons().add(iconApp);
		Scene scene = new Scene(page);
		telaCadastro.setScene(scene);
		ArbitroCadastroController controller = loader.getController();
		controller.setArbitroAdd(telaCadastro);
		controller.setArbitro(arbitro);
		telaCadastro.showAndWait();
		return controller.isClicou();
	}

}
