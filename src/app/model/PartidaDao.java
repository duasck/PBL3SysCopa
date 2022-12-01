package app.model;

import java.util.ArrayList;
import java.util.List;

public class PartidaDao {
	private List<Partida> partidas;
	private int idAtual;

	/**
	 * contrutor
	 */
	public PartidaDao() {
		partidas = new ArrayList<>();
		idAtual = 0;
	}

	public List<Partida> getPartidas() {
		return partidas;
	}

	public Partida getPartida(int posicao) {
		return partidas.get(posicao);
	}

	public void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	public int getIdAtual() {
		return idAtual;
	}

	public void setIdAtual(int idAtual) {
		this.idAtual = idAtual;
	}

	/**
	 * adiciona uma nova partida
	 * 
	 * @param partida
	 */
	public void create(Partida partida) {
		partidas.add(partida);
		++idAtual;
	}

	/**
	 * tamanho da lista
	 */
	public int tamanho() {
		return partidas.size();
	}

	public void setFalse(int posicao, String op) {
		if (posicao < tamanho()) {
			switch (op) {
			case "1":
				partidas.get(posicao).getTime1().setGrupo(false);
				break;
			case "2":
				partidas.get(posicao).getTime2().setGrupo(false);
				break;
			}
		}
	}

	public void resetarGols(int posicao, String op) {
		if (posicao < tamanho()) {
			switch (op) {
			case "1":
				int tamanho = partidas.get(posicao).getTime1().getJogadores().size();
				for (int i = 0; i < tamanho; i++) {
					partidas.get(posicao).getTime1().getJogadores().get(i).setGols(0);
				}
				partidas.get(posicao).setGol1(0);
				break;
			case "2":
				tamanho = partidas.get(posicao).getTime2().getJogadores().size();
				for (int i = 0; i < tamanho; i++) {
					partidas.get(posicao).getTime2().getJogadores().get(i).setGols(0);
				}
				partidas.get(posicao).setGol2(0);
				break;
			}
		}

	}

	public Selecao pegarSelecao(int posicao, String op) {
		switch (op) {
		case "1":
			return partidas.get(posicao).getTime1();
		case "2":
			return partidas.get(posicao).getTime2();
		default:
			return null;
		}
	}

	/**
	 * Método de edição de partida
	 */
	public void editar(int posicao, String op, String trocar, Selecao selecao) {
		if (posicao < tamanho()) {
			switch (op) {
			case "1":
				setFalse(posicao, "1");
				partidas.get(posicao).setTime1(selecao);
				break;
			case "2":
				setFalse(posicao, "2");
				partidas.get(posicao).setTime2(selecao);
				break;
			case "3":
				resetarGols(posicao, "1");
				break;
			case "4":
				resetarGols(posicao, "2");
				break;
			case "5":
				partidas.get(posicao).setLocal(trocar);
				break;
			case "6":
				partidas.get(posicao).setHora(trocar);
				break;
			case "7":
				partidas.get(posicao).setData(trocar);
				break;
			}
		}
	}

	/**
	 * Método de remoção de partida
	 */
	public void excluir(Partida partida) {
		partidas.remove(partida);
	}

	/**
	 * Método de busca de partida por data
	 */
	public List<Integer> buscaPorData(String data) {
		List<Integer> posicoes = new ArrayList<>();
		for (int i = 0; i < tamanho(); i++) {
			if (partidas.get(i).getData().equals(data)) {
				posicoes.add(i);
			}
		}
		return posicoes;
	}
}
