package reflaction;

import java.lang.reflect.Field;

import annotation.AnnotationNotNull;
import error.AnnotationNotNullException;

class ReflactionNotNull<T> {
	final Class<T> clazz;

	public ReflactionNotNull(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	protected void annotationNotNull(T t) throws AnnotationNotNullException {
		try {
			for (Field field : clazz.getDeclaredFields()) {
				AnnotationNotNull annotationNotNull = (AnnotationNotNull) field.getAnnotation(AnnotationNotNull.class);
				if (annotationNotNull instanceof AnnotationNotNull) {
					Object valor = field.get(t);
					notNull(field, valor, annotationNotNull.line(), annotationNotNull.error());
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new AnnotationNotNullException(e);
		}
	}
	
	private void notNull(Field field, Object value, Integer numberLine, String message) throws AnnotationNotNullException {
		if (value == null) {
			Throwable throwable = createErrorType(field, value, numberLine, message);
			throw new AnnotationNotNullException(throwable);
		}
	}
	
	private Throwable createErrorType(Field field, Object object, Integer numberLine, String message) {
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
