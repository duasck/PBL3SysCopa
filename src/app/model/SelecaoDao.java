package app.model;

import java.util.ArrayList;
import java.util.List;

public class SelecaoDao {
	private List<Selecao> selecoes;

	public SelecaoDao() {
		selecoes = new ArrayList<>();
	}

	public List<Selecao> getSelecoes() {
		return selecoes;
	}

	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}

	/**
	 * Método para criar/adicionar uma seleção a lista de seleções
	 * 
	 * @param selecao
	 */
	public void create(Selecao selecao) {
		selecoes.add(selecao);
	}

	/**
	 * tamanho do array
	 */
	public int tamanho() {
		return selecoes.size();
	}

	public Selecao getSelecao(int posicao) {
		return (posicao < tamanho()) ? selecoes.get(posicao) : null;
	}

	/**
	 * Método para verificar se a lista de seleções está vazia
	 * 
	 * @return
	 */
	public boolean vazio() {
		return (tamanho() == 0) ? true : false;
	}

	/**
	 * Método para buscar a seleção na lista através do nome
	 * 
	 * @param nome
	 * @return
	 */
	public Selecao buscaNome(String nome) {
		for (int i = 0; i < tamanho(); i++) {
			if (selecoes.get(i).getNome().equals(nome))
				return selecoes.get(i);
		}
		return null;
	}

	/**
	 * Método para verificar se existe uma seleção através do nome
	 * 
	 * @param nome
	 * @return
	 */
	public boolean existe(String nome) {
		for (int i = 0; i < tamanho(); i++) {
			if (selecoes.get(i).getNome().equals(nome))
				return true;
		}
		return false;
	}

	// Busca posição/índice do elemento na lista pelo nome
	public int buscaPos(String nome) {
		for (int i = 0; i < tamanho(); i++) {
			if (selecoes.get(i).getNome().equals(nome))
				return i;
		}
		return -1;
	}

	/**
	 * Método de busca do técnico
	 * 
	 * @param selecao
	 * @param tecnico
	 * @return
	 */
	public boolean buscaTecnico(String selecao, String tecnico) {
		for (int i = 0; i < tamanho(); i++) {
			if ((selecoes.get(i).getTecnicos().equals(tecnico)) && (selecoes.get(i).getNome().equals(selecao)))
				return true;
		}
		return false;
	}

	/**
	 * Método para editar uma seleção através da opção de entrada. Seleciona o nome
	 * antigo e edita com o nome atual e/ou edita o nome do técnico.
	 * 
	 * @param nome
	 * @param jogadores
	 * @param tecnico
	 */
	public void editar(int entrada, String nomeAnt, String nvNome, String tecnico) {
		switch (entrada) {
		case 1:
			selecoes.get(buscaPos(nomeAnt)).setNome(nvNome);
			break;
		case 2:
			selecoes.get(buscaPos(nomeAnt)).setTecnicos(tecnico);
			break;
		}
	}

	/**
	 * Método de exclusão de uma seleção pelo nom
	 * 
	 * @param nome
	 */
	public void excluir(String nome) {
		selecoes.remove(selecoes.get(buscaPos(nome)));
	}

	/**
	 * Método para imprir seleção e seus atributos logo após cadastro
	 * 
	 * @param selecao
	 */
	public List<String> imprime(Selecao selecao) {
		List<String> mensagens = new ArrayList<>();
		mensagens.add("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		mensagens.add("Selecao: " + selecao.getNome());
		if (selecao.getTecnicos() == null) {
			mensagens.add("Tecnico nao cadastrado! ");
		} else {
			mensagens.add("Tecnico: " + selecao.getTecnicos());
		}
		if (selecao.getJogadores().size() == 0) {
			mensagens.add("Jogadores nao cadastrados!");
			mensagens.add("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			mensagens.add("");
		} else {
			mensagens.add(">>>Jogadores<<<");
			for (int i = 0; i < selecao.getJogadores().size(); i++) {
				mensagens.add(
						selecao.getJogadores().get(i).getPosicao() + " " + selecao.getJogadores().get(i).getNome());
			}
			mensagens.add("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			mensagens.add("");
		}
		return mensagens;
	}

	/**
	 * Método que busca selecao pelo codigo do jogador
	 */
	public String encontrarSelecaoPorJog(int id) {
		for (int i = 0; i < tamanho(); i++) {
			int t = selecoes.get(i).getJogadores().size();
			for (int j = 0; j < t; j++) {
				int codigo = selecoes.get(i).getJogadores().get(j).getCodJog();
				if (codigo == id) {
					return selecoes.get(i).getJogadores().get(j).getSelecao();
				}
			}
		}
		return null;
	}

	/**
	 * Método que encontra jogador de tal seleção pelo ID
	 */
	public int encontrarJogador(int id) {
		int localSelecao = buscaPos(encontrarSelecaoPorJog(id));
		int tamanho = selecoes.get(localSelecao).getJogadores().size();
		for (int i = 0; i < tamanho; i++) {
			int cod = selecoes.get(localSelecao).getJogadores().get(i).getCodJog();
			if (cod == id) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método de edição do jogador na/pela seleçao
	 */
	public void editarJogador(int entrada, int id, int amarelo, int vermelho, int gol, String nome, int num,
			int posicao) {
		int p1 = buscaPos(encontrarSelecaoPorJog(id));
		int p2 = encontrarJogador(id);
		System.out.println(p1 + " " + p2);
		String[] posicoes = { "Goleiro", "Lateral direito", "Lateral esquerdo", "Zagueiro central", "Quarto zagueiro",
				"Meia defensivo", "Meia atacante", "Meia armador", "Volante, Atacante", "Segundo volante",
				"Centroavante", "Ponta direita", "Ponta esquerda" };

		switch (entrada) {
		case 1:
			selecoes.get(p1).getJogadores().get(p1).setCartaoAmarelo(amarelo);
			break;
		case 2:
			selecoes.get(p1).getJogadores().get(p2).setCartaoVermelho(vermelho);
			break;
		case 3:
			selecoes.get(p1).getJogadores().get(p2).setGols(gol);
			break;
		case 4:
			selecoes.get(p1).getJogadores().get(p2).setNome(nome);
			break;
		case 5:
			selecoes.get(p1).getJogadores().get(p2).setNumero(num);
			break;
		case 6:
			selecoes.get(p1).getJogadores().get(p2).setPosicao(posicoes[posicao - 1]);
			break;
		}
	}

	/**
	 * Método de exclusão do jogador na lista da seleçao
	 */
	public void apagarJogador(int id) {
		int p1 = buscaPos(encontrarSelecaoPorJog(id));
		int p2 = encontrarJogador(id);
		selecoes.get(p1).getJogadores().remove(p2);
	}

	/**
	 * Metodo de encontrar seleçao pelo nome do tecnico
	 */
	public int encontrarSelecaoPorTec(String tecnico) {
		for (int i = 0; i < tamanho(); i++) {
			if (selecoes.get(i).getTecnicos().equals(tecnico)) {
				return i;
			}
		}
		return -1;
	}

	public String NomePorTec(String tecnico) {
		for (int i = 0; i < tamanho(); i++) {
			if (selecoes.get(i).getTecnicos().equals(tecnico)) {
				return selecoes.get(i).getTecnicos();
			}
		}
		return null;
	}

	/**
	 * Metodo de editar tecnico na/pela selecao
	 */
	public void editarTecnico(int entrada, String nomeAntigo, String nomeNovo, String nacionalidade, String selecao) {
		switch (entrada) {
		case 1:
			selecoes.get(encontrarSelecaoPorTec(nomeAntigo)).setTecnicos(nomeNovo);
			break;
		case 3:
			selecoes.get(encontrarSelecaoPorTec(nomeAntigo)).setTecnicos("Sem tecnico ");
		}
	}

	public void apagarJogador(Jogador jogador) {
		Selecao selecao = buscaNome(jogador.getSelecao());
		excluir(selecao);
		if(selecao.getJogadores().contains(jogador)) {
			selecao.getJogadores().remove(jogador);
		}
		create(selecao);
	}

	public void addJogador(Jogador jogador) {
		Selecao selecao = buscaNome(jogador.getSelecao());
		excluir(selecao);
		selecao.getJogadores().add(jogador);
		create(selecao);
	}

	public void excluir(Selecao excluir) {
		selecoes.remove(excluir);
	}

}
