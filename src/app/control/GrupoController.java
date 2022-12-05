package app.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import app.Main;
import app.model.Grupo;
import app.model.GrupoDao;
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

public class GrupoController {

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
    private Label labelGrupo;

    @FXML
    private Label grupoFix;

    @FXML
    private Label selecao1;

    @FXML
    private Label selecao1Fix;

    @FXML
    private Label selecao2;

    @FXML
    private Label selecao2Fix;

    @FXML
    private Label selecao3;

    @FXML
    private Label selecao4;

    @FXML
    private Label selecaoFix3;

    @FXML
    private Label selecaoFix4;

    @FXML
    private TextField textFiledPesquisa;
    
    @FXML
    private ListView<Grupo> listViewGrupo;

	private ObservableList<Grupo> obsGrupos;
	
	GrupoDao grupos;
    
    
	
	@FXML
	void actionAdd(ActionEvent event) throws IOException {
		Grupo grupo = new Grupo();
		boolean confirmou = cadastrarGrupo(grupo);
		if (confirmou) {
			grupos = Main.getGrupos();
			grupos.create(grupo);
			carregarListView();
		}
	}

	@FXML
	void actionDelete(ActionEvent event) {
		Grupo grupo = listViewGrupo.getSelectionModel().getSelectedItem();
		if (grupo != null) {
			grupos = Main.getGrupos();
			grupos.excluir(grupo);
			carregarListView();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um grupo clicando na tabela! ");
			alert.show();
			carregarListView();
		}
	}

	@FXML
	void actionEdit(ActionEvent event) throws IOException {
		Grupo grupo = listViewGrupo.getSelectionModel().getSelectedItem();
		Grupo excluir = listViewGrupo.getSelectionModel().getSelectedItem();
		if (grupo != null) {
			boolean confirmou = cadastrarGrupo(grupo);
			if (confirmou) {
				grupos = Main.getGrupos();
				grupos.excluir(excluir);
				grupos.create(grupo);
				carregarListView();
			}
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Escolha um grupo clicando na tabela! ");
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
		listViewGrupo.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionar(newValue));

	}

    public void selecionar(Grupo grupo) {
		if (grupo == null) {
			labelGrupo.setText("");
			selecao1.setText("");
			selecao2.setText("");
			selecao3.setText("");
			selecao4.setText("");
		} else {
			labelGrupo.setText(grupo.getNome());
			selecao1.setText(grupo.getTime1().getNome());
			selecao2.setText(grupo.getTime2().getNome());
			selecao3.setText(grupo.getTime3().getNome());
			selecao4.setText(grupo.getTime4().getNome());
		}
	}

	public void carregarListView() {
		grupos = Main.getGrupos();
		obsGrupos = FXCollections.observableArrayList(grupos.getGrupos());
		listViewGrupo.setItems(obsGrupos);
	}

	public boolean cadastrarGrupo(Grupo grupo) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(GrupoCadastroController.class.getResource("/app/view/GrupoCadastro.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		Stage telaCadastro = new Stage();
		telaCadastro.setTitle("Cadastro grupo");
		Image iconApp = new Image(getClass().getResourceAsStream("/app/resources/Grupo300x.png"));
		telaCadastro.getIcons().add(iconApp);
		Scene scene = new Scene(page);
		telaCadastro.setScene(scene);
		GrupoCadastroController controller = loader.getController();
		controller.setGrupoAdd(telaCadastro);
		controller.setGrupo(grupo);
		telaCadastro.showAndWait();
		return controller.isClicou();
	}

}
