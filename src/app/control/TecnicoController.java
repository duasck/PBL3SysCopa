package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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
    private Label labelNacionalidade;

    @FXML
    private Label labelNome;

    @FXML
    private Label labelSelecao;

    @FXML
    private ListView<?> listViewTecnico;

    @FXML
    private TextField textFieldPesquisa;

    @FXML
    void ActionAdd(ActionEvent event) {

    }

    @FXML
    void actionDelete(ActionEvent event) {

    }

    @FXML
    void actionEdit(ActionEvent event) {

    }

    @FXML
    void actionVoltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert buttonDel != null : "fx:id=\"buttonDel\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert buttonEdit != null : "fx:id=\"buttonEdit\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert labelNacionalidade != null : "fx:id=\"labelNacionalidade\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert labelNome != null : "fx:id=\"labelNome\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert labelSelecao != null : "fx:id=\"labelSelecao\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert listViewTecnico != null : "fx:id=\"listViewTecnico\" was not injected: check your FXML file 'TecnicoView.fxml'.";
        assert textFieldPesquisa != null : "fx:id=\"textFieldPesquisa\" was not injected: check your FXML file 'TecnicoView.fxml'.";

    }

}
