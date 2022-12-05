package app.control;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Selecao;
import app.model.SelecaoDao;
import app.model.Tecnico;
import app.model.TecnicoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TecnicoCadastroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCancelar;

    @FXML
    private Button buttonConfirmar;

    @FXML
    private ComboBox<Selecao> comboBoxSelecao;

    @FXML
    private TextField textFieldNacionalidade;

    @FXML
    private TextField textFieldNome;

	private boolean clicou = false;
	private Tecnico tecnico;
	private Stage tecnicoAdd;
	
	TecnicoDao tecnicos;
	SelecaoDao selecoes;

	public TecnicoCadastroController() {
		tecnicoAdd = new Stage();
	}

	public boolean isClicou() {
		return clicou;
	}

	public void setClicou(boolean clicou) {
		this.clicou = clicou;
	}

	public Stage getTecnicoAdd() {
		return tecnicoAdd;
	}

	public void setTecnicoAdd(Stage tecnicoAdd) {
		this.tecnicoAdd = tecnicoAdd;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
		if (tecnico != null) {
			this.textFieldNome.setText(tecnico.getNome());
			this.textFieldNacionalidade.setText(tecnico.getNacionalidade());
			selecoes = Main.getSelecoes();
			String selecao = tecnico.getSelecao();
			this.comboBoxSelecao.setValue(selecoes.buscaNome(selecao)); 
			
		}
	}


	@FXML
	void actionConfirmar(ActionEvent event) {
		if (validacao()) {
			this.tecnico.setNome(textFieldNome.getText());
			this.tecnico.setNacionalidade(textFieldNacionalidade.getText());
			this.clicou = true;
			this.tecnicoAdd.close();
		}
	}

	@FXML
	void actionCancelar(ActionEvent event) {
		this.tecnicoAdd.close();
	}

	@FXML
	void initialize() {
		SelecaoDao selecoes = Main.getSelecoes();
		comboBoxSelecao.getItems().addAll(selecoes.getSelecoes());
	}

	private boolean validacao() {
		if (textFieldNome.getText() == null || textFieldNome.getText().isEmpty()) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText("Campo nome está vazio, por favor preencha. \n");
			alert.show();
			return false;
		} else {
			return true;
		}
	}

	public void setArbitro(Stage telaCadastro) {		
	}

}
