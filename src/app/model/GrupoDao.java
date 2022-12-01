package app.model;

import java.util.ArrayList;
import java.util.List;

public class GrupoDao {
	private List<Grupo> grupos;

	/**
	 * contrutor
	 */
	public GrupoDao() {
		grupos = new ArrayList<>();
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public Grupo getGrupo(int posicao) {
		return grupos.get(posicao);
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	/**
	 * @return tamanho
	 */
	public int tamanho() {
		return grupos.size();
	}

	/**
	 * Metodo de adicionar um grupo
	 * 
	 * @param grupo
	 */
	public void create(Grupo grupo) {
		grupos.add(grupo);
	}

	/**
	 * Funçao que remove um grupo
	 * 
	 * @param grupo
	 */
	public void excluir(Grupo grupo) {
		grupos.remove(grupo);
	}

	/**
	 * Funçao que edita as seleçoes de por grupo
	 * 
	 * @param grupo
	 * @param selecao1
	 * @param selecao2
	 * @param selecao3
	 * @param selecao4
	 */
	public void editar(Grupo grupo, Selecao selecao1, Selecao selecao2, Selecao selecao3, Selecao selecao4) {
		excluir(grupo);
		grupo.setTime1(selecao1);
		grupo.setTime2(selecao2);
		grupo.setTime3(selecao3);
		grupo.setTime4(selecao4);
		create(grupo);
	}

}
