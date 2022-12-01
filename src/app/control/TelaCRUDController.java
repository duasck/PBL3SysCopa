package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class TelaCRUDController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtoInserir;

    @FXML
    private Button ButtonApagar;

    @FXML
    private Button ButtonEditar;

    @FXML
    private Button ButtonListar;

    @FXML
    private Button ButtonVoltar;

    @FXML
    private ImageView Icon;

    @FXML
    private Label Titulo;

    @FXML
    void ActionApagar(ActionEvent event) {

    }

    @FXML
    void ActionEditar(ActionEvent event) {

    }

    @FXML
    void ActionInserir(ActionEvent event) {

    }

    @FXML
    void ActionListar(ActionEvent event) {

    }

    @FXML
    void ActionVoltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert ButtoInserir != null : "fx:id=\"ButtoInserir\" was not injected: check your FXML file 'TelaCRUD.fxml'.";
        assert ButtonApagar != null : "fx:id=\"ButtonApagar\" was not injected: check your FXML file 'TelaCRUD.fxml'.";
        assert ButtonEditar != null : "fx:id=\"ButtonEditar\" was not injected: check your FXML file 'TelaCRUD.fxml'.";
        assert ButtonListar != null : "fx:id=\"ButtonListar\" was not injected: check your FXML file 'TelaCRUD.fxml'.";
        assert ButtonVoltar != null : "fx:id=\"ButtonVoltar\" was not injected: check your FXML file 'TelaCRUD.fxml'.";
        assert Icon != null : "fx:id=\"Icon\" was not injected: check your FXML file 'TelaCRUD.fxml'.";
        assert Titulo != null : "fx:id=\"Titulo\" was not injected: check your FXML file 'TelaCRUD.fxml'.";

    }

}
