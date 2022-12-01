package app;

import app.model.ArbitroDao;
import app.model.GrupoDao;
import app.model.JogadorDao;
import app.model.PartidaDao;
import app.model.SelecaoDao;
import app.model.TecnicoDao;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;

/*
Autor: Luis Eduardo Leite Azevedo e Lucca Coutinho
Componente Curricular: Algoritmos II
Concluído em: 07/11/2022
Declaro que este código foi elaborado em dupla e não contém nenhum trecho de código de outro colega ou de outro autor, 
tais como provindos de livros eapostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código de 
outra autoria que não a minha está destacado com uma citação para o autor e a fonte do código, e estou ciente que estes 
trechos não serão considerados para fins de avaliação. */

public class Main extends Application {

	private static Stage stage;
	private static Scene jogadorView;
	private static Scene selecaoView;
	private static Scene arbitroView;
	private static Scene telaPrincipalView;
	private static Scene grupoView;
	private static Scene partidaView;
	private static Scene tecnicoView;
	private static Scene pesquisaView;
	static JogadorDao jogadores;
	static ArbitroDao arbitros;
	static GrupoDao grupos;
	static PartidaDao partidas;
	static SelecaoDao selecoes;
	static TecnicoDao tecnicos;
	

	@SuppressWarnings("exports")
	@Override
	public void start(Stage primaryStage) {
		try {
			carregarDados();
			stage = primaryStage;

			primaryStage.setResizable(false);
			primaryStage.setTitle("SysCopa");
			Image iconApp = new Image(getClass().getResourceAsStream("resources/Icone.png"));
			stage.getIcons().add(iconApp);

			String css = this.getClass().getResource("application.css").toExternalForm();

			Parent telaPrincipal = FXMLLoader.load(getClass().getResource("view/TelaPrincipal.fxml"));
			telaPrincipalView = new Scene(telaPrincipal);
			telaPrincipalView.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			telaPrincipalView.getStylesheets().add(css);

			Parent jogador = FXMLLoader.load(getClass().getResource("view/JogadorView.fxml"));
			jogadorView = new Scene(jogador);
			jogadorView.getStylesheets().add(css);

			Parent selecao = FXMLLoader.load(getClass().getResource("view/SelecaoView.fxml"));
			selecaoView = new Scene(selecao);
			selecaoView.getStylesheets().add(css);

			Parent arbitro = FXMLLoader.load(getClass().getResource("view/TelaPrincipal.fxml"));
			arbitroView = new Scene(arbitro);
			arbitroView.getStylesheets().add(css);

			Parent grupo = FXMLLoader.load(getClass().getResource("view/TelaPrincipal.fxml"));
			grupoView = new Scene(grupo);
			grupoView.getStylesheets().add(css);

			Parent partida = FXMLLoader.load(getClass().getResource("view/TelaPrincipal.fxml"));
			partidaView = new Scene(partida);
			partidaView.getStylesheets().add(css);

			Parent tecnico = FXMLLoader.load(getClass().getResource("view/TelaPrincipal.fxml"));
			tecnicoView = new Scene(tecnico);
			tecnicoView.getStylesheets().add(css);

			Parent pesquisa = FXMLLoader.load(getClass().getResource("view/TelaPrincipal.fxml"));
			pesquisaView = new Scene(pesquisa);
			pesquisaView.getStylesheets().add(css);

			primaryStage.setScene(telaPrincipalView);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Instacia as classes DAO para poderem ser usadas
	 */
	public static void carregarDados() {
		selecoes = new SelecaoDao();
		tecnicos = new TecnicoDao();
		partidas = new PartidaDao();
		jogadores = new JogadorDao();
		arbitros = new ArbitroDao();
		grupos = new GrupoDao();
	}
	
	@SuppressWarnings("exports")
	public static JogadorDao getJogadores() {
		return jogadores;
	}

	@SuppressWarnings("exports")
	public static void setJogadores(JogadorDao jogadores) {
		Main.jogadores = jogadores;
	}

	@SuppressWarnings("exports")
	public static ArbitroDao getArbitros() {
		return arbitros;
	}

	@SuppressWarnings("exports")
	public static void setArbitros(ArbitroDao arbitros) {
		Main.arbitros = arbitros;
	}

	@SuppressWarnings("exports")
	public static GrupoDao getGrupos() {
		return grupos;
	}

	@SuppressWarnings("exports")
	public static void setGrupos(GrupoDao grupos) {
		Main.grupos = grupos;
	}

	@SuppressWarnings("exports")
	public static PartidaDao getPartidas() {
		return partidas;
	}

	@SuppressWarnings("exports")
	public static void setPartidas(PartidaDao partidas) {
		Main.partidas = partidas;
	}

	@SuppressWarnings("exports")
	public static SelecaoDao getSelecoes() {
		return selecoes;
	}

	@SuppressWarnings("exports")
	public static void setSelecoes(SelecaoDao selecoes) {
		Main.selecoes = selecoes;
	}

	@SuppressWarnings("exports")
	public static TecnicoDao getTecnicos() {
		return tecnicos;
	}

	@SuppressWarnings("exports")
	public static void setTecnicos(TecnicoDao tecnicos) {
		Main.tecnicos = tecnicos;
	}

	/**
	 * @param tela
	 * troca a tela
	 */
	public static void trocarTela(String tela) {
		switch (tela) {
		case "principal":
			stage.setScene(telaPrincipalView);
			break;
		case "jogador":
			stage.setScene(jogadorView);
			break;
		case "selecao":
			stage.setScene(selecaoView);
			break;
		case "tecnico":
			stage.setScene(tecnicoView);
			break;
		case "arbitro":
			stage.setScene(arbitroView);
			break;
		case "grupo":
			stage.setScene(grupoView);
			break;
		case "pesquisa":
			stage.setScene(pesquisaView);
			break;
		case "partida":
			stage.setScene(partidaView);
			break;
		}
	}
}
