package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PartidaCadastroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonCancelar;

    @FXML
    private Button buttonConfirmar;

    @FXML
    private ComboBox<?> comboBoxGrupo;

    @FXML
    private ComboBox<?> comboBoxSelecao1;

    @FXML
    private ComboBox<?> comboBoxSelecao2;

    @FXML
    private DatePicker data;

    @FXML
    private TextField textFieldGolsSelecao1;

    @FXML
    private TextField textFieldGolsSelecao2;

    @FXML
    private TextField textFieldHorario;

    @FXML
    private TextField textFieldLocal;

    @FXML
    void ActionConfirmar(ActionEvent event) {

    }

    @FXML
    void actionCancelar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert buttonCancelar != null : "fx:id=\"buttonCancelar\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert buttonConfirmar != null : "fx:id=\"buttonConfirmar\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert comboBoxGrupo != null : "fx:id=\"comboBoxGrupo\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert comboBoxSelecao1 != null : "fx:id=\"comboBoxSelecao1\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert comboBoxSelecao2 != null : "fx:id=\"comboBoxSelecao2\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert data != null : "fx:id=\"data\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert textFieldGolsSelecao1 != null : "fx:id=\"textFieldGolsSelecao1\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert textFieldGolsSelecao2 != null : "fx:id=\"textFieldGolsSelecao2\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert textFieldHorario != null : "fx:id=\"textFieldHorario\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";
        assert textFieldLocal != null : "fx:id=\"textFieldLocal\" was not injected: check your FXML file 'PartidaCadastro.fxml'.";

    }

}
