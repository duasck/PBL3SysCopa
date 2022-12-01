package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    private ComboBox<?> comboBoxSelecao;

    @FXML
    private TextField textFieldNacionalidade;

    @FXML
    private TextField textFieldNome;

    @FXML
    void ActionConfirmar(ActionEvent event) {

    }

    @FXML
    void actionCancelar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonCancelar != null : "fx:id=\"buttonCancelar\" was not injected: check your FXML file 'TecnicoCadastro.fxml'.";
        assert buttonConfirmar != null : "fx:id=\"buttonConfirmar\" was not injected: check your FXML file 'TecnicoCadastro.fxml'.";
        assert comboBoxSelecao != null : "fx:id=\"comboBoxSelecao\" was not injected: check your FXML file 'TecnicoCadastro.fxml'.";
        assert textFieldNacionalidade != null : "fx:id=\"textFieldNacionalidade\" was not injected: check your FXML file 'TecnicoCadastro.fxml'.";
        assert textFieldNome != null : "fx:id=\"textFieldNome\" was not injected: check your FXML file 'TecnicoCadastro.fxml'.";

    }

}
