package app.model;

/**
 * Classe que cria os atributos a partir dos dados do usuário
 */

public class Jogador {
	private int codJog;
	private String nome;
	private String posicao;
	private int numero;
	private int gols;
	private int cartaoAmarelo;
	private int cartaoVermelho;
	private String selecao;

	public Jogador() {
		this.gols = 0;
		this.cartaoAmarelo = 0;
		this.cartaoVermelho = 0;
	}

	/**
	 * @param nome
	 * @param posicao
	 * @param numero
	 * @param selecao
	 * @param codJog
	 */
	public Jogador(String nome, String posicao, int numero, String selecao, int codJog) {
		this.nome = nome;
		this.posicao = posicao;
		this.numero = numero;
		this.selecao = selecao;
		this.codJog = codJog;
		this.gols = 0;
		this.cartaoAmarelo = 0;
		this.cartaoVermelho = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodJog() {
		return codJog;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public void setCartaoAmarelo(int cartaoAmarelo) {
		this.cartaoAmarelo = cartaoAmarelo;
	}

	public int getCartaoAmarelo() {
		return cartaoAmarelo;
	}

	public void setCartaoVermelho(int cartaoVermelho) {
		this.cartaoVermelho = cartaoVermelho;
	}

	public int getCartaoVermelho() {
		return cartaoVermelho;
	}

	public void setGols(int gols) {
		this.gols = gols;
	}

	public int getgols() {
		return gols;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}

	public String getSelecao() {
		return selecao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getPosicao() {
		return posicao;
	}

	@Override
	public String toString() {
		return "Jogador: " + getNome() + " ID: " + getCodJog();
	}

	public int getGols() {
		return gols;
	}

	public void setCodJog(int codJog) {
		this.codJog = codJog;
	}

}