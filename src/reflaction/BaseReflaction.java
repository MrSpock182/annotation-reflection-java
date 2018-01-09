package reflaction;

public class BaseReflaction<T> {
	final Class<T> clazz;

	public BaseReflaction(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void checkAnnotation(T t) throws Exception {
		new ReflactionNotNull<T>(this.clazz).annotationNotNull(t);
		new ReflactionModel<T>(this.clazz).annotationModel(t);
	}
}
