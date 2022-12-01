package app.model;

import java.util.ArrayList;
import java.util.List;

public class ArbitroDao {
	private List<Arbitro> arbitros;

	public ArbitroDao() {
		arbitros = new ArrayList<>();
	}

	/**
	 * Método para adicionar/criar um árbitro na lista de árbitros
	 * 
	 * @param arbrito
	 */
	public boolean create(Arbitro arbrito) {
		int atual = tamanho();
		arbitros.add(arbrito);
		if (atual < tamanho())
			return true;
		return false;
	}

	/**
	 * @return tamanho
	 */
	public int tamanho() {
		return arbitros.size();
	}

	/**
	 * @param arbitro
	 * @param nomeNovo
	 * @param nacionalidade
	 */
	public void editar(Arbitro arbitro, String nome, String nacionalidade) {
		excluir(arbitro);
		arbitro.setNacionalidade(nacionalidade);
		arbitro.setNome(nome);
		create(arbitro);
	}

	/**
	 * Método de exclusão de um árbitro pelo objeto
	 * 
	 * @param arbitro
	 */
	public void excluir(Arbitro arbitro) {
		arbitros.remove(arbitro);
	}

	/**
	 * Método para verificar se a lista de árbitros está vazia
	 * 
	 * @return boolean
	 */
	public boolean vazio() {
		if (arbitros.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Método para verificar se existe um árbitro pelo nome
	 * 
	 * @param arbitro
	 * @return boolean
	 */
	public boolean existe(Arbitro arbitro) {
		if (arbitros.contains(arbitro)) {
			return true;
		}
		return false;
	}

}
