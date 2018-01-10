package br.com.studiotrek.reflaction;

import java.lang.reflect.Field;

import br.com.studiotrek.annotation.AnnotationModel;
import br.com.studiotrek.error.AnnotationModelException;
import br.com.studiotrek.error.CustomThrowable;

class ReflactionModel<T> {
	final Class<T> clazz;

	public ReflactionModel(Class<T> clazz) {
		this.clazz = clazz;
	}

	protected void annotationModel(T t) throws AnnotationModelException {
		try {
			for (Field field : clazz.getDeclaredFields()) {
				AnnotationModel annotationModel = (AnnotationModel) field.getAnnotation(AnnotationModel.class);
				if (annotationModel instanceof AnnotationModel) {
					if (field.getType().getSimpleName().equalsIgnoreCase("String")) {
						maxSize(field, t, annotationModel);
					}
				}
			}
		} catch (IllegalArgumentException e) {
			throw new AnnotationModelException(e);
		}
	}

	private void maxSize(Field field, T t, AnnotationModel annotationModel) throws AnnotationModelException {
		try {
			String value = (String)field.get(t);
			
			if (value.length() > annotationModel.maxSize()) {
				Throwable throwable = new CustomThrowable(annotationModel.error()).getThrowable(t.getClass().getSimpleName(), 
						field.getName(), annotationModel.line());
				throw new AnnotationModelException(throwable);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new AnnotationModelException();
		}
	}

}
