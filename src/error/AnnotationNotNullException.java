package error;

public class AnnotationNotNullException extends Exception {

	static final long serialVersionUID = 2118375828146090133L;

	public AnnotationNotNullException() {
		super();
	}

	public AnnotationNotNullException(String message) {
		super(message);
	}

	public AnnotationNotNullException(String message, Throwable cause) {
		super(message, cause);
	}

	public AnnotationNotNullException(Throwable cause) {
		super(cause);
	}
}
