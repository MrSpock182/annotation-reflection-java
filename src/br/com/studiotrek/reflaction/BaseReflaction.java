package br.com.studiotrek.reflaction;

public class BaseReflaction<T> {
	final Class<T> clazz;

	public BaseReflaction(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void checkAnnotation(T t) throws Exception {
		new ReflactionNotNull<T>(this.clazz).annotationNotNull(t);
		new ReflactionModel<T>(this.clazz).annotationModel(t);
	}
	
	
	/*
	//Forma para retornar metodos da classe
	for (Method method : Negocio.class.getDeclaredMethods()) {
		System.out.println(method.getName());
	}
	*/
}
