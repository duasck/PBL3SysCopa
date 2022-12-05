package app.model;

/**
 * Classe que cria os atributos do técnico pelas entradas do usuário
 *
 */

public class Tecnico {
	private String nacionalidade;
	private String selecao;
	private String nome;

	public Tecnico() {
	}
	
	public Tecnico(String nome, String selecao) {
		this.nome = nome;
		this.selecao = selecao;
		this.nacionalidade = "não definido";
	}

	public Tecnico(String nacionalidade, String selecao, String nome) {
		this.nacionalidade = nacionalidade;
		this.selecao = selecao;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}

	public String getSelecao() {
		return selecao;
	}

	@Override
	public String toString() {
		return getNome();
	}
}