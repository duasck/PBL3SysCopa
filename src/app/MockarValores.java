package app;

import java.util.Random;
import app.model.Jogador;
import app.model.Selecao;
import app.model.Tecnico;
import app.model.SelecaoDao;
import app.model.JogadorDao;
import app.model.TecnicoDao;

public class MockarValores {
	static SelecaoDao sDao;
	static JogadorDao jDao;
	static TecnicoDao tDao;

	public static void MockSelecoes() {
		sDao = Main.getSelecoes();
		for (int i = 0; i < 32; i++) {
			try {
				Selecao selec = new Selecao("Time " + (i + 1));
				sDao.create(selec);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	String[] GrupoA = { "Qatar", "Equador", "Senegal", "Holanda" };
	String[] GrupoB = { "Inglaterra", "RI do Irã", "Estados Unidos", "País de Gales" };
	String[] GrupoC = { "Argentina", "Arábia Saudita", "México", "Polônia" };
	String[] GrupoD = { "França", "Austrália", "Dinamarca ", "Tunísia " };
	String[] GrupoE = { "Espanha", "Costa Rica", "Alemanha ", "Japão" };
	String[] GrupoF = { "Bélgica", "Canadá", "Marrocos ", "Croácia " };
	String[] GrupoG = { "Brasil", "Sérvia", "Suíça ", "Camarões " };
	String[] GrupoH = { "Portugal", "Gana", "Uruguai", "República da Coreia " };

	public static void MockJogadores() {
		sDao = Main.getSelecoes();
		String[] nomes = { "Tyrell", "Shola", "Garin", "Ajay", "River", "Rehan", "Edan", "Roland", "Jaye", "Lochlan",
				"Antoni" };
		String[] sobreNomes = { "Dickerson", "Leonard", "Hewitt", "Bassett", "Suarez", "Suarez", "Jackson", "Britt",
				"Garner", "Coles", "Klein" };

		String[] posicoes = { "Zagueiro", "Lateral direito", "Lateral esquerdo", "Libero", "Ala direito",
				"Ala esquerdo", "Meia-armador", "Meia-de-ligacao", "Apoiador", "Medio", "Medio-centro", "Meio-campista",
				"Lateral direito", "Meio-campista", "Lateral esquerdo", "Meia-atacante", "Meia Ofensivo",
				"Medio ofensivo", "Ponta", "Segundo atacante", "Centroavante", "Avancado-centro" };
		Random rand = new Random();
		int codigo = 0;
		try {
			for (Selecao s : sDao.getSelecoes()) {

				for (int i = 0; i < 11; i++) {
					int numAleatorio1 = rand.nextInt(11);
					int numAleatorio2 = rand.nextInt(11);
					int numPosicaoAleatorio = rand.nextInt(22);
					int numCamisaCodigo = i;
					try {
						jDao = Main.getJogadores();
						Jogador jog = new Jogador(nomes[numAleatorio1] + " " + sobreNomes[numAleatorio2],
								posicoes[numPosicaoAleatorio], numCamisaCodigo, s.getNome(), codigo);
						s.getJogadores().add(jog);
						jDao.create(jog);
						codigo++;

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void MockTecnicos() {
		String[] nomes = { "Tyrell", "Shola", "Garin", "Ajay", "River", "Rehan", "Edan", "Roland", "Jaye", "Lochlan",
				"Antoni" };
		String[] sobreNomes = { "Dickerson", "Leonard", "Hewitt", "Bassett", "Suarez", "Suarez", "Jackson", "Britt",
				"Garner", "Coles", "Klein" };
		Random rand = new Random();
		try {
			for (Selecao selec : sDao.getSelecoes()) {
				int numAleatorio1 = rand.nextInt(11);
				int numAleatorio2 = rand.nextInt(11);
				Tecnico t = new Tecnico(" ", selec.getNome(), nomes[numAleatorio1] + " " + sobreNomes[numAleatorio2]);
				selec.setTecnicos(nomes[numAleatorio1] + " " + sobreNomes[numAleatorio2]);
				tDao = Main.getTecnicos();
				tDao.create(t);
			}
		} catch (Exception e) {
		}

	}
}
