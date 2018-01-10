package br.com.studiotrek.error;

public class AnnotationModelException extends Exception {

	static final long serialVersionUID = 1218375828146090144L;

	public AnnotationModelException() {
		super();
	}

	public AnnotationModelException(String message) {
		super(message);
	}
	
	
	public AnnotationModelException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnnotationModelException(Throwable cause) {
		super(cause);
	}
}
