package app;

import java.util.ArrayList;
import java.util.List;

//import app.model.Jogador;
import app.model.Selecao;
import app.model.SelecaoDao;
import app.model.Tecnico;
import app.model.TecnicoDao;

public class Dados {
	SelecaoDao sDao;
	TecnicoDao tDao;
	public Dados() {
		// TODO Auto-generated constructor stub
	}

	public void selecoes() {
		List<Selecao> s = new ArrayList<>();
		//
		String[] GrupoA = { "Qatar", "Equador", "Senegal", "Holanda" };
		String[] GrupoB = { "Inglaterra", "Irã", "Estados Unidos", "País de Gales" };
		String[] GrupoC = { "Argentina", "Arábia Saudita", "México", "Polônia" };
		String[] GrupoD = { "França", "Austrália", "Dinamarca", "Tunísia" };
		String[] GrupoE = { "Espanha", "Costa Rica", "Alemanha", "Japão" };
		String[] GrupoF = { "Bélgica", "Canadá", "Marrocos", "Croácia" };
		String[] GrupoG = { "Brasil", "Sérvia", "Suíça", "Camarões" };
		String[] GrupoH = { "Portugal", "Gana", "Uruguai", "República da Coreia" };
		
		for(int i=0; i<4; i++) {
			Selecao a = new Selecao(GrupoA[i]);
			s.add(a);
			Selecao b = new Selecao(GrupoB[i]);
			s.add(b);
			Selecao c = new Selecao(GrupoC[i]);
			s.add(c);
			Selecao d = new Selecao(GrupoD[i]);
			s.add(d);
			Selecao e = new Selecao(GrupoE[i]);
			s.add(e);
			Selecao f = new Selecao(GrupoF[i]);
			s.add(f);
			Selecao g = new Selecao(GrupoG[i]);
			s.add(g);
			Selecao h = new Selecao(GrupoH[i]);
			s.add(h);
		}
		sDao = Main.getSelecoes();
		sDao.setSelecoes(s);
	}
	
//	public void jogadores() {
//		List<Jogador> j = new ArrayList<>();
//		
//		String[] jQatar = {"Franco Armani", "Geronimo Rulli", "Damian Martinez"};
//
//	}
//	
	public void tecnicos() {
		List<Tecnico> t = new ArrayList<>();
		tDao = Main.getTecnicos();
		sDao = Main.getSelecoes();
		
		Tecnico t1 = new Tecnico ("Lionel Scaloni", "Argentina");
		t.add(t1);
		sDao.getSelecao(2).setTecnicos(t1.getNome());;
		Tecnico t2 = new Tecnico ("Graham James Arnold", "Austrália");
		t.add(t2);
		sDao.getSelecao(11).setTecnicos(t2.getNome());;
		Tecnico t3 = new Tecnico ("Roberto Martínez Montoliu", "Bélgica");
		t.add(t3);
		sDao.getSelecao(5).setTecnicos(t3.getNome());;
		Tecnico t4 = new Tecnico ("Tite", "Brasil");
		t.add(t4);
		sDao.getSelecao(6).setTecnicos(t4.getNome());;
		Tecnico t5 = new Tecnico ("Rigobert Song Bahanag", "Camarões");
		t.add(t5);
		sDao.getSelecao(30).setTecnicos(t5.getNome());;
		Tecnico t6 = new Tecnico ("John Herdman", "Canadá");
		t.add(t6);
		sDao.getSelecao(13).setTecnicos(t6.getNome());;
		Tecnico t7 = new Tecnico ("Fernando Suárez", "Costa Rica");
		t.add(t7);
		sDao.getSelecao(12).setTecnicos(t7.getNome());;
		Tecnico t8 = new Tecnico ("Zlatko Dalić", "Croácia");
		t.add(t8);
		sDao.getSelecao(29).setTecnicos(t8.getNome());;
		Tecnico t9 = new Tecnico ("Kasper Hjulmand", "Dinamarca");
		t.add(t9);
		sDao.getSelecao(19).setTecnicos(t9.getNome());;
		Tecnico t10 = new Tecnico ("Gustavo Alfaro", "Equador");
		t.add(t10);
		sDao.getSelecao(8).setTecnicos(t10.getNome());;
		Tecnico t11 = new Tecnico ("Gareth Southgate", "Inglaterra");
		t.add(t11);
		sDao.getSelecao(1).setTecnicos(t11.getNome());;
		Tecnico t12 = new Tecnico ("Didier Deschamps", "França");
		t.add(t12);
		sDao.getSelecao(3).setTecnicos(t12.getNome());;
		Tecnico t13 = new Tecnico ("Hans Dieter Flick", "Alemanha");
		t.add(t13);
		sDao.getSelecao(20).setTecnicos(t13.getNome());;
		Tecnico t14 = new Tecnico ("Otto Addo", "Gana");
		t.add(t14);
		sDao.getSelecao(15).setTecnicos(t14.getNome());;
		Tecnico t15 = new Tecnico ("Carlos Queiroz", "Irã");
		t.add(t15);
		sDao.getSelecao(9).setTecnicos(t15.getNome());;
		Tecnico t16 = new Tecnico ("Hajime Moriyasu", "Japão");
		t.add(t16);
		sDao.getSelecao(28).setTecnicos(t16.getNome());;
		Tecnico t17 = new Tecnico ("Paulo Jorge Gomes", "República da Coreia");
		t.add(t17);
		sDao.getSelecao(31).setTecnicos(t17.getNome());;
		Tecnico t18 = new Tecnico ("Gerardo Daniel Martino", "México");
		t.add(t18);
		sDao.getSelecao(18).setTecnicos(t18.getNome());;
		Tecnico t19 = new Tecnico ("Robert John Page", "País de Gales");
		t.add(t19);
		sDao.getSelecao(25).setTecnicos(t19.getNome());;
		Tecnico t20 = new Tecnico ("Hoalid Regragui", "Marrocos");
		t.add(t20);
		sDao.getSelecao(21).setTecnicos(t20.getNome());;
		Tecnico t21 = new Tecnico ("Louis Van Gaal", "Holanda");
		t.add(t21);
		sDao.getSelecao(24).setTecnicos(t21.getNome());;
		Tecnico t22 = new Tecnico ("Czes ław Michniewicz", "Polônia");
		t.add(t22);
		sDao.getSelecao(26).setTecnicos(t22.getNome());;
		Tecnico t23 = new Tecnico ("Fernando Manuel Fernandes", "Portugal");
		t.add(t23);
		sDao.getSelecao(7).setTecnicos(t23.getNome());;
		Tecnico t24 = new Tecnico ("Féliz Sánchez Bas", "Qatar");
		t.add(t24);
		sDao.getSelecao(0).setTecnicos(t24.getNome());;
		Tecnico t25 = new Tecnico ("Hervé Renard", "Arábia Saudita");
		t.add(t25);
		sDao.getSelecao(10).setTecnicos(t25.getNome());;
		Tecnico t26 = new Tecnico ("Aliou Cissé", "Senegal");
		t.add(t26);
		sDao.getSelecao(16).setTecnicos(t26.getNome());;
		Tecnico t27 = new Tecnico ("Dragan Stojković", "Sérvia");
		t.add(t27);
		sDao.getSelecao(14).setTecnicos(t27.getNome());;
		Tecnico t28 = new Tecnico ("Luis Enrique Martínez", "Espanha");
		t.add(t28);
		sDao.getSelecao(4).setTecnicos(t28.getNome());;
		Tecnico t29 = new Tecnico ("Murat Yakin", "Suíça");
		t.add(t29);
		sDao.getSelecao(22).setTecnicos(t29.getNome());;
		Tecnico t30 = new Tecnico ("Jalel Kadri", "Tunísia");
		t.add(t30);
		sDao.getSelecao(27).setTecnicos(t30.getNome());;
		Tecnico t31 = new Tecnico ("Gregg Berhalter", "Estados Unidos");
		t.add(t31);
		sDao.getSelecao(17).setTecnicos(t31.getNome());;
		Tecnico t32 = new Tecnico ("Diego Alonso", "Uruguai");
		t.add(t32);
		sDao.getSelecao(23).setTecnicos(t32.getNome());;

		tDao.setTecnicos(t);
		
	}
}
