package app.model;

/**
 * Classe que cria os atributos do Grupo através das entradas do usuário
 *
 */

public class Grupo {
	private Selecao time1;
	private Selecao time2;
	private Selecao time3;
	private Selecao time4;
	
	public Grupo() {
		
	}
	
	/**
	 * @param time1
	 * @param time2
	 * @param time3
	 * @param time4
	 */
	public Grupo(Selecao time1, Selecao time2, Selecao time3, Selecao time4) {
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
		this.time4 = time4;
	}

	public Selecao getTime1() {
		return time1;
	}

	public void setTime1(Selecao time1) {
		this.time1 = time1;
	}

	public Selecao getTime2() {
		return time2;
	}

	public void setTime2(Selecao time2) {
		this.time2 = time2;
	}

	public Selecao getTime3() {
		return time3;
	}

	public void setTime3(Selecao time3) {
		this.time3 = time3;
	}

	public Selecao getTime4() {
		return time4;
	}

	public void setTime4(Selecao time4) {
		this.time4 = time4;
	}
}
