package app.control;

import java.util.List;

import app.Main;
import app.model.Jogador;
import app.model.JogadorDao;
import app.model.Selecao;
import app.model.SelecaoDao;
import app.model.Tecnico;
import app.model.TecnicoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SelecaoCadastroController {

	@FXML
	private Button buttonAdd;

	@FXML
	private Button buttonCancelar;

	@FXML
	private Button buttonConfirmar;

	@FXML
	private ComboBox<Jogador> comboBoxJogador;

	@FXML
	private ComboBox<Tecnico> comboBoxTecnico;

	@FXML
	private TableColumn<Jogador, String> tableColumnID;

	@FXML
	private TableColumn<Jogador, String> tableColumnNome;

	@FXML
	private TableView<Jogador> tableViewJogador;

	@FXML
	private TextField textFieldNome;

	private boolean clicou = false;
	private Selecao selecao;
	private Stage selecaoAdd;
	private ObservableList<Jogador> obsJogadores;

	TecnicoDao tecnicos;
	JogadorDao jogadores;
	SelecaoDao selecoes;
	List<Jogador> j;

	public SelecaoCadastroController() {
		selecaoAdd = new Stage();
	}

	public boolean isClicou() {
		return clicou;
	}

	public void setClicou(boolean clicou) {
		this.clicou = clicou;
	}

	public Stage getSelecaoAdd() {
		return selecaoAdd;
	}

	public void setSelecaoAdd(Stage selecaoAdd) {
		this.selecaoAdd = selecaoAdd;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
		if (selecao != null) {
			this.textFieldNome.setText(selecao.getNome());
			tecnicos = Main.getTecnicos();
			this.comboBoxTecnico.setValue(tecnicos.buscaNome(selecao.getTecnicos()));
			carregarTabela();
		}
	}

	public void carregarTabela() {
		if (this.selecao != null && selecao.getJogadores() != null) {
			obsJogadores = FXCollections.observableArrayList(selecao.getJogadores());
			tableViewJogador.setItems(obsJogadores);
		}
	}

	@FXML
	void actionConfirmar(ActionEvent event) {
		if (validacao()) {
			this.selecao.setGols(0);
			this.selecao.setJogadores(j);
			this.selecao.setNome(textFieldNome.getText());
			this.selecao.setTecnicos(comboBoxTecnico.getEditor().getText());
			this.clicou = true;
			this.selecaoAdd.close();
		}
	}

	@FXML
	void actionCancelar(ActionEvent event) {
		this.selecaoAdd.close();
	}

	@FXML
	void actionAdd(ActionEvent event) {
		j = selecao.getJogadores();
		j.add(comboBoxJogador.getValue());
		carregarTabela();
	}

	@FXML
	void initialize() {
		carregarTabela();
		tableColumnID.setCellValueFactory(new PropertyValueFactory<Jogador, String>("codJog"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<Jogador, String>("nome"));
		JogadorDao jogadores = Main.getJogadores();
		comboBoxJogador.getItems().addAll(jogadores.getJogadores());
		TecnicoDao tecnicos = Main.getTecnicos();
		Tecnico t1 = new Tecnico("Argentino", "Argentina", "Boludo");
		Tecnico t2 = new Tecnico("Russo", "Russia", "Wisk");
		tecnicos.create(t2);
		tecnicos.create(t1);
		comboBoxTecnico.getItems().addAll(tecnicos.getTecnicos());
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
