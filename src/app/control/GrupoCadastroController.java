package app.control;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Grupo;
import app.model.Selecao;
import app.model.SelecaoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GrupoCadastroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCancelar;

    @FXML
    private Button buttonConfirmar;

    @FXML
    private ComboBox<Selecao> comboBoxSelecao1;

    @FXML
    private ComboBox<Selecao> comboBoxSelecao2;

    @FXML
    private ComboBox<Selecao> comboBoxSelecao3;

    @FXML
    private ComboBox<Selecao> comboBoxSelecao4;

    @FXML
    private TextField textFieldNome;
    
	private boolean clicou = false;
	private Grupo grupo;
	private Stage grupoAdd;

	public Stage getGrupoAdd() {
		return grupoAdd;
	}

	public void setGrupoAdd(Stage grupoAdd) {
		this.grupoAdd = grupoAdd;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
		if (grupo != null) {
			this.textFieldNome.setText(grupo.getNome());
			this.comboBoxSelecao1.setValue(grupo.getTime1());
			this.comboBoxSelecao2.setValue(grupo.getTime2());
			this.comboBoxSelecao3.setValue(grupo.getTime3());
			this.comboBoxSelecao4.setValue(grupo.getTime4());
		}
	}

	public boolean isClicou() {
		return clicou;
	}

	public void setClicou(boolean clicou) {
		this.clicou = clicou;
	}

	@FXML
	void actionConfirmar(ActionEvent event) {
		if (validacao()) {
			this.grupo.setNome(textFieldNome.getText());
			grupo.setTime1(comboBoxSelecao1.getValue());
			grupo.setTime2(comboBoxSelecao2.getValue());
			grupo.setTime3(comboBoxSelecao3.getValue());
			grupo.setTime4(comboBoxSelecao4.getValue());
			this.clicou = true;
			this.grupoAdd.close();
		}
	}

	@FXML
	void actionCancelar(ActionEvent event) {
		this.grupoAdd.close();
	}

    @FXML
    void initialize() {
		SelecaoDao selecoes = Main.getSelecoes();
		comboBoxSelecao1.getItems().addAll(selecoes.getSelecoes());
		comboBoxSelecao2.getItems().addAll(selecoes.getSelecoes());
		comboBoxSelecao3.getItems().addAll(selecoes.getSelecoes());
		comboBoxSelecao4.getItems().addAll(selecoes.getSelecoes());


    }

	private boolean validacao() {
		String mensagens = "";
		if (textFieldNome.getText() == null || textFieldNome.getText().isEmpty()) {
			mensagens += "Campo nome está vazio, por favor preencha. \n";
		}
		
		if (comboBoxSelecao1.getValue() == null) {
			mensagens += "Campo selecao 1 está vazio, por favor preencha. \n";
		}
		
		if (comboBoxSelecao2.getValue() == null) {
			mensagens += "Campo selecao 2 está vazio, por favor preencha. \n";
		}
		
		if (comboBoxSelecao3.getValue() == null) {
			mensagens += "Campo selecao 3 está vazio, por favor preencha. \n";
		}
		
		if (comboBoxSelecao4.getValue() == null) {
			mensagens += "Campo selecao 4 está vazio, por favor preencha. \n";
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
	
}
