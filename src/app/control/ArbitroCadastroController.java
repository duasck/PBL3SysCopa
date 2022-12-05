package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import app.model.Arbitro;
import app.model.ArbitroDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ArbitroCadastroController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button buttonCancelar;

	@FXML
	private Button buttonConfirmar;

	@FXML
	private TextField textFieldNacionalidade;

	@FXML
	private TextField textFieldNome;

	private boolean clicou = false;
	private Arbitro arbitro;
	private Stage arbitroAdd;

	ArbitroDao arbitros;

	public ArbitroCadastroController() {
		arbitroAdd = new Stage();
	}

	public boolean isClicou() {
		return clicou;
	}

	public void setClicou(boolean clicou) {
		this.clicou = clicou;
	}

	public Stage getArbitroAdd() {
		return arbitroAdd;
	}

	public void setArbitroAdd(Stage arbitroAdd) {
		this.arbitroAdd = arbitroAdd;
	}

	public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
		if (arbitro != null) {
			this.textFieldNome.setText(arbitro.getNome());
			this.textFieldNacionalidade.setText(arbitro.getNacionalidade());
		}
	}

	@FXML
	void actionConfirmar(ActionEvent event) {
		if (validacao()) {
			this.arbitro.setNome(textFieldNome.getText());
			this.arbitro.setNacionalidade(textFieldNacionalidade.getText());
			this.clicou = true;
			this.arbitroAdd.close();
		}
	}

	@FXML
	void actionCancelar(ActionEvent event) {
		this.arbitroAdd.close();
	}

	@FXML
	void initialize() {

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

}
