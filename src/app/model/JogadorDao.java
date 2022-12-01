package app.model;

import java.util.ArrayList;
import java.util.List;

public class JogadorDao {
	private int idAtual;
	private List<Jogador> jogadores;

	/**
	 * contrutor
	 */
	public JogadorDao() {
		idAtual = 0;
		jogadores = new ArrayList<>();
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public void setId(int id) {
		this.idAtual = id;
	}

	public int getId() {
		return idAtual;
	}

	/**
	 * Método para adicionar um jogador na lista de jogadores e incrementar +1 no ID
	 * 
	 * @param jogador
	 */
	public void create(Jogador jogador) {
		jogadores.add(jogador);
		++idAtual;
	}

	/**
	 * Método para saber o tamanho da lista de jogadores
	 * 
	 * @return tamanho
	 */
	public int tamanho() {
		return jogadores.size();
	}

	/**
	 * Método para unir jogadores com o mesmo nome de seleção em uma lista
	 * 
	 * @param nome
	 * @return
	 */
	public List<Jogador> juntaJogadores(String nomeSel) {
		List<Jogador> junta = new ArrayList<>();
		for (int i = 0; i < tamanho(); i++) {
			if (jogadores.get(i).getSelecao().equals(nomeSel)) {
				junta.add(jogadores.get(i));
			}
		}
		if (junta.size() == 0) {
			return null;
		}
		return junta;
	}


	/**
	 * Método para verificar se existe um jogador pelo objeto
	 * @param jogador
	 * @return
	 */
	public boolean existe(Jogador jogador) {
		if (jogadores.contains(jogador)) {
			return true;
		}
		return false;
	}

	/**
	 * Método que recebe o ID de um jogador para editar as características dele
	 * 
	 * @param jogador
	 * @param amarelo
	 * @param vermelho
	 * @param gol
	 * @param nome
	 * @param num
	 * @param posicao
	 */
	public void editar(Jogador jogador, int amarelo, int vermelho, int gol, String nome, int num, String posicao) {
		excluir(jogador);
		jogador.setCartaoAmarelo(amarelo);
		jogador.setCartaoVermelho(vermelho);
		jogador.setGols(gol);
		jogador.setNome(nome);
		jogador.setNumero(num);
		jogador.setPosicao(posicao);
		create(jogador);
	}

	/**
	 * Método de exclusão de um jogador através do seu ID
	 * 
	 * @param id
	 */
	public void excluir(Jogador jogador) {
		jogadores.remove(jogador);
	}

	/**
	 * Método para verificar se a lista de jogadores está vazia
	 * 
	 * @return
	 */
	public boolean vazio() {
		if (tamanho() == 0) {
			return true;
		}
		return false;
	}

	public Jogador getJogador(int posicao) {
		return jogadores.get(posicao);
	}

}
