package br.com.studiotrek.main;

import br.com.studiotrek.dao.NegocioDao;
import br.com.studiotrek.model.Negocio;

public class Main {

	public static void main(String[] args) {

		try {
			Negocio negocio = new Negocio();
			negocio.setNome("aaaaaaaaa");
			negocio.setIdade(18);
			
			new NegocioDao().inserir(negocio);
		} catch (Exception e) {
			// System.out.println(e);
			e.printStackTrace();
		}

	}

}
