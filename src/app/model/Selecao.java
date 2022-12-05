package app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cria os atributos da seleção através das entradas do usuário
 * Recebe a lista de jogadores, técnico e o nome
 */

public class Selecao {
	private List<Jogador> jogadores;
	private String tecnico;
	private String nome;
	private boolean grupo;
	private int gols;

	public Selecao() {
		this.jogadores = null;
		this.grupo = false;
		this.gols = 0;
	}

	public Selecao(String nome) {
		this.jogadores = new ArrayList<Jogador>();
		this.nome = nome;
		this.grupo = false;
		this.gols = 0;
	}

	public Selecao(String nome, String tecnico, List<Jogador> jogadores) {
		this.jogadores = jogadores;
		this.nome = nome;
		this.tecnico = tecnico;
		this.grupo = false;
		this.gols = 0;
	}
	
	public int getGols() {
		return gols;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setTecnicos(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getTecnicos() {
		return tecnico;
	}

	public boolean isGrupo() {
		return grupo;
	}

	public void setGrupo(boolean grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return getNome();
	}
}