package app.model;

/**
 * Classe que cria os atributos do árbitro através das entradas do usuário
 *
 */

public class Arbitro {
	private String nome;
	private String nacionalidade;

	public Arbitro() {
	}

	public Arbitro(String nome, String nacionalidade) {
		this.nome = nome;
		this.nacionalidade = nacionalidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

//	@Override
//	public boolean equals(Object a) {
//		return ((Arbitro) a).nome.equals(this.nome) ? true : false;
//	}

	@Override
	public String toString() {
		return getNome();
	}
}
