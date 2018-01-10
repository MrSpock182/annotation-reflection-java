package br.com.studiotrek.reflaction;

import java.lang.reflect.Field;

import br.com.studiotrek.annotation.AnnotationNotNull;
import br.com.studiotrek.error.AnnotationNotNullException;
import br.com.studiotrek.error.CustomThrowable;

class ReflactionNotNull<T> {
	final Class<T> clazz;

	public ReflactionNotNull(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	protected void annotationNotNull(T t) throws AnnotationNotNullException {
		for (Field field : clazz.getDeclaredFields()) {
			AnnotationNotNull annotationNotNull = (AnnotationNotNull) field.getAnnotation(AnnotationNotNull.class);
			if (annotationNotNull instanceof AnnotationNotNull) {
				notNull(field, t, annotationNotNull.line(), annotationNotNull.error());
			}
		}
	}
	
	private void notNull(Field field, T t, Integer numberLine, String message) throws AnnotationNotNullException {
		try {
			Object value = field.get(t);
			if (value == null) {
				Throwable throwable = new CustomThrowable(message).getThrowable(t.getClass().getSimpleName(), 
						field.getName(), numberLine);
				throw new AnnotationNotNullException(throwable);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new AnnotationNotNullException();
		}
	}
}
