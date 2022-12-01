package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    private ComboBox<?> comboBoxSelecao1;

    @FXML
    private ComboBox<?> comboBoxSelecao2;

    @FXML
    private ComboBox<?> comboBoxSelecao3;

    @FXML
    private ComboBox<?> comboBoxSelecao4;

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
        assert buttonCancelar != null : "fx:id=\"buttonCancelar\" was not injected: check your FXML file 'GrupoCadastro.fxml'.";
        assert buttonConfirmar != null : "fx:id=\"buttonConfirmar\" was not injected: check your FXML file 'GrupoCadastro.fxml'.";
        assert comboBoxSelecao1 != null : "fx:id=\"comboBoxSelecao1\" was not injected: check your FXML file 'GrupoCadastro.fxml'.";
        assert comboBoxSelecao2 != null : "fx:id=\"comboBoxSelecao2\" was not injected: check your FXML file 'GrupoCadastro.fxml'.";
        assert comboBoxSelecao3 != null : "fx:id=\"comboBoxSelecao3\" was not injected: check your FXML file 'GrupoCadastro.fxml'.";
        assert comboBoxSelecao4 != null : "fx:id=\"comboBoxSelecao4\" was not injected: check your FXML file 'GrupoCadastro.fxml'.";
        assert textFieldNome != null : "fx:id=\"textFieldNome\" was not injected: check your FXML file 'GrupoCadastro.fxml'.";

    }

}
