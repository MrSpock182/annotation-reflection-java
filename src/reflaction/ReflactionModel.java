package reflaction;

import java.lang.reflect.Field;

import annotation.AnnotationModel;
import error.AnnotationModelException;

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
					} else {
						Throwable throwable = createErrorType(field, t, annotationModel.line());
						throw new AnnotationModelException(throwable);	
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
				Throwable throwable = createErrorMaxSize(field, t, annotationModel.line(), annotationModel.error());
				throw new AnnotationModelException(throwable);
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new AnnotationModelException();
		}
		
	}

	private Throwable createErrorType(Field field, Object object, Integer numberLine) {
		
		StringBuilder error = new StringBuilder();
		error.append("\n Atributo " + field.getName());
		error.append(" no " + object.getClass() + "\n");
		error.append(" está com tipo " + field.getType().getSimpleName() + "\n");
		error.append(" esse tipo não é permitido para annotation\n");
		error.append(" veja os tipos permitidos em: https://www.google.com.br");
		
		StackTraceElement stack = new StackTraceElement(object.getClass().getSimpleName(), 
				field.getName(), 
				object.getClass().getSimpleName() + ".java", 
				numberLine);
		
		StackTraceElement[] stacks = {stack};
		
		Throwable throwable = new Throwable(error.toString());
		throwable.setStackTrace(stacks);
		
		return throwable;
	}
	
	private Throwable createErrorMaxSize(Field field, Object object, Integer numberLine, String message) {
		StackTraceElement stack = new StackTraceElement(object.getClass().getSimpleName(), 
				field.getName(), 
				object.getClass().getSimpleName() + ".java", 
				numberLine);
		
		StackTraceElement[] stacks = {stack};
		
		Throwable throwable = new Throwable(message);
		throwable.setStackTrace(stacks);
		return throwable;
	}
	
}
