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

    }

}
