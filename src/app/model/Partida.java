package app.model;

public class Partida {
	private int codigo;
	private int gol1;
	private int gol2;
	private String data;
	private String hora;
	private String local;
	private Selecao time1;
	private Selecao time2;

	public Partida() {

	}

	public Partida(int codigo, int gol1, int gol2, String data, String hora, String local, Selecao time1,
			Selecao time2) {
		this.codigo = codigo;
		this.gol1 = gol1;
		this.gol2 = gol2;
		this.data = data;
		this.hora = hora;
		this.local = local;
		this.time1 = time1;
		this.time2 = time2;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getGol1() {
		return gol1;
	}

	public void setGol1(int gol1) {
		this.gol1 = gol1;
	}

	public int getGol2() {
		return gol2;
	}

	public void setGol2(int gol2) {
		this.gol2 = gol2;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
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

}
