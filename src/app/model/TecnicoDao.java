package app.model;

import java.util.ArrayList;
import java.util.List;

public class TecnicoDao {
	/**
	 * Lista de tecnicos/banco de dados
	 */
	private List<Tecnico> tecnicos;

	

	/**
	 * Construtor
	 */
	public TecnicoDao() {
		tecnicos = new ArrayList<>();
	}

	public List<Tecnico> getTecnicos() {
		return tecnicos;
	}

	public void setTecnicos(List<Tecnico> tecnicos) {
		this.tecnicos = tecnicos;
	}
	
	/**
	 * Método para criar/adicionar um técnico na lista de técnicos
	 * 
	 * @param tecnico
	 */
	public void create(Tecnico tecnico) {
		tecnicos.add(tecnico);
	}

	/**
	 * Método para buscar o técnico através do nome
	 * 
	 * @param nome
	 * @return lista
	 */
	public Tecnico buscaNome(String nome) {
		for (int i = 0; i < tecnicos.size(); i++) {
			if (tecnicos.get(i).getNome().equals(nome))
				return tecnicos.get(i);
		}
		return null;
	}

	/**
	 * Método para editar as características do técnico. Recebe a opção de entrada,
	 * nome antigo, novo nome, a nacionalidade e seleção a serem alteradas
	 * 
	 * @param tecnico
	 * @param nome
	 * @param nacionalidade
	 * @param selecao
	 */
	public void editar(Tecnico tecnico, String nome, String nacionalidade, String selecao) {
		excluir(tecnico);
		tecnico.setNacionalidade(nacionalidade);
		tecnico.setSelecao(selecao);
		tecnico.setNome(nome);
		create(tecnico);
	}

	/**
	 * Método de exclusão de um técnico pelo nome
	 * 
	 * @param tecnico
	 */
	public void excluir(Tecnico tecnico) {
		tecnicos.remove(tecnico);
	}

	/**
	 * Verifica se a lista de técnicos está vazia
	 * 
	 */
	public boolean vazio() {
		if (tecnicos.size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se existe um técnico através do nome
	 */
	public boolean existe(Tecnico tecnico) {
		if (tecnicos.contains(tecnico))
			return true;
		return false;
	}

	/**
	 * Método para unir o técnico a uma seleção através do nome dela Caso uma
	 * selecaoo seja criada depois do técnico, por exemplo
	 * 
	 * @param selecao
	 * @return nome
	 */
	public String junta(String selecao) {
		for (int i = 0; i < tecnicos.size(); i++) {
			if (tecnicos.get(i).getSelecao().equals(selecao))
				return tecnicos.get(i).getNome();
		}
		return null;
	}

	public Tecnico getTecnico(int posicao) {
		return tecnicos.get(posicao);
	}

	public int tamanho() {
		return tecnicos.size();
	}

}
