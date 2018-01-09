package main;

import business.Negocio;
import reflaction.BaseReflaction;

public class Main {

	public static void main(String[] args) {

		try {
			Negocio n = new Negocio();
			n.setNome("Verificando o tamanho da variavel");

			BaseReflaction<Negocio> reflaction = new BaseReflaction<>(Negocio.class);
			reflaction.checkAnnotation(n);

			/*
			for (Method method : Negocio.class.getDeclaredMethods()) {
				System.out.println(method.getName());
			}
			*/			
		} catch (Exception e) {
			// System.out.println(e);
			e.printStackTrace();
		}

	}

}
