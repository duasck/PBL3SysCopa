package app.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class GrupoController {

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
    private Label grupo;

    @FXML
    private Label grupoFix;

    @FXML
    private ListView<?> listViewGrupo;

    @FXML
    private Label selecao1;

    @FXML
    private Label selecao1Fix;

    @FXML
    private Label selecao2;

    @FXML
    private Label selecao2Fix;

    @FXML
    private Label selecao3;

    @FXML
    private Label selecao4;

    @FXML
    private Label selecaoFix3;

    @FXML
    private Label selecaoFix4;

    @FXML
    private TextField textFiledPesquisa;

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
        assert buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert buttonDel != null : "fx:id=\"buttonDel\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert buttonEdit != null : "fx:id=\"buttonEdit\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert grupo != null : "fx:id=\"grupo\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert grupoFix != null : "fx:id=\"grupoFix\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert listViewGrupo != null : "fx:id=\"listViewGrupo\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecao1 != null : "fx:id=\"selecao1\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecao1Fix != null : "fx:id=\"selecao1Fix\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecao2 != null : "fx:id=\"selecao2\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecao2Fix != null : "fx:id=\"selecao2Fix\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecao3 != null : "fx:id=\"selecao3\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecao4 != null : "fx:id=\"selecao4\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecaoFix3 != null : "fx:id=\"selecaoFix3\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert selecaoFix4 != null : "fx:id=\"selecaoFix4\" was not injected: check your FXML file 'GrupoView.fxml'.";
        assert textFiledPesquisa != null : "fx:id=\"textFiledPesquisa\" was not injected: check your FXML file 'GrupoView.fxml'.";

    }

}
